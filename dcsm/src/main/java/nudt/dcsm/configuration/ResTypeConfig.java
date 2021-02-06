package nudt.dcsm.configuration;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import nudt.dcsm.elasticsearch.entity.enums.ResTypeSec;
import nudt.dcsm.elasticsearch.entity.enums.ResTypeSys;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ResTypeConfig {
    //ResType初始化数据json文件存放路径
    @Value("${restype.initdata.filepath}")
    private String filepath;
    //程序运行目录：IJIDEA中为src所在目录，jar包运行时为jar所在目录
    private String rootpath = null;

    //ResType初始化数据json文件名称
    @Value("${restype.initdata.sys}")
    private String initFile_ResTypeSys;
    @Value("${restype.initdata.sec}")
    private String initFile_ResTypeSec;

    public String getFilepath() {
        return filepath;
    }

    public String getRootpath() {
        return rootpath;
    }

    public String getInitFile_ResTypeSys() {
        return initFile_ResTypeSys;
    }

    public String getInitFile_ResTypeSec() {
        return initFile_ResTypeSec;
    }

    public ResTypeConfig(){
        //获取程序运行目录
        this.rootpath = System.getProperty("user.dir").replace("\\", "/");
    }

    /**
     * 从json文件中加载ResTypeSys初始化数据到内存
     *//*
    public ArrayList<ResTypeSys> loadResTypeSysInitDada() {
        String filepath = this.rootpath +this.filepath +"\\"+this.initFile_ResTypeSys;
        System.out.println("Load ResTypeSysInitData from " + filepath);
        File file = new File(filepath);

        ArrayList<ResTypeSys> resTypeSysList = new ArrayList<ResTypeSys>();
        try {
            String input = FileUtils.readFileToString(file, "UTF-8");
            JSONObject dataObject = JSONObject.fromObject(input);
            JSONArray resTypeSysArray = dataObject.getJSONArray("data");
            resTypeSysArray.forEach(jsonObject -> {
                resTypeSysList.add((ResTypeSys) JSONObject.toBean(
                        (JSONObject) jsonObject, ResTypeSys.class));
            });
            return resTypeSysList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/

    /**
     * 从json文件中加载ResTypeSec初始化数据到内存
     */
    public ArrayList<ResTypeSec> loadResTypeSecInitDada() {
        String filepath = this.rootpath +"/dcsm"+this.filepath +"\\"+this.initFile_ResTypeSec;
        System.out.println("Load ResTypeSecInitData from " + filepath);
        File file = new File(filepath);

        ArrayList<ResTypeSec> resTypeSecList = new ArrayList<ResTypeSec>();
        try {
            String input = FileUtils.readFileToString(file, "UTF-8");
            JSONObject dataObject = JSONObject.fromObject(input);
            JSONArray resTypeSecArray = dataObject.getJSONArray("data");
            resTypeSecArray.forEach(jsonObject -> {
                resTypeSecList.add((ResTypeSec) JSONObject.toBean(
                        (JSONObject) jsonObject, ResTypeSec.class));
            });
            return resTypeSecList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 无用方法，仅供参考
     * 从ResTypePhy_Filename（ResTypePhyData.json）中加载ResTypePhy对象
     * 注意：文件中仅有一条数据，例如{"typeid":1,"typename":"交换机"}
     * @return ResTypePhy对象
     */
    /*
    private ResTypePhy loadResTypePhyObject() {
        String filepath = this.rootpath +this.filepath +"\\"+this.initFile_ResTypePhy;
        System.out.println("Reade ResTypePhyData from " + filepath);
        File file = new File(filepath);

        ResTypePhy resTypePhy = null;
        try {
            String input = FileUtils.readFileToString(file, "UTF-8");
            JSONObject jsonObject = JSONObject.fromObject(input);
            resTypePhy = (ResTypePhy) JSONObject.toBean(jsonObject, ResTypePhy.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resTypePhy;
    }
    */
    /**
     * 无用方法，仅供参考
     * 从ResTypePhy_Filename（ResTypePhyData.json）中加载ResTypePhy对象列表
     * 文件中包含一条或多条数据，例如{data:{[{"typeid":1,"typename":"交换机"},{"typeid":2,"typename":"交换机"}]}}
     * @return List<ResTypePhy> ResTypePhy对象列表
     */
    /*

    private List<ResTypePhy> loadResTypePhyArray() {
        String filepath = this.rootpath +this.filepath +"\\"+this.initFile_ResTypePhy;
        System.out.println("Reade ResTypePhyData from " + filepath);
        File file = new File(filepath);

        List<ResTypePhy> resTypePhyList = new ArrayList<ResTypePhy>();
        try {
            String input = FileUtils.readFileToString(file, "UTF-8");
            JSONObject dataObject = JSONObject.fromObject(input);
            JSONArray resTypePhyArray = dataObject.getJSONArray("data");
            resTypePhyArray.forEach(jsonObject -> {
                resTypePhyList.add((ResTypePhy) JSONObject.toBean(
                        (JSONObject) jsonObject, ResTypePhy.class));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resTypePhyList;
    }

     */
}
