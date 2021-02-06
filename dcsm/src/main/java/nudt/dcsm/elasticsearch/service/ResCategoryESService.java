package nudt.dcsm.elasticsearch.service;

import nudt.dcsm.elasticsearch.entity.enums.ResCategory;

import java.util.List;

public interface ResCategoryESService {
    void saveAll(List<ResCategory> resCategoryList);

}
