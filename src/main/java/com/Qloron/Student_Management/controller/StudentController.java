package com.Qloron.Student_Management.controller;

import com.Qloron.Student_Management.model.Student;
import com.Qloron.Student_Management.services.StudentServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentServices studentServices;

    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student createdStudent = studentServices.addStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> student = studentServices.getAllStudents();
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/{rollNo}")
    public ResponseEntity<Student> getStudentByRollNo(@PathVariable String rollNo) {
        Student student = studentServices.getStudentById(rollNo);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/class/{classId}")
    public ResponseEntity<List<Student>> getStudentsByClassId(@PathVariable Long classId) {
        List<Student> students = studentServices.getStudentsByClassId(classId);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @DeleteMapping("/{rollNo}")
    public ResponseEntity<Void> deleteStudentByRollNo(@PathVariable String rollNo) {
        studentServices.deleteStudentById(rollNo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{rollNo}")
    public ResponseEntity<Student> updateStudent(@PathVariable String rollNo, @RequestBody Student updatedStudent) {
        Student student = studentServices.updateStudent(rollNo, updatedStudent);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
