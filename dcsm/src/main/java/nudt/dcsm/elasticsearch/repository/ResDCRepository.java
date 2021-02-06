package nudt.dcsm.elasticsearch.repository;

import nudt.dcsm.elasticsearch.entity.resource.ResDC;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface ResDCRepository extends ElasticsearchRepository<ResDC, String> {
}
