package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;
import com.example.demo.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/api/v1")
@CrossOrigin("*")
public class StudentRestController {
    @Autowired
    private IStudentService studentService;
    @GetMapping
    public ResponseEntity<List<Student>> getStudentList() {
        List<Student> students = (List<Student>) studentService.findAll();
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Student> addNewStudent(@RequestBody StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        Student currentStudent = studentService.findById(id).get();
        if (currentStudent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentStudent.setGender(studentDto.getGender());
        currentStudent.setName(studentDto.getName());
        studentService.save(currentStudent);
        return new ResponseEntity<>(currentStudent, HttpStatus.OK);
    }
}
