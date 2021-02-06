package nudt.dcsm.grpc;

//import com.sun.org.apache.xpath.internal.operations.String;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SecAgentClient {

    private final saRegServiceGrpc.saRegServiceBlockingStub blockingStub;

    /** Construct client for accessing HelloWorld server using the existing channel. */
    public SecAgentClient(Channel channel) {
        // 'channel' here is a Channel, not a ManagedChannel, so it is not this code's responsibility to
        // shut it down.

        // Passing Channels to code makes code easier to test and makes it easier to reuse Channels.
        blockingStub = saRegServiceGrpc.newBlockingStub(channel);
    }

    /** Say hello to server. */
    public void greet(String name) {
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply response;
        try {
            response = blockingStub.sayHello(request);
        } catch (StatusRuntimeException e) {
            return;
        }
        System.out.println("Greeting: " + response.getMessage());
    }

    /** Say hello to server. */
    public void greet(String name, String country, String city) {
        HelloRequest.location location = HelloRequest.location.newBuilder().setCountry(country).setCity(city).build();
        HelloRequest request = HelloRequest.newBuilder().setName(name).setLoc(location).build();
        HelloReply response;
        try {
            response = blockingStub.sayHello(request);
        } catch (StatusRuntimeException e) {
            return;
        }
        System.out.println("Greeting: " + response.getMessage());
    }

    public void secAgentRegister(String saName, String saIP, String saMac, boolean Is_phy,
                                 int vm_num, List<String> list_vmip, int sservice_num, List<String> list_sservice_name){

        saReg2smRequest.Builder builder = saReg2smRequest.newBuilder();
        builder.setSaName(saName).setSaIP(saIP).setSaMac(saMac).setIsPhy(Is_phy);
        if(list_vmip.size()>0){
            for (String vmip : list_vmip) {
                builder.addVmip(vmip);
            }
        }

        builder.setSserviceNum(sservice_num);
        for (String ssname : list_sservice_name) {
            builder.addSserviceName(ssname);
        }
        saReg2smRequest request = builder.build();
        saReg2smReply response;
        try {
            response = blockingStub.saReg(request);
        } catch (StatusRuntimeException e) {
            return;
        }
        System.out.println("SaReging: " + response.getSaID());

    }

    /**
     * Greet server. If provided, the first element of {@code args} is the name to use in the
     * greeting. The second argument is the target server.
     */
    public static void main(String[] args) throws Exception {
        String user = "hahahahah";
        // Access a service running on the local machine on port 50051
        String target = "localhost:50051";
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

        // Create a communication channel to the server, known as a Channel. Channels are thread-safe
        // and reusable. It is common to create channels at the beginning of your application and reuse
        // them until the application shuts down.
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();
        try {
            SecAgentClient client = new SecAgentClient(channel);
            //client.greet(user);
            client.greet(user, "China", "Changsha");
            ArrayList<java.lang.String> list_vmip = new ArrayList<>();
            list_vmip.add("2.2.2.2");
            list_vmip.add("df");
            ArrayList<String> list_ssname = new ArrayList<String>();
            list_ssname.add("sss");
            client.secAgentRegister("saname","1.1.1.1","12:11:22:22:22:22",
                    true,3, list_vmip,3, list_ssname);
        } finally {
            // ManagedChannels use resources like threads and TCP connections. To prevent leaking these
            // resources the channel should be shut down when it will no longer be used. If it may be used
            // again leave it running.
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
