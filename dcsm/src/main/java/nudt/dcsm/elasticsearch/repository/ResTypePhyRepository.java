package nudt.dcsm.elasticsearch.repository;

import nudt.dcsm.elasticsearch.entity.enums.ResTypePhy;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ResTypePhyRepository extends ElasticsearchRepository<ResTypePhy,String> {
}
