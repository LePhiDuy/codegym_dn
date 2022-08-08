package vn.codegym.student_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.student_management.model.Course;
import vn.codegym.student_management.repository.ICourseRepository;
import vn.codegym.student_management.service.ICourseService;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CourseServiceImpl implements ICourseService {
    @Autowired
    ICourseRepository courseRepository;
    @Override
    public Iterable<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }
}
