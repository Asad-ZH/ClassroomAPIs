package com.mydemo.classroomapis.Service;

import com.mydemo.classroomapis.Entity.Student;
import com.mydemo.classroomapis.Entity.Teacher;
import com.mydemo.classroomapis.Repository.TeacherRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public String getSubjects() {
        Teacher teacher = fetchData();
        return teacher.getSubject().getSubjectName();
    }


    public Teacher fetchData() {

        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return teacherRepository.findByUsername(username);
    }

    public List<String> getStudents() {
        Teacher teacher = fetchData();
        return teacher.getStudents().stream().map(Student::getStudentName).toList();
    }
}
