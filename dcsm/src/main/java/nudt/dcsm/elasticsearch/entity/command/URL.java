package nudt.dcsm.elasticsearch.entity.command;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

public class URL {
    @Field(type = FieldType.keyword)
    private String urlName;
    @Field(type = FieldType.text)
    private String url;
    @Field(type = FieldType.text)
    private String urlDes;
    @Field(type = FieldType.keyword)
    private String username;
    @Field(type = FieldType.keyword)
    private String password;

    public URL(){}
    public URL(String urlName, String url, String urlDes, String username, String password){
        this.urlName = urlName;
        this.url = url;
        this.urlDes = urlDes;
        this.username = username;
        this.password = password;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUrlDes(String urlDes) {
        this.urlDes = urlDes;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrlName() {
        return urlName;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlDes() {
        return urlDes;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
