package nudt.dcsm.elasticsearch.service;

import nudt.dcsm.elasticsearch.entity.resource.ResSec;

import java.util.List;

public interface ResSecESService {
    void save(ResSec resSec);
    void saveAll(List<ResSec> resSecList);
    ResSec findById(String id);
    void deleteByEntity(ResSec resSec);
}
