package com.Qloron.Student_Management.controller;

import com.Qloron.Student_Management.model.ClassEntity;
import com.Qloron.Student_Management.model.Student;
import com.Qloron.Student_Management.services.ClassEntityServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassEntityController {

    private final ClassEntityServices classEntityServices;

    public ClassEntityController(ClassEntityServices classEntityServices) {
        this.classEntityServices = classEntityServices;
    }

    @PostMapping
    public ResponseEntity<ClassEntity> addClass(@RequestBody ClassEntity classEntity){
        ClassEntity createdClass = classEntityServices.addClass(classEntity);
        return new ResponseEntity<>(createdClass, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClassEntity>> getAllClasses(){
        List<ClassEntity> classes = classEntityServices.getAllClasses();
        return new ResponseEntity<>(classes,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassEntity> getClassById(@PathVariable Long id) {
        ClassEntity classEntity = classEntityServices.getClassById(id);
        return new ResponseEntity<>(classEntity, HttpStatus.OK);
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<List<Student>> getStudentsByClass(@PathVariable Long id) {
        List<Student> students = classEntityServices.getStudentsByClassId(id);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long id) {
        classEntityServices.deleteClassById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
