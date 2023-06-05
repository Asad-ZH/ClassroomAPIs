package com.mydemo.classroomapis.Controller;

import com.mydemo.classroomapis.Service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/test")
    public String get() {
        return "Hello Teacher";
    }

    @GetMapping("/subjects")
    public String getSubjects() {
        return teacherService.getSubjects();
    }

    @GetMapping("/students")
    public List<String> getStudents() {
        return teacherService.getStudents();
    }
}
