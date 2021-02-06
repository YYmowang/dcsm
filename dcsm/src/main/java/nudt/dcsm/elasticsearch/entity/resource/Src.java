package nudt.dcsm.elasticsearch.entity.resource;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

public class Src {
    @Field(type = FieldType.keyword)
    private String id;

    public Src(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
