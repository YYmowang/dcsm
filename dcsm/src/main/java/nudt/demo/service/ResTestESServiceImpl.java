package nudt.demo.service;


import nudt.demo.entity.ResTest;
import nudt.demo.repository.ResTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResTestESServiceImpl implements ResTestESService {

    private ResTestRepository resTestRepository;

    @Autowired
    public void setResTestRepository(ResTestRepository resTestRepository) {
        this.resTestRepository = resTestRepository;
    }

    @Override
    public void save(ResTest resTest) {
        this.resTestRepository.save(resTest);
    }

    @Override
    public void saveAll(List<ResTest> resTestList) {

    }

    @Override
    public ResTest findById(String id) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public void deleteByEntity(ResTest resTest) {

    }

    @Override
    public List<ResTest> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
