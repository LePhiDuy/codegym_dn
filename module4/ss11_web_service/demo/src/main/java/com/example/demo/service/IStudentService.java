package com.example.demo.service;

import com.example.demo.model.Student;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface IStudentService {
    Iterable<Student> findAll();
    Optional<Student> findById(Long id);
    void save(Student student);
    void delete(Long id);
}
