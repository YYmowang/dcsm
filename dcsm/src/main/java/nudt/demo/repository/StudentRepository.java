package nudt.demo.repository;

import nudt.demo.entity.Student;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends ElasticsearchRepository<Student,String> {
    Iterable<Student> findBySex(String sex);
}
