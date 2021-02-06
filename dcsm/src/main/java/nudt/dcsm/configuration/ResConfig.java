package nudt.dcsm.configuration;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import nudt.dcsm.elasticsearch.entity.command.Command;
import nudt.dcsm.elasticsearch.entity.command.Parameter;
import nudt.dcsm.elasticsearch.entity.resource.*;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ResConfig {
    //Res初始化数据json文件存放路径
    @Value("${res.initdata.filepath}")
    private String filepath;
    //程序运行目录：IJIDEA中为src所在目录，jar包运行时为jar所在目录
    private String rootpath;

    //Res初始化数据json文件名称
    @Value("${res.initdata.dc}")
    private String initFile_ResDC;
    @Value("${res.initdata.phy}")
    private String initFile_ResPhy;
    @Value("${res.initdata.vtl}")
    private String initFile_ResVtl;
    @Value("${res.initdata.sys}")
    private String initFile_ResSys;
    @Value("${res.initdata.sec}")
    private String initFile_ResSec;

    public String getFilepath() {
        return filepath;
    }

    public String getRootpath() {
        return rootpath;
    }

    public String getInitFile_ResDC() { return initFile_ResDC; }

    public String getInitFile_ResPhy() {
        return initFile_ResPhy;
    }

    public String getInitFile_ResVtl() {
        return initFile_ResVtl;
    }

    public String getInitFile_ResSys() {
        return initFile_ResSys;
    }

    public String getInitFile_ResSec() {
        return initFile_ResSec;
    }

    public ResConfig(){
        //获取程序运行目录
        this.rootpath = System.getProperty("user.dir").replace("\\", "/");
    }

    /**
     * 从json文件中加载ResDataCenter初始化数据到内存
     */
    public List<ResDC> loadResDCData() {
        String filepath = this.rootpath +this.filepath +"\\"+this.initFile_ResDC;
        System.out.println("Load ResDCInitData from " + filepath);
        File file = new File(filepath);

        List<ResDC> resDCList = new ArrayList<ResDC>();
        try {
            String input = FileUtils.readFileToString(file, "UTF-8");
            JSONObject dataObject = JSONObject.fromObject(input);
            JSONArray resDCArray = dataObject.getJSONArray("data");
            resDCArray.forEach(jsonObject -> {
                resDCList.add((ResDC) JSONObject.toBean(
                        (JSONObject) jsonObject, ResDC.class));
            });
            return resDCList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 从json文件中加载ResPhy初始化数据到内存
     */
    public List<ResPhy> loadResPhyData() {
        String filepath = this.rootpath +this.filepath +"\\"+this.initFile_ResPhy;
        System.out.println("Load ResPhyInitData from " + filepath);
        File file = new File(filepath);

        List<ResPhy> resPhyList = new ArrayList<ResPhy>();
        try {
            String input = FileUtils.readFileToString(file, "UTF-8");
            JSONObject dataObject = JSONObject.fromObject(input);
            JSONArray resPhyArray = dataObject.getJSONArray("data");
            resPhyArray.forEach(jsonObject -> {
                resPhyList.add((ResPhy) JSONObject.toBean(
                        (JSONObject) jsonObject, ResPhy.class));
            });
            return resPhyList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * 从json文件中加载ResVtl初始化数据到内存
     */
    public List<ResVtl> loadResVtlData() {
        String filepath = this.rootpath +this.filepath +"\\"+this.initFile_ResVtl;
        System.out.println("Load ResVtlInitData from " + filepath);
        File file = new File(filepath);

        List<ResVtl> resVtlList = new ArrayList<ResVtl>();
        try {
            String input = FileUtils.readFileToString(file, "UTF-8");
            JSONObject dataObject = JSONObject.fromObject(input);
            JSONArray resVtlArray = dataObject.getJSONArray("data");
            resVtlArray.forEach(jsonObject -> {
                resVtlList.add((ResVtl) JSONObject.toBean(
                        (JSONObject) jsonObject, ResVtl.class));
            });
            return resVtlList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从json文件中加载ResSys初始化数据到内存
     */
    public List<ResSys> loadResSysData() {
        String filepath = this.rootpath +this.filepath +"\\"+this.initFile_ResSys;
        System.out.println("Load ResSysInitData from " + filepath);
        File file = new File(filepath);

        List<ResSys> resSysList = new ArrayList<ResSys>();
        try {
            String input = FileUtils.readFileToString(file, "UTF-8");
            JSONObject dataObject = JSONObject.fromObject(input);
            JSONArray resSysArray = dataObject.getJSONArray("data");
            resSysArray.forEach(jsonObject -> {
                resSysList.add((ResSys) JSONObject.toBean(
                        (JSONObject) jsonObject, ResSys.class));
            });
            return resSysList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从json文件中加载ResSec初始化数据到内存
     */
    public List<ResSec> loadResSecData() {
        String filepath = this.rootpath +this.filepath +"\\"+this.initFile_ResSec;
        System.out.println("Load ResSecInitData from " + filepath);
        File file = new File(filepath);

        //手工定义自定义实体对应的java类
        Map<String,Class<?>> classMap = new HashMap<String,Class<?>>();
        classMap.put("commandList", Command.class);
        classMap.put("parameterList", Parameter.class);

        List<ResSec> resSecList = new ArrayList<ResSec>();
        try {
            String input = FileUtils.readFileToString(file, "UTF-8");
            JSONObject dataObject = JSONObject.fromObject(input);
            JSONArray resSecArray = dataObject.getJSONArray("data");
            resSecArray.forEach(jsonObject -> {
                ResSec resSec = (ResSec) JSONObject.toBean(
                        (JSONObject) jsonObject, ResSec.class, classMap);
                resSecList.add(resSec);
            });
            return resSecList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 无用方法，仅供参考
     * 从ResPhy_Filename（ResPhyData.json）中加载ResPhy对象
     * 注意：文件中仅有一条数据
     * @return ResPhy对象
     */
    private ResPhy loadResPhyObject() {
        String filepath = this.rootpath +this.filepath +"\\"+this.initFile_ResPhy;
        System.out.println("Reade ResPhyData from " + filepath);
        File file = new File(filepath);

        ResPhy resPhy = null;
        try {
            String input = FileUtils.readFileToString(file, "UTF-8");
            JSONObject jsonObject = JSONObject.fromObject(input);
            resPhy = (ResPhy) JSONObject.toBean(jsonObject, ResPhy.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resPhy;
    }

    /**
     * 无用方法，仅供参考
     * 从ResPhy_Filename（ResPhyData.json）中加载ResPhy对象列表
     * 文件中包含一条或多条数据
     * @return List<ResPhy> ResPhy对象列表
     */
    private List<ResPhy> loadResPhyArray() {
        String filepath = this.rootpath +this.filepath +"\\"+this.initFile_ResPhy;
        System.out.println("Reade ResPhyData from " + filepath);
        File file = new File(filepath);

        List<ResPhy> resPhyList = new ArrayList<ResPhy>();
        try {
            String input = FileUtils.readFileToString(file, "UTF-8");
            JSONObject dataObject = JSONObject.fromObject(input);
            JSONArray resPhyArray = dataObject.getJSONArray("data");
            resPhyArray.forEach(jsonObject -> {
                resPhyList.add((ResPhy) JSONObject.toBean(
                        (JSONObject) jsonObject, ResPhy.class));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resPhyList;
    }
}
