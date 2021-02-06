package nudt.dcsm.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import nudt.dcsm.MianThread;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RegisterServer {
    private Server server;
    private ApplicationContext context;
    public void start() throws IOException {
        /* The port on which the server should run */
        this.context = context;
        int port = 50052;
        System.out.println("grpc start");
        server = ServerBuilder.forPort(port)
                .addService(new RegisterServiceImpl())
                .build()
                .start();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    RegisterServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    public void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        //final RegisterServer server = new RegisterServer();


        //server.start();
        //server.blockUntilShutdown();
    }

    static class RegisterServiceImpl extends  RegisterServiceGrpc.RegisterServiceImplBase{



        @Override
        public void regAgent(AgentRequest request, StreamObserver<AgentReply> responseObserver) {
            AgentReply reply = AgentReply.newBuilder().setAgentID("1").build();

            regSevice.resPhyVtlAgent(request.getAgentName(),request.getAgentMac(),request.getIsVirtHost(),request.getAgentIP(),request.getIpsList(),request.getVbNum(),request.getVmNum(),request.getVpotNum(),request.getServiceNum());
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void regVMachine(VMachineRequest request, StreamObserver<VMachineReply> responseObserver)  {
            VMachineReply reply = VMachineReply.newBuilder().setAck("ok").build();

            if(request.getVMachingList().size()>0){
                for (int i=0;i<request.getVMachingList().size();i++){
                    regSevice.resVtiVMachine(
                            request.getVmNum(),request.getVMachingList().get(i).getVmName(),request.getVMachingList().get(i).getOnState(),
                            request.getVMachingList().get(i).getBridge(),request.getVMachingList().get(i).getVmMac(),
                            request.getVMachingList().get(i).getVmIP());
                }
            }

            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void regVPot(VPotRequest request, StreamObserver<VPotReply> responseObserver)  {
            VPotReply reply = VPotReply.newBuilder().setAck("ok").build();




            if(request.getVpotList().size()>0){
                for (int i=0;i<request.getVpotList().size();i++){
                    regSevice.resVtiVPot(
                            request.getVpotNum(),
                            request.getVpotList().get(i).getVpotName(),request.getVpotList().get(i).getOnState(),
                            request.getVpotList().get(i).getBridge(),request.getVpotList().get(i).getVpotMac(),
                            request.getVpotList().get(i).getVpotIP());
                    //re.selectVpot();
                }
            }


            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void regVBridge(VBridgeRequest request, StreamObserver<VBridgeReply> responseObserver) {
            VBridgeReply reply = VBridgeReply.newBuilder().setAck("ok").build();



            if(request.getVBridgeList().size()>0){
                for (int i=0;i<request.getVBridgeList().size();i++){
                    regSevice.resVtiVBridge(
                            request.getVbNum(),request.getVBridgeList().get(i).getVbName(),request.getVBridgeList().get(i).getPeerVBridgeList(),
                            request.getVBridgeList().get(i).getPhyInterfaceList());
                    //re.selectVBridge();
                }
            }

            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void regSecFun(SecFunRequest request, StreamObserver<SecFunReply> responseObserver) {



            SecFunReply reply = SecFunReply.newBuilder().setAck("ok").build();


            regSevice.resSecFun(request.getAgentID(),request.getSecFunName(),request.getSecFunType(),request.getUrlList(),request.getCmdList());

            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}
