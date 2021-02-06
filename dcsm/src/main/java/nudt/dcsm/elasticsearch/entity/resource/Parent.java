package nudt.dcsm.elasticsearch.entity.resource;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

public class Parent {
    @Field(type = FieldType.text)
    private String name;
    @Field(type = FieldType.keyword)
    private String id;
    @Field(type = FieldType.Integer)
    private Integer level;

    public Parent(){}

    public Parent(String name, String id, Integer level){
        this.name = name;
        this.id = id;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
