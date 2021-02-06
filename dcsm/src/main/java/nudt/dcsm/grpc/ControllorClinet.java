package nudt.dcsm.grpc;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import nudt.dcsm.elasticsearch.entity.command.Para;
import nudt.dcsm.elasticsearch.entity.resource.ResSec;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ControllorClinet {

    private final ControllorServiceGrpc.ControllorServiceBlockingStub blockingStub;

    /** Construct client for accessing HelloWorld server using the existing channel. */
    public ControllorClinet(Channel channel) {
        // 'channel' here is a Channel, not a ManagedChannel, so it is not this code's responsibility to
        // shut it down.

        // Passing Channels to code makes code easier to test and makes it easier to reuse Channels.
        blockingStub = ControllorServiceGrpc.newBlockingStub(channel);
    }

    /** Say hello to server. */
    public void Command(String agentID, String secFunName, String secFunType, String cmdEName, int para_num, List<nudt.dcsm.elasticsearch.entity.command.Para> Para) {
        //AgentRequest.HostIpMac Ho = AgentRequest.HostIpMac.newBuilder().setMac(mac).setIp(ip).setInterface(interfac).build();
        CommandRequest.Builder builder = CommandRequest.newBuilder();
        if(cmdEName !=null){
            builder.setAgentID(agentID).setSecFunName(secFunName).setSecFunType(secFunType).setCmdEName(cmdEName).setParaNum(para_num);
        }else{
            builder.setAgentID(agentID).setSecFunName(secFunName).setSecFunType(secFunType).setParaNum(para_num);
        }

        if(Para != null) {
            for (nudt.dcsm.elasticsearch.entity.command.Para p : Para) {
                if(p.getParaValue() != null){
                    CommandRequest.Para pa = CommandRequest.Para.newBuilder().setParaEName(p.getParaEName()).setParaValue(p.getParaValue()).build();
                    builder.addPara(pa);
                }else{
                    CommandRequest.Para pa = CommandRequest.Para.newBuilder().setParaEName(p.getParaEName()).build();
                    builder.addPara(pa);
                }
            }
        }

        CommandRequest request = builder.build();
        CommandReply response;

        try {
            response = blockingStub.runCommand(request);
        } catch (StatusRuntimeException e) {
            return;
        }
        System.out.println("Greeting: " + response.getResult());

    }

    /**
     * Greet server. If provided, the first element of {@code args} is the name to use in the
     * greeting. The second argument is the target server.
     */
    public static void ContrCtRun(String secID,String cmdEName,List<Para> Para) throws Exception {
        // Access a service running on the local machine on port 50051


        // Allow passing in the user and target strings as command line arguments

        String angentip = ElasticInput.SelectSys(secID);
        String target = angentip+":50053";

        ResSec sec =  ElasticInput.Selectsec(secID);
        // Create a communication channel to the server, known as a Channel. Channels are thread-safe
        // and reusable. It is common to create channels at the beginning of your application and reuse
        // them until the application shuts down.
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();
        try {
            //String agentID, String secFunName, String secFunType, String cmdEName, int para_num, List<nudt.dcsm.elasticsearch.entity.command.Para> Para
            ControllorClinet client = new ControllorClinet(channel);
            if(Para != null){
                System.out.println("escid"+secID+"|name:"+sec.getName()+"|type:"+sec.getResType());
                client.Command(secID,sec.getName(),sec.getResType(),cmdEName,Para.size(),Para);
            }else{
                client.Command(secID,sec.getName(),sec.getResType(),cmdEName,0,null);
            }

        } finally {

            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
