package com.mydemo.classroomapis.Service;

import com.mydemo.classroomapis.Entity.Parent;
import com.mydemo.classroomapis.Entity.Student;
import com.mydemo.classroomapis.Entity.Subject;
import com.mydemo.classroomapis.Entity.Teacher;
import com.mydemo.classroomapis.Repository.ParentRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ParentService {

    private final ParentRepository parentRepository;

    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public List<String> getChildren() {
        Parent parent = fetchData();
        return parent.getStudents().stream().map(Student::getStudentName).toList();
    }

    public HashMap<String, List<String>> getTeachers() {
        Parent parent = fetchData();

        HashMap<String, List<String>> teacherMap = new HashMap<>(parent.getStudents().size());

        for (Student student : parent.getStudents()) {
            List<String> teacherNames = new ArrayList<>(student.getTeachers().size());

            for (Teacher teacher : student.getTeachers()) {
                teacherNames.add(teacher.getTeacherName());
            }
            teacherMap.put(student.getStudentName(), teacherNames);
        }

        return teacherMap;

    }

    public HashMap<String, List<String>> getSubjects() {
        Parent parent = fetchData();

        HashMap<String, List<String>> subjectMap = new HashMap<>(parent.getStudents().size());

        for (Student student : parent.getStudents()) {
            List<String> subjectNames = new ArrayList<>(student.getSubjects().size());

            for (Subject subject : student.getSubjects()) {
                subjectNames.add(subject.getSubjectName());
            }
            subjectMap.put(student.getStudentName(), subjectNames);
        }

        return subjectMap;
    }

    public Parent fetchData() {

        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return parentRepository.findByUsername(username);
    }

}
