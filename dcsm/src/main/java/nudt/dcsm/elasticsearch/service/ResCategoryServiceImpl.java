package nudt.dcsm.elasticsearch.service;

import nudt.dcsm.elasticsearch.entity.enums.ResCategory;
import nudt.dcsm.elasticsearch.repository.ResCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResCategoryServiceImpl implements ResCategoryESService {

    private ResCategoryRepository resCategoryRepository;

    @Autowired

    public void setResTypePhyRepository(ResCategoryRepository resCategoryRepository) {
        this.resCategoryRepository = resCategoryRepository;
    }

    @Override
    public void saveAll(List<ResCategory> resCategoryList) {
        resCategoryRepository.saveAll(resCategoryList);
    }

}
