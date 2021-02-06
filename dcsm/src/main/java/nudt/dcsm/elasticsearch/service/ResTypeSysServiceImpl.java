package nudt.dcsm.elasticsearch.service;

import nudt.dcsm.elasticsearch.entity.enums.ResTypeSys;
import nudt.dcsm.elasticsearch.entity.resource.ResSys;
import nudt.dcsm.elasticsearch.repository.ResTypeSysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResTypeSysServiceImpl implements ResTypeSysESService {

    private ResTypeSysRepository resTypeSysRepository;

    @Autowired
    public void setResTypeSysRepository(ResTypeSysRepository resTypeSysRepository) {
        this.resTypeSysRepository = resTypeSysRepository;
    }

    @Override
    public void saveAll(List<ResTypeSys> resTypeSysList) {
        resTypeSysRepository.saveAll(resTypeSysList);
    }




}
