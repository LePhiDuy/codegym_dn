package _8_clean_code.demoMVC.repository.impl;

import _8_clean_code.demoMVC.model.Student;
import _8_clean_code.demoMVC.repository.IStudentRepository;

public class StudentRepository implements IStudentRepository {
    private static Student[] students = new Student[1000];
    private static int numberPeopleOfCompany =0;
    @Override
    public void saveStudent(Student student) {
        students[numberPeopleOfCompany] = student;
        numberPeopleOfCompany++;
    }
}
