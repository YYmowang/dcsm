package nudt.dcsm.elasticsearch.service;

import nudt.dcsm.elasticsearch.entity.enums.ResTypeSec;

import java.util.List;

public interface ResTypeSecESService {
    void save(ResTypeSec resTypeSec);
    void saveAll(List<ResTypeSec> resTypeSecList);

}
