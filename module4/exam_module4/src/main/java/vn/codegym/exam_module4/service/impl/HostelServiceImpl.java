package vn.codegym.exam_module4.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.exam_module4.entity.Hostel;
import vn.codegym.exam_module4.repository.IHostelRepository;
import vn.codegym.exam_module4.service.IHostelService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HostelServiceImpl implements IHostelService {
    @Autowired
    private IHostelRepository hostelRepository;
    @Override
    public List<Hostel> findAll() {
        return hostelRepository.findAll();
    }

    @Override
    public List<Hostel> findHostelFree() {
        return hostelRepository.findHostelByStatus(true);
    }

}
