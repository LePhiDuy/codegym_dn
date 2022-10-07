package com.codegym.exam.service.impl;

import com.codegym.exam.model.ClassName;
import com.codegym.exam.repository.ClassNameRepository;
import com.codegym.exam.service.ClassNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassNameServiceImpl implements ClassNameService {

    @Autowired
    ClassNameRepository classNameRepository;
    @Override
    public List<ClassName> getAll() {
        return classNameRepository.findAll();
    }
}
