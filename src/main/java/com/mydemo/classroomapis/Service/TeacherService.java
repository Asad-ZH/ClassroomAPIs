package com.mydemo.classroomapis.Service;

import com.mydemo.classroomapis.Entity.Student;
import com.mydemo.classroomapis.Entity.Subject;
import com.mydemo.classroomapis.Entity.Teacher;
import com.mydemo.classroomapis.Repository.SubjectRepository;
import com.mydemo.classroomapis.Repository.TeacherRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;

    public TeacherService(TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
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

    public void registerSubject(String subjectName) {

        Teacher teacher = fetchData();
        Subject subject = subjectRepository.findBySubjectName(subjectName);

        teacher.setSubject(subject);
        subject.setTeacher(teacher);
        teacherRepository.save(teacher);
        subjectRepository.save(subject);

    }
}
