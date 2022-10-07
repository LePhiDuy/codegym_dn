package vn.codegym.student_management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.codegym.student_management.entity.QuestionType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuestionContentDto {
    private Long id;
    @NotNull(message = "Tittle can't null")
    @Size(min = 5, max = 100, message = "Tittle size must between 5 and 100")
    private String tittle;
    @NotNull(message = "Content can't null")
    @Size(min = 10, max = 500, message = "Content size must between 10 and 500")
    private String content;
    private String answer;
    private boolean status;
    private LocalDate dateCreate;
    @NotNull(message = "Question Type can't null")
    private QuestionType questionType;
}
