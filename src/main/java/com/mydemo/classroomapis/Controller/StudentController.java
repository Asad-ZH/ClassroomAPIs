package com.mydemo.classroomapis.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @GetMapping
    @PreAuthorize("hasAuthority('STUDENT')")
    public String get() {
        return "Hello Student";
    }
}
