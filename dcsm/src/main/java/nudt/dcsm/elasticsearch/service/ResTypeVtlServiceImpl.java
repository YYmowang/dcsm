package nudt.dcsm.elasticsearch.service;

import nudt.dcsm.elasticsearch.entity.enums.ResTypeVtl;
import nudt.dcsm.elasticsearch.repository.ResTypeVtlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResTypeVtlServiceImpl implements ResTypeVtlESService {

    private ResTypeVtlRepository resTypeVtlRepository;

    @Autowired
    public void setResTypeVtlRepository(ResTypeVtlRepository resTypeVtlRepository) {
        this.resTypeVtlRepository = resTypeVtlRepository;
    }

    @Override
    public void saveAll(List<ResTypeVtl> resTypeVtlList) {
        resTypeVtlRepository.saveAll(resTypeVtlList);
    }

}
