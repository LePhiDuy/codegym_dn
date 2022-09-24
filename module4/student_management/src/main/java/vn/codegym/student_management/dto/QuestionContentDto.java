package vn.codegym.student_management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.codegym.student_management.entity.ClassStudent;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDto {
    private Long id;
    private String name;
    private String email;
    private boolean gender;
    private String phone;
    private LocalDate birthDate;
    private ClassStudent classStudent;
}
