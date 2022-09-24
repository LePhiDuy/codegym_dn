package vn.codegym.student_management.service;

import vn.codegym.student_management.entity.ClassStudent;

import java.util.List;

public interface IClassService {
    List<ClassStudent> findAll();
}
