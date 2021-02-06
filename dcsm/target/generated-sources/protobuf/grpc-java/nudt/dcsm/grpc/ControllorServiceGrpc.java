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
 *SecManager send CMDs of security functions to SecAgent
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.33.1)",
    comments = "Source: Controllor.proto")
public final class ControllorServiceGrpc {

  private ControllorServiceGrpc() {}

  public static final String SERVICE_NAME = "ControllorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<nudt.dcsm.grpc.CommandRequest,
      nudt.dcsm.grpc.CommandReply> getRunCommandMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "runCommand",
      requestType = nudt.dcsm.grpc.CommandRequest.class,
      responseType = nudt.dcsm.grpc.CommandReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<nudt.dcsm.grpc.CommandRequest,
      nudt.dcsm.grpc.CommandReply> getRunCommandMethod() {
    io.grpc.MethodDescriptor<nudt.dcsm.grpc.CommandRequest, nudt.dcsm.grpc.CommandReply> getRunCommandMethod;
    if ((getRunCommandMethod = ControllorServiceGrpc.getRunCommandMethod) == null) {
      synchronized (ControllorServiceGrpc.class) {
        if ((getRunCommandMethod = ControllorServiceGrpc.getRunCommandMethod) == null) {
          ControllorServiceGrpc.getRunCommandMethod = getRunCommandMethod =
              io.grpc.MethodDescriptor.<nudt.dcsm.grpc.CommandRequest, nudt.dcsm.grpc.CommandReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "runCommand"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  nudt.dcsm.grpc.CommandRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  nudt.dcsm.grpc.CommandReply.getDefaultInstance()))
              .setSchemaDescriptor(new ControllorServiceMethodDescriptorSupplier("runCommand"))
              .build();
        }
      }
    }
    return getRunCommandMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ControllorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ControllorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ControllorServiceStub>() {
        @java.lang.Override
        public ControllorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ControllorServiceStub(channel, callOptions);
        }
      };
    return ControllorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ControllorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ControllorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ControllorServiceBlockingStub>() {
        @java.lang.Override
        public ControllorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ControllorServiceBlockingStub(channel, callOptions);
        }
      };
    return ControllorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ControllorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ControllorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ControllorServiceFutureStub>() {
        @java.lang.Override
        public ControllorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ControllorServiceFutureStub(channel, callOptions);
        }
      };
    return ControllorServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *SecManager send CMDs of security functions to SecAgent
   * </pre>
   */
  public static abstract class ControllorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void runCommand(nudt.dcsm.grpc.CommandRequest request,
        io.grpc.stub.StreamObserver<nudt.dcsm.grpc.CommandReply> responseObserver) {
      asyncUnimplementedUnaryCall(getRunCommandMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRunCommandMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                nudt.dcsm.grpc.CommandRequest,
                nudt.dcsm.grpc.CommandReply>(
                  this, METHODID_RUN_COMMAND)))
          .build();
    }
  }

  /**
   * <pre>
   *SecManager send CMDs of security functions to SecAgent
   * </pre>
   */
  public static final class ControllorServiceStub extends io.grpc.stub.AbstractAsyncStub<ControllorServiceStub> {
    private ControllorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControllorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ControllorServiceStub(channel, callOptions);
    }

    /**
     */
    public void runCommand(nudt.dcsm.grpc.CommandRequest request,
        io.grpc.stub.StreamObserver<nudt.dcsm.grpc.CommandReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRunCommandMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *SecManager send CMDs of security functions to SecAgent
   * </pre>
   */
  public static final class ControllorServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ControllorServiceBlockingStub> {
    private ControllorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControllorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ControllorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public nudt.dcsm.grpc.CommandReply runCommand(nudt.dcsm.grpc.CommandRequest request) {
      return blockingUnaryCall(
          getChannel(), getRunCommandMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *SecManager send CMDs of security functions to SecAgent
   * </pre>
   */
  public static final class ControllorServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ControllorServiceFutureStub> {
    private ControllorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControllorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ControllorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<nudt.dcsm.grpc.CommandReply> runCommand(
        nudt.dcsm.grpc.CommandRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRunCommandMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RUN_COMMAND = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ControllorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ControllorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RUN_COMMAND:
          serviceImpl.runCommand((nudt.dcsm.grpc.CommandRequest) request,
              (io.grpc.stub.StreamObserver<nudt.dcsm.grpc.CommandReply>) responseObserver);
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

  private static abstract class ControllorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ControllorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return nudt.dcsm.grpc.Controllor.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ControllorService");
    }
  }

  private static final class ControllorServiceFileDescriptorSupplier
      extends ControllorServiceBaseDescriptorSupplier {
    ControllorServiceFileDescriptorSupplier() {}
  }

  private static final class ControllorServiceMethodDescriptorSupplier
      extends ControllorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ControllorServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ControllorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ControllorServiceFileDescriptorSupplier())
              .addMethod(getRunCommandMethod())
              .build();
        }
      }
    }
    return result;
  }
}
