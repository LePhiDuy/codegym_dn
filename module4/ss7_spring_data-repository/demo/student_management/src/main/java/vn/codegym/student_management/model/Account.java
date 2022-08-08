package vn.codegym.student_management.model;

import vn.codegym.student_management.model.Student;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date dateCreate;
    @OneToOne(mappedBy = "account")
    private Student student;

    public Account() {
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

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Account(Long id, String name, Date dateCreate, Student student) {
        this.id = id;
        this.name = name;
        this.dateCreate = dateCreate;
        this.student = student;
    }
}
