package com.example.demo.dto;

public class StudentDto {
    private Long id;
    private String name;
    private int gender;

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

    public StudentDto() {
    }

    public StudentDto(Long id, String name, int gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
}
