package nudt.dcsm.configuration;

import nudt.dcsm.elasticsearch.entity.enums.*;
import nudt.dcsm.elasticsearch.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@Component
//确保包名正确
@EnableElasticsearchRepositories(basePackages = "nudt.dcsm.elasticsearch.repository")
//经测试，只能放在这里
@PropertySource(value = {"classpath:esconfig.properties", //ES名称地址等
        "classpath:restypeconfig.properties",   //Restype初始化文件位置及名称
        "classpath:resconfig.properties"})      //Res初始化文件位置及名称

public class BeanConfig {


    public BeanConfig(){
        System.out.println("BeanConfig容器启动，初始化Bean。。。");
    }

    //解决读取多个properties文件出错问题
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public ElasticConfig elasticConfig(){
        System.out.println("Create Bean \"elasticConfig\"");
        return new ElasticConfig();
    }

    @Bean
    public ResTypeConfig resTypeConfig() {
        System.out.println("Create Bean \"resTypeConfig\"");
        return new ResTypeConfig();
    }

    @Bean
    public ResConfig resConfig() {
        System.out.println("Create Bean \"resConfig\"");
        return new ResConfig();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        System.out.println("Create Bean \"elasticsearchTemplate\"");
        //创建TransportClient实例
        elasticConfig().createTransportClient();
        return new ElasticsearchTemplate(elasticConfig().getClient());
    }

    @Bean
    public ResCategoryESService resCategoryESService() {
        System.out.println("Create Bean \"resCategoryESService\"");
        this.recreateIndexIfExist(ResCategory.class);
        return new ResCategoryServiceImpl();
    }

    @Bean
    public ResTypePhyESService resTypePhyESService() {
        System.out.println("Create Bean \"resTypePhyESService\"");
        this.recreateIndexIfExist(ResTypePhy.class);
        return new ResTypePhyServiceImpl();
    }
    @Bean
    public ResTypeVtlESService resTypeVtlESService() {
        System.out.println("Create Bean \"resTypeVtlESService\"");
        this.recreateIndexIfExist(ResTypeVtl.class);
        return new ResTypeVtlServiceImpl();
    }

    @Bean
    public ResTypeSysESService resTypeSysESService() {
        System.out.println("Create Bean \"resTypeSysESService\"");
        this.recreateIndexIfExist(ResTypeSys.class);
        return new ResTypeSysServiceImpl();
    }
    @Bean
    public ResTypeSecESService resTypeSecESService() {
        System.out.println("Create Bean \"resTypeSecESService\"");
        this.recreateIndexIfExist(ResTypeSec.class);
        return new ResTypeSecServiceImpl();
    }

    /**
     * 以下为资源相关服务
     */
    @Bean
    public ResDCESService resDCESService(){
        System.out.println("Create Bean \"resDCESService\"");
        return new ResDCESServiceImpl();
    }
    @Bean
    public ResPhyESService resPhyESService(){
        System.out.println("Create Bean \"resPhyESService\"");
        return new ResPhyESServiceImpl();
    }
    @Bean
    public ResVtlESService resVtlESService(){
        System.out.println("Create Bean \"resVtlESService\"");
        return new ResVtlESServiceImpl();
    }
    @Bean
    public ResSysESService resSysESService(){
        System.out.println("Create Bean \"resSysESService\"");
        return new ResSysESServiceImpl();
    }
    @Bean
    public ResSecESService resSecESService(){
        System.out.println("Create Bean \"resSecESService\"");
        return new ResSecESServiceImpl();
    }

    @Bean
    public ResTopolinkESService resTopolinkESService(){
        System.out.println("Create Bean \"resTopolinkESService\"");
        return new ResTopolinkESServiceImpl();
    }


    /**
     * 判断索引是否已经存在，若存在则删除重建
     * 防止开发环境中因新旧索引mapping不同导致的错误
     * @param aclass
     * @param <T>
     */
    private <T> void recreateIndexIfExist(Class<T> aclass){
        try {
            //若索引已存在则删除重建，防止与已有索引映射不一致报错
            if(elasticsearchTemplate().indexExists(aclass))
                elasticsearchTemplate().deleteIndex(aclass);
            elasticsearchTemplate().createIndex(aclass);
            elasticsearchTemplate().putMapping(aclass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private <T> void recreateIndexIfExist2(Class<T> aclass){
        ApplicationContext context = new AnnotationConfigApplicationContext(nudt.dcsm.configuration.BeanConfig.class);
        ElasticsearchTemplate elasticsearchTemplate = (ElasticsearchTemplate) context.getBean("elasticsearchTemplate");
        try {
            //若索引已存在则删除重建，防止与已有索引映射不一致报错
            if(elasticsearchTemplate.indexExists(aclass)){
                Map<Object, Object> mapping = new LinkedHashMap<Object, Object>();
                elasticsearchTemplate.deleteIndex(aclass);
            }

            elasticsearchTemplate.createIndex(aclass);
            elasticsearchTemplate.putMapping(aclass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
