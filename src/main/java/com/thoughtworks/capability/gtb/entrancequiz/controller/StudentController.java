package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.entity.Student;
import com.thoughtworks.capability.gtb.entrancequiz.entity.Team;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/student")
    public ResponseEntity addNewStudent(@RequestParam String name) {
        studentService.addStudent(name);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/partition")
    public List<Team> getPartition() {
        studentService.newPartition();

        return studentService.getPartition();
    }
}
