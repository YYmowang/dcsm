package nudt.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Mapping;


@Document(indexName = "restest",type = "res")
//@Mapping(mappingPath = "ResTestMappings.json")
public class ResTest {
    @Id
    @Field(type = FieldType.keyword)
    private String id;
    @Field(type =  FieldType.text)
    private String name;

    public ResTest(){}

    public ResTest(String id, String name){
        this.id = id;
        this.name = name;
    }

    //必须有get方法，否则查询ES时_sourc字段没有该字段
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

}
