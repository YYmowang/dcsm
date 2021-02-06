package nudt.dcsm.elasticsearch.entity.command;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

public class Parameter {
    @Field(type = FieldType.keyword)
    private String ename;           //命令下发使用英文名称
    @Field(type = FieldType.keyword)
    private String cname;           //界面显示中文名称
    @Field(type = FieldType.text)
    private String description;     //参数描述
    @Field(type = FieldType.text)
    private String format;         //参数格式要求
    @Field(type = FieldType.text)
    private String regular;         //格式检查正则表达式
    @Field(type = FieldType.Boolean)
    private boolean isOptional;     //true 界面不强制输入
    @Field(type = FieldType.text)
    private String defaultVal;  //默认值，可为空

    public Parameter(){}

    public Parameter(String ename, String cname, String description,
                     String format, String regular, boolean isOptional, String defaultVal){
        this.ename = ename;
        this.cname = cname;
        this.defaultVal = description;
        this.format = format;
        this.regular = regular;
        this.isOptional = isOptional;
        this.defaultVal = defaultVal;
    }

    //以下为set方法

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public void setOptional(boolean optional) {
        isOptional = optional;
    }

    public void setDefaultVal(String defaultVal) {
        this.defaultVal = defaultVal;
    }
    //以下为get方法

    public String getEname() {
        return ename;
    }

    public String getCname() {
        return cname;
    }

    public String getDescription() {
        return description;
    }

    public String getFormat() {
        return format;
    }

    public String getRegular() {
        return regular;
    }

    public String getDefaultVal() {
        return defaultVal;
    }
    public boolean getIsOptional()
    {
        return  isOptional;
    }
}
