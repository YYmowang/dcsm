package nudt.dcsm.elasticsearch.repository;

import nudt.dcsm.elasticsearch.entity.enums.ResTypeSys;
import nudt.dcsm.elasticsearch.entity.resource.ResSys;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ResTypeSysRepository extends ElasticsearchRepository<ResTypeSys,String> {


}
