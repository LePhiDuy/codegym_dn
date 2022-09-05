package com.codegym.exam.repository;

import com.codegym.exam.model.ClassName;
import com.codegym.exam.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassNameRepository extends JpaRepository<ClassName, Integer> {
}
