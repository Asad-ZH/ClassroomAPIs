package com.mydemo.classroomapis.Repository;

import com.mydemo.classroomapis.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
