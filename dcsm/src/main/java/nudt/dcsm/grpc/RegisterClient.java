package nudt.dcsm.grpc;


import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegisterClient {
    private final RegisterServiceGrpc.RegisterServiceBlockingStub blockingStub;

    /** Construct client for accessing HelloWorld server using the existing channel. */
    public RegisterClient(Channel channel) {
        // 'channel' here is a Channel, not a ManagedChannel, so it is not this code's responsibility to
        // shut it down.

        // Passing Channels to code makes code easier to test and makes it easier to reuse Channels.
        blockingStub = RegisterServiceGrpc.newBlockingStub(channel);
    }

    /** Say hello to server. */
    public void Agent(String agentName, String agentIP, String agentMac, List<String> ips, String mac, String interfac, int vm_num, int vb_num, int pot_num, int service_num,boolean isvm) {
        //AgentRequest.HostIpMac Ho = AgentRequest.HostIpMac.newBuilder().setMac(mac).setIp(ip).setInterface(interfac).build();

        AgentRequest.Builder builder = AgentRequest.newBuilder();

        builder.setAgentName(agentName).setAgentMac(agentMac).setAgentIP(agentIP).setVbNum(vm_num).setVmNum(vb_num).setServiceNum(service_num).setIsVirtHost(isvm);

        if(ips.size()>0){
            for (String ip : ips) {
                builder.addIps(ip);
            }
        }
        AgentRequest request = builder.build();

        AgentReply response;


        try {
            response = blockingStub.regAgent(request);
        } catch (StatusRuntimeException e) {
            return;
        }
        System.out.println("Greeting: " + response.getAgentID());
    }
    /** Say hello to server. */
    public void VBridge(int vb_num,String vbName,String peerVBridge,String phyInterface) {
        VBridgeRequest.VBridge VB = VBridgeRequest.VBridge.newBuilder().setVbName(vbName).addPeerVBridge(peerVBridge).addPhyInterface(phyInterface).build();
        VBridgeRequest request = VBridgeRequest.newBuilder().setVbNum(vb_num).addVBridge(VB).build();
        VBridgeReply response;

        try {
            response = blockingStub.regVBridge(request);
        } catch (StatusRuntimeException e) {
            return;
        }
        System.out.println("Greeting: " + response.getAck());
    }
    /** Say hello to server. */
    public void VMachine(int vm_num,String vmName,boolean onState,String bridge,String vmMac,String vmIP) {

        VMachineRequest.Builder builder = VMachineRequest.newBuilder();
        VMachineRequest.VMachine VM = VMachineRequest.VMachine.newBuilder().setVmName(vmName).setOnState(onState).setVmIP(vmIP).build();
        builder.setVmNum(vm_num).addVMaching(VM);

        VMachineRequest request = builder.build();
        VMachineReply response;

        try {
            response = blockingStub.regVMachine(request);
        } catch (StatusRuntimeException e) {
            return;
        }
        System.out.println("Greeting: " + response.getAck());
    }

    /** Say hello to server. */
    public void VPotRe(int vpot_num,String vpotName,boolean onState,String bridge,String vpotMac,String vpotIP) {


        VPotRequest.VPot vp = VPotRequest.VPot.newBuilder().setVpotName(vpotName).setOnState(onState).setVpotIP(vpotIP).build();
        VPotRequest request = VPotRequest.newBuilder().setVpotNum(vpot_num).addVpot(vp).build();
        VPotReply response;

        try {
            response = blockingStub.regVPot(request);
        } catch (StatusRuntimeException e) {
            return;
        }
        System.out.println("Greeting: " + response.getAck());
    }

    /** Say hello to server. */
    public void SecFun(String agentID,String secFunName,String secFunType
            ,String urlCName,String url,String urlDes,String username,String password,
                       String cmdCName,String cmdEName, String cmdDes,int para_num,String paraCName
            ,String paraEName,String paraDes,String paraFomate,String paraRegular,boolean paraIsOptional,String paraDefaultVal
    ) {

       /* SecFunRequest.Connector connector =  SecFunRequest.Connector.newBuilder().setUrlCName(urlCName).setUrlDes(urlDes).setUrl(url).setUsername(username)
                .setPassword(password).build();*/

        SecFunRequest.CMD.Para pa = SecFunRequest.CMD.Para.newBuilder().setParaCName(paraCName).setParaEName(paraEName)
                .setParaDes(paraDes).setParaRegular(paraRegular).setParaIsOptional(paraIsOptional)
                .setParaDefaultVal(paraDefaultVal).build();
        SecFunRequest.CMD cm =  SecFunRequest.CMD.newBuilder().setCmdCName(cmdCName).setCmdEName(cmdEName)
                .setCmdDes(cmdDes).setParaNum(para_num).setPara(5,pa).build();
        SecFunRequest request = SecFunRequest.newBuilder().setAgentID(agentID).setSecFunName(secFunName).setSecFunType(secFunType)
                .setCmd(5,cm).build();
        SecFunReply response;
        SecFunRequest.Builder builder = SecFunRequest.newBuilder();
        builder.setAgentID(agentID);

        try {
            response = blockingStub.regSecFun(request);
        } catch (StatusRuntimeException e) {
            return;
        }
        System.out.println("Greeting: " + response.getAck());
    }
    /**
     * Greet server. If provided, the first element of {@code args} is the name to use in the
     * greeting. The second argument is the target server.
     */
    public static void main(String[] args) throws Exception {
        String user = "hahahahah";
        // Access a service running on the local machine on port 50051
        String target = "localhost:50052";
        // Allow passing in the user and target strings as command line arguments
        if (args.length > 0) {
            if ("--help".equals(args[0])) {
                System.err.println("Usage: [name [target]]");
                System.err.println("");
                System.err.println("  name    The name you wish to be greeted by. Defaults to " + user);
                System.err.println("  target  The server to connect to. Defaults to " + target);
                System.exit(1);
            }
            user = args[0];
        }
        if (args.length > 1) {
            target = args[1];
        }
        List<String> ips = new ArrayList<String>();
        ips.add("1.1.1.1");
        ips.add("2.2.2.2");
        // Create a communication channel to the server, known as a Channel. Channels are thread-safe
        // and reusable. It is common to create channels at the beginning of your application and reuse
        // them until the application shuts down.
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();
        try {
            RegisterClient client = new RegisterClient(channel);
            //client.greet(user);
            client.Agent("第一","3.3.3.3","",ips,"","",0,1,1,1,false);
            client.VBridge(1,"NO.1 VBridge","vbwangqiao","wulijiekou");
            client.VPotRe(1,"no.1 vpot",true,null,null,"5.5.5.5");
            client.VMachine(1,"no.1 server",true,null,null,"1.2.3.4");
        } finally {
            // ManagedChannels use resources like threads and TCP connections. To prevent leaking these
            // resources the channel should be shut down when it will no longer be used. If it may be used
            // again leave it running.
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
