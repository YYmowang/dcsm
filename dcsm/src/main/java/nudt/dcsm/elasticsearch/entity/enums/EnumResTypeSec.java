package nudt.dcsm.elasticsearch.entity.enums;

public enum EnumResTypeSec {

    OTHER("其他"),
    HIDS("HIDS"),
    NIDS("NIDS"),
    MOLOCH("Moloch"),
    METRICBEAT("MetricBeat"),
    LIBVMI("Libvmi"),
    KMONITOR("KMonitor"),
    FIREWALL("Firewall");

    public final String value;
    private EnumResTypeSec(String value) {
        this.value = value;
    }
    public String value() {
        return this.value;
    }
}
