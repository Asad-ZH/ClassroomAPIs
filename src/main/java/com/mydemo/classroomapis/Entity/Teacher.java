package com.mydemo.classroomapis.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
@Data
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long id;
    private String teacherName;

}
