package vn.codegym.student_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.student_management.entity.QuestionType;
import vn.codegym.student_management.repository.IQuestionTypeRepository;
import vn.codegym.student_management.service.IQuestionTypeService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class QuestionTypeServiceImpl implements IQuestionTypeService {
    @Autowired
    private IQuestionTypeRepository questionTypeRepository;
    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }
}
