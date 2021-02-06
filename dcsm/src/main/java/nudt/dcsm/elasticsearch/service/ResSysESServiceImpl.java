package nudt.dcsm.elasticsearch.service;

import nudt.dcsm.elasticsearch.entity.resource.ResSys;
import nudt.dcsm.elasticsearch.repository.ResSysRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ResSysESServiceImpl implements ResSysESService{
    private ResSysRepository resSysRepository;

    @Autowired
    public void setResSysRepository(ResSysRepository resSysRepository) {
        this.resSysRepository = resSysRepository;
    }

    @Override
    public void save(ResSys resSys) {
        this.resSysRepository.save(resSys);
    }

    @Override
    public void saveAll(List<ResSys> resSysList) {
        this.resSysRepository.saveAll(resSysList);
    }

    @Override
    public ResSys findById(String id) {
        return this.resSysRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteByEntity(ResSys resSys) {
        this.resSysRepository.delete(resSys);
    }

    @Override
    public List<ResSys> findByResType(String resType) {
        return  this.resSysRepository.findByResType(resType);
    }

}