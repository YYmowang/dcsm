package nudt.dcsm.elasticsearch.repository;

import nudt.dcsm.elasticsearch.entity.resource.ResSec;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface ResSecRepository extends ElasticsearchRepository<ResSec, String> {
}
