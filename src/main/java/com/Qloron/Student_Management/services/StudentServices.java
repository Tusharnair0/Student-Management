package com.Qloron.Student_Management.services;

import com.Qloron.Student_Management.model.ClassEntity;
import com.Qloron.Student_Management.model.Student;
import com.Qloron.Student_Management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {

    private final StudentRepository studentRepository;
    private final ClassEntityServices classEntityServices;

    public StudentServices(StudentRepository studentRepository, ClassEntityServices classEntityServices) {
        this.studentRepository = studentRepository;
        this.classEntityServices = classEntityServices;
    }

    public Student addStudent(Student student) {
        ClassEntity classEntity = classEntityServices.getClassById(student.getClassEntity().getClassId());
        student.setClassEntity(classEntity);
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String rollNo) {
        return studentRepository.findById(rollNo)
                .orElseThrow(() -> new RuntimeException("Student with roll number " + rollNo + " not found"));
    }

    public void deleteStudentById(String rollNo) {
        Student student = getStudentById(rollNo);
        studentRepository.delete(student);
    }

    public Student updateStudent(String rollNo, Student updatedStudent) {
        Student existingStudent = getStudentById(rollNo);

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setPhoneNumber(updatedStudent.getPhoneNumber());

        if (updatedStudent.getClassEntity() != null) {
            ClassEntity classEntity = classEntityServices.getClassById(updatedStudent.getClassEntity().getClassId());
            existingStudent.setClassEntity(classEntity);
        }

        return studentRepository.save(existingStudent);
    }

    public List<Student> getStudentsByClassId(Long classId) {
        return studentRepository.findByClassEntity_ClassId(classId);
    }
}
