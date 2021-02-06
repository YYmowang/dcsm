package nudt.demo.service;

import nudt.demo.entity.Student;

import java.util.List;

public interface StudentESService {
    void save(Student student);
    void saveAll(List<Student> studentList);
    Student findById(String id);
    Iterable<Student> findBySex(String sex);
    Iterable<Student> findAll();
    void deleteById(String id);
    void deleteByEntity(Student student);
    void deleteAll();
    void deleteAllEntities(List<Student> studentList);
}
