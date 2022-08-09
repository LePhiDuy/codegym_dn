package com.example.register_form_validate.repository;

import com.example.register_form_validate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
