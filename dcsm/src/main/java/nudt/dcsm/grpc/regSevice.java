package nudt.dcsm.grpc;

import nudt.dcsm.MianThread;
import nudt.dcsm.elasticsearch.entity.command.Command;
import nudt.dcsm.elasticsearch.entity.command.Parameter;
import nudt.dcsm.elasticsearch.entity.command.URL;
import nudt.dcsm.elasticsearch.entity.resource.*;
import nudt.dcsm.elasticsearch.service.*;
import org.springframework.context.ApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//物理资产是1 虚拟2 安全3 系统4
public class regSevice {
    static int SN_2 = 1;
    static int SN_3 = 1;
    static int SN_4 = 1;
    static  boolean isafter = false; //虚拟机agent是否在物理机agent之前
    static  boolean isavtl = false; //虚拟机agent是否在物理机agent之前
    static String  vpottype = "业务容器";
    static String  setype = "业务虚拟机";
    static String  vtlid = "";
    static  List<String> ipssave = new ArrayList<>();
    private static ArrayList<ResVtl> SaveVMachineResVtlList = new ArrayList<>();
    private static ArrayList<ResVtl> SaveVPotResVtlList = new ArrayList<>();

    private static ArrayList<ResVtl> SaveAgentResVtlList = new ArrayList<>();
    private static ArrayList<ResVtl> SaveVBridgeResVtlList = new ArrayList<>();
    private static ArrayList<ResSec> SaveSecFunResSecList = new ArrayList<>();
    private static ArrayList<ResSys> SaveSysAgentResSysList = new ArrayList<>();



    static String vtlip = "1";


    static  ApplicationContext context = MianThread.Application();
    /*
     *判断物理机与虚拟机  并存入数据库
     * */
    public static void resPhyVtlAgent(String agentName, String agentMac,boolean isVirtHost,String agentIP,List<String> ips, int vb_num, int vm_num,int vpot_num,int service_num)  {
        if(!isVirtHost){
            //物理资产
            //获取最大值
            SN_2 =  findphySn();
            String parentid = "1-"+SN_2;
            //System.out.println("Sn_2:"+SN_2);
            isafter = false;
            ElasticInput.ElasticPhy(SN_2,parentid,ips,vb_num,vm_num,vpot_num);
            ElasticInput.ElasticTopoLink(parentid,"1");
            resphySysAgent(agentName,agentIP);
        }else {
            //虚拟资产

            inputvtlAgent(agentIP);
            inputAtl(ips);
            resvtlSysAgent(agentName,agentIP);
        }
        isavtl =isVirtHost;
    }


    public static void aftervtlipt() {
        String parentid = "1-" + SN_2;
        if (SaveAgentResVtlList.size() > 0) {
            for(ResVtl SaveAgentResVtl : SaveAgentResVtlList){
                String id = "1-" + SN_2 + "-" + SN_3;
                vtlid = id;
                ElasticInput.ElasticVtl("业务虚拟机",SN_3,id,parentid,null, true,SaveAgentResVtl.getIp(),null,null);
                ElasticInput.ElasticTopoLink(id,parentid);
                SN_3++;
                SN_4=1;
            }
            SaveAgentResVtlList.clear();
        }
        if (SaveSysAgentResSysList.size() > 0) {
            String id = "1-" + SN_2 + "-" + SN_3;
            for(ResSys SaveSysAgentResSys : SaveSysAgentResSysList){
                String sysid = vtlid+"-"+SN_4;
                ElasticInput.ElasticSys(SN_4,sysid,id,SaveSysAgentResSys.getName(), SaveSysAgentResSys.getIp());
                ElasticInput.ElasticTopoLink(sysid,id);
                SN_4++;
            }
            SaveSysAgentResSysList.clear();
        }
        if (SaveVMachineResVtlList.size() > 0) {
            for(ResVtl SaveVMachineResVtl : SaveVMachineResVtlList){
                String id = "1-" + SN_2 + "-" + SN_3;
                ElasticInput.ElasticVtl("业务虚拟机",SN_3,id,parentid,SaveVMachineResVtl.getName(), SaveVMachineResVtl.getIsON(),SaveVMachineResVtl.getIp(),null,null);
                ElasticInput.ElasticTopoLink(id,parentid);
                SN_3++;
                SN_4=1;
            }
            SaveVMachineResVtlList.clear();
        }

        if (SaveVPotResVtlList.size() > 0) {
            for(ResVtl SaveVPotResVtl : SaveVPotResVtlList) {
                String id = "1-" + SN_2 + "-" + SN_3;
                ElasticInput.ElasticVtl("业务容器", SN_3, id, parentid, SaveVPotResVtl.getName(), SaveVPotResVtl.getIsON(), SaveVPotResVtl.getIp(), null, null);
                ElasticInput.ElasticTopoLink(id,parentid);
                SN_3++;
                SN_4=1;
            }
            SaveVPotResVtlList.clear();
        }
        if (SaveVBridgeResVtlList.size() > 0) {
            for(ResVtl SaveVBridgeResVtl : SaveVBridgeResVtlList) {
                String id = "1-" + SN_2 + "-" + SN_3;
                ElasticInput.ElasticVtl("其它", SN_3, id, parentid, SaveVBridgeResVtl.getName(), true, null, SaveVBridgeResVtl.getPeerBr(), SaveVBridgeResVtl.getPhyInterface());
                ElasticInput.ElasticTopoLink(id,parentid);
                SN_3++;
                SN_4=1;
            }
            SaveVBridgeResVtlList.clear();
        }
        if (SaveSecFunResSecList.size() > 0) {
            String id = "1-" + SN_2 + "-" + SN_3;
            for(ResSec SaveSecFunResSec : SaveSecFunResSecList) {
                String sysid = vtlid+"-"+SN_4;
                ElasticInput.ElasticSecFun(SN_4, sysid,id, SaveSecFunResSec.getName(), SaveSecFunResSec.getResType(), SaveSecFunResSec.getUrlList(), SaveSecFunResSec.getCommandList());
                ElasticInput.ElasticTopoLink(sysid,id);
                InputvtlSys();
                InputvtlSec();
                SN_4++;
            }
            SaveSecFunResSecList.clear();
            //System.out.println("SaveSecFunResSecList size:"+SaveSecFunResSecList.size());
        }
    }

    public static void  InputSN(){
        InputPhy();
        InputSys();
        InputVlt();
        InputSec();
    }
    /*
    虚拟机资产
     */
    public static void resVtiVMachine(int Vm_Num,String vmName, boolean onState, String bridge, String vmMac, String vmIP)  {
        //System.out.println("VMachine come  -------------");
        String parentid = "1-"+SN_2;
        String id = "1-"+SN_2+"-"+SN_3;
        String resTypev = "业务虚拟机";
        if(ipssave.size()>0){
            for(String ip : ipssave){
                if(ip.equals(vmIP))
                    resTypev = "安全虚拟机";
            }
        }
        ArrayList ip= new ArrayList();
        ip.add(vmIP);
        //System.out.println("VtiVMachine isafter:"+isafter);
        if(isafter){
            //物理机在虚拟机之后  先储存
            ResVtl SaveVMachineResVtl = new ResVtl();
            SaveVMachineResVtl.setIp(ip);
            SaveVMachineResVtl.setName(vmName);
            SaveVMachineResVtl.setIsON(onState);
            SaveVMachineResVtlList.add(SaveVMachineResVtl);
        }else {
            ElasticInput.ElasticVtl(resTypev,SN_3,id,parentid,vmName,onState,ip,null,null);
            ElasticInput.ElasticTopoLink(id,parentid);
            InputSN();
            SN_3++;
            SN_4=1;
            //System.out.println("vtlip:"+vtlip+"|vmIP:"+vmIP);
            if(vtlip.equals(vmIP)){
                aftervtlipt();
            }
        }
    }


    /*
    容器资产
     */
    public static void resVtiVPot(int Vpot_Num,String vpotName, boolean onState, String bridge, String vpotMac, String vpotIP)  {
        ArrayList ip= new ArrayList();
        String parentid = "1-"+SN_2;
        String id = "1-"+SN_2+"-"+SN_3;
        String resTypev = "业务容器";
        if(ipssave.size()>0){
            for(String ips : ipssave){
                if(ips.equals(vpotIP))
                    resTypev = "安全容器";
            }
        }
        ip.add(vpotIP);
        System.out.println("VtiVPot isafter:"+isafter);
        if(isafter){
            //物理机在虚拟机之后  先储存
            ResVtl SaveVPotResVtl = new ResVtl();
            SaveVPotResVtl.setIp(ip);
            SaveVPotResVtl.setName(vpotName);
            SaveVPotResVtl.setIsON(onState);
            SaveVPotResVtlList.add(SaveVPotResVtl);
        }else {
            ElasticInput.ElasticVtl(resTypev,SN_3,id,parentid,vpotName,onState,ip,null,null);
            ElasticInput.ElasticTopoLink(id,parentid);
            InputSN();
            SN_3++;
            SN_4=1;
            System.out.println("vtlip:"+vtlip+"|vmIP:"+vpotIP);
            if(vtlip.equals(vpotIP)){
                aftervtlipt();
            }
        }
    }



    /*
    网桥资产
      */
    public static void resVtiVBridge(int Vb_Num,String vbName, List<String> peerVBridge, List<String> phyInterface) {
        String parentid = "1-"+SN_2;
        String id = "1-"+SN_2+"-"+SN_3;
        ArrayList ip= new ArrayList();
        System.out.println("VtiVBridge isafter:"+isafter);
        if(isafter){
            //物理机在虚拟机之后  先储存
            ResVtl SaveVBridgeResVtl = new ResVtl();
            SaveVBridgeResVtl.setIp(ip);
            SaveVBridgeResVtl.setName(vbName);
            SaveVBridgeResVtl.setPeerBr(peerVBridge);
            SaveVBridgeResVtl.setPhyInterface(phyInterface);
            SaveVBridgeResVtlList.add(SaveVBridgeResVtl);
        }else {
            ElasticInput.ElasticVtl("其它",SN_3,id,parentid,vbName,true,ip,peerVBridge,phyInterface);
            ElasticInput.ElasticTopoLink(id,parentid);
            InputSN();
            SN_3++;
            SN_4=1;
        }
    }
    /*
        安全资产
     */
    public static void resSecFun(String agentID, String secFunName, String secFunType, List<SecFunRequest.URL> url, List<SecFunRequest.CMD> cmd){
        String parentid = "1-"+SN_2;
        String id = "1-"+SN_2+"-"+SN_3;
        String sysid = vtlid+"-"+SN_4;


        List<Parameter> parameterList = new ArrayList  <Parameter>();
        List<Command> commandList = new ArrayList<Command>();
        if(cmd.size()>0){
            for(SecFunRequest.CMD cmds : cmd){
                for(SecFunRequest.CMD.Para  Para:cmds.getParaList()){
                    parameterList.add(new Parameter(Para.getParaEName(),Para.getParaCName(),Para.getParaDes(),
                            Para.getParaFormat(),Para.getParaRegular(),Para.getParaIsOptional(),Para.getParaDefaultVal()));
                }
                commandList.add(new Command(cmds.getCmdEName(),cmds.getCmdCName(),cmds.getCmdDes(),cmds.getParaNum(), parameterList));
            }
        }

        List<URL> urlList = new ArrayList<URL>();
        if(url.size()>0){
            for(SecFunRequest.URL urls : url){
                urlList.add(new URL(urls.getUrlCName(),urls.getUrl(),urls.getUrlDes(),urls.getUsername(),urls.getPassword()));
            }
        }
        System.out.println("resSecFun isafter:"+isafter);
        if(isafter){
            //物理机在虚拟机之后  先储存
            ResSec SaveSecFunResSec = new ResSec();
            SaveSecFunResSec.setName(secFunName);
            SaveSecFunResSec.setResType(secFunType);
            SaveSecFunResSec.setUrlList(urlList);
            SaveSecFunResSec.setCommandList(commandList);
            SaveSecFunResSecList.add(SaveSecFunResSec);
        }else {
            if(isavtl){
                ElasticInput.ElasticSecFun(SN_4,sysid,vtlid,secFunName,secFunType,urlList,commandList);
                ElasticInput.ElasticTopoLink(sysid,vtlid);
                InputvtlSys();
                InputvtlSec();
                SN_4++;
            }else{
                ElasticInput.ElasticSecFun(SN_3,id,parentid,secFunName,secFunType,urlList,commandList);
                ElasticInput.ElasticTopoLink(id,parentid);
                InputSN();
                SN_3++;
                SN_4=1;
            }
        }
    }

    /*
     *   物理系统资产
     *  */
    public static void resphySysAgent(String agentName, String agentIP) {
        String parentid = "1-"+SN_2;
        String id = "1-"+SN_2+"-"+SN_3;
        ElasticInput.ElasticSys(SN_3,id,parentid,agentName,agentIP);
        ElasticInput.ElasticTopoLink(id,parentid);
        SN_3++;
        SN_4=1;
    }

    /*
     *   虚拟系统资产
     *  */
    public static void resvtlSysAgent(String agentName, String agentIP) {
        String sysid = vtlid+"-"+SN_4;
        System.out.println("resvtlSysAgent isafter:"+isafter);
        if(isafter){
            ResSys SaveSysAgentResSys = new ResSys();
            SaveSysAgentResSys.setName(agentName);
            vtlip = agentIP;
            SaveSysAgentResSys.setIp(vtlip);
            SaveSysAgentResSysList.add(SaveSysAgentResSys);
        }else {
            ElasticInput.ElasticSys(SN_4,sysid,vtlid,agentName,agentIP);
            ElasticInput.ElasticTopoLink(sysid,vtlid);
            SN_4++;
        }
    }

    public static int findphySn(){
        int sn = 1;
        String parentid = "1-1";
        ResPhyESService resPhyESService = (ResPhyESService) context.getBean("resPhyESService");
        ResPhy resPhy = resPhyESService.findById(parentid);
        if(resPhy !=null){
            sn=resPhy.getSn()+1;
        }
        SN_3 = 1;
        return sn;
    }

    //public void Input
//确定SN

    public static void InputPhy(){
        ResPhyESService resPhyESService = (ResPhyESService) context.getBean("resPhyESService");
        //System.out.println("InputPhy SN_2:"+SN_2);
        for(int i =1;i<=SN_2;i++){
            String id = "1-"+i;
            ResPhy re = resPhyESService.findById(id);
            if(re != null) {
                //System.out.println("ID :"+re.getId()+"|ip:"+re.getIp().get(3));
                ElasticInput.ElasticPhy(SN_2,re.getId(),re.getIp(),re.getVm_num(),re.getVb_num(),re.getVpot_num());
            }
        }

    }
    public static void InputVlt(){
        ResVtlESService resVtlESService = (ResVtlESService) context.getBean("resVtlESService");
        for(int i =1;i<=SN_3;i++){
            String id = "1-"+SN_2+"-"+i;
            ResVtl re = resVtlESService.findById(id);
            if(re != null){
                ElasticInput.ElasticVtl(re.getResType(),SN_3,re.getId(),re.getParent().getId(),re.getName(), re.getIsON(),re.getIp(),re.getPeerBr(),re.getPhyInterface());
            }
        }


    }

    public static void InputSys(){
        ResSysESService resSysESService = (ResSysESService) context.getBean("resSysESService");
        for(int i =1;i<=SN_3;i++){
            String id = "1-"+SN_2+"-"+i;
            ResSys re2 = resSysESService.findById(id);
            if(re2 != null){
                ElasticInput.ElasticSys(SN_3,re2.getId(),re2.getParent().getId(),re2.getName(),re2.getIp());
            }
        }
    }

    public static void InputSec(){
        ResSecESService resSecESService = (ResSecESService) context.getBean("resSecESService");
        for(int i =1;i<=SN_3;i++){
            String id = "1-"+SN_2+"-"+i;
            ResSec re3 = resSecESService.findById(id);
            if(re3 != null){
                ElasticInput.ElasticSecFun(SN_3,re3.getId(),re3.getParent().getId(),re3.getName(),re3.getResType(),re3.getUrlList(),re3.getCommandList());
            }
        }
    }
    public static void InputvtlSys(){
        ResSysESService resSysESService = (ResSysESService) context.getBean("resSysESService");
        for(int i =1;i<=SN_4;i++){
            String id = "1-"+SN_2+"-"+SN_3+"-"+i;
            ResSys re2 = resSysESService.findById(id);
            if(re2 != null){
                ElasticInput.ElasticSys(SN_4,re2.getId(),re2.getParent().getId(),re2.getName(),re2.getIp());
            }
        }
    }
    public static void InputvtlSec(){
        ResSecESService resSecESService = (ResSecESService) context.getBean("resSecESService");
        for(int i =1;i<=SN_4;i++){
            String id = "1-"+SN_2+"-"+SN_3+"-"+i;
            ResSec re3 = resSecESService.findById(id);
            if(re3 != null){
                ElasticInput.ElasticSecFun(SN_4,re3.getId(),re3.getParent().getId(),re3.getName(),re3.getResType(),re3.getUrlList(),re3.getCommandList());
            }
        }
    }
    //根据ip寻找id号
    public static void inputvtlAgent(String agentIP){
        ResVtlESService resVtlESService = (ResVtlESService) context.getBean("resVtlESService");
        ResVtl re = resVtlESService.findByIp(agentIP);

        if(re != null){
            //物理资产先存入
            SN_2 = Integer.parseInt(re.getParent().getId().substring(2,3));
            SN_3 =  re.getSn();
        }else {
            //物理资产后存入
            isafter = true;
        }
    }

    //修改容器与虚拟机类型  存入虚拟机类型
    public static void inputAtl(List<String> ips){
        int i =0;
        String parentid = "1-"+SN_2;
        String id = "1-"+SN_2+"-"+SN_3;
        ResVtlESService resVtlESService = (ResVtlESService) context.getBean("resVtlESService");
        if(ips.size()>0) {
            for (String ip : ips) {
                ResVtl  re = resVtlESService.findByIp(ip);
                if (re != null) {
                    i++;
                    if (re.getResType().equals(vpottype)) {
                        //如果为业务容器
                        ElasticInput.ElasticVtl("安全容器",re.getSn(),re.getId(),re.getName(),re.getParent().getId(), true,re.getIp(),null,null);
                    } else if (re.getResType().equals(setype)) {
                        //如果为业务虚拟机
                        ElasticInput.ElasticVtl("安全虚拟机",re.getSn(),re.getId(),re.getName(),re.getParent().getId(), true,re.getIp(),null,null);
                    }
                }
            }
            if(i == 0){
                //如果没有匹配的ip地址
                //没有查出值
                ipssave = ips;
            }
        }
        System.out.println("inputAtl isafter:"+isafter);
        if(isafter){
            ResVtl SaveAgentResVtl = new ResVtl();
            SaveAgentResVtl.setIp(ips);
            SaveAgentResVtlList.add(SaveAgentResVtl);
        }else {
            vtlid = id;
            ElasticInput.ElasticVtl("业务虚拟机",SN_3,id,parentid,parentid, true,ips,null,null);
            ElasticInput.ElasticTopoLink(id,parentid);
            SN_3 ++;
            SN_4=1;
        }

    }

}



