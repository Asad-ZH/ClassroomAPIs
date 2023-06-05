package com.mydemo.classroomapis.Service;

import com.mydemo.classroomapis.Entity.Parent;
import com.mydemo.classroomapis.Entity.Student;
import com.mydemo.classroomapis.Repository.ParentRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {


    private final ParentRepository parentRepository;

    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public List<String> getParent() {
        return null;
    }

    public List<Student> getChildren() {
        Parent parent = fetchData();
        return parent.getStudents();
//                .stream().map(Student::getStudentName).toList();
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
