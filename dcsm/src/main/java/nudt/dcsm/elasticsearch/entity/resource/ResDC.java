package nudt.dcsm.elasticsearch.entity.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Document(indexName = "dcsm_res_dc", type = "data_center")
public class ResDC {
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

    @Field(type = FieldType.Object)
    private Location location;

    @Field(type = FieldType.Integer)
    private Integer resCategory;

    @Field(type = FieldType.Integer)
    private Integer number;

    @Field(type = FieldType.Object)
    private Topo topo;
    public ResDC(){}

    public ResDC(String id, String name, String alias, String createTime,
                 Integer level, Integer siblingID, String note,
                 String country, String province, String city, double lat, double lon, Integer resCategory, Integer number, Topo topo)
                         throws ParseException {
        this.id = id;
        this.name = name;
        this.alias = alias;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        this.createTime = df.parse(createTime);
        this.topo = topo;
        this.level = level;
        this.sn = siblingID;
        this.note = note;
        this.resCategory = resCategory;
        this.number = number;
        this.location = new Location(country, province, city, lat, lon);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setLocation(Location location) { this.location = location; }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    //以下为get方法

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public Location getLocation() { return location; }
}
