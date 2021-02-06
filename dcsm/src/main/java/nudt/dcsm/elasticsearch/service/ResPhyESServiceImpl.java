package nudt.dcsm.elasticsearch.service;

import nudt.dcsm.elasticsearch.entity.resource.ResPhy;
import nudt.dcsm.elasticsearch.repository.ResPhyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ResPhyESServiceImpl implements ResPhyESService{
    private ResPhyRepository resPhyRepository;

    @Autowired
    public void setResPhyRepository(ResPhyRepository resPhyRepository) {
        this.resPhyRepository = resPhyRepository;
    }
    @Override
    public void save(ResPhy resPhy) {
        this.resPhyRepository.save(resPhy);
    }

    @Override
    public void saveAll(List<ResPhy> resPhyList) {
        this.resPhyRepository.saveAll(resPhyList);
    }

    @Override
    public ResPhy findById(String id) {
        return this.resPhyRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteByEntity(ResPhy resPhy) {
        this.resPhyRepository.delete(resPhy);
    }

}