package nudt.dcsm;

import nudt.dcsm.elasticsearch.entity.resource.*;
import nudt.dcsm.elasticsearch.service.*;
import nudt.dcsm.grpc.RegisterServer;
import nudt.dcsm.initialization.InitializeMain;
import nudt.dcsm.websocket.SocketServer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class MianThread{
    static ApplicationContext context = null;

    public static ApplicationContext Application(){

        if(context == null){
            context  = new AnnotationConfigApplicationContext(nudt.dcsm.configuration.BeanConfig.class);
        }
        return context;
    }

    public static void main(String[] args) {

        context = Application();

        ResDCESService resDCESService = (ResDCESService) context.getBean("resDCESService");
        ResPhyESService resPhyESService = (ResPhyESService) context.getBean("resPhyESService");
        ResVtlESService resVtlESService = (ResVtlESService) context.getBean("resVtlESService");
        ResSysESService resSysESService = (ResSysESService) context.getBean("resSysESService");
        ResSecESService resSecESService = (ResSecESService) context.getBean("resSecESService");
        ElasticsearchTemplate elasticsearchTemplate = (ElasticsearchTemplate) context.getBean("elasticsearchTemplate");


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


            InitializeMain  in = new InitializeMain();
            in.initialize(context);

            getThread1().start();
            getThread2().start();
    }


    public static Thread getThread1()
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                final RegisterServer server = new RegisterServer();
                try {

                    server.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    server.blockUntilShutdown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        return thread;
    }

    public static Thread getThread2()
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                new SocketServer(3000).start();
            }
        });

        return thread;
    }
}