package com.mydemo.classroomapis.Controller;

import com.mydemo.classroomapis.Entity.Student;
import com.mydemo.classroomapis.Service.ParentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/parent")
public class ParentController {

    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping("/test")
    public String getParent() {
        return "Hello parent";
    }

    @GetMapping("/children")
    public List<Student> getChildren() {
        return parentService.getChildren();
    }


}
