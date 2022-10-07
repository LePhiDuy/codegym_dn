package vn.codegym.student_management.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.student_management.entity.QuestionContent;

public interface IQuestionContentService {
    Page<QuestionContent> findAll(Pageable pageable);
    void save(QuestionContent student);
    void delete(Long id);
    Page<QuestionContent> find(String tittle, String type, Pageable pageable);
    Page<QuestionContent> findQuestionContentByTittle(String tittle, Pageable pageable);
}
