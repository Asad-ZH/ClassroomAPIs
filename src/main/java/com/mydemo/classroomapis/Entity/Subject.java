package com.mydemo.classroomapis.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "subject")
@Data
public class Subject {

    @Id
    @SequenceGenerator(
            name = "subject_sequence",
            sequenceName = "subject_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subject_sequence"
    )
    private Long id;
    private String subjectName;
    private String subjectDescription;

}
