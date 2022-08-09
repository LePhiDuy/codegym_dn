package com.example.register_form_validate.dto;

import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDto implements Validator {
    private Long id;
    @NotBlank
    @Size(min = 5, max = 45)
    private String firstName;
    @NotBlank
    @Size(min = 5, max = 45)
    private String lastName;
    private String phone;
    @Min(18)
    private int age;
    @Email
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String phone = userDto.phone;
        ValidationUtils.rejectIfEmpty(errors, "phone", "phone.empty");
        if (phone.length() > 11 || phone.length() < 10) {
            errors.rejectValue("phone", "phone.length");
        }
        if (!phone.startsWith("0")) {
            errors.rejectValue("phone", "phone.startWith0");
        }
        if (!phone.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("phone", "phone.matches");
        }
    }
}
