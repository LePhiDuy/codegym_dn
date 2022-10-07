package vn.codegym.student_management.service;

import vn.codegym.student_management.entity.QuestionType;

import java.util.List;

public interface IQuestionTypeService {
    List<QuestionType> findAll();
}
