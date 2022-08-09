package vn.codegym.student_management.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.student_management.model.Account;
import vn.codegym.student_management.model.ClassRoom;
import vn.codegym.student_management.model.Course;
import vn.codegym.student_management.model.Student;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class StudentDto implements Validator {
    private Long id;
    @NotBlank
    @NotNull
    @NotEmpty
    private String name;
    private int gender;
    private Account account;
    private ClassRoom classRoom;
    private Set<Course> courses;
    public Set<Course> getCourses() {
        return courses;
    }
    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public StudentDto() {
    }

    public StudentDto(Long id, String name, int gender, Account account, ClassRoom classRoom) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.account = account;
        this.classRoom = classRoom;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", account=" + account +
                ", classRoom=" + classRoom +
                '}';
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDto studentDto = (StudentDto) target;
        if("admin".equals(studentDto.name)) {
            errors.rejectValue("name", "name.forbidden", "Khong duoc nhap admin");
        }
    }
}
