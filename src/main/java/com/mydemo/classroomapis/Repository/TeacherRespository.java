package com.mydemo.classroomapis.Repository;

import com.mydemo.classroomapis.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRespository extends JpaRepository<Teacher, Long> {
}
