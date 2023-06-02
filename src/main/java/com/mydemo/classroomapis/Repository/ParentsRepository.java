package com.mydemo.classroomapis.Repository;

import com.mydemo.classroomapis.Entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentsRepository extends JpaRepository<Parent, Long> {
}