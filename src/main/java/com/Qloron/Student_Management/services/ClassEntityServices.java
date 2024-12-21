package com.Qloron.Student_Management.services;

import com.Qloron.Student_Management.exception.ResourceNotFoundException;
import com.Qloron.Student_Management.model.ClassEntity;
import com.Qloron.Student_Management.model.Student;
import com.Qloron.Student_Management.repository.ClassEntityRepository;
import com.Qloron.Student_Management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassEntityServices {

    private final ClassEntityRepository classEntityRepository;
    private final StudentRepository studentRepository;

    public ClassEntityServices(ClassEntityRepository classEntityRepository, StudentRepository studentRepository) {
        this.classEntityRepository = classEntityRepository;
        this.studentRepository = studentRepository;
    }

    public ClassEntity addClass(ClassEntity classEntity) {
        return classEntityRepository.save(classEntity);
    }

    public void deleteClassById(Long id) {
        if (!classEntityRepository.existsById(id)) {
            throw new RuntimeException("Class with ID " + id + " not found");
        }
        classEntityRepository.deleteById(id);
    }

    public List<ClassEntity> getAllClasses() {
        return classEntityRepository.findAll();
    }

    public ClassEntity getClassById(Long id) {
        return classEntityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Class with ID " + id + " not found"));
    }

    public List<Student> getStudentsByClassId(Long classId) {
        ClassEntity classEntity = classEntityRepository.findById(classId)
                .orElseThrow(() -> new ResourceNotFoundException("Class with ID " + classId + " does not exist."));

        return studentRepository.findByClassEntity_ClassId(classId);
    }
}
