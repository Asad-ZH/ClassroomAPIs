package com.mydemo.classroomapis.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
@Data
@DiscriminatorValue("STUDENT")
public class Student extends Person {

    private String studentName;
    private String studentPhone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @ManyToMany(mappedBy = "students")
    private List<Teacher> teachers;

    @ManyToMany(mappedBy = "students")
    private List<Subject> subjects;

}