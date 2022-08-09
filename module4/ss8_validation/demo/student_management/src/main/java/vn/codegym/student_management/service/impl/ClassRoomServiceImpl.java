package vn.codegym.student_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.student_management.model.ClassRoom;
import vn.codegym.student_management.repository.IClassRoomRepository;
import vn.codegym.student_management.service.IClassRoomService;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ClassRoomServiceImpl implements IClassRoomService {
    @Autowired
    IClassRoomRepository classRoomRepository;
    @Override
    public Iterable<ClassRoom> findAll() {
        return classRoomRepository.findAll();
    }

    @Override
    public Optional<ClassRoom> findById(Long id) {
        return classRoomRepository.findById(id);
    }

    @Override
    public void save(ClassRoom classRoom) {
        classRoomRepository.save(classRoom);
    }

    @Override
    public void delete(Long id) {
        classRoomRepository.deleteById(id);
    }
}
