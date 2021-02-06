// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Register.proto

package nudt.dcsm.grpc;

public interface AgentReplyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:AgentReply)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * assigned by SecManager
   * </pre>
   *
   * <code>string agentID = 1;</code>
   * @return The agentID.
   */
  java.lang.String getAgentID();
  /**
   * <pre>
   * assigned by SecManager
   * </pre>
   *
   * <code>string agentID = 1;</code>
   * @return The bytes for agentID.
   */
  com.google.protobuf.ByteString
      getAgentIDBytes();

  /**
   * <pre>
   * system resources (eg. ELK ) provided by SecManager
   * </pre>
   *
   * <code>int32 sysRes_num = 2;</code>
   * @return The sysResNum.
   */
  int getSysResNum();

  /**
   * <code>repeated .AgentReply.SysRes sysRes = 3;</code>
   */
  java.util.List<nudt.dcsm.grpc.AgentReply.SysRes> 
      getSysResList();
  /**
   * <code>repeated .AgentReply.SysRes sysRes = 3;</code>
   */
  nudt.dcsm.grpc.AgentReply.SysRes getSysRes(int index);
  /**
   * <code>repeated .AgentReply.SysRes sysRes = 3;</code>
   */
  int getSysResCount();
  /**
   * <code>repeated .AgentReply.SysRes sysRes = 3;</code>
   */
  java.util.List<? extends nudt.dcsm.grpc.AgentReply.SysResOrBuilder> 
      getSysResOrBuilderList();
  /**
   * <code>repeated .AgentReply.SysRes sysRes = 3;</code>
   */
  nudt.dcsm.grpc.AgentReply.SysResOrBuilder getSysResOrBuilder(
      int index);
}