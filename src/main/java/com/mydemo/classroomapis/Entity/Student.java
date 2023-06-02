package com.mydemo.classroomapis.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String studentName;
    private String studentPhone;

    @ManyToOne
    @JoinColumn(
            name = "student_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "student_book_fk"
            )
    )
    private Parent parent;

}