package com.mydemo.classroomapis.Service;

import com.mydemo.classroomapis.Entity.Subject;
import com.mydemo.classroomapis.Entity.Student;
import com.mydemo.classroomapis.Repository.StudentRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.mydemo.classroomapis.Entity.Teacher;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<String> getSubjects() {
        Student student = fetchData();
        return student.getSubjects().stream().map(Subject::getSubjectName).toList();
    }

    public List<String> getTeachers() {
        Student student = fetchData();
        return student.getTeachers().stream().map(Teacher::getTeacherName).toList();
    }

    public Student fetchData() {

        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return studentRepository.findByUsername(username);
    }

}
