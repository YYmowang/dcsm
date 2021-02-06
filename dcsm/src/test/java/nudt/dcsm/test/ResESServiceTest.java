package nudt.dcsm.test;

import nudt.dcsm.elasticsearch.entity.command.Command;
import nudt.dcsm.elasticsearch.entity.command.Parameter;
import nudt.dcsm.elasticsearch.entity.command.URL;
import nudt.dcsm.elasticsearch.entity.resource.*;
import nudt.dcsm.elasticsearch.service.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ResESServiceTest {
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
        System.out.println("create and put index of ResDC...");
        elasticsearchTemplate.createIndex(ResDC.class);
        elasticsearchTemplate.putMapping(ResDC.class);
        System.out.println("create and put index of ResPhy...");
        elasticsearchTemplate.createIndex(ResPhy.class);
        elasticsearchTemplate.putMapping(ResPhy.class);
        System.out.println("create and put index of ResVtl...");
        elasticsearchTemplate.createIndex(ResVtl.class);
        elasticsearchTemplate.putMapping(ResVtl.class);
        System.out.println("create and put index of ResSys...");
        elasticsearchTemplate.createIndex(ResSys.class);
        elasticsearchTemplate.putMapping(ResSys.class);
        System.out.println("create and put index of ResSec...");
        elasticsearchTemplate.createIndex(ResSec.class);
        elasticsearchTemplate.putMapping(ResSec.class);
    }

    @Test
    public void saveRes() {
        System.out.println("\n TESTING saveRes()...\n");
        Topo to = new Topo();
        try {
            System.out.println("save ResDC...");
            ResDC resDC = new ResDC("1", "NUDT Data Center", "NUDT Data Center", "2020-10-18 15:11:12",
                    1,1,"This is an example of data center doc",
                    "China","Hunan","Changsha",80,121,0,1 ,to);
            resDCESService.save(resDC);

            System.out.println("save ResPhy...");
            ResPhy resPhy = new ResPhy("1-4", "Server No. 1", "ubuntu","2020-10-18 15:11:12",
                    2,4, "This is the first physical res in NUDT Data Center",
                    1,"服务器", true, null,
                    2,1,0,
                    "NUDT Data Center","1",1,to);
            resPhyESService.save(resPhy);

            System.out.println("save ResVtl...");
            ResVtl resVtl = new ResVtl("1-1-1", "User VM NO. 1", "kylin","2020-10-18 15:11:12",
                    3, 1, "This is a user vm", 2,"业务虚拟机",true,null,
                    "Server NO. 1","1-1",2,null,null,to);
            resVtlESService.save(resVtl);

            System.out.println("save ResSys...");
            ResSys resSys = new ResSys("1-1-13","Elastics","Elastics","2020-10-19 18:11:12",
                    2,13,"This is a Elastics",4,"Elastics",true,
                    "6.6.6.6",9200,"5.5.1",3,"Server NO.1","1-1",2,to);
            resSysESService.save(resSys);

            System.out.println("save ResSec...");
            List<Parameter> parameterList = new ArrayList<Parameter>();
            parameterList.add(new Parameter("ip","IP地址","ES服务地址",
                    "IPv4地址，例如X.X.X.X","*.*.*.*",false,"127.0.0.1"));
            parameterList.add(new Parameter("port","端口","ES服务端口",
                    "0-65538","0-655538",false,"9200"));
            List<Command> commandList = new ArrayList<Command>();
            List<URL> urlList = new ArrayList<URL>();
            commandList.add(new Command("start","启动","启动ES服务",2, parameterList));
            ResSec resSec = new ResSec("1-1-14","Elastics","Elastics","2020-10-19 18:11:12",
                    2,14,"",
                    4,"Elastics",true,"6.6.6.6",9200,"5.5.1", commandList,urlList,
                    "Server NO.1","1-1",2,to);
            resSecESService.save(resSec);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
