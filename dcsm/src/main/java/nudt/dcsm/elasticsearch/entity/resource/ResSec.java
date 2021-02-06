package nudt.dcsm.elasticsearch.entity.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import nudt.dcsm.elasticsearch.entity.command.Command;
import nudt.dcsm.elasticsearch.entity.command.URL;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Document(indexName = "dcsm_res_sec", type = "security_res")
public class ResSec {
    @Id
    @Field(type = FieldType.keyword)
    private String id;
    @Field(type =  FieldType.text)
    private String name;
    @Field(type =  FieldType.text)
    private String alias;
    @Field(type = FieldType.Date, format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")  // 指定存储格式
    @JsonFormat(shape =JsonFormat.Shape.STRING,pattern ="yyyy-MM-dd HH:mm:ss",timezone ="GMT+8")  // 数据格式转换，并加上8小时进行存储
    private Date createTime;

    @Field(type = FieldType.Integer)
    private Integer level;
    @Field(type = FieldType.Integer)
    private Integer sn;
    @Field(type =  FieldType.text)
    private String note;

    @Field(type = FieldType.Integer)
    private Integer resCategory;
    @Field(type = FieldType.keyword)
    private String resType;
    @Field(type = FieldType.Boolean)
    private boolean isON;

    @Field(type = FieldType.Ip)
    private String ip;
    @Field(type = FieldType.Integer)
    private Integer port;
    @Field(type = FieldType.keyword)
    private String version;

    @Field(type = FieldType.Object)
    private List<Command> commandList;
    @Field(type = FieldType.Object)
    private List<URL> urlList;

    @Field(type = FieldType.Object)
    private Parent parent;

    @Field(type = FieldType.Object)
    private Topo topo;
    public ResSec(){}

    public ResSec(String id, String name, String alias, String createTime,
                  Integer level, Integer sn, String note,
                  Integer resCategory, String resType,
                  boolean isON, String ip, Integer port, String version,
                  List<Command> commandList, List<URL> urlList,
                  String parentName, String parentId, Integer parentLevel, Topo topo) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        try {
            this.createTime = df.parse(createTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.level = level;
        this.sn = sn;
        this.note = note;
        this.topo = topo;
        this.resCategory = resCategory;
        this.resType = resType;
        this.isON = isON;
        this.ip = ip;
        this.port = port;
        this.version = version;
        this.urlList = urlList;
        this.commandList = commandList;

        this.parent = new Parent(parentName, parentId, parentLevel);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setResCategory(Integer resCategory) {
        this.resCategory = resCategory;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public void setCommandList(List<Command> commandList) {
        this.commandList = commandList;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setUrlList(List<URL> urlList) {
        this.urlList = urlList;
    }
    //以下为get方法

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public Integer getLevel() {
        return level;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Integer getSn() {
        return sn;
    }

    public String getNote() {
        return note;
    }

    public Integer getResCategory() {
        return resCategory;
    }

    public String getResType() {
        return resType;
    }

    public List<Command> getCommandList() {
        return commandList;
    }

    public Parent getParent() {
        return parent;
    }

    public Integer getPort() {
        return port;
    }

    public String getIp() {
        return ip;
    }

    public String getVersion() {
        return version;
    }

    public List<URL> getUrlList() {
        return urlList;
    }

    public boolean getIsON() {
        return isON;
    }

    public void setIsON(boolean isON) {
        this.isON = isON;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }
}
