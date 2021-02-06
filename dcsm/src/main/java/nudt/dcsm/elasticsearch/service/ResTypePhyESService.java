package nudt.dcsm.elasticsearch.service;

import nudt.dcsm.elasticsearch.entity.enums.ResTypePhy;

import java.util.List;

public interface ResTypePhyESService {
    void saveAll(List<ResTypePhy> resTypePhyList);
}
