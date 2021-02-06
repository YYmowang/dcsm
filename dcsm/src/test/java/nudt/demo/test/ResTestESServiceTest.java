package nudt.demo.test;

import net.sf.json.JSONObject;
import nudt.demo.configuration.BeanConfig;
import nudt.demo.entity.ResTest;
import nudt.demo.service.ResTestESService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.ArrayList;
import java.util.List;

public class ResTestESServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

    ResTestESService resTestESService = (ResTestESService) context.getBean("resTestESService");
    ElasticsearchTemplate elasticsearchTemplate = (ElasticsearchTemplate) context.getBean("elasticsearchTemplate");

    @Test
    public void createIndex() throws Exception {
        System.out.println("TESTING createIndex()...");
        elasticsearchTemplate.createIndex(ResTest.class);
        elasticsearchTemplate.putMapping(ResTest.class);
    }

    @Test
    public void saveResTest() {
        System.out.println("TESTING save()...");
        ResTest resTest = null;
        resTest = new ResTest("id1", "name1");
        resTestESService.save(resTest);
    }

    @Test
    public void saveAllResTest(){
        System.out.println("TESTING saveAll()...");
        List<ResTest> resTestList= new ArrayList<ResTest>();
        resTestList.add(new ResTest("1","restest1"));
        resTestList.add(new ResTest("2","restest2"));
        resTestESService.saveAll(resTestList);

    }
    @Test
    public void findResTestById() {
        System.out.println("TESTING findById()...");
        this.saveAllResTest();
        ResTest resTest = resTestESService.findById("2");
        System.out.println("The doc found:");
        System.out.println(JSONObject.fromObject(resTest).toString());
    }

    @Test
    public void findAllResTest(){
        System.out.println("TESTING findAll()...");
        this.saveAllResTest();
        Iterable<ResTest> resTestList = resTestESService.findAll();
        System.out.println("All docs found:");
        if(resTestList != null)
            resTestList.forEach(resTest -> System.out.println(JSONObject.fromObject(resTest).toString()));
    }

    @Test
    public void deleteResTestById(){
        System.out.println("TESTING deleteById()...");
        this.saveAllResTest();
        resTestESService.deleteById("2");
        Iterable<ResTest> resTestList = resTestESService.findAll();
        System.out.println("All docs left:");
        if(resTestList != null)
            resTestList.forEach(resTest -> System.out.println(JSONObject.fromObject(resTest).toString()));
    }

    @Test
    public void deleteAllResTest(){
        System.out.println("TESTING deleteAll()...");
        resTestESService.deleteAll();
        Iterable<ResTest> resTestList = resTestESService.findAll();
        System.out.println("All docs left:");
        if(resTestList !=null) resTestList.forEach(resTest -> System.out.println(JSONObject.fromObject(resTest).toString()));
    }

    @Test
    public void deteleResTestnByEntity(){
        System.out.println("TESTING deleteByEntity()...");
        ResTest resTest = resTestESService.findById("2");
        resTestESService.deleteByEntity(resTest);
        Iterable<ResTest> resTestList = resTestESService.findAll();
        System.out.println("All docs left:");
        if(resTestList != null)
            resTestList.forEach(resTest1 -> System.out.println(JSONObject.fromObject(resTest1).toString()));
    }
}
