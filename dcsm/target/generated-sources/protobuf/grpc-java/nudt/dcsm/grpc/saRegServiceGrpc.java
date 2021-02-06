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
 * define a service 
 *1. secure_agent register to secure_manager
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.33.1)",
    comments = "Source: saReg.proto")
public final class saRegServiceGrpc {

  private saRegServiceGrpc() {}

  public static final String SERVICE_NAME = "saRegService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<nudt.dcsm.grpc.HelloRequest,
      nudt.dcsm.grpc.HelloReply> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello",
      requestType = nudt.dcsm.grpc.HelloRequest.class,
      responseType = nudt.dcsm.grpc.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<nudt.dcsm.grpc.HelloRequest,
      nudt.dcsm.grpc.HelloReply> getSayHelloMethod() {
    io.grpc.MethodDescriptor<nudt.dcsm.grpc.HelloRequest, nudt.dcsm.grpc.HelloReply> getSayHelloMethod;
    if ((getSayHelloMethod = saRegServiceGrpc.getSayHelloMethod) == null) {
      synchronized (saRegServiceGrpc.class) {
        if ((getSayHelloMethod = saRegServiceGrpc.getSayHelloMethod) == null) {
          saRegServiceGrpc.getSayHelloMethod = getSayHelloMethod =
              io.grpc.MethodDescriptor.<nudt.dcsm.grpc.HelloRequest, nudt.dcsm.grpc.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  nudt.dcsm.grpc.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  nudt.dcsm.grpc.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new saRegServiceMethodDescriptorSupplier("SayHello"))
              .build();
        }
      }
    }
    return getSayHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<nudt.dcsm.grpc.saReg2smRequest,
      nudt.dcsm.grpc.saReg2smReply> getSaRegMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saReg",
      requestType = nudt.dcsm.grpc.saReg2smRequest.class,
      responseType = nudt.dcsm.grpc.saReg2smReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<nudt.dcsm.grpc.saReg2smRequest,
      nudt.dcsm.grpc.saReg2smReply> getSaRegMethod() {
    io.grpc.MethodDescriptor<nudt.dcsm.grpc.saReg2smRequest, nudt.dcsm.grpc.saReg2smReply> getSaRegMethod;
    if ((getSaRegMethod = saRegServiceGrpc.getSaRegMethod) == null) {
      synchronized (saRegServiceGrpc.class) {
        if ((getSaRegMethod = saRegServiceGrpc.getSaRegMethod) == null) {
          saRegServiceGrpc.getSaRegMethod = getSaRegMethod =
              io.grpc.MethodDescriptor.<nudt.dcsm.grpc.saReg2smRequest, nudt.dcsm.grpc.saReg2smReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "saReg"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  nudt.dcsm.grpc.saReg2smRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  nudt.dcsm.grpc.saReg2smReply.getDefaultInstance()))
              .setSchemaDescriptor(new saRegServiceMethodDescriptorSupplier("saReg"))
              .build();
        }
      }
    }
    return getSaRegMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static saRegServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<saRegServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<saRegServiceStub>() {
        @java.lang.Override
        public saRegServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new saRegServiceStub(channel, callOptions);
        }
      };
    return saRegServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static saRegServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<saRegServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<saRegServiceBlockingStub>() {
        @java.lang.Override
        public saRegServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new saRegServiceBlockingStub(channel, callOptions);
        }
      };
    return saRegServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static saRegServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<saRegServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<saRegServiceFutureStub>() {
        @java.lang.Override
        public saRegServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new saRegServiceFutureStub(channel, callOptions);
        }
      };
    return saRegServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * define a service 
   *1. secure_agent register to secure_manager
   * </pre>
   */
  public static abstract class saRegServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * define the interface and data type
     * </pre>
     */
    public void sayHello(nudt.dcsm.grpc.HelloRequest request,
        io.grpc.stub.StreamObserver<nudt.dcsm.grpc.HelloReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    /**
     */
    public void saReg(nudt.dcsm.grpc.saReg2smRequest request,
        io.grpc.stub.StreamObserver<nudt.dcsm.grpc.saReg2smReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSaRegMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                nudt.dcsm.grpc.HelloRequest,
                nudt.dcsm.grpc.HelloReply>(
                  this, METHODID_SAY_HELLO)))
          .addMethod(
            getSaRegMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                nudt.dcsm.grpc.saReg2smRequest,
                nudt.dcsm.grpc.saReg2smReply>(
                  this, METHODID_SA_REG)))
          .build();
    }
  }

  /**
   * <pre>
   * define a service 
   *1. secure_agent register to secure_manager
   * </pre>
   */
  public static final class saRegServiceStub extends io.grpc.stub.AbstractAsyncStub<saRegServiceStub> {
    private saRegServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected saRegServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new saRegServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * define the interface and data type
     * </pre>
     */
    public void sayHello(nudt.dcsm.grpc.HelloRequest request,
        io.grpc.stub.StreamObserver<nudt.dcsm.grpc.HelloReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void saReg(nudt.dcsm.grpc.saReg2smRequest request,
        io.grpc.stub.StreamObserver<nudt.dcsm.grpc.saReg2smReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSaRegMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * define a service 
   *1. secure_agent register to secure_manager
   * </pre>
   */
  public static final class saRegServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<saRegServiceBlockingStub> {
    private saRegServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected saRegServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new saRegServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * define the interface and data type
     * </pre>
     */
    public nudt.dcsm.grpc.HelloReply sayHello(nudt.dcsm.grpc.HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }

    /**
     */
    public nudt.dcsm.grpc.saReg2smReply saReg(nudt.dcsm.grpc.saReg2smRequest request) {
      return blockingUnaryCall(
          getChannel(), getSaRegMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * define a service 
   *1. secure_agent register to secure_manager
   * </pre>
   */
  public static final class saRegServiceFutureStub extends io.grpc.stub.AbstractFutureStub<saRegServiceFutureStub> {
    private saRegServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected saRegServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new saRegServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * define the interface and data type
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<nudt.dcsm.grpc.HelloReply> sayHello(
        nudt.dcsm.grpc.HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<nudt.dcsm.grpc.saReg2smReply> saReg(
        nudt.dcsm.grpc.saReg2smRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSaRegMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;
  private static final int METHODID_SA_REG = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final saRegServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(saRegServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((nudt.dcsm.grpc.HelloRequest) request,
              (io.grpc.stub.StreamObserver<nudt.dcsm.grpc.HelloReply>) responseObserver);
          break;
        case METHODID_SA_REG:
          serviceImpl.saReg((nudt.dcsm.grpc.saReg2smRequest) request,
              (io.grpc.stub.StreamObserver<nudt.dcsm.grpc.saReg2smReply>) responseObserver);
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

  private static abstract class saRegServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    saRegServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return nudt.dcsm.grpc.SaReg.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("saRegService");
    }
  }

  private static final class saRegServiceFileDescriptorSupplier
      extends saRegServiceBaseDescriptorSupplier {
    saRegServiceFileDescriptorSupplier() {}
  }

  private static final class saRegServiceMethodDescriptorSupplier
      extends saRegServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    saRegServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (saRegServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new saRegServiceFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .addMethod(getSaRegMethod())
              .build();
        }
      }
    }
    return result;
  }
}
