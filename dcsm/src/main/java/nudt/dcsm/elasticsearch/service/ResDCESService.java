package nudt.dcsm.elasticsearch.service;

import nudt.dcsm.elasticsearch.entity.resource.ResDC;

import java.util.List;

public interface ResDCESService {
    void save(ResDC resDateCenter);
    void saveAll(List<ResDC> resDateCenterList);
    ResDC findById(String id);
    void deleteByEntity(ResDC resDateCenter);
}
