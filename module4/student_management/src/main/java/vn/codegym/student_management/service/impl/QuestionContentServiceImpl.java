package vn.codegym.student_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.student_management.entity.QuestionContent;
import vn.codegym.student_management.repository.IQuestionContentRepository;
import vn.codegym.student_management.service.IQuestionContentService;

import javax.transaction.Transactional;

@Service
@Transactional
public class QuestionContentServiceImpl implements IQuestionContentService {
    @Autowired
    private IQuestionContentRepository questionContentRepository;

    @Override
    public Page<QuestionContent> findAll(Pageable pageable) {
        return questionContentRepository.findAll(pageable);
    }

    @Override
    public void save(QuestionContent questionContent) {
        questionContentRepository.save(questionContent);
    }

    @Override
    public void delete(Long id) {
        questionContentRepository.deleteById(id);
    }

    @Override
    public Page<QuestionContent> find(String tittle, String type, Pageable pageable) {
        return questionContentRepository.find(tittle, type, pageable);
    }

    @Override
    public Page<QuestionContent> findQuestionContentByTittle(String tittle, Pageable pageable) {
        return questionContentRepository.findQuestionContentByTittleContaining(tittle, pageable);
    }

}
