package nudt.dcsm.elasticsearch.service;

import nudt.dcsm.elasticsearch.entity.enums.ResTypeSys;
import nudt.dcsm.elasticsearch.entity.resource.ResSys;
import nudt.dcsm.elasticsearch.entity.resource.ResVtl;

import java.util.List;

public interface ResTypeSysESService {

    void saveAll(List<ResTypeSys> resTypeSysList);


}
