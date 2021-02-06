package nudt.dcsm.elasticsearch.service;

import nudt.dcsm.elasticsearch.entity.resource.ResVtl;

import java.util.List;

public interface ResVtlESService {
    void save(ResVtl resVtl);
    void saveAll(List<ResVtl> resVtlList);
    ResVtl findById(String id);
    void deleteByEntity(ResVtl resVtl);
    ResVtl findByIp(String ip);
}
