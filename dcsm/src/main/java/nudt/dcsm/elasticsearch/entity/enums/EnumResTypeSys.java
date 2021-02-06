package nudt.dcsm.elasticsearch.entity.enums;

public enum EnumResTypeSys {
    OTHER("其他"),
    SECAGENT("SecAgent"),
    ELASTICS("Elastics"),
    REDIS("Redis"),
    LOGSTASH("Logstash");

    public final String value;
    private EnumResTypeSys(String value) {
        this.value = value;
    }
    public String value() {
        return this.value;
    }
}
