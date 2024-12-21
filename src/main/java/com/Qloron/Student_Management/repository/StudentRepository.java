package com.Qloron.Student_Management.repository;

import com.Qloron.Student_Management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findByClassEntity_ClassId(Long classId);
}
