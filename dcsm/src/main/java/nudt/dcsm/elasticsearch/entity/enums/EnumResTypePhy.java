package nudt.dcsm.elasticsearch.entity.enums;

/**
 * 枚举物理资产种类：其它、服务器、交换机、路由器
 */
public enum EnumResTypePhy {
    OTHER("其它"),
    SERVER("服务器"),
    SWITCH("交换机"),
    ROUTER("路由器");

    public final String value;
    private EnumResTypePhy(String value) {
        this.value = value;
    }
    public String value() {
        return this.value;
    }
}
