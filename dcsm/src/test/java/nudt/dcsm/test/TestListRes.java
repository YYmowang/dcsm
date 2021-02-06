package nudt.dcsm.test;

import nudt.dcsm.elasticsearch.entity.resource.*;
import nudt.dcsm.elasticsearch.service.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.ArrayList;
import java.util.List;


public class TestListRes {
    ApplicationContext context = new AnnotationConfigApplicationContext(nudt.dcsm.configuration.BeanConfig.class);

    ResDCESService resDCESService = (ResDCESService) context.getBean("resDCESService");
    ResPhyESService resPhyESService = (ResPhyESService) context.getBean("resPhyESService");
    ResVtlESService resVtlESService = (ResVtlESService) context.getBean("resVtlESService");
    ResSysESService resSysESService = (ResSysESService) context.getBean("resSysESService");
    ResSecESService resSecESService = (ResSecESService) context.getBean("resSecESService");
    ElasticsearchTemplate elasticsearchTemplate = (ElasticsearchTemplate) context.getBean("elasticsearchTemplate");

    @Test
    public void createResIndex() throws Exception {
        System.out.println("\n TESTING createResIndex()...\n");

        System.out.println("create and put index of ResVtl...");
        elasticsearchTemplate.createIndex(ResVtl.class);
        elasticsearchTemplate.putMapping(ResVtl.class);

    }

    @Test
    public void saveRes() {
        System.out.println("\n TESTING saveRes()...\n");
     
            String ip="1.1.1.1";
            List<String> ips = new ArrayList<>();
            ips.add(ip);
            Topo to = new Topo();
            ips.add("2.2.2.2");
            System.out.println("save ResVtl...");
            ResVtl resVtl = new ResVtl("1-1-1", "User VM NO. 1", "kylin","2020-10-18 15:11:12",
                    3, 1, "This is a user vm", 2,"业务虚拟机",true,ips,
                    "Server NO. 1","1-1",2,null,null,to);
            resVtlESService.save(resVtl);

            ResVtl rl = resVtlESService.findByIp("1.1.1.1");
            System.out.println("rl :" + rl.getId()+"|"+rl.getIp().get(0)+"|"+rl.getIp().get(1));


    }
}

