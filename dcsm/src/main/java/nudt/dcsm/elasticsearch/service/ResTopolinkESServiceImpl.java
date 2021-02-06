package nudt.dcsm.elasticsearch.service;

import nudt.dcsm.elasticsearch.entity.resource.TopoLink;
import nudt.dcsm.elasticsearch.repository.ResTopolinkRepository;
import nudt.dcsm.elasticsearch.repository.ResVtlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResTopolinkESServiceImpl implements ResTopolinkESService {
    private ResTopolinkRepository resTopolinkRepository;
    @Autowired
    public void setResTopolinkRepository(ResTopolinkRepository resTopolinkRepository) {
        this.resTopolinkRepository = resTopolinkRepository;
    }
    @Override
    public void save(TopoLink tpoLink) {
        this.resTopolinkRepository.save(tpoLink);
    }

    @Override
    public void saveAll(List<TopoLink> tpoLinkList) {
        this.resTopolinkRepository.saveAll(tpoLinkList);
    }

    @Override
    public TopoLink findById(String id) {
        return this.resTopolinkRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteByEntity(TopoLink tpoLink) {
        this.resTopolinkRepository.delete(tpoLink);
    }
}
