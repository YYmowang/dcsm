package nudt.dcsm.elasticsearch.service;

import nudt.dcsm.elasticsearch.entity.enums.ResTypeSec;
import nudt.dcsm.elasticsearch.repository.ResTypeSecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResTypeSecServiceImpl implements ResTypeSecESService {

    private ResTypeSecRepository resTypeSecRepository;

    @Autowired
    public void setResTypeSecRepository(ResTypeSecRepository resTypeSecRepository) {
        this.resTypeSecRepository = resTypeSecRepository;
    }

    @Override
    public void save(ResTypeSec resTypeSec) {
        resTypeSecRepository.save(resTypeSec);
    }

    @Override
    public void saveAll(List<ResTypeSec> resTypeSecList) {
        resTypeSecRepository.saveAll(resTypeSecList);
    }
}
