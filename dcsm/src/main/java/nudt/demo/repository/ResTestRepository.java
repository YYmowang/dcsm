package nudt.demo.repository;

import nudt.demo.entity.ResTest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResTestRepository extends ElasticsearchRepository<ResTest,String> {
}
