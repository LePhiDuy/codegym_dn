package vn.codegym.student_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.student_management.entity.ClassStudent;
import vn.codegym.student_management.repository.IClassRepository;
import vn.codegym.student_management.service.IClassService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClassServiceImpl implements IClassService {
    @Autowired
    private IClassRepository classRepository;
    @Override
    public List<ClassStudent> findAll() {
        return classRepository.findAll();
    }
}
