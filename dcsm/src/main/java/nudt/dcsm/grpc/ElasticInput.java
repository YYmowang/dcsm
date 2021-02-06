package nudt.dcsm.grpc;

import nudt.dcsm.MianThread;
import nudt.dcsm.elasticsearch.entity.command.Command;
import nudt.dcsm.elasticsearch.entity.command.URL;
import nudt.dcsm.elasticsearch.entity.resource.*;
import nudt.dcsm.elasticsearch.service.*;
import org.springframework.context.ApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ElasticInput {

    static ApplicationContext context = MianThread.Application();

    public static ResSec Selectsec(String secID){
        ResSecESService resSecESService = (ResSecESService) context.getBean("resSecESService");
        ResSec  sec = resSecESService.findById(secID);
        return sec;
    }

    //查找ip
    public static String SelectSys(String secID){
        ResSysESService resSysESService = (ResSysESService) context.getBean("resSysESService");
        String ip = "";

        int i = secID.length();
        if(i == 7){
            ResSys resSys = resSysESService.findById(secID.substring(0,5)+"-1");
            ip = resSys.getIp();
        }else{
            ResSys resSys = resSysESService.findById(secID.substring(0,3)+"-1");
            ip = resSys.getIp();
        }
        System.out.println("ip:"+ip);
        return ip;
    }
    /*
     *获取时间
     * */
    public static String NowDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());
    }

    public static void ElasticVtl(String resType,int Sn,String id,String parentid,String vmName, boolean onState,List<String> ip,List<String> peerVBridge, List<String> phyInterface){

        Topo to = new Topo();
        ResVtlESService resVtlESService = (ResVtlESService) context.getBean("resVtlESService");
        ResVtl resVtl = new ResVtl(id, vmName, null, ElasticInput.NowDate(),
                3, Sn, null, 2, resType, onState, ip,
                parentid, parentid, 2, peerVBridge, phyInterface,to);
        resVtlESService.save(resVtl);
    }

    public static void ElasticTopoLink(String id, String parentid){
        ResTopolinkESService resTopolinkESService = (ResTopolinkESService) context.getBean("ResTopolinkESService");
        Src s = new Src(parentid);
        Dst d = new Dst(id);

        TopoLink tolink = new TopoLink(s,d);
        resTopolinkESService.save(tolink);
    }

    public static void ElasticSecFun(int Sn,String id, String parentid,String secFunName, String secFunType, List<URL> urlList,List<Command> commandList){
        Topo to = new Topo();
        ResSecESService resSecESService = (ResSecESService) context.getBean("resSecESService");
        ResSec resSec = new ResSec(id, secFunName, null, ElasticInput.NowDate(),
                3, Sn, null,
                3, secFunType, true, null, 9200, "5.5.1", commandList, urlList,
                parentid, parentid, 2,to);
        resSecESService.save(resSec);
    }

    public static void ElasticPhy(int Sn,String id,List<String> ips, int vb_num, int vm_num,int vpot_num){
        Topo to = new Topo();
        ResPhyESService resPhyESService = (ResPhyESService) context.getBean("resPhyESService");
        ResPhy resPhy = new ResPhy(id, id, null,ElasticInput.NowDate(),
                2,Sn, null,
                1,"服务器", true, ips,
                vm_num,vb_num,vpot_num,
                "数据中心","1",1,to);
        resPhyESService.save(resPhy);
    }

    public static void ElasticSys(int Sn,String id, String parentid,String agentName, String agentIP){
        Topo to = new Topo();
        ResSysESService resSysESService = (ResSysESService) context.getBean("resSysESService");
        ResSys resSys = new ResSys(id,agentName,null,ElasticInput.NowDate(),
                3,Sn,null,4,"系统资产",true,
                agentIP,9200,"5.5.1",3,parentid,parentid,2,to);
        resSysESService.save(resSys);

    }
}
