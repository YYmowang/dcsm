// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Controllor.proto

package nudt.dcsm.grpc;

public interface CommandReplyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:CommandReply)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * reply "OK" if command runs successfully
   * or reply error message
   * </pre>
   *
   * <code>string result = 1;</code>
   * @return The result.
   */
  java.lang.String getResult();
  /**
   * <pre>
   * reply "OK" if command runs successfully
   * or reply error message
   * </pre>
   *
   * <code>string result = 1;</code>
   * @return The bytes for result.
   */
  com.google.protobuf.ByteString
      getResultBytes();
}