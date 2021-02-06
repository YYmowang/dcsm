package nudt.dcsm.initialization;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InitializeMain {


    public void  initialize(ApplicationContext context) {

        //ApplicationContext context = new AnnotationConfigApplicationContext(nudt.dcsm.configuration.BeanConfig.class);


        InitializeResType initializeResCategory = new InitializeResType(context);
        initializeResCategory.initResCategory();
        initializeResCategory.initResTypePhy();
        initializeResCategory.initResTypeVtl();
        initializeResCategory.initResTypeSys();
        initializeResCategory.initResTypeSec();

       /* InitializeRes initializeRes = new InitializeRes(context);
        initializeRes.initResDC();
        initializeRes.initResPhy();
        initializeRes.initResVtl();
        initializeRes.initResSys();
        initializeRes.initResSec();*/

    }
}
