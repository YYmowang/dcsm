package nudt.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;


@Document(indexName = "student",type = "std")
public class Student {
    @Id
    @Field(type = FieldType.keyword)
    private String id;
    @Field(type = FieldType.keyword)
    private String sex;
    @Field(type = FieldType.Integer)
    private Integer age;
    @Field(type = FieldType.Date)
    private String birthday;


    public class Name {
        @Field(type = FieldType.text)
        private String firstname;
        @Field(type = FieldType.text)
        private String lastname;

        public Name(){

        }

        public Name(String firstname, String lastname){
            this.firstname = firstname;
            this.lastname = lastname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getLastname() {
            return lastname;
        }
    }
    @Field(type = FieldType.Object)
    private Name name;


    public class Location {
        @Field(type = FieldType.keyword)
        private String country;
        @Field(type = FieldType.keyword)
        private String province;
        @Field(type = FieldType.keyword)
        private String city;
        @GeoPointField
        private GeoPoint geoPoint;

        public Location(){

        }

        public Location(String country, String province, String city, double lat, double lon){
            this.country = country;
            this.province = province;
            this.city = city;
            this.geoPoint = new GeoPoint(lat, lon);
        }

        public GeoPoint getGeoPoint() {
            return geoPoint;
        }

        public String getCountry() {
            return country;
        }

        public String getCity() {
            return city;
        }

        public String getProvince() {
            return province;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setGeoPoint(GeoPoint geoPoint) {
            this.geoPoint = geoPoint;
        }
    }
    @Field(type = FieldType.Object)
    private Location location;
    @Field(type = FieldType.text)
    private String motto;

    public Student(){

    }

    public Student(String id, String sex, Integer age, String firstname, String lastname, String birthday,
                   String country, String province, String city, double lat, double lon, String motto) {
        this.id = id;
        this.sex = sex;
        this.age = age;
        this.name = new Name(firstname, lastname);
        this.birthday = birthday;
        this.location = new Location(country, province, city, lat, lon);
        this.motto = motto;
    }

    public String getId() {
        return id;
    }

    public String getSex() {
        return sex;
    }

    public Integer getAge() {
        return age;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getMotto() {
        return motto;
    }

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setId(String id) {
        this.id = id;
    }
}
