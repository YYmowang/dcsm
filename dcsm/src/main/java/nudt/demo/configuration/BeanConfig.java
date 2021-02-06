package nudt.demo.configuration;

import nudt.demo.service.*;
import nudt.demo.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Component;

@Configuration
@Component
//确保包名正确
@EnableElasticsearchRepositories(basePackages = "nudt.demo.repository")
//经测试，只能放在这里
@PropertySource("classpath:esconfig.properties")
public class BeanConfig {
    public BeanConfig() {
        System.out.println("BeanConfig容器启动，初始化Bean。。。");
    }

    @Bean
    public ElasticConfig elasticConfig() {
        System.out.println("Create Bean \"elasticConfig\"");
        return new ElasticConfig();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        System.out.println("Create Bean \"elasticsearchTemplate\"");
        //创建TransportClient实例
        elasticConfig().createTransportClient();
        return new ElasticsearchTemplate(elasticConfig().getClient());
    }

    @Bean
    public StudentESService studentESService() {
        System.out.println("Create Bean \"studentESService\"");
        return new StudentESServiceImpl();
    }
    @Bean
    public ResTestESService resTestESService() {
        System.out.println("Create Bean \"resTestESService\"");
        return new ResTestESServiceImpl();
    }


}