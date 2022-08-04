package student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.model.Student;
import student.repository.IStudentRepository;
import student.repository.StudentRepositoryImpl;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }
}
