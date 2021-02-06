package nudt.dcsm.initialization;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import nudt.dcsm.configuration.ResTypeConfig;
import nudt.dcsm.elasticsearch.entity.enums.*;
import nudt.dcsm.elasticsearch.entity.resource.ResDC;
import nudt.dcsm.elasticsearch.service.*;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 初始化数据库中的资产种类表
 *
 */

public class InitializeResType {
    private ApplicationContext context = null;

    public InitializeResType(){
        this.context = new AnnotationConfigApplicationContext(
                nudt.dcsm.configuration.BeanConfig.class);
    }

    public InitializeResType(ApplicationContext context){
        this.context = context;
    }

    /**
     * 存储资产种类到ES中
     */
    public void initResCategory(){
        ResCategoryESService resCategoryESService = (ResCategoryESService) context.getBean("resCategoryESService");
        //存储ResCategory初始化数据到ES
        resCategoryESService.saveAll(this.loadCategoryInitDada());
    }

    /**
     * 存储物理资产类型到ES中
     */
    public void initResTypePhy(){
        ResTypePhyESService resTypePhyESService = (ResTypePhyESService) context.getBean("resTypePhyESService");
        //存储ResTypePhy初始化数据到ES
        resTypePhyESService.saveAll(this.loadResTypePhyInitDada());
    }

    /**
     * 存储虚拟资产类型到ES中
     */
    public void initResTypeVtl(){
        ResTypeVtlESService resTypeVtlESService = (ResTypeVtlESService) context.getBean("resTypeVtlESService");
        //存储ResTypeVtl初始化数据到ES
        resTypeVtlESService.saveAll(this.loadResTypeVtlInitDada());
    }

    /**
     * 存储系统资产类型到ES中
     */
    public void initResTypeSys()
    {
        ResTypeSysESService resTypeSysESService = (ResTypeSysESService) context.getBean("resTypeSysESService");
        //存储ResTypePhy初始化数据到ES
        List<ResTypeSys> resTypeSysList = this.loadResTypeSysInitDada();
        if( resTypeSysList != null) resTypeSysESService.saveAll(resTypeSysList);
    }

    /**
     * 存储安全资产类型到ES中
     */
    public void initResTypeSec()
    {
        ResTypeSecESService resTypeSecESService = (ResTypeSecESService) context.getBean("resTypeSecESService");
        //存储ResTypePhy初始化数据到ES
        List<ResTypeSec> resTypeSecList = this.loadResTypeSecInitDada();
        if( resTypeSecList != null) resTypeSecESService.saveAll(resTypeSecList);
    }

    /**
     * 从资产种类枚举中加载资产种类
     * @return 资产种类列表
     */
    private List<ResCategory> loadCategoryInitDada()
    {
        List<ResCategory> resCategoryList = new ArrayList<ResCategory>();
        for (EnumResCategory e : EnumResCategory.values()) {
            //System.out.println("Category:"+e.value());
            resCategoryList.add(new ResCategory(e.value()));
        }
        return resCategoryList;
    }

    /**
     * 从物理资产类型枚举中加载物理资产类型
     * @return 物理资产类型列表
     */
    private List<ResTypePhy> loadResTypePhyInitDada()
    {
        List<ResTypePhy> resTypePhyList = new ArrayList<ResTypePhy>();
        for (EnumResTypePhy e : EnumResTypePhy.values()) {
            resTypePhyList.add(new ResTypePhy(e.value()));
        }
        return resTypePhyList;
    }

    /**
     * 从虚拟资产类型枚举中加载虚拟资产类型
     * @return 虚拟资产类型列表
     */
    private List<ResTypeVtl> loadResTypeVtlInitDada()
    {
        List<ResTypeVtl> resTypeVtlList = new ArrayList<ResTypeVtl>();
        for (EnumResTypeVtl e : EnumResTypeVtl.values()) {
            resTypeVtlList.add(new ResTypeVtl(e.value()));
        }
        return resTypeVtlList;
    }
    /**
     * 从系统资产类型枚举中加载系统资产类型
     * @return 系统资产类型列表
     */
    private List<ResTypeSys> loadResTypeSysInitDada()
    {
        List<ResTypeSys> resTypeSysList = new ArrayList<ResTypeSys>();
        for (EnumResTypeSys e : EnumResTypeSys.values()) {
            resTypeSysList.add(new ResTypeSys(e.value()));
        }
        return resTypeSysList;
    }

    /**
     * 从安全资产类型json文件中加载安全资产类型
     * @return 安全资产类型列表
     */
    private List<ResTypeSec> loadResTypeSecInitDada()
    {
        int i=0;
        List<ResTypeSec> resTypeSecList = new ArrayList<ResTypeSec>();
        for (EnumResTypeSec e : EnumResTypeSec.values()) {
            resTypeSecList.add(new ResTypeSec(i,e.value()));
            i++;
        }
        return resTypeSecList;
    }

}
