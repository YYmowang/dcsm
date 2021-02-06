package nudt.dcsm.initialization;

import nudt.dcsm.configuration.ResConfig;
import nudt.dcsm.configuration.ResTypeConfig;
import nudt.dcsm.elasticsearch.entity.enums.ResTypeSec;
import nudt.dcsm.elasticsearch.entity.enums.ResTypeSys;
import nudt.dcsm.elasticsearch.entity.resource.*;
import nudt.dcsm.elasticsearch.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.List;

/**
 * 初始化ResType
 */
public class InitializeRes {
    private ApplicationContext context = null;
    private ResConfig resConfig = null;
    private ElasticsearchTemplate elasticsearchTemplate = null;

    public InitializeRes(){}

    public InitializeRes(ApplicationContext context){
        this.context = context;
    }

    public void initRes(){
        this.context = new AnnotationConfigApplicationContext(nudt.dcsm.configuration.BeanConfig.class);
        this.resConfig =  (ResConfig) context.getBean("resConfig");
        //加载ResTypePhy初始化数据到内存
        //resConfig.loadResInitDada();

        this.elasticsearchTemplate = (ElasticsearchTemplate) context.getBean("elasticsearchTemplate");
        this.initResDC();
        this.initResPhy();
        this.initResVtl();
        this.initResSys();
        this.initResSec();
    }

    public void initResDC()
    {
        ResDCESService resDCESService = (ResDCESService) context.getBean("resDCESService");
        //存储ResDC初始化数据到ES
        List<ResDC> resDCList = this.loadResDCInitDada();
        if (resDCList != null) resDCESService.saveAll(resDCList);
    }
    public void initResPhy()
    {
        ResPhyESService resPhyESService = (ResPhyESService) context.getBean("resPhyESService");
        //存储ResPhy初始化数据到ES
        List<ResPhy> resPhyList = this.loadResPhyInitDada();
        if (resPhyList != null) resPhyESService.saveAll(resPhyList);
    }
    public void initResVtl()
    {
        ResVtlESService resVtlESService = (ResVtlESService) context.getBean("resVtlESService");
        //存储ResVtl初始化数据到ES
        List<ResVtl> resVtlList = this.loadResVtlInitDada();
        if (resVtlList != null) resVtlESService.saveAll(resVtlList);
    }
    public void initResSys()
    {
        ResSysESService resSysESService = (ResSysESService) context.getBean("resSysESService");
        //存储ResSys初始化数据到ES
        List<ResSys> resSysList = this.loadResSysInitDada();
        if (resSysList != null) resSysESService.saveAll(resSysList);
    }
    public void initResSec()
    {
        ResSecESService resSecESService = (ResSecESService) context.getBean("resSecESService");
        //存储ResSec初始化数据到ES
        List<ResSec> resSecList = this.loadResSecInitDada();
        if (resSecList != null)resSecESService.saveAll(resSecList);
    }

    /**
     * 从数据中心资产json文件中加载数据中心资产初始化数据
     * @return 数据中心资产列表
     */
    private List<ResDC> loadResDCInitDada()
    {
        ResConfig resConfig = (ResConfig) context.getBean("resConfig");
        return resConfig.loadResDCData();
    }

    /**
     * 从物理资产json文件中加载物理资产初始化数据
     * @return 物理资产列表
     */
    private List<ResPhy> loadResPhyInitDada()
    {
        ResConfig resConfig = (ResConfig) context.getBean("resConfig");
        return resConfig.loadResPhyData();
    }

    /**
     * 从虚拟资产json文件中加载虚拟资产初始化数据
     * @return 虚拟资产列表
     */
    private List<ResVtl> loadResVtlInitDada()
    {
        ResConfig resConfig = (ResConfig) context.getBean("resConfig");
        return resConfig.loadResVtlData();
    }

    /**
     * 从系统资产json文件中加载系统资产初始化数据
     * @return 系统资产列表
     */
    private List<ResSys> loadResSysInitDada()
    {
        ResConfig resConfig = (ResConfig) context.getBean("resConfig");
        return resConfig.loadResSysData();
    }

    /**
     * 从安全资产json文件中加载安全资产初始化数据
     * @return 安全资产列表
     */
    private List<ResSec> loadResSecInitDada()
    {
        ResConfig resConfig = (ResConfig) context.getBean("resConfig");
        return resConfig.loadResSecData();
    }
}
