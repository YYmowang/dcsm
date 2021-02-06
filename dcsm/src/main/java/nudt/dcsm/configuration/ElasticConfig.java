package nudt.dcsm.configuration;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class ElasticConfig {
    @Value("${elasticsearch.host}")
    private String EsHost;

    @Value("${elasticsearch.port}")
    private int EsPort;

    @Value("${elasticsearch.clustername}")
    private String EsClusterName;

    private TransportClient client = null;

    public ElasticConfig(){}

    /**
     * 创建TransportClient，必须在@Bean之后运行
     * @throws UnknownHostException
     */
    public void createTransportClient() throws UnknownHostException {
        Settings esSettings = Settings.builder().put("cluster.name", this.EsClusterName)
                // 开启嗅探功能(即自动检测集群内其他的节点和新加入的节点);或者全部用addTransportAddress添加，如下：
                .put("client.transport.sniff", true).build();

        this.client = new PreBuiltTransportClient(esSettings);
        String[] esHosts = EsHost.trim().split(",");
        for (String host : esHosts) {
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host),
                    this.EsPort));
        }
    }
    public TransportClient getClient() {
        return client;
    }

    public void setClient(TransportClient client) {
        this.client = client;
    }

    public String getEsClusterName() {
        return EsClusterName;
    }

    public void setEsClusterName(String esClusterName) {
        EsClusterName = esClusterName;
    }

    public String getEsHost() {
        return EsHost;
    }

    public void setEsHost(String esHost) {
        EsHost = esHost;
    }

    public int getEsPort() {
        return EsPort;
    }

    public void setEsPort(int esPort) {
        EsPort = esPort;
    }
}
