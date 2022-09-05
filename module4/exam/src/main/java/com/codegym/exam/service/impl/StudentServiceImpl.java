package com.codegym.exam.service.impl;

import com.codegym.exam.model.Student;
import com.codegym.exam.repository.StudentRepository;
import com.codegym.exam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public void create(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Student> findAllWithPaging(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> searchByNameOrEmail(Pageable pageable, String searchVal) {
        return studentRepository.findByNameContainingOrEmailContainingOrClassName_NameContaining(pageable, searchVal, searchVal, searchVal);
    }


}
