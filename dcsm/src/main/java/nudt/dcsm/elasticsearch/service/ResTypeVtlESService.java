package nudt.dcsm.elasticsearch.service;
import nudt.dcsm.elasticsearch.entity.enums.ResTypeVtl;

import java.util.List;

public interface ResTypeVtlESService {
    void saveAll(List<ResTypeVtl> resTypeVtlList);
}
