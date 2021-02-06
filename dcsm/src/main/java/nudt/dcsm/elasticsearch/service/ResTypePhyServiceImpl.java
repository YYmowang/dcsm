package nudt.dcsm.elasticsearch.service;

import nudt.dcsm.elasticsearch.entity.enums.ResTypePhy;
import nudt.dcsm.elasticsearch.repository.ResTypePhyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResTypePhyServiceImpl implements ResTypePhyESService {

    private ResTypePhyRepository resTypePhyRepository;

    @Autowired
    public void setResTypePhyRepository(ResTypePhyRepository resTypePhyRepository) {
        this.resTypePhyRepository = resTypePhyRepository;
    }

    @Override
    public void saveAll(List<ResTypePhy> resTypePhyList) {
        resTypePhyRepository.saveAll(resTypePhyList);
    }
}
