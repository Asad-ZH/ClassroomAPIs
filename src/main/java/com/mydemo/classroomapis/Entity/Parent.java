package com.mydemo.classroomapis.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parent")
@Data
@DiscriminatorValue("PARENT")
public class Parent extends Person {

    private String name;
    private String parentAddress;
    private String parentPhone;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Student> students;


}
