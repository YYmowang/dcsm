package nudt.dcsm.elasticsearch.entity.command;

import java.util.List;

public class Controllor {

    private String agentID;
    private String secFunName;
    private String secFunType;
    private String cmdEName;
    private int para_num;
    private List<Para> para;

    public Controllor(String agentID, String secFunName, String secFunType, String cmdEName, int para_num,List<Para> para){
        this.agentID = agentID;
        this.secFunName = secFunName;
        this.secFunType = secFunType;
        this.cmdEName = cmdEName;
        this.para_num = para_num;
        this.para = para;
    }

    public String getAgentID() {
        return agentID;
    }

    public void setAgentID(String agentID) {
        this.agentID = agentID;
    }

    public String getSecFunName() {
        return secFunName;
    }

    public void setSecFunName(String secFunName) {
        this.secFunName = secFunName;
    }

    public String getSecFunType() {
        return secFunType;
    }

    public void setSecFunType(String secFunType) {
        this.secFunType = secFunType;
    }

    public String getCmdEName() {
        return cmdEName;
    }

    public void setCmdEName(String cmdEName) {
        this.cmdEName = cmdEName;
    }

    public int getPara_num() {
        return para_num;
    }

    public void setPara_num(int para_num) {
        this.para_num = para_num;
    }

    public List<Para> getPara() {
        return para;
    }

    public void setPara(List<Para> para) {
        this.para = para;
    }
}
