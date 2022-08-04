package student.service;

import student.model.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> findAll();
    public void save(Student student);
}
