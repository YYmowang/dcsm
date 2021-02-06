package nudt.dcsm.elasticsearch.service;

import nudt.dcsm.elasticsearch.entity.resource.ResSys;

import java.util.List;

public interface ResSysESService {
    void save(ResSys resSys);
    void saveAll(List<ResSys> resSysList);
    ResSys findById(String id);
    void deleteByEntity(ResSys resSys);

    List<ResSys> findByResType(String resType);
}
