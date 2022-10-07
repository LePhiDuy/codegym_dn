package com.codegym.exam.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ClassName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "className")
    private Set<Student> students;

    public ClassName() {
    }

    public ClassName(Integer id, String name, Set<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
