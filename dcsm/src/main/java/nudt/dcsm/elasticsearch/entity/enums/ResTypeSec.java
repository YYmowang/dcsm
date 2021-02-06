package nudt.dcsm.elasticsearch.entity.enums;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "dcsm_restype_sec", type = "security_restype")
public class ResTypeSec {
    @Id
    @Field(type = FieldType.Integer)
    private Integer typeid;
    @Field(type = FieldType.keyword)
    private String typename;

    public ResTypeSec(){}

    public ResTypeSec(Integer typeid, String typename){
        this.typeid = typeid;
        this.typename = typename;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public String getTypename() {
        return typename;
    }
}
