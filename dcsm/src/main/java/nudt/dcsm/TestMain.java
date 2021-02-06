package nudt.dcsm;

import nudt.dcsm.elasticsearch.entity.resource.ResSys;
import nudt.dcsm.elasticsearch.service.ResSysESService;
import nudt.dcsm.grpc.regSevice;
import nudt.dcsm.initialization.InitializeMain;
import nudt.demo.configuration.BeanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {

    public static void main(String[] args) {

        // @Configuration注解的spring容器加载方式，用AnnotationConfigApplicationContext替换ClassPathXmlApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(nudt.dcsm.configuration.BeanConfig.class);


        // 如果加载spring-context.xml文件：
        // ApplicationContext context = new
        // ClassPathXmlApplicationContext("spring-context.xml");

/*        //获取bean
        StudentESService studentESService = (StudentESService) context.getBean("studentESService");
        studentESService.save(new Student("9", "man", 35, "Wang1", "Fei1", "1985-03-04",
                "China", "Hunan", "Changsha", 90, 102, "这是我的格言"));

        Iterable<Student> studentList = studentESService.findAll();
        System.out.println("\n All docs found:");
        studentList.forEach(student -> System.out.println(JSONObject.fromObject(student).toString()));*/



        ResSysESService resSysESService = (ResSysESService) context.getBean("resSysESService");
        InitializeMain in = new InitializeMain();
        in.initialize(context);
        //String id = "1-1-5";
        for(int i =1;i<=5;i++){
            String id = "1-"+"1"+"-"+i;
            System.out.println("Sys ------id:"+id);
            ResSys re2 = resSysESService.findById(id);
            if(re2 != null) {
                System.out.println(re2.getId() + "|" + re2.getSn());
            }
        }
        //ResSys re2 = resSysESService.findById(id);




    }
}
