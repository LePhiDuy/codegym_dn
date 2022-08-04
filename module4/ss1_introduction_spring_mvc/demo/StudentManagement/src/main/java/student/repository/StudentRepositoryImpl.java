package student.repository;

import org.springframework.stereotype.Repository;
import student.model.Student;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements IStudentRepository{
    private static List<Student> students;
    static {
        students = new ArrayList<>();
        students.add(new Student(1, "Le Phi Duy", 1, new String[] {"Java", "C#"}));
        students.add(new Student(2, "Hoang Thi C", 2, new String[] {"Java", "C#"}));
        students.add(new Student(3, "Van Ve", 3, new String[] {"Java", "PHP"}));
    }
    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void save(Student student) {
        students.add(student);
    }
    public List<Student> findByName(String keyword) {
        List<Student> result = new ArrayList<>();
        for(Student student: students){
            if(student.getName().contains(keyword)){
                result.add(student);
            }
        }
        return result;
    }
}
