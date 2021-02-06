package nudt.demo.service;

import nudt.demo.repository.StudentRepository;
import nudt.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentESServiceImpl implements StudentESService {

    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public void saveAll(List<Student> studentList) {
        studentRepository.saveAll(studentList);
    }

    public Student findById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Iterable<Student> findBySex(String sex) {
        return studentRepository.findBySex(sex);
    }

    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    public void deleteById(String id) {
        studentRepository.deleteById(id);
    }

    public void deleteByEntity(Student student) {
        studentRepository.delete(student);
    }

    public void deleteAll() {
        studentRepository.deleteAll();
    }

    public void deleteAllEntities(List<Student> studentList) {
        studentRepository.deleteAll(studentList);
    }
}
