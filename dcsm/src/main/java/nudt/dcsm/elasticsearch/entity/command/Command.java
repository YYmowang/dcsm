package nudt.dcsm.elasticsearch.entity.command;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

public class Command {
    @Field(type = FieldType.keyword)
    private String ename;
    @Field(type = FieldType.keyword)
    private String cname;
    @Field(type = FieldType.text)
    private String description;
    @Field(type = FieldType.Integer)
    private Integer paranum;
    @Field(type = FieldType.Object)
    private List<Parameter> parameterList;

    public Command(){}

    public Command(String ename, String cname, String description,
                   Integer paranum, List<Parameter> parameterList){
        this.ename = ename;
        this.cname = cname;
        this.description = description;
        this.paranum = paranum;
        this.parameterList = parameterList;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setParanum(Integer paranum) {
        this.paranum = paranum;
    }

    public void setParameterList(List<Parameter> parameterList) {
        this.parameterList = parameterList;
    }

    public String getEname() {
        return ename;
    }

    public String getCname() {
        return cname;
    }

    public String getDescription() {
        return description;
    }

    public Integer getParanum() {
        return paranum;
    }

    public List<Parameter> getParameterList() {
        return parameterList;
    }
}
