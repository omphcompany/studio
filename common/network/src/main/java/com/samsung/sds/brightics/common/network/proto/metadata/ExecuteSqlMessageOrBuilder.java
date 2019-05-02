/*
    Copyright 2019 Samsung SDS
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
        http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: metadata.proto

package com.samsung.sds.brightics.common.network.proto.metadata;

public interface ExecuteSqlMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.samsung.sds.brightics.common.network.proto.metadata.ExecuteSqlMessage)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string user = 1;</code>
   */
  java.lang.String getUser();
  /**
   * <code>string user = 1;</code>
   */
  com.google.protobuf.ByteString
      getUserBytes();

  /**
   * <code>repeated .com.samsung.sds.brightics.common.network.proto.metadata.AliasMessage alias = 2;</code>
   */
  java.util.List<com.samsung.sds.brightics.common.network.proto.metadata.AliasMessage> 
      getAliasList();
  /**
   * <code>repeated .com.samsung.sds.brightics.common.network.proto.metadata.AliasMessage alias = 2;</code>
   */
  com.samsung.sds.brightics.common.network.proto.metadata.AliasMessage getAlias(int index);
  /**
   * <code>repeated .com.samsung.sds.brightics.common.network.proto.metadata.AliasMessage alias = 2;</code>
   */
  int getAliasCount();
  /**
   * <code>repeated .com.samsung.sds.brightics.common.network.proto.metadata.AliasMessage alias = 2;</code>
   */
  java.util.List<? extends com.samsung.sds.brightics.common.network.proto.metadata.AliasMessageOrBuilder> 
      getAliasOrBuilderList();
  /**
   * <code>repeated .com.samsung.sds.brightics.common.network.proto.metadata.AliasMessage alias = 2;</code>
   */
  com.samsung.sds.brightics.common.network.proto.metadata.AliasMessageOrBuilder getAliasOrBuilder(
      int index);

  /**
   * <code>string limit = 3;</code>
   */
  java.lang.String getLimit();
  /**
   * <code>string limit = 3;</code>
   */
  com.google.protobuf.ByteString
      getLimitBytes();

  /**
   * <code>string sql = 4;</code>
   */
  java.lang.String getSql();
  /**
   * <code>string sql = 4;</code>
   */
  com.google.protobuf.ByteString
      getSqlBytes();
}
