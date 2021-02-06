package nudt.dcsm.elasticsearch.entity.enums;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "dcsm_rescategory", type = "rescategory")
public class ResCategory {
    @Id
    @Field(type = FieldType.keyword)
    private String categoryName;

    public ResCategory(){}

    public ResCategory(String categoryName){
        this.categoryName = categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
