package nudt.demo.service;



import nudt.demo.entity.ResTest;

import java.util.List;

public interface ResTestESService {
    void save(ResTest resTest);
    void saveAll(List<ResTest> resTestList);
    ResTest findById(String id);
    void deleteById(String id);
    void deleteByEntity(ResTest resTest);
    List<ResTest> findAll();
    void deleteAll();
}
