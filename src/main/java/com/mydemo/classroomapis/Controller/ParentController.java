package com.mydemo.classroomapis.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parent")
public class ParentController {
    @GetMapping("/test")
    public String getParent() {
        return "Hello parent";
    }

}
