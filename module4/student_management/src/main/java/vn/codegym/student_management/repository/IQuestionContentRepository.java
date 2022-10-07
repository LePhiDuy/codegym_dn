package vn.codegym.student_management.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.codegym.student_management.entity.QuestionContent;

import java.util.Date;

public interface IQuestionContentRepository extends JpaRepository<QuestionContent, Long> {
    @Query(value = "select c.* from question_content c join question_type t on c.id = t.id where c.tittle like ?1 or t.name like ?2",
            countQuery = "select c.* from question_content c join question_type t on c.id = t.id where  c.tittle like ?1 and t.name like ?2", nativeQuery = true)
    Page<QuestionContent> find(String tittle, String questionType, Pageable pageable);
    Page<QuestionContent> findQuestionContentByTittleContaining(String tittle, Pageable pageable);
}
