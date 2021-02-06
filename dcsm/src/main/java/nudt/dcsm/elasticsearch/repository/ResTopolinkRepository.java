package nudt.dcsm.elasticsearch.repository;

import nudt.dcsm.elasticsearch.entity.resource.TopoLink;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ResTopolinkRepository extends ElasticsearchRepository<TopoLink,String> {
}
