package nudt.dcsm.elasticsearch.entity.enums;

/**
 * 枚举虚拟资产类型：其它、业务虚拟机、安全虚拟机、业务容器、安全容器
 */
public enum EnumResTypeVtl {
    OTHER("其它"),
    USERVM("业务虚拟机"),
    SECVM("安全虚拟机"),
    USERPOT("业务容器"),
    SECPOT("安全容器");

    public final String value;
    private EnumResTypeVtl(String value) {
        this.value = value;
    }
    public String value() {
        return this.value;
    }
}
