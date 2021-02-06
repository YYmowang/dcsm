package nudt.dcsm.elasticsearch.service;

import nudt.dcsm.elasticsearch.entity.resource.ResVtl;
import nudt.dcsm.elasticsearch.repository.ResVtlRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ResVtlESServiceImpl implements ResVtlESService{
    private ResVtlRepository resVtlRepository;

    @Autowired
    public void setResVtlRepository(ResVtlRepository resVtlRepository) {
        this.resVtlRepository = resVtlRepository;
    }
    @Override
    public void save(ResVtl resVtl) {
        this.resVtlRepository.save(resVtl);
    }

    @Override
    public void saveAll(List<ResVtl> resVtlList) {
        this.resVtlRepository.saveAll(resVtlList);
    }

    @Override
    public ResVtl findById(String id) {
        return this.resVtlRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteByEntity(ResVtl resVtl) {
        this.resVtlRepository.delete(resVtl);
    }

    @Override
    public ResVtl findByIp(String ip) {
        return this.resVtlRepository.findByIp(ip);
    }
}