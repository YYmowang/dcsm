package nudt.dcsm.elasticsearch.service;

import nudt.dcsm.elasticsearch.entity.resource.ResDC;
import nudt.dcsm.elasticsearch.repository.ResDCRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ResDCESServiceImpl implements ResDCESService {
    private ResDCRepository resDataCenterRepository;

    @Autowired
    public void setResDataCenterRepository(ResDCRepository resDataCenterRepository) {
        this.resDataCenterRepository = resDataCenterRepository;
    }

    @Override
    public void save(ResDC resDateCenter) {
        this.resDataCenterRepository.save(resDateCenter);
    }

    @Override
    public void saveAll(List<ResDC> resDateCenterList) {
        this.resDataCenterRepository.saveAll(resDateCenterList);
    }

    @Override
    public ResDC findById(String id) {
        return this.resDataCenterRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteByEntity(ResDC resDateCenter) {
        this.resDataCenterRepository.delete(resDateCenter);
    }
}