package nudt.dcsm.elasticsearch.repository;

import nudt.dcsm.elasticsearch.entity.enums.ResTypeSec;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ResTypeSecRepository extends ElasticsearchRepository<ResTypeSec,Integer> {
}
