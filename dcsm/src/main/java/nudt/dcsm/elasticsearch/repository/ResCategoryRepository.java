package nudt.dcsm.elasticsearch.repository;

import nudt.dcsm.elasticsearch.entity.enums.ResCategory;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ResCategoryRepository extends ElasticsearchRepository<ResCategory,String> {
}
