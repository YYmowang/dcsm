// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: saReg.proto

package nudt.dcsm.grpc;

public interface saReg2smReplyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:saReg2smReply)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string saID = 1;</code>
   * @return The saID.
   */
  java.lang.String getSaID();
  /**
   * <code>string saID = 1;</code>
   * @return The bytes for saID.
   */
  com.google.protobuf.ByteString
      getSaIDBytes();

  /**
   * <code>repeated .saReg2smReply.SaOutput SaOutputserver = 2;</code>
   */
  java.util.List<nudt.dcsm.grpc.saReg2smReply.SaOutput> 
      getSaOutputserverList();
  /**
   * <code>repeated .saReg2smReply.SaOutput SaOutputserver = 2;</code>
   */
  nudt.dcsm.grpc.saReg2smReply.SaOutput getSaOutputserver(int index);
  /**
   * <code>repeated .saReg2smReply.SaOutput SaOutputserver = 2;</code>
   */
  int getSaOutputserverCount();
  /**
   * <code>repeated .saReg2smReply.SaOutput SaOutputserver = 2;</code>
   */
  java.util.List<? extends nudt.dcsm.grpc.saReg2smReply.SaOutputOrBuilder> 
      getSaOutputserverOrBuilderList();
  /**
   * <code>repeated .saReg2smReply.SaOutput SaOutputserver = 2;</code>
   */
  nudt.dcsm.grpc.saReg2smReply.SaOutputOrBuilder getSaOutputserverOrBuilder(
      int index);

  /**
   * <code>repeated string on_service_name = 3;</code>
   * @return A list containing the onServiceName.
   */
  java.util.List<java.lang.String>
      getOnServiceNameList();
  /**
   * <code>repeated string on_service_name = 3;</code>
   * @return The count of onServiceName.
   */
  int getOnServiceNameCount();
  /**
   * <code>repeated string on_service_name = 3;</code>
   * @param index The index of the element to return.
   * @return The onServiceName at the given index.
   */
  java.lang.String getOnServiceName(int index);
  /**
   * <code>repeated string on_service_name = 3;</code>
   * @param index The index of the value to return.
   * @return The bytes of the onServiceName at the given index.
   */
  com.google.protobuf.ByteString
      getOnServiceNameBytes(int index);
}
