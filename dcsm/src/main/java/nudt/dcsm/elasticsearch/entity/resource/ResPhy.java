package nudt.dcsm.elasticsearch.entity.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Document(indexName = "dcsm_res_phy", type = "physical_res")
public class ResPhy {
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
    private List<String> ip;


    @Field(type = FieldType.Object)
    private Parent parent;

    @Field(type = FieldType.Integer)
    private Integer vm_num;
    @Field(type = FieldType.Integer)
    private Integer vpot_num;
    @Field(type = FieldType.Integer)
    private Integer vb_num;


    @Field(type = FieldType.Object)
    private Topo topo;

    public ResPhy(){}

    public ResPhy(String id, String name, String alias, String createTime,
                  Integer level, Integer sn, String note,
                  Integer resCategory, String resType, boolean isON, List<String> ips,
                  Integer vm_num, Integer vb_num, Integer vpot_num,
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

        this.resCategory = resCategory;
        this.resType = resType;
        this.isON = isON;
        this.ip = ips;
        this.topo = topo;
        this.vm_num = vm_num;
        this.vb_num = vb_num;
        this.vpot_num = vpot_num;

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



    public void setNote(String note) {
        this.note = note;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public void setResCategory(Integer resCategory) {
        this.resCategory = resCategory;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public void setIp(List<String> ip) {
        this.ip = ip;
    }

    public void setVm_num(Integer vm_num) {
        this.vm_num = vm_num;
    }

    public void setVpot_num(Integer vpot_num) {
        this.vpot_num = vpot_num;
    }

    public void setVb_num(Integer vb_num) {
        this.vb_num = vb_num;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public Topo getTopo() {
        return topo;
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

    public Parent getParent() {
        return parent;
    }

    public List<String> getIp() {
        return ip;
    }

    public Integer getVm_num() {
        return vm_num;
    }

    public Integer getVb_num() {
        return vb_num;
    }

    public Integer getVpot_num() {
        return vpot_num;
    }

    public boolean getIsON() {
        return isON;
    }

    public void setIsON(boolean isON) {
        this.isON = isON;
    }
}
