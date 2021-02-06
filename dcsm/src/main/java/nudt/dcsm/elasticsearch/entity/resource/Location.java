package nudt.dcsm.elasticsearch.entity.resource;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

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
