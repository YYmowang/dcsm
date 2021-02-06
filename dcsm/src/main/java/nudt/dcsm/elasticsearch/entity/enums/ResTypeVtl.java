package nudt.dcsm.elasticsearch.entity.enums;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "dcsm_restype_vtl", type = "virtual_restype")
public class ResTypeVtl {
    @Id
    @Field(type = FieldType.keyword)
    private String typename;

    public ResTypeVtl(){}

    public ResTypeVtl(String typename){
        this.typename = typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getTypename() {
        return typename;
    }
}
