package vn.codegym.student_management.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuestionContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tittle;
    private String content;
    private String answer;
    private boolean status;
    private LocalDate dateCreate;
    @ManyToOne
    @JoinColumn(name = "question_type_id")
    private QuestionType questionType;
}
