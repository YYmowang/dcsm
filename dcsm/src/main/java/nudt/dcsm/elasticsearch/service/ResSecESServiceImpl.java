package nudt.dcsm.elasticsearch.service;

import nudt.dcsm.elasticsearch.entity.resource.ResSec;
import nudt.dcsm.elasticsearch.repository.ResSecRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ResSecESServiceImpl implements ResSecESService{
    private ResSecRepository resSecRepository;

    @Autowired
    public void setResSecRepository(ResSecRepository resSecRepository) {
        this.resSecRepository = resSecRepository;
    }

    @Override
    public void save(ResSec resSec) {
        this.resSecRepository.save(resSec);
    }

    @Override
    public void saveAll(List<ResSec> resSecList) {
        this.resSecRepository.saveAll(resSecList);
    }

    @Override
    public ResSec findById(String id) {
        return this.resSecRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteByEntity(ResSec resSec) {
        this.resSecRepository.delete(resSec);
    }

}