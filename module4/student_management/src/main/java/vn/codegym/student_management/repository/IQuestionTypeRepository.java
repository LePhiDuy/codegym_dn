package vn.codegym.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.student_management.entity.QuestionType;

public interface IQuestionTypeRepository extends JpaRepository<QuestionType, Long> {
}
