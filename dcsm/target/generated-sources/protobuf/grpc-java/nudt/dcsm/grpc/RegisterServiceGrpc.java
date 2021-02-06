package nudt.dcsm.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 *SecAgent register to SecManager
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.33.1)",
    comments = "Source: Register.proto")
public final class RegisterServiceGrpc {

  private RegisterServiceGrpc() {}

  public static final String SERVICE_NAME = "RegisterService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<nudt.dcsm.grpc.AgentRequest,
      nudt.dcsm.grpc.AgentReply> getRegAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "regAgent",
      requestType = nudt.dcsm.grpc.AgentRequest.class,
      responseType = nudt.dcsm.grpc.AgentReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<nudt.dcsm.grpc.AgentRequest,
      nudt.dcsm.grpc.AgentReply> getRegAgentMethod() {
    io.grpc.MethodDescriptor<nudt.dcsm.grpc.AgentRequest, nudt.dcsm.grpc.AgentReply> getRegAgentMethod;
    if ((getRegAgentMethod = RegisterServiceGrpc.getRegAgentMethod) == null) {
      synchronized (RegisterServiceGrpc.class) {
        if ((getRegAgentMethod = RegisterServiceGrpc.getRegAgentMethod) == null) {
          RegisterServiceGrpc.getRegAgentMethod = getRegAgentMethod =
              io.grpc.MethodDescriptor.<nudt.dcsm.grpc.AgentRequest, nudt.dcsm.grpc.AgentReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "regAgent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  nudt.dcsm.grpc.AgentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  nudt.dcsm.grpc.AgentReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterServiceMethodDescriptorSupplier("regAgent"))
              .build();
        }
      }
    }
    return getRegAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<nudt.dcsm.grpc.VBridgeRequest,
      nudt.dcsm.grpc.VBridgeReply> getRegVBridgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "regVBridge",
      requestType = nudt.dcsm.grpc.VBridgeRequest.class,
      responseType = nudt.dcsm.grpc.VBridgeReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<nudt.dcsm.grpc.VBridgeRequest,
      nudt.dcsm.grpc.VBridgeReply> getRegVBridgeMethod() {
    io.grpc.MethodDescriptor<nudt.dcsm.grpc.VBridgeRequest, nudt.dcsm.grpc.VBridgeReply> getRegVBridgeMethod;
    if ((getRegVBridgeMethod = RegisterServiceGrpc.getRegVBridgeMethod) == null) {
      synchronized (RegisterServiceGrpc.class) {
        if ((getRegVBridgeMethod = RegisterServiceGrpc.getRegVBridgeMethod) == null) {
          RegisterServiceGrpc.getRegVBridgeMethod = getRegVBridgeMethod =
              io.grpc.MethodDescriptor.<nudt.dcsm.grpc.VBridgeRequest, nudt.dcsm.grpc.VBridgeReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "regVBridge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  nudt.dcsm.grpc.VBridgeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  nudt.dcsm.grpc.VBridgeReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterServiceMethodDescriptorSupplier("regVBridge"))
              .build();
        }
      }
    }
    return getRegVBridgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<nudt.dcsm.grpc.VMachineRequest,
      nudt.dcsm.grpc.VMachineReply> getRegVMachineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "regVMachine",
      requestType = nudt.dcsm.grpc.VMachineRequest.class,
      responseType = nudt.dcsm.grpc.VMachineReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<nudt.dcsm.grpc.VMachineRequest,
      nudt.dcsm.grpc.VMachineReply> getRegVMachineMethod() {
    io.grpc.MethodDescriptor<nudt.dcsm.grpc.VMachineRequest, nudt.dcsm.grpc.VMachineReply> getRegVMachineMethod;
    if ((getRegVMachineMethod = RegisterServiceGrpc.getRegVMachineMethod) == null) {
      synchronized (RegisterServiceGrpc.class) {
        if ((getRegVMachineMethod = RegisterServiceGrpc.getRegVMachineMethod) == null) {
          RegisterServiceGrpc.getRegVMachineMethod = getRegVMachineMethod =
              io.grpc.MethodDescriptor.<nudt.dcsm.grpc.VMachineRequest, nudt.dcsm.grpc.VMachineReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "regVMachine"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  nudt.dcsm.grpc.VMachineRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  nudt.dcsm.grpc.VMachineReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterServiceMethodDescriptorSupplier("regVMachine"))
              .build();
        }
      }
    }
    return getRegVMachineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<nudt.dcsm.grpc.VPotRequest,
      nudt.dcsm.grpc.VPotReply> getRegVPotMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "regVPot",
      requestType = nudt.dcsm.grpc.VPotRequest.class,
      responseType = nudt.dcsm.grpc.VPotReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<nudt.dcsm.grpc.VPotRequest,
      nudt.dcsm.grpc.VPotReply> getRegVPotMethod() {
    io.grpc.MethodDescriptor<nudt.dcsm.grpc.VPotRequest, nudt.dcsm.grpc.VPotReply> getRegVPotMethod;
    if ((getRegVPotMethod = RegisterServiceGrpc.getRegVPotMethod) == null) {
      synchronized (RegisterServiceGrpc.class) {
        if ((getRegVPotMethod = RegisterServiceGrpc.getRegVPotMethod) == null) {
          RegisterServiceGrpc.getRegVPotMethod = getRegVPotMethod =
              io.grpc.MethodDescriptor.<nudt.dcsm.grpc.VPotRequest, nudt.dcsm.grpc.VPotReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "regVPot"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  nudt.dcsm.grpc.VPotRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  nudt.dcsm.grpc.VPotReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterServiceMethodDescriptorSupplier("regVPot"))
              .build();
        }
      }
    }
    return getRegVPotMethod;
  }

  private static volatile io.grpc.MethodDescriptor<nudt.dcsm.grpc.SecFunRequest,
      nudt.dcsm.grpc.SecFunReply> getRegSecFunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "regSecFun",
      requestType = nudt.dcsm.grpc.SecFunRequest.class,
      responseType = nudt.dcsm.grpc.SecFunReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<nudt.dcsm.grpc.SecFunRequest,
      nudt.dcsm.grpc.SecFunReply> getRegSecFunMethod() {
    io.grpc.MethodDescriptor<nudt.dcsm.grpc.SecFunRequest, nudt.dcsm.grpc.SecFunReply> getRegSecFunMethod;
    if ((getRegSecFunMethod = RegisterServiceGrpc.getRegSecFunMethod) == null) {
      synchronized (RegisterServiceGrpc.class) {
        if ((getRegSecFunMethod = RegisterServiceGrpc.getRegSecFunMethod) == null) {
          RegisterServiceGrpc.getRegSecFunMethod = getRegSecFunMethod =
              io.grpc.MethodDescriptor.<nudt.dcsm.grpc.SecFunRequest, nudt.dcsm.grpc.SecFunReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "regSecFun"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  nudt.dcsm.grpc.SecFunRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  nudt.dcsm.grpc.SecFunReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterServiceMethodDescriptorSupplier("regSecFun"))
              .build();
        }
      }
    }
    return getRegSecFunMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RegisterServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegisterServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegisterServiceStub>() {
        @java.lang.Override
        public RegisterServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegisterServiceStub(channel, callOptions);
        }
      };
    return RegisterServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegisterServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegisterServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegisterServiceBlockingStub>() {
        @java.lang.Override
        public RegisterServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegisterServiceBlockingStub(channel, callOptions);
        }
      };
    return RegisterServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RegisterServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegisterServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegisterServiceFutureStub>() {
        @java.lang.Override
        public RegisterServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegisterServiceFutureStub(channel, callOptions);
        }
      };
    return RegisterServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *SecAgent register to SecManager
   * </pre>
   */
  public static abstract class RegisterServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * register agent and host
     * </pre>
     */
    public void regAgent(nudt.dcsm.grpc.AgentRequest request,
        io.grpc.stub.StreamObserver<nudt.dcsm.grpc.AgentReply> responseObserver) {
      asyncUnimplementedUnaryCall(getRegAgentMethod(), responseObserver);
    }

    /**
     * <pre>
     * register virtual bridge
     * </pre>
     */
    public void regVBridge(nudt.dcsm.grpc.VBridgeRequest request,
        io.grpc.stub.StreamObserver<nudt.dcsm.grpc.VBridgeReply> responseObserver) {
      asyncUnimplementedUnaryCall(getRegVBridgeMethod(), responseObserver);
    }

    /**
     * <pre>
     * register virtual machine
     * </pre>
     */
    public void regVMachine(nudt.dcsm.grpc.VMachineRequest request,
        io.grpc.stub.StreamObserver<nudt.dcsm.grpc.VMachineReply> responseObserver) {
      asyncUnimplementedUnaryCall(getRegVMachineMethod(), responseObserver);
    }

    /**
     * <pre>
     * register virtual pot
     * </pre>
     */
    public void regVPot(nudt.dcsm.grpc.VPotRequest request,
        io.grpc.stub.StreamObserver<nudt.dcsm.grpc.VPotReply> responseObserver) {
      asyncUnimplementedUnaryCall(getRegVPotMethod(), responseObserver);
    }

    /**
     * <pre>
     * register security function
     * </pre>
     */
    public void regSecFun(nudt.dcsm.grpc.SecFunRequest request,
        io.grpc.stub.StreamObserver<nudt.dcsm.grpc.SecFunReply> responseObserver) {
      asyncUnimplementedUnaryCall(getRegSecFunMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegAgentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                nudt.dcsm.grpc.AgentRequest,
                nudt.dcsm.grpc.AgentReply>(
                  this, METHODID_REG_AGENT)))
          .addMethod(
            getRegVBridgeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                nudt.dcsm.grpc.VBridgeRequest,
                nudt.dcsm.grpc.VBridgeReply>(
                  this, METHODID_REG_VBRIDGE)))
          .addMethod(
            getRegVMachineMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                nudt.dcsm.grpc.VMachineRequest,
                nudt.dcsm.grpc.VMachineReply>(
                  this, METHODID_REG_VMACHINE)))
          .addMethod(
            getRegVPotMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                nudt.dcsm.grpc.VPotRequest,
                nudt.dcsm.grpc.VPotReply>(
                  this, METHODID_REG_VPOT)))
          .addMethod(
            getRegSecFunMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                nudt.dcsm.grpc.SecFunRequest,
                nudt.dcsm.grpc.SecFunReply>(
                  this, METHODID_REG_SEC_FUN)))
          .build();
    }
  }

  /**
   * <pre>
   *SecAgent register to SecManager
   * </pre>
   */
  public static final class RegisterServiceStub extends io.grpc.stub.AbstractAsyncStub<RegisterServiceStub> {
    private RegisterServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegisterServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * register agent and host
     * </pre>
     */
    public void regAgent(nudt.dcsm.grpc.AgentRequest request,
        io.grpc.stub.StreamObserver<nudt.dcsm.grpc.AgentReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegAgentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * register virtual bridge
     * </pre>
     */
    public void regVBridge(nudt.dcsm.grpc.VBridgeRequest request,
        io.grpc.stub.StreamObserver<nudt.dcsm.grpc.VBridgeReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegVBridgeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * register virtual machine
     * </pre>
     */
    public void regVMachine(nudt.dcsm.grpc.VMachineRequest request,
        io.grpc.stub.StreamObserver<nudt.dcsm.grpc.VMachineReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegVMachineMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * register virtual pot
     * </pre>
     */
    public void regVPot(nudt.dcsm.grpc.VPotRequest request,
        io.grpc.stub.StreamObserver<nudt.dcsm.grpc.VPotReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegVPotMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * register security function
     * </pre>
     */
    public void regSecFun(nudt.dcsm.grpc.SecFunRequest request,
        io.grpc.stub.StreamObserver<nudt.dcsm.grpc.SecFunReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegSecFunMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *SecAgent register to SecManager
   * </pre>
   */
  public static final class RegisterServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RegisterServiceBlockingStub> {
    private RegisterServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegisterServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * register agent and host
     * </pre>
     */
    public nudt.dcsm.grpc.AgentReply regAgent(nudt.dcsm.grpc.AgentRequest request) {
      return blockingUnaryCall(
          getChannel(), getRegAgentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * register virtual bridge
     * </pre>
     */
    public nudt.dcsm.grpc.VBridgeReply regVBridge(nudt.dcsm.grpc.VBridgeRequest request) {
      return blockingUnaryCall(
          getChannel(), getRegVBridgeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * register virtual machine
     * </pre>
     */
    public nudt.dcsm.grpc.VMachineReply regVMachine(nudt.dcsm.grpc.VMachineRequest request) {
      return blockingUnaryCall(
          getChannel(), getRegVMachineMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * register virtual pot
     * </pre>
     */
    public nudt.dcsm.grpc.VPotReply regVPot(nudt.dcsm.grpc.VPotRequest request) {
      return blockingUnaryCall(
          getChannel(), getRegVPotMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * register security function
     * </pre>
     */
    public nudt.dcsm.grpc.SecFunReply regSecFun(nudt.dcsm.grpc.SecFunRequest request) {
      return blockingUnaryCall(
          getChannel(), getRegSecFunMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *SecAgent register to SecManager
   * </pre>
   */
  public static final class RegisterServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RegisterServiceFutureStub> {
    private RegisterServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegisterServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * register agent and host
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<nudt.dcsm.grpc.AgentReply> regAgent(
        nudt.dcsm.grpc.AgentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRegAgentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * register virtual bridge
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<nudt.dcsm.grpc.VBridgeReply> regVBridge(
        nudt.dcsm.grpc.VBridgeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRegVBridgeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * register virtual machine
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<nudt.dcsm.grpc.VMachineReply> regVMachine(
        nudt.dcsm.grpc.VMachineRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRegVMachineMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * register virtual pot
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<nudt.dcsm.grpc.VPotReply> regVPot(
        nudt.dcsm.grpc.VPotRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRegVPotMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * register security function
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<nudt.dcsm.grpc.SecFunReply> regSecFun(
        nudt.dcsm.grpc.SecFunRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRegSecFunMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REG_AGENT = 0;
  private static final int METHODID_REG_VBRIDGE = 1;
  private static final int METHODID_REG_VMACHINE = 2;
  private static final int METHODID_REG_VPOT = 3;
  private static final int METHODID_REG_SEC_FUN = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RegisterServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RegisterServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REG_AGENT:
          serviceImpl.regAgent((nudt.dcsm.grpc.AgentRequest) request,
              (io.grpc.stub.StreamObserver<nudt.dcsm.grpc.AgentReply>) responseObserver);
          break;
        case METHODID_REG_VBRIDGE:
          serviceImpl.regVBridge((nudt.dcsm.grpc.VBridgeRequest) request,
              (io.grpc.stub.StreamObserver<nudt.dcsm.grpc.VBridgeReply>) responseObserver);
          break;
        case METHODID_REG_VMACHINE:
          serviceImpl.regVMachine((nudt.dcsm.grpc.VMachineRequest) request,
              (io.grpc.stub.StreamObserver<nudt.dcsm.grpc.VMachineReply>) responseObserver);
          break;
        case METHODID_REG_VPOT:
          serviceImpl.regVPot((nudt.dcsm.grpc.VPotRequest) request,
              (io.grpc.stub.StreamObserver<nudt.dcsm.grpc.VPotReply>) responseObserver);
          break;
        case METHODID_REG_SEC_FUN:
          serviceImpl.regSecFun((nudt.dcsm.grpc.SecFunRequest) request,
              (io.grpc.stub.StreamObserver<nudt.dcsm.grpc.SecFunReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RegisterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegisterServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return nudt.dcsm.grpc.Register.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RegisterService");
    }
  }

  private static final class RegisterServiceFileDescriptorSupplier
      extends RegisterServiceBaseDescriptorSupplier {
    RegisterServiceFileDescriptorSupplier() {}
  }

  private static final class RegisterServiceMethodDescriptorSupplier
      extends RegisterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RegisterServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RegisterServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RegisterServiceFileDescriptorSupplier())
              .addMethod(getRegAgentMethod())
              .addMethod(getRegVBridgeMethod())
              .addMethod(getRegVMachineMethod())
              .addMethod(getRegVPotMethod())
              .addMethod(getRegSecFunMethod())
              .build();
        }
      }
    }
    return result;
  }
}
