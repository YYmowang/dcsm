package nudt.dcsm.elasticsearch.entity.resource;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

public class Topo {
    @Field(type = FieldType.keyword)
    private String flag;

    public Topo(){this.flag = flag;}
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
