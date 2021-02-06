package nudt.dcsm.test;

import nudt.dcsm.elasticsearch.entity.enums.ResTypePhy;
import nudt.dcsm.elasticsearch.entity.enums.ResTypeSec;
import nudt.dcsm.elasticsearch.entity.enums.ResTypeSys;
import nudt.dcsm.elasticsearch.entity.enums.ResTypeVtl;
import nudt.dcsm.elasticsearch.service.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.ArrayList;
import java.util.List;

public class ResTypeESServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(nudt.dcsm.configuration.BeanConfig.class);

    ResTypePhyESService resTypePhyESService = (ResTypePhyESService)
            context.getBean("resTypePhyESService");
    ResTypeVtlESService resTypeVtlESService = (ResTypeVtlESService)
            context.getBean("resTypeVtlESService");
    ResTypeSysESService resTypeSysESService = (ResTypeSysESService)
            context.getBean("resTypeSysESService");
    ResTypeSecESService resTypeSecESService = (ResTypeSecESService)
            context.getBean("resTypeSecESService");

    ElasticsearchTemplate elasticsearchTemplate = (ElasticsearchTemplate) context.getBean("elasticsearchTemplate");

    @Test
    public void createResTypeIndex() throws Exception {
        System.out.println("\n TESTING createResTypeIndex()...\n");
        System.out.println("create and put index of ResTypePhy...");
        elasticsearchTemplate.createIndex(ResTypePhy.class);
        elasticsearchTemplate.putMapping(ResTypePhy.class);
        System.out.println("create and put index of ResTypeVtl...");
        elasticsearchTemplate.createIndex(ResTypeVtl.class);
        elasticsearchTemplate.putMapping(ResTypeVtl.class);
        System.out.println("create and put index of ResTypeSys...");
        elasticsearchTemplate.createIndex(ResTypeSys.class);
        elasticsearchTemplate.putMapping(ResTypeSys.class);
        System.out.println("create and put index of ResTypeSec...");
        elasticsearchTemplate.createIndex(ResTypeSec.class);
        elasticsearchTemplate.putMapping(ResTypeSec.class);
    }

    @Test
    public void saveResType() {
        System.out.println("\n TESTING saveResType()...\n");

        System.out.println("save ResTypePhy...");
        ResTypePhy resTypePhy = new ResTypePhy("其它");
        List<ResTypePhy> resTypePhyList = new ArrayList<ResTypePhy>();
        resTypePhyList.add(resTypePhy);
        resTypePhyESService.saveAll(resTypePhyList);

        System.out.println("save ResTypeVtl...");
        ResTypeVtl resTypeVtl = new ResTypeVtl("其它");
        List<ResTypeVtl> resTypeVtlList = new ArrayList<ResTypeVtl>();
        resTypeVtlList.add(resTypeVtl);
        resTypeVtlESService.saveAll(resTypeVtlList);

        System.out.println("save ResTypeSys...");
        ResTypeSys resTypeSys = new ResTypeSys("其它");
        List<ResTypeSys> resTypeSysList = new ArrayList<ResTypeSys>();
        resTypeSysList.add(resTypeSys);
        resTypeSysESService.saveAll(resTypeSysList);

        /*System.out.println("save ResTypeSec...");
        ResTypeSec resTypeSec = new ResTypeSec(0,"其它");
        List<ResTypeSec> resTypeSecList = new ArrayList<ResTypeSec>();
        resTypeSecList.add(resTypeSec);
        resTypeSecESService.saveAll(resTypeSecList);*/
    }
}
