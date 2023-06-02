package com.mydemo.classroomapis.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parent")
@Data
public class Parent {

    @Id
    @SequenceGenerator(
            name = "parent_sequence",
            sequenceName = "parent_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "parent_sequence"
    )
    private Long id;
    private String motherName;
    private String fatherName;
    private String parentAddress;
    private String parentPhone;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true
    )
    private List<Student> students;


}
