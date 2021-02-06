package nudt.dcsm.elasticsearch.repository;

import nudt.dcsm.elasticsearch.entity.resource.ResPhy;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface ResPhyRepository extends ElasticsearchRepository<ResPhy, String> {
}
