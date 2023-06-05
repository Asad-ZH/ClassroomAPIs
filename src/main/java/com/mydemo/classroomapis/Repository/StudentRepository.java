package com.mydemo.classroomapis.Repository;

import com.mydemo.classroomapis.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUsername(String username);
}
