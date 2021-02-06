package nudt.dcsm.elasticsearch.service;

import nudt.dcsm.elasticsearch.entity.resource.ResPhy;

import java.util.List;

public interface ResPhyESService {
    void save(ResPhy resPhy);
    void saveAll(List<ResPhy> resPhyList);
    ResPhy findById(String id);
    void deleteByEntity(ResPhy resPhy);
}
