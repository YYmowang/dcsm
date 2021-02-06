package nudt.dcsm.elasticsearch.repository;

import nudt.dcsm.elasticsearch.entity.resource.ResVtl;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface ResVtlRepository extends ElasticsearchRepository<ResVtl, String> {

    ResVtl findByIp(String ip);
}
