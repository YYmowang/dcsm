package nudt.dcsm.elasticsearch.repository;

import nudt.dcsm.elasticsearch.entity.resource.ResSys;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface ResSysRepository extends ElasticsearchRepository<ResSys, String> {

    List<ResSys> findByResType(String resType);
}
