package nudt.dcsm.websocket;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import nudt.dcsm.elasticsearch.entity.command.Para;
import nudt.dcsm.grpc.ControllorClinet;
import nudt.dcsm.grpc.regSevice;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * @Author li
 * @Create 2020/12/29 16:33
 **/
public class SocketServer extends WebSocketServer {



    public SocketServer() {

    }

    public SocketServer(int port) {
        super(new InetSocketAddress(port));
        System.out.println("websocket Server start at port:"+port);
    }


    /**
     * 触发连接事件
     */
    @Override
    public void onOpen(WebSocket conn, ClientHandshake clientHandshake) {
        System.out.println(conn.getLocalSocketAddress());
        System.out.println("new connection ===" + conn.getRemoteSocketAddress().getAddress().getHostAddress());
    }

    /**
     *
     * 连接断开时触发关闭事件
     */
    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        System.out.println("连接断开时触发关闭事件 ");
    }

    /**
     * 客户端发送消息到服务器时触发事件
     * end 为单次传送结束
     */
    @Override
    public void onMessage(WebSocket conn, String message) {
        System.out.println("you have a new message: "+ message);
        //向客户端发送消息
        //String target = "localhost:50052";

        JSONObject object = JSONObject.parseObject(message);
        String agentID = object.getString("agentID");
        String cdmEName = object.getString("cdmEName");
        if(object.getJSONArray("Para") !=null){
            List<Para> Para = JSON.parseArray(object.getJSONArray("Para").toJSONString(),Para.class);
            try {
                ControllorClinet.ContrCtRun(agentID,cdmEName,Para);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{
            try {
                ControllorClinet.ContrCtRun(agentID,cdmEName,null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }




        conn.send("ok");
    }

    /**
     * 触发异常事件
     */
    @Override
    public void onError(WebSocket conn, Exception e) {
        //e.printStackTrace();
        if( conn != null ) {
            //some errors like port binding failed may not be assignable to a specific websocket
            System.out.println("触发异常事件 ");
        }
    }

    @Override
    public void onStart() {
        System.out.println("onStart");
    }

}
