package com.example.validate_form_input.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class User {
    @NotEmpty(message = "{user.error.name}")
    @Size(min = 2, max = 10, message = "2 den 10 thui")
    private String name;
    @Min(15)
    @Max(100)
    private int age;
}
