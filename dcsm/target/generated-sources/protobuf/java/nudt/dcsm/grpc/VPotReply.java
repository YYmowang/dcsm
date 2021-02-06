// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Register.proto

package nudt.dcsm.grpc;

/**
 * Protobuf type {@code VPotReply}
 */
public final class VPotReply extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:VPotReply)
    VPotReplyOrBuilder {
private static final long serialVersionUID = 0L;
  // Use VPotReply.newBuilder() to construct.
  private VPotReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private VPotReply() {
    ack_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new VPotReply();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private VPotReply(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            ack_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return nudt.dcsm.grpc.Register.internal_static_VPotReply_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return nudt.dcsm.grpc.Register.internal_static_VPotReply_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            nudt.dcsm.grpc.VPotReply.class, nudt.dcsm.grpc.VPotReply.Builder.class);
  }

  public static final int ACK_FIELD_NUMBER = 1;
  private volatile java.lang.Object ack_;
  /**
   * <pre>
   * reply "OK" if success
   * </pre>
   *
   * <code>string ack = 1;</code>
   * @return The ack.
   */
  @java.lang.Override
  public java.lang.String getAck() {
    java.lang.Object ref = ack_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      ack_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * reply "OK" if success
   * </pre>
   *
   * <code>string ack = 1;</code>
   * @return The bytes for ack.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getAckBytes() {
    java.lang.Object ref = ack_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      ack_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getAckBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, ack_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getAckBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, ack_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof nudt.dcsm.grpc.VPotReply)) {
      return super.equals(obj);
    }
    nudt.dcsm.grpc.VPotReply other = (nudt.dcsm.grpc.VPotReply) obj;

    if (!getAck()
        .equals(other.getAck())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ACK_FIELD_NUMBER;
    hash = (53 * hash) + getAck().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static nudt.dcsm.grpc.VPotReply parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static nudt.dcsm.grpc.VPotReply parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static nudt.dcsm.grpc.VPotReply parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static nudt.dcsm.grpc.VPotReply parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static nudt.dcsm.grpc.VPotReply parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static nudt.dcsm.grpc.VPotReply parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static nudt.dcsm.grpc.VPotReply parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static nudt.dcsm.grpc.VPotReply parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static nudt.dcsm.grpc.VPotReply parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static nudt.dcsm.grpc.VPotReply parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static nudt.dcsm.grpc.VPotReply parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static nudt.dcsm.grpc.VPotReply parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(nudt.dcsm.grpc.VPotReply prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code VPotReply}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:VPotReply)
      nudt.dcsm.grpc.VPotReplyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return nudt.dcsm.grpc.Register.internal_static_VPotReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return nudt.dcsm.grpc.Register.internal_static_VPotReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              nudt.dcsm.grpc.VPotReply.class, nudt.dcsm.grpc.VPotReply.Builder.class);
    }

    // Construct using nudt.dcsm.grpc.VPotReply.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      ack_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return nudt.dcsm.grpc.Register.internal_static_VPotReply_descriptor;
    }

    @java.lang.Override
    public nudt.dcsm.grpc.VPotReply getDefaultInstanceForType() {
      return nudt.dcsm.grpc.VPotReply.getDefaultInstance();
    }

    @java.lang.Override
    public nudt.dcsm.grpc.VPotReply build() {
      nudt.dcsm.grpc.VPotReply result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public nudt.dcsm.grpc.VPotReply buildPartial() {
      nudt.dcsm.grpc.VPotReply result = new nudt.dcsm.grpc.VPotReply(this);
      result.ack_ = ack_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof nudt.dcsm.grpc.VPotReply) {
        return mergeFrom((nudt.dcsm.grpc.VPotReply)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(nudt.dcsm.grpc.VPotReply other) {
      if (other == nudt.dcsm.grpc.VPotReply.getDefaultInstance()) return this;
      if (!other.getAck().isEmpty()) {
        ack_ = other.ack_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      nudt.dcsm.grpc.VPotReply parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (nudt.dcsm.grpc.VPotReply) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object ack_ = "";
    /**
     * <pre>
     * reply "OK" if success
     * </pre>
     *
     * <code>string ack = 1;</code>
     * @return The ack.
     */
    public java.lang.String getAck() {
      java.lang.Object ref = ack_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        ack_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * reply "OK" if success
     * </pre>
     *
     * <code>string ack = 1;</code>
     * @return The bytes for ack.
     */
    public com.google.protobuf.ByteString
        getAckBytes() {
      java.lang.Object ref = ack_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        ack_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * reply "OK" if success
     * </pre>
     *
     * <code>string ack = 1;</code>
     * @param value The ack to set.
     * @return This builder for chaining.
     */
    public Builder setAck(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      ack_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * reply "OK" if success
     * </pre>
     *
     * <code>string ack = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearAck() {
      
      ack_ = getDefaultInstance().getAck();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * reply "OK" if success
     * </pre>
     *
     * <code>string ack = 1;</code>
     * @param value The bytes for ack to set.
     * @return This builder for chaining.
     */
    public Builder setAckBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      ack_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:VPotReply)
  }

  // @@protoc_insertion_point(class_scope:VPotReply)
  private static final nudt.dcsm.grpc.VPotReply DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new nudt.dcsm.grpc.VPotReply();
  }

  public static nudt.dcsm.grpc.VPotReply getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<VPotReply>
      PARSER = new com.google.protobuf.AbstractParser<VPotReply>() {
    @java.lang.Override
    public VPotReply parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new VPotReply(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<VPotReply> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<VPotReply> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public nudt.dcsm.grpc.VPotReply getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
