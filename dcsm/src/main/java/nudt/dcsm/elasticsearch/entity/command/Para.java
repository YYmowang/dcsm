package nudt.dcsm.elasticsearch.entity.command;



public class Para {

    private String paraEName;
    private String paraValue;

    public Para(String paraEName, String paraValue){
        this.paraEName = paraEName;
        this.paraValue = paraValue;
    }

    public void setParaEName(String paraEName) {
        this.paraEName = paraEName;
    }
    public String getParaEName() {
        return paraEName;
    }

    public void setParaValue(String paraValue) {
        this.paraValue = paraValue;
    }
    public String getParaValue() {
        return paraValue;
    }
}
