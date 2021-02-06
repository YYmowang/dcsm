package nudt.dcsm.elasticsearch.entity.enums;

/**
 * 枚举资产种类 ：数据中心、物理资产、虚拟资产、系统资产、安全资产
 */
public enum EnumResCategory {
    DATACENTER("数据中心"),
    PYHSICALRES("物理资产"),
    VIRTUALRES("虚拟资产"),
    SYSTEMRES("系统资产"),
    SECURITYRES("安全资产");

    public final String value;
    private EnumResCategory(String value) {
        this.value = value;
    }
    public String value() {
        return this.value;
    }
}
