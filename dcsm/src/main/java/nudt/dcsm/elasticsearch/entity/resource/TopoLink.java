package nudt.dcsm.elasticsearch.entity.resource;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "dcsm_res_topolink", type = "topolink")
public class TopoLink {
    @Id
   /* private String id;
    @Field(type = FieldType.keyword)*/
    private Src src;
    @Field(type =  FieldType.keyword)
    private Dst dst;

    public TopoLink(){}

    public TopoLink(Src src, Dst dst) {
        this.src = src;
        this.dst = dst;
        //this.id = src.getId() +"_"+dst.getId();
    }

    public Src getSrc() {
        return src;
    }

    public Dst getDst() {
        return dst;
    }

    public void setSrc(Src src) {
        this.src = src;
    }

    public void setDst(Dst dst) {
        this.dst = dst;
    }
}
