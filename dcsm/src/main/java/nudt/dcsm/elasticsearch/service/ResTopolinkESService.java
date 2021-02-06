package nudt.dcsm.elasticsearch.service;

import nudt.dcsm.elasticsearch.entity.resource.ResVtl;
import nudt.dcsm.elasticsearch.entity.resource.TopoLink;

import java.util.List;

public interface ResTopolinkESService {
    void save(TopoLink tpoLink);
    void saveAll(List<TopoLink> tpoLinkList);
    TopoLink findById(String id);
    void deleteByEntity(TopoLink resVtl);

}
