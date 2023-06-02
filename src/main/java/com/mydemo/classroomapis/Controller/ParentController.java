package com.mydemo.classroomapis.Controller;

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

    @GetMapping
    public String get() {
        return "Hello Parent";
    }

    @GetMapping
    public List<String> getParent() {
        return parentService.getParent();
    }

}
