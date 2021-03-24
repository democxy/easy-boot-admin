/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : springboot-api-demo

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2021-03-24 22:52:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '编号',
  `name` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `comments` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `class_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '实体类名称',
  `package_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `model_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `parent_table` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '关联父表',
  `parent_table_fk` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '关联父表外键',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `gen_table_name` (`name`) USING BTREE,
  KEY `gen_table_del_flag` (`del_flag`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='业务表';

-- ----------------------------
-- Records of gen_table
-- ----------------------------
INSERT INTO `gen_table` VALUES ('86D822A90E144837B722F79D22DDB7D4', 'sys_notice', '通知公告', 'Notice', 'com.democxy', 'sys', null, null, null, null, null, '2021-03-04 20:42:09', '系统通知', '0');

-- ----------------------------
-- Table structure for gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '编号',
  `gen_table_id` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '归属表编号',
  `name` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `comments` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `jdbc_type` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '列的数据类型的字节长度',
  `java_type` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(10) COLLATE utf8_bin DEFAULT NULL COMMENT '是否主键',
  `is_null` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '是否可为空',
  `is_insert` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '是否为插入字段',
  `is_edit` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '是否编辑字段',
  `is_list` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '是否列表字段',
  `is_query` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '是否查询字段',
  `query_type` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE）',
  `show_type` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '字段生成方案（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择）',
  `dict_type` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '字典类型',
  `settings` varchar(2000) COLLATE utf8_bin DEFAULT NULL COMMENT '其它设置（扩展字段JSON）',
  `sort` decimal(10,0) DEFAULT NULL COMMENT '排序（升序）',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `gen_table_column_table_id` (`gen_table_id`) USING BTREE,
  KEY `gen_table_column_name` (`name`) USING BTREE,
  KEY `gen_table_column_sort` (`sort`) USING BTREE,
  KEY `gen_table_column_del_flag` (`del_flag`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='业务表字段';

-- ----------------------------
-- Records of gen_table_column
-- ----------------------------
INSERT INTO `gen_table_column` VALUES ('01A94E9DD67C43DAAB4A866E489CB092', '4EE107A08DFF4A4AB05CC91AFE612E43', 'del_flag', '删除标记', 'char', 'String', 'delFlag', '0', '1', null, null, null, null, null, null, null, null, '130', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('045405B31FDA4DC5BE5BF240A9118CD3', '71E8F718AB7D4AE0A1D4EECC8C3EEC98', 'category', '分类', 'varchar', 'String', 'category', '0', '1', null, null, null, null, null, null, null, null, '30', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('06313719DC0F44B9BE7139DE283FDBE3', 'F70D15D1740C458A87D9453C42A4479D', 'href', '请求地址', 'varchar', 'String', 'href', '0', '1', null, null, null, null, null, null, null, null, '50', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('0665E626E5FB45528DCF7A2887DF830A', '86D822A90E144837B722F79D22DDB7D4', 'create_time', '发布时间', 'timestamp', 'java.util.Date', 'createTime', '0', '1', '1', '1', '1', '0', null, 'input', null, null, '50', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('0718B2A8500546F9AC2C51C84F1D9FD9', '28ED9210382A4DD0A0AC5D0D45B9F53F', 'title', '模块标题', 'varchar', 'String', 'title', '0', '1', null, null, null, null, null, null, null, null, '20', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('0B1115D34038450C8B6E8F987ADF8104', '28ED9210382A4DD0A0AC5D0D45B9F53F', 'operator_type', '操作类别（0其它 1后台用户 2手机端用户）', 'int', 'Integer', 'operatorType', '0', '1', null, null, null, null, null, null, null, null, '60', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('0BD7C4FCA2B841F8A323DF6E62E7D9EC', 'CF51B63AC1EF4ABC82500C7D260E7A3F', 'id', '', 'int', 'Integer', 'id', '1', '0', '1', '1', '1', '0', null, 'input', null, null, '10', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('0E4A7E84A73646E7B271B4C291EF873C', '71E8F718AB7D4AE0A1D4EECC8C3EEC98', 'create_by', '创建者', 'varchar', 'String', 'createBy', '0', '1', null, null, null, null, null, null, null, null, '70', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('103FB8355EF543FB93217E578F7A7D58', '3C280FEB7EBB40D1A9F428D29B89E2D8', 'package_name', '', 'varchar', 'String', 'packageName', '0', '1', null, null, null, null, null, null, null, null, '50', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('10839F98310E4346BA3AFB0EDB1BF87A', 'CFD4BFC787F64A489DB004EBCC7F64A0', 'file_size', '文件大小', 'double', 'Double', 'fileSize', '0', '1', '1', '1', '1', '1', null, 'input', null, null, '50', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('1437F301738246118C6BCB56A1C90A6D', '6C2A217E2EB1435698470053B94152F7', 'file_path', '文件路径', 'varchar', 'String', 'filePath', '0', '1', '1', '1', '1', '1', null, null, null, null, '20', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('14CF3DB045814B98A741EE5B18E8DA63', '28ED9210382A4DD0A0AC5D0D45B9F53F', 'oper_ip', '主机地址', 'varchar', 'String', 'operIp', '0', '1', null, null, null, null, null, null, null, null, '100', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('183CBD515F7D4675B3A84326FABDA882', '6C2A217E2EB1435698470053B94152F7', 'use_id', '用户ID', 'varchar', 'String', 'useId', '0', '1', '1', '1', '1', '1', null, null, null, null, '90', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('1D4141330C8D4403877961750068691B', '6C2A217E2EB1435698470053B94152F7', 'file_size', '文件大小', 'double', 'Double', 'fileSize', '0', '1', '1', '1', '1', '1', null, null, null, null, '50', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('1E99D0A8E097424CA2FE025D62E97C1A', '60E96A737ABD4B7AADBFBB0182879BA9', 'id', '主键ID', 'int', 'Integer', 'id', '1', '0', '1', '1', '1', '0', null, 'input', null, null, '10', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('1EA88FADA9C544648EA0B1BA11919543', '6C2A217E2EB1435698470053B94152F7', 'file_old_name', '原始名称', 'varchar', 'String', 'fileOldName', '0', '1', '1', '1', '1', '1', null, null, null, null, '40', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('1F560DBCD05840649BBFC061FD17F26A', '2C54D4645C624977836D1FBA56FB3C26', 'file_type', '文件类型', 'varchar', 'String', 'fileType', '0', '1', '1', '1', '1', '0', null, 'input', null, null, '70', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('21406F3EDAD04B09AFA9CEEAEA99C694', '4EE107A08DFF4A4AB05CC91AFE612E43', 'sort', '排序（升序）', 'decimal', 'BigDecimal', 'sort', '0', '0', null, null, null, null, null, null, null, null, '60', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('22E892374F0847B89609563B0B1CADF7', '3C8EF32B253A40B6AF021EB3F4683CD3', 'id', '主键ID', 'int', 'Integer', 'id', '1', '0', null, null, null, null, null, null, null, null, '10', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('2607C7AEE5B74ECB8D160249501EB6EF', 'B397D301B13340F1B732EE3174CCD9DE', 'task_status', '', 'char', 'String', 'taskStatus', '0', '1', null, null, null, null, null, null, null, null, '70', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('2692D20873374461BD425944B5EC62EE', 'C28232E9CE584EC88CE43D248B4766F2', 'id', '编号', 'varchar', 'String', 'id', '1', '0', null, null, null, null, null, null, null, null, '10', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('276B260590DD44CABD350662CCCD1EFE', 'C28232E9CE584EC88CE43D248B4766F2', 'is_insert', '是否为插入字段', 'char', 'String', 'isInsert', '0', '1', null, null, null, null, null, null, null, null, '100', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('27AF6A77235C40BFA9855C59C961598B', 'CF51B63AC1EF4ABC82500C7D260E7A3F', 'task_status', '', 'char', 'String', 'taskStatus', '0', '1', '1', '1', '1', '0', null, 'input', null, null, '70', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('29B9951AA66343C09D96376FDD57B7B0', '1916025BBB7A456EAE8E6D16041869D5', 'account_id', '', 'varchar', 'String', 'accountId', '1', '0', null, null, null, null, null, null, null, null, '10', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('29EE71C7715E4DD494C606E662AAD576', '28ED9210382A4DD0A0AC5D0D45B9F53F', 'status', '操作状态（0正常 1异常）', 'int', 'Integer', 'status', '0', '1', null, null, null, null, null, null, null, null, '140', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('2E0AE5561EBB46F7AB5F03D9A8434D41', 'B397D301B13340F1B732EE3174CCD9DE', 'method_name', '', 'varchar', 'String', 'methodName', '0', '1', null, null, null, null, null, null, null, null, '30', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('2E14FF5ED41940E2A499783A347200DC', 'B397D301B13340F1B732EE3174CCD9DE', 'id', '', 'int', 'Integer', 'id', '1', '0', null, null, null, null, null, null, null, null, '10', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('2E894AE499D044C9B45E4A65E3EF1D16', '4EE107A08DFF4A4AB05CC91AFE612E43', 'remarks', '备注信息', 'varchar', 'String', 'remarks', '0', '1', null, null, null, null, null, null, null, null, '120', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('305611FE8AD14751811FF9BA44A3F15D', '6C2A217E2EB1435698470053B94152F7', 'upload_time', '', 'timestamp', 'java.util.Date', 'uploadTime', '0', '0', '1', '1', '1', '1', null, null, null, null, '100', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('31547D6566844A36B035C841B7EFEAE3', '2C54D4645C624977836D1FBA56FB3C26', 'file_suffix', '文件后缀名', 'varchar', 'String', 'fileSuffix', '0', '1', '1', '1', '1', '0', null, 'input', null, null, '60', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('33EFBA78B8B4458196A94AF60EFDCE79', 'C28232E9CE584EC88CE43D248B4766F2', 'create_time', '创建时间', 'datetime', 'java.util.Date', 'createTime', '0', '1', null, null, null, null, null, null, null, null, '200', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('3427E3FC736E4F8F81CCD3BD5389AD4B', '3A7309CC5E734D479DFC7B4C2063BCFC', 'update_time', '更新时间', 'datetime', 'Date', 'updateTime', '0', '1', null, null, null, null, null, null, null, null, '100', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('35CA00376CA94795B42A7A0707ABE502', '3C280FEB7EBB40D1A9F428D29B89E2D8', 'update_by', '更新者', 'varchar', 'String', 'updateBy', '0', '1', null, null, null, null, null, null, null, null, '110', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('36E95767594D410692DD85B7FDB391A9', '6C2A217E2EB1435698470053B94152F7', 'id', '文件编号', 'varchar', 'String', 'id', '1', '1', '1', '1', '1', '1', null, null, null, null, '10', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('3AE83C9E070043BAB6B79AD62E6729B8', '60E96A737ABD4B7AADBFBB0182879BA9', 'data_scope', '数据范围', 'varchar', 'String', 'dataScope', '0', '1', '1', '1', '1', '0', null, 'input', null, null, '40', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('3DDA1B926EC247E5847EDFAC1E435BFB', 'CFD4BFC787F64A489DB004EBCC7F64A0', 'file_suffix', '文件后缀名', 'varchar', 'String', 'fileSuffix', '0', '1', '1', '1', '1', '1', null, 'input', null, null, '60', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('3DEE2A8EC5EE4CE38551243713CE33A7', 'CFD4BFC787F64A489DB004EBCC7F64A0', 'file_newname', '文件名称', 'varchar', 'String', 'fileNewname', '0', '1', '1', '1', '1', '1', null, 'input', null, null, '30', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('3ECF5197DD0143F7B34CAEE00C4499A5', '28ED9210382A4DD0A0AC5D0D45B9F53F', 'id', '日志主键', 'bigint', 'Long', 'id', '1', '0', null, null, null, null, null, null, null, null, '10', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('3FBA5C2EA37C46DB8B0FF597A7072CD5', 'C28232E9CE584EC88CE43D248B4766F2', 'del_flag', '删除标记（0：正常；1：删除）', 'char', 'String', 'delFlag', '0', '1', null, null, null, null, null, null, null, null, '240', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('406535794BCE43639548DBD742F14A62', 'C28232E9CE584EC88CE43D248B4766F2', 'is_list', '是否列表字段', 'char', 'String', 'isList', '0', '1', null, null, null, null, null, null, null, null, '120', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('40CD898476B343A98D032C0CCA7FB844', '3A7309CC5E734D479DFC7B4C2063BCFC', 'create_by', '创建者', 'varchar', 'String', 'createBy', '0', '1', null, null, null, null, null, null, null, null, '70', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('4186BB8531DF45E7BDE845FC00352248', 'C28232E9CE584EC88CE43D248B4766F2', 'settings', '其它设置（扩展字段JSON）', 'varchar', 'String', 'settings', '0', '1', null, null, null, null, null, null, null, null, '170', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('4200E19465754139B26C97F4D090FE13', 'C28232E9CE584EC88CE43D248B4766F2', 'create_by', '创建者', 'varchar', 'String', 'createBy', '0', '1', null, null, null, null, null, null, null, null, '190', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('438A11A385154B9EBA257535E6AD7218', 'F70D15D1740C458A87D9453C42A4479D', 'target', '打开方式（menuItem页签 menuBlank新窗口）', 'varchar', 'String', 'target', '0', '1', null, null, null, null, null, null, null, null, '60', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('4495409D3BB94711B19FE1B04F546128', '3A7309CC5E734D479DFC7B4C2063BCFC', 'id', '编号', 'varchar', 'String', 'id', '1', '0', null, null, null, null, null, null, null, null, '10', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('45821AC8FC5248F3A513D6494A19B40E', 'F70D15D1740C458A87D9453C42A4479D', 'create_by', '创建者', 'varchar', 'String', 'createBy', '0', '1', null, null, null, null, null, null, null, null, '110', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('483A0C7B8C4D4369B6FAED6CC627F946', 'F70D15D1740C458A87D9453C42A4479D', 'update_by', '更新者', 'varchar', 'String', 'updateBy', '0', '1', null, null, null, null, null, null, null, null, '130', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('487C2C9B7C674F96AE083DCEA8ED91D7', 'B397D301B13340F1B732EE3174CCD9DE', 'method_params', '', 'varchar', 'String', 'methodParams', '0', '1', null, null, null, null, null, null, null, null, '40', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('48DF0936FACE431FA799BE1425DB896C', 'F70D15D1740C458A87D9453C42A4479D', 'perms', '权限标识', 'varchar', 'String', 'perms', '0', '1', null, null, null, null, null, null, null, null, '90', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('4901B6118BAA4AB4B421ED8E7BF5A473', 'C28232E9CE584EC88CE43D248B4766F2', 'is_edit', '是否编辑字段', 'char', 'String', 'isEdit', '0', '1', null, null, null, null, null, null, null, null, '110', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('4C2FA5916D70448C84E7F31D3A99051C', '60E96A737ABD4B7AADBFBB0182879BA9', 'role_flag', '角色标识', 'varchar', 'String', 'roleFlag', '0', '1', '1', '1', '1', '0', null, 'input', null, null, '30', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('4F25C44A56B94396B726A6E8901E5D19', 'C28232E9CE584EC88CE43D248B4766F2', 'remark', '备注信息', 'varchar', 'String', 'remark', '0', '1', null, null, null, null, null, null, null, null, '230', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('4F371C5756ED4D6DA5094E212CF9B521', '4EE107A08DFF4A4AB05CC91AFE612E43', 'parent_id', '父级编号', 'varchar', 'String', 'parentId', '0', '1', null, null, null, null, null, null, null, null, '70', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('51D2F9A9CD184EB3AB1957AF04C7746F', 'C28232E9CE584EC88CE43D248B4766F2', 'comments', '描述', 'varchar', 'String', 'comments', '0', '1', null, null, null, null, null, null, null, null, '40', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('53787EF437DC4452BB6C45300C4B27C3', '28ED9210382A4DD0A0AC5D0D45B9F53F', 'oper_param', '请求参数', 'varchar', 'String', 'operParam', '0', '1', null, null, null, null, null, null, null, null, '120', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('557A3769EF6C4A54841A9188913C0248', 'F70D15D1740C458A87D9453C42A4479D', 'visible', '菜单状态（0显示 1隐藏）', 'char', 'String', 'visible', '0', '1', null, null, null, null, null, null, null, null, '80', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('55F970A3E08C42FFA82F33A71AAA121B', '28ED9210382A4DD0A0AC5D0D45B9F53F', 'json_result', '返回参数', 'varchar', 'String', 'jsonResult', '0', '1', null, null, null, null, null, null, null, null, '130', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('5716261C22E4484082103C82020D874D', '3C8EF32B253A40B6AF021EB3F4683CD3', 'role_flag', '角色标识', 'varchar', 'String', 'roleFlag', '0', '1', null, null, null, null, null, null, null, null, '30', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('5936599B174A456DAADFF15558C15E02', '3C280FEB7EBB40D1A9F428D29B89E2D8', 'create_time', '创建时间', 'datetime', 'java.util.Date', 'createTime', '0', '1', null, null, null, null, null, null, null, null, '100', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('5979A4E64E644EA5BFCBBD39580B2CE1', 'CFD4BFC787F64A489DB004EBCC7F64A0', 'id', '文件编号', 'varchar', 'String', 'id', '1', '0', '1', '1', '1', '1', null, 'input', null, null, '10', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('5A4F6E14B4574B0D84B925C938670257', 'F70D15D1740C458A87D9453C42A4479D', 'icon', '菜单图标', 'varchar', 'String', 'icon', '0', '1', null, null, null, null, null, null, null, null, '100', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('5B8B711646294A2B8BF10E92D4316447', '2C54D4645C624977836D1FBA56FB3C26', 'id', '文件编号', 'varchar', 'String', 'id', '1', '0', '1', '1', '1', '0', '', 'input', null, null, '10', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('5D9F131A939E46DF80224588132B751E', '3C280FEB7EBB40D1A9F428D29B89E2D8', 'parent_table_fk', '关联父表外键', 'varchar', 'String', 'parentTableFk', '0', '1', null, null, null, null, null, null, null, null, '80', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('5E21777699864AD984802C624B337E92', '3C280FEB7EBB40D1A9F428D29B89E2D8', 'name', '名称', 'varchar', 'String', 'name', '0', '1', null, null, null, null, null, null, null, null, '20', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('5F46D9A6445B4B17B0412F316B04B438', '3C8EF32B253A40B6AF021EB3F4683CD3', 'data_scope', '数据范围', 'varchar', 'String', 'dataScope', '0', '1', null, null, null, null, null, null, null, null, '40', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('63E4D835D6B948F8B160954FFE998111', 'CFD4BFC787F64A489DB004EBCC7F64A0', 'file_path', '文件路径', 'varchar', 'String', 'filePath', '0', '1', '1', '1', '1', '1', null, 'input', null, null, '20', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('64955A2876174CE2B0E8DD8D15CF5599', '4EE107A08DFF4A4AB05CC91AFE612E43', 'update_by', '更新者', 'varchar', 'String', 'updateBy', '0', '1', null, null, null, null, null, null, null, null, '100', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('65FC52C33CC54585A1BD9F15405B8B33', '3A7309CC5E734D479DFC7B4C2063BCFC', 'category', '分类', 'varchar', 'String', 'category', '0', '1', null, null, null, null, null, null, null, null, '30', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('69A38999552F403BB38C12FB94F2550B', '86D822A90E144837B722F79D22DDB7D4', 'create_by', '发布人', 'varchar', 'String', 'createBy', '0', '1', '1', '1', '1', '0', null, 'input', null, null, '60', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('6BFE3C31323B4AB0B9ABD843AB1ED8D5', '2C54D4645C624977836D1FBA56FB3C26', 'use_id', '用户ID', 'varchar', 'String', 'useId', '0', '1', '1', '1', '1', '0', null, 'input', null, null, '90', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('6C4073E4B593444C90753BC8C5421285', 'B397D301B13340F1B732EE3174CCD9DE', 'task_name', '', 'varchar', 'String', 'taskName', '0', '1', null, null, null, null, null, null, null, null, '20', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('6C4EDA09CF5742F497618059CFEB844F', '28ED9210382A4DD0A0AC5D0D45B9F53F', 'request_method', '请求方式', 'varchar', 'String', 'requestMethod', '0', '1', null, null, null, null, null, null, null, null, '50', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('6C7D4F42E89349B8BFB0BFCEBA3D1BB6', '3C8EF32B253A40B6AF021EB3F4683CD3', 'role_name', '角色名', 'varchar', 'String', 'roleName', '0', '0', null, null, null, null, null, null, null, null, '20', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('6FB5D7981C824AD98132515D76F6EF32', 'CF51B63AC1EF4ABC82500C7D260E7A3F', 'task_name', '', 'varchar', 'String', 'taskName', '0', '1', '1', '1', '1', '0', null, 'input', null, null, '20', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('721978BA44264BCB95F525D075C02E32', 'B397D301B13340F1B732EE3174CCD9DE', 'create_time', '', 'timestamp', 'java.util.Date', 'createTime', '0', '1', null, null, null, null, null, null, null, null, '80', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('72873ED70D564B4589E2EB6AAF5EAF08', '3C280FEB7EBB40D1A9F428D29B89E2D8', 'model_name', '', 'varchar', 'String', 'modelName', '0', '1', null, null, null, null, null, null, null, null, '60', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('72D8FE5A274C45308385758C3E76D06A', '2C54D4645C624977836D1FBA56FB3C26', 'file_old_name', '', 'varchar', 'String', 'fileOldName', '0', '1', '1', '1', '1', '0', null, 'input', null, null, '40', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('731B434959C64A98948BF8390FDF6E9F', 'F70D15D1740C458A87D9453C42A4479D', 'order_num', '显示顺序', 'int', 'Integer', 'orderNum', '0', '1', null, null, null, null, null, null, null, null, '40', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('74765FB9581C4330B08B13378F1F110F', '3A7309CC5E734D479DFC7B4C2063BCFC', 'remark', '备注信息', 'varchar', 'String', 'remark', '0', '1', null, null, null, null, null, null, null, null, '110', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('74D649BF0A04449E93F37BAB6AD2D711', '3A7309CC5E734D479DFC7B4C2063BCFC', 'name', '名称', 'varchar', 'String', 'name', '0', '1', null, null, null, null, null, null, null, null, '20', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('76C613EF56F145B2B43A00A9AF59A978', '4EE107A08DFF4A4AB05CC91AFE612E43', 'id', '编号', 'bigint', 'Long', 'id', '1', '0', null, null, null, null, null, null, null, null, '10', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('79AF76BCBEF2445F993A499BD88675E2', '3C280FEB7EBB40D1A9F428D29B89E2D8', 'parent_table', '关联父表', 'varchar', 'String', 'parentTable', '0', '1', null, null, null, null, null, null, null, null, '70', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('7A2192A8CA2D48D7BA05292E3BEC7C2F', '28ED9210382A4DD0A0AC5D0D45B9F53F', 'oper_time', '操作时间', 'datetime', 'java.util.Date', 'operTime', '0', '1', null, null, null, null, null, null, null, null, '160', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('7B92B84A9ACC41DDB45A5F9F36679A91', '2C54D4645C624977836D1FBA56FB3C26', 'upload_time', '', 'timestamp', 'java.util.Date', 'uploadTime', '0', '0', '1', '1', '1', '0', null, 'input', null, null, '100', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('7C78FC7F11464B889BE86B9B34F4DEDA', 'C28232E9CE584EC88CE43D248B4766F2', 'show_type', '字段生成方案（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择）', 'varchar', 'String', 'showType', '0', '1', null, null, null, null, null, null, null, null, '150', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('7D8FE7E6B3F441D1A5AF94B4303979BD', '28ED9210382A4DD0A0AC5D0D45B9F53F', 'method', '方法名称', 'varchar', 'String', 'method', '0', '1', null, null, null, null, null, null, null, null, '40', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('8106CBA63BF34403A00B7F176D645DBC', 'F70D15D1740C458A87D9453C42A4479D', 'create_time', '创建时间', 'datetime', 'java.util.Date', 'createTime', '0', '1', null, null, null, null, null, null, null, null, '120', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('81BB7177029E46109A452EE2F72DE6EC', 'F70D15D1740C458A87D9453C42A4479D', 'id', '菜单ID', 'bigint', 'Long', 'id', '1', '0', null, null, null, null, null, null, null, null, '10', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('829A30A615304DCF9E932BB83FB5D142', '71E8F718AB7D4AE0A1D4EECC8C3EEC98', 'file_name', '生成文件名', 'varchar', 'String', 'fileName', '0', '1', null, null, null, null, null, null, null, null, '50', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('8371871934384063AE18C7845BAF6EAC', 'F70D15D1740C458A87D9453C42A4479D', 'menu_name', '菜单名称', 'varchar', 'String', 'menuName', '0', '0', null, null, null, null, null, null, null, null, '20', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('84EDF0905A7D431981C208F3D19663B4', 'CF51B63AC1EF4ABC82500C7D260E7A3F', 'method_name', '', 'varchar', 'String', 'methodName', '0', '1', '1', '1', '1', '0', null, 'input', null, null, '30', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('855620AD97F64B47ABDB66F0C431B0B0', '71E8F718AB7D4AE0A1D4EECC8C3EEC98', 'create_time', '创建时间', 'datetime', 'java.util.Date', 'createTime', '0', '1', null, null, null, null, null, null, null, null, '80', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('85DE06215B754E518AF893C0AFA05E97', '71E8F718AB7D4AE0A1D4EECC8C3EEC98', 'del_flag', '删除标记（0：正常；1：删除）', 'char', 'String', 'delFlag', '0', '1', null, null, null, null, null, null, null, null, '120', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('87B508A8E7F741699864EB23F3C125AD', '6C2A217E2EB1435698470053B94152F7', 'file_type', '文件类型', 'varchar', 'String', 'fileType', '0', '1', '1', '1', '1', '1', null, null, null, null, '70', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('8C9D127CB9C64D55B140DCB1C235E47A', '3A7309CC5E734D479DFC7B4C2063BCFC', 'file_path', '生成文件路径', 'varchar', 'String', 'filePath', '0', '1', null, null, null, null, null, null, null, null, '40', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('8FDB6B7605C4499C93CBB793C47750B4', '4EE107A08DFF4A4AB05CC91AFE612E43', 'value', '数据值', 'varchar', 'String', 'value', '0', '0', null, null, null, null, null, null, null, null, '20', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('930C40184EB64CF2924BF7B42B129991', '3A7309CC5E734D479DFC7B4C2063BCFC', 'del_flag', '删除标记（0：正常；1：删除）', 'char', 'String', 'delFlag', '0', '1', null, null, null, null, null, null, null, null, '120', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('942196343D01423CBF13B6848AD90E03', 'CF51B63AC1EF4ABC82500C7D260E7A3F', 'method_params', '', 'varchar', 'String', 'methodParams', '0', '1', '1', '1', '1', '0', null, 'input', null, null, '40', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('94955A17A1B74A9DA1F06694ACCA4BA0', '3C280FEB7EBB40D1A9F428D29B89E2D8', 'create_by', '创建者', 'varchar', 'String', 'createBy', '0', '1', null, null, null, null, null, null, null, null, '90', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('95C9975B551A445080D6BD8D693FD941', 'CFD4BFC787F64A489DB004EBCC7F64A0', 'remark', '备注', 'text', 'String', 'remark', '0', '1', '1', '1', '1', '1', null, 'input', null, null, '80', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('96F502ADE853458B91BD9E3442D05D83', '71E8F718AB7D4AE0A1D4EECC8C3EEC98', 'content', '内容', 'text', 'String', 'content', '0', '1', null, null, null, null, null, null, null, null, '60', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('96FBF3F4AE33450ABA46A741AFF9E4CD', '6C2A217E2EB1435698470053B94152F7', 'file_suffix', '文件后缀名', 'varchar', 'String', 'fileSuffix', '0', '1', '1', '1', '1', '1', null, null, null, null, '60', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('9831532CC5EE49AFA3465B099E130F97', '60E96A737ABD4B7AADBFBB0182879BA9', 'role_name', '角色名', 'varchar', 'String', 'roleName', '0', '0', '1', '1', '1', '0', null, 'input', null, null, '20', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('9C43426540D94479B3DF936B6A2BF503', '2C54D4645C624977836D1FBA56FB3C26', 'file_newname', '文件名称', 'varchar', 'String', 'fileNewname', '0', '1', '1', '1', '1', '0', '=', 'input', null, null, '30', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('9DE78EA57A3D42FBA3EFB5B2DB3812A0', '3C280FEB7EBB40D1A9F428D29B89E2D8', 'update_time', '更新时间', 'datetime', 'java.util.Date', 'updateTime', '0', '1', null, null, null, null, null, null, null, null, '120', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('9ED685FC291A480C957F528780A35D7B', '3C8EF32B253A40B6AF021EB3F4683CD3', 'status', '角色状态', 'varchar', 'String', 'status', '0', '1', null, null, null, null, null, null, null, null, '50', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('A09653265A744990B2AC7E71481830C2', '3C280FEB7EBB40D1A9F428D29B89E2D8', 'del_flag', '删除标记（0：正常；1：删除）', 'char', 'String', 'delFlag', '0', '1', null, null, null, null, null, null, null, null, '140', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('A16AADE7ACEB4ACBBEDE1DC123AAB501', 'C28232E9CE584EC88CE43D248B4766F2', 'update_by', '更新者', 'varchar', 'String', 'updateBy', '0', '1', null, null, null, null, null, null, null, null, '210', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('A3FABF91191044928549E0622F83DD76', '3A7309CC5E734D479DFC7B4C2063BCFC', 'content', '内容', 'text', 'String', 'content', '0', '1', null, null, null, null, null, null, null, null, '60', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('A470858703444A32ABB7C61A5091793E', '2C54D4645C624977836D1FBA56FB3C26', 'remark', '备注', 'text', 'String', 'remark', '0', '1', '1', '1', '1', '0', null, 'input', null, null, '80', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('A470B72CD9BA4AE3A6D2653F2DEAB61F', '4EE107A08DFF4A4AB05CC91AFE612E43', 'create_date', '创建时间', 'datetime', 'java.util.Date', 'createDate', '0', '1', null, null, null, null, null, null, null, null, '90', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('A58C3F78983048C0BA6E76966A9918F0', 'C28232E9CE584EC88CE43D248B4766F2', 'sort', '排序（升序）', 'decimal', 'BigDecimal', 'sort', '0', '1', null, null, null, null, null, null, null, null, '180', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('AA6AEE83E6A348E5B24BFC9DF9F97A69', 'CFD4BFC787F64A489DB004EBCC7F64A0', 'file_type', '文件类型', 'varchar', 'String', 'fileType', '0', '1', '1', '1', '1', '1', null, 'input', null, null, '70', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('AA87B501BDF544939DA8A601E3E54B30', '4EE107A08DFF4A4AB05CC91AFE612E43', 'description', '描述', 'varchar', 'String', 'description', '0', '0', null, null, null, null, null, null, null, null, '50', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('AAC266D660714C73843188525B4FEC0C', 'B397D301B13340F1B732EE3174CCD9DE', 'remark', '', 'varchar', 'String', 'remark', '0', '1', null, null, null, null, null, null, null, null, '60', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('AD46E8B54DF14082A48AC0108294937A', 'C28232E9CE584EC88CE43D248B4766F2', 'name', '名称', 'varchar', 'String', 'name', '0', '1', null, null, null, null, null, null, null, null, '30', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('B1187AC2589641F6B4D738B2B566B681', '86D822A90E144837B722F79D22DDB7D4', 'title', '标题', 'varchar', 'String', 'title', '0', '1', '1', '1', '1', '1', 'like', 'input', null, null, '20', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('B71561C6F207407B87D7DDBF568ECD50', '86D822A90E144837B722F79D22DDB7D4', 'content', '内容', 'longtext', 'String', 'content', '0', '1', '1', '1', '1', '0', null, 'input', null, null, '40', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('B9B85F6175C047F59C30D51C0A465AE7', '86D822A90E144837B722F79D22DDB7D4', 'type', '类型', 'varchar', 'String', 'type', '0', '1', '1', '1', '1', '1', '=', 'input', null, null, '30', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('BB862A8AD3324689A7C3D1F3656CB4EE', '71E8F718AB7D4AE0A1D4EECC8C3EEC98', 'remark', '备注信息', 'varchar', 'String', 'remark', '0', '1', null, null, null, null, null, null, null, null, '110', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('BC95AA5329144021AB3D79D2B3020B63', '3C280FEB7EBB40D1A9F428D29B89E2D8', 'comments', '描述', 'varchar', 'String', 'comments', '0', '1', null, null, null, null, null, null, null, null, '30', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('BCEE694309DE472EA5B73AED401BA296', '6C2A217E2EB1435698470053B94152F7', 'file_newname', '文件名称', 'varchar', 'String', 'fileNewname', '0', '1', '1', '1', '1', '1', null, null, null, null, '30', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('BD680EB67505452F9B1C77D14309D28D', '4EE107A08DFF4A4AB05CC91AFE612E43', 'type', '类型', 'varchar', 'String', 'type', '0', '0', null, null, null, null, null, null, null, null, '40', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('C41B95E967944C88A7B0D6CB0AEEDBA8', 'CF51B63AC1EF4ABC82500C7D260E7A3F', 'remark', '', 'varchar', 'String', 'remark', '0', '1', '1', '1', '1', '0', null, 'input', null, null, '60', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('C49C4FFC97C14C66A91DF55FF7D2C9A4', '3A7309CC5E734D479DFC7B4C2063BCFC', 'file_name', '生成文件名', 'varchar', 'String', 'fileName', '0', '1', null, null, null, null, null, null, null, null, '50', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('C818436B3496491B8101AB2878400ED4', 'CFD4BFC787F64A489DB004EBCC7F64A0', 'use_id', '用户ID', 'varchar', 'String', 'useId', '0', '1', '1', '1', '1', '1', null, 'input', null, null, '90', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('C975868381E94741BCEA1F7FE80125F5', '86D822A90E144837B722F79D22DDB7D4', 'id', 'ID', 'int', 'Integer', 'id', '1', '0', '1', '0', '0', '0', null, 'input', null, null, '10', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('CAD622FFE34247DA81C8777331EAAE8D', 'B397D301B13340F1B732EE3174CCD9DE', 'cron_type', '', 'varchar', 'String', 'cronType', '0', '1', null, null, null, null, null, null, null, null, '50', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('CE27E9C985DE4A868E88131FF88FF39F', '71E8F718AB7D4AE0A1D4EECC8C3EEC98', 'name', '名称', 'varchar', 'String', 'name', '0', '1', null, null, null, null, null, null, null, null, '20', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('CE86A51F3636446A944F00C7D76CE39F', '71E8F718AB7D4AE0A1D4EECC8C3EEC98', 'update_by', '更新者', 'varchar', 'String', 'updateBy', '0', '1', null, null, null, null, null, null, null, null, '90', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('D03DAD652C2F40F0B3ADB1B5282CEA05', '28ED9210382A4DD0A0AC5D0D45B9F53F', 'oper_location', '操作地点', 'varchar', 'String', 'operLocation', '0', '1', null, null, null, null, null, null, null, null, '110', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('D13211360B704CD9A3F8AA8F8F2C25F5', '1916025BBB7A456EAE8E6D16041869D5', 'role', '', 'varchar', 'String', 'role', '0', '1', null, null, null, null, null, null, null, null, '40', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('D238ED687BE54F65A2544A676F2BDB3D', 'C28232E9CE584EC88CE43D248B4766F2', 'java_field', 'JAVA字段名', 'varchar', 'String', 'javaField', '0', '1', null, null, null, null, null, null, null, null, '70', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('D2ED05B969E84568B4ABC9304F301E00', 'C28232E9CE584EC88CE43D248B4766F2', 'is_null', '是否可为空', 'char', 'String', 'isNull', '0', '1', null, null, null, null, null, null, null, null, '90', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('D325C44EA04E4E76AE35FAAE7873239D', '4EE107A08DFF4A4AB05CC91AFE612E43', 'create_by', '创建者', 'varchar', 'String', 'createBy', '0', '1', null, null, null, null, null, null, null, null, '80', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('D3692E55FDB343DFAAEE3F7AF3C68422', 'CFD4BFC787F64A489DB004EBCC7F64A0', 'file_old_name', '', 'varchar', 'String', 'fileOldName', '0', '1', '1', '1', '1', '1', null, 'input', null, null, '40', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('D393FFB1C25645099B2B729E13539278', 'C28232E9CE584EC88CE43D248B4766F2', 'dict_type', '字典类型', 'varchar', 'String', 'dictType', '0', '1', null, null, null, null, null, null, null, null, '160', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('D50B5C414DA8431B9A1E0376A7D09701', '4EE107A08DFF4A4AB05CC91AFE612E43', 'label', '标签名', 'varchar', 'String', 'label', '0', '0', null, null, null, null, null, null, null, null, '30', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('D5F9E313E1B04775A0769E2058C3DDA8', 'C28232E9CE584EC88CE43D248B4766F2', 'is_pk', '是否主键', 'char', 'String', 'isPk', '0', '1', null, null, null, null, null, null, null, null, '80', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('D64F45A26FDC4F658F3129A14B81D398', 'C28232E9CE584EC88CE43D248B4766F2', 'jdbc_type', '列的数据类型的字节长度', 'varchar', 'String', 'jdbcType', '0', '1', null, null, null, null, null, null, null, null, '50', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('D6AE9981BD5D420784001A2796B07C79', '71E8F718AB7D4AE0A1D4EECC8C3EEC98', 'update_time', '更新时间', 'datetime', 'java.util.Date', 'updateTime', '0', '1', null, null, null, null, null, null, null, null, '100', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('D88E1A24F2E74BF18F38518AD055D2A3', 'C28232E9CE584EC88CE43D248B4766F2', 'query_type', '查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE）', 'varchar', 'String', 'queryType', '0', '1', null, null, null, null, null, null, null, null, '140', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('D8FFB06A81454F8EBD842945BB9D6AF3', 'F70D15D1740C458A87D9453C42A4479D', 'remark', '备注', 'varchar', 'String', 'remark', '0', '1', null, null, null, null, null, null, null, null, '150', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('DA48EBA038144CBFA34428CE6C039601', '3C280FEB7EBB40D1A9F428D29B89E2D8', 'remark', '备注信息', 'varchar', 'String', 'remark', '0', '1', null, null, null, null, null, null, null, null, '130', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('DBA04D3FD924446B9D89EA8225B28493', 'F70D15D1740C458A87D9453C42A4479D', 'parent_id', '父菜单ID', 'bigint', 'Long', 'parentId', '0', '1', null, null, null, null, null, null, null, null, '30', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('DDAE3EF0E7F54AA38EE952C9FEF8D2AA', '3C280FEB7EBB40D1A9F428D29B89E2D8', 'class_name', '实体类名称', 'varchar', 'String', 'className', '0', '1', null, null, null, null, null, null, null, null, '40', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('DDEE86A882F84464B4EEB4E1FB0BA956', 'C28232E9CE584EC88CE43D248B4766F2', 'java_type', 'JAVA类型', 'varchar', 'String', 'javaType', '0', '1', null, null, null, null, null, null, null, null, '60', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('DF411D49B5094F65B4D2DDB0F6595747', '1B7E2C5F80554130B611D81CE93EE4E0', 'menu_id', '', 'varchar', 'String', 'menuId', '0', '0', null, null, null, null, null, null, null, null, '10', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('DF957C01A7FA41CB864D0BCF39BE2F56', '1916025BBB7A456EAE8E6D16041869D5', 'account_no', '', 'varchar', 'String', 'accountNo', '0', '0', null, null, null, null, null, null, null, null, '20', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('E1509A0D4CAC418D8356D3F852526C30', '28ED9210382A4DD0A0AC5D0D45B9F53F', 'oper_name', '操作人员', 'varchar', 'String', 'operName', '0', '1', null, null, null, null, null, null, null, null, '70', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('E1ACE8D06F494F35B8AB767D96B12D7C', '71E8F718AB7D4AE0A1D4EECC8C3EEC98', 'id', '编号', 'varchar', 'String', 'id', '1', '0', null, null, null, null, null, null, null, null, '10', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('E2D4B1BCCE4D408694FA3CF2B53299BC', 'CF51B63AC1EF4ABC82500C7D260E7A3F', 'cron_type', '', 'varchar', 'String', 'cronType', '0', '1', '1', '1', '1', '0', null, 'input', null, null, '50', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('E3DC3716F2DD44E697BB37BD86ADB806', '1916025BBB7A456EAE8E6D16041869D5', 'password', '', 'varchar', 'String', 'password', '0', '1', null, null, null, null, null, null, null, null, '30', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('E4EB96D3A6A94D958852E3171481D676', '28ED9210382A4DD0A0AC5D0D45B9F53F', 'error_msg', '错误消息', 'varchar', 'String', 'errorMsg', '0', '1', null, null, null, null, null, null, null, null, '150', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('E67FE1AF87D7489DBE5894218C8F6CF7', '2C54D4645C624977836D1FBA56FB3C26', 'file_path', '文件路径', 'varchar', 'String', 'filePath', '0', '1', '1', '1', '1', '0', null, 'input', null, null, '20', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('E87EE43C8E8D45D7B67FE622F92189D3', 'F70D15D1740C458A87D9453C42A4479D', 'menu_type', '菜单类型（M目录 C菜单 F按钮）', 'char', 'String', 'menuType', '0', '1', null, null, null, null, null, null, null, null, '70', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('EB882288422E427CBF758A24E212CDD9', '3C280FEB7EBB40D1A9F428D29B89E2D8', 'id', '编号', 'varchar', 'String', 'id', '1', '0', null, null, null, null, null, null, null, null, '10', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('EC07BD90ED2746179A21D7A5AEDA8FA8', '3A7309CC5E734D479DFC7B4C2063BCFC', 'update_by', '更新者', 'varchar', 'String', 'updateBy', '0', '1', null, null, null, null, null, null, null, null, '90', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('ED07E1875AA94E76B252A453DDBAE37A', '4EE107A08DFF4A4AB05CC91AFE612E43', 'update_date', '更新时间', 'datetime', 'java.util.Date', 'updateDate', '0', '1', null, null, null, null, null, null, null, null, '110', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('EFD26CF362DD46678AC1DD0AAFB1998E', '28ED9210382A4DD0A0AC5D0D45B9F53F', 'oper_url', '请求URL', 'varchar', 'String', 'operUrl', '0', '1', null, null, null, null, null, null, null, null, '90', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('F00DB6A5DD7A4235B020D0C79713ABDF', '3A7309CC5E734D479DFC7B4C2063BCFC', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '1', null, null, null, null, null, null, null, null, '80', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('F20C1B7C58154EF8AE57011010930FB5', '1B7E2C5F80554130B611D81CE93EE4E0', 'role_id', '', 'varchar', 'String', 'roleId', '0', '0', null, null, null, null, null, null, null, null, '20', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('F5C6790839EA4845AE68612D2E6BBA93', 'F70D15D1740C458A87D9453C42A4479D', 'update_time', '更新时间', 'datetime', 'java.util.Date', 'updateTime', '0', '1', null, null, null, null, null, null, null, null, '140', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('F720F93C06F7493387205A26D8C8E1E5', 'CFD4BFC787F64A489DB004EBCC7F64A0', 'upload_time', '', 'timestamp', 'java.util.Date', 'uploadTime', '0', '0', '1', '1', '1', '1', null, 'input', null, null, '100', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('F72F43F31A404F3698126D3309409ECD', '60E96A737ABD4B7AADBFBB0182879BA9', 'status', '角色状态', 'varchar', 'String', 'status', '0', '1', '1', '1', '1', '0', null, 'input', null, null, '50', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('F7879E62C9454E21B48D0A3303920893', '71E8F718AB7D4AE0A1D4EECC8C3EEC98', 'file_path', '生成文件路径', 'varchar', 'String', 'filePath', '0', '1', null, null, null, null, null, null, null, null, '40', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('F8036AEDE6E7491F80ED8D0BD9E7BBAC', '28ED9210382A4DD0A0AC5D0D45B9F53F', 'dept_name', '部门名称', 'varchar', 'String', 'deptName', '0', '1', null, null, null, null, null, null, null, null, '80', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('FA8A3C442FEB4253A6C549CA8475754E', '6C2A217E2EB1435698470053B94152F7', 'remark', '备注', 'text', 'String', 'remark', '0', '1', '1', '1', '1', '1', null, null, null, null, '80', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('FAE89C2B5C144221BD756A6B468ED3F1', 'C28232E9CE584EC88CE43D248B4766F2', 'is_query', '是否查询字段', 'char', 'String', 'isQuery', '0', '1', null, null, null, null, null, null, null, null, '130', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('FB4819DFF1834DE0B917A0052FC71E31', 'C28232E9CE584EC88CE43D248B4766F2', 'update_time', '更新时间', 'datetime', 'java.util.Date', 'updateTime', '0', '1', null, null, null, null, null, null, null, null, '220', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('FC325A4F24D34CF284B204871E0A3878', 'CF51B63AC1EF4ABC82500C7D260E7A3F', 'create_time', '', 'timestamp', 'java.util.Date', 'createTime', '0', '1', '1', '1', '1', '0', null, 'input', null, null, '80', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('FE7148C81F634512AC5262AE611EE387', 'C28232E9CE584EC88CE43D248B4766F2', 'gen_table_id', '归属表编号', 'varchar', 'String', 'genTableId', '0', '1', null, null, null, null, null, null, null, null, '20', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('FE933E63021744EA9BD1B2DAB72CD348', '2C54D4645C624977836D1FBA56FB3C26', 'file_size', '文件大小', 'double', 'Double', 'fileSize', '0', '1', '1', '1', '1', '0', null, 'input', null, null, '50', null, null, null, null, null, '0');
INSERT INTO `gen_table_column` VALUES ('FEA4D33EF0774FF2993AB43D0FBBFAE9', '28ED9210382A4DD0A0AC5D0D45B9F53F', 'business_type', '业务类型（0其它 1新增 2修改 3删除）', 'int', 'Integer', 'businessType', '0', '1', null, null, null, null, null, null, null, null, '30', null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for sys_account
-- ----------------------------
DROP TABLE IF EXISTS `sys_account`;
CREATE TABLE `sys_account` (
  `account_id` varchar(40) NOT NULL,
  `account_no` varchar(30) NOT NULL,
  `password` varchar(40) DEFAULT NULL,
  `role` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `account_no` (`account_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_account
-- ----------------------------
INSERT INTO `sys_account` VALUES ('8B28F4D285EF4ADEB16C4F3113CEA118', 'admin', 'a66abb5684c45962d887564f08346e8d', '14');
INSERT INTO `sys_account` VALUES ('B994F1EC4B924B01BECE75C6B4C96767', 'democxy', '9bd3ab33be3be4c14d142797d24a9c1a', '14');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `value` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '数据值',
  `label` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '标签名',
  `type` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '类型',
  `description` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '描述',
  `sort` decimal(10,0) NOT NULL COMMENT '排序（升序）',
  `parent_id` varchar(64) COLLATE utf8_bin DEFAULT '0' COMMENT '父级编号',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `sys_dict_value` (`value`) USING BTREE,
  KEY `sys_dict_label` (`label`) USING BTREE,
  KEY `sys_dict_del_flag` (`del_flag`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('5', 'Y', '是', 'yes_no', '是/否', '10', '0', '1', '2013-05-27 08:00:00', '1', '2021-03-14 00:11:06', null, '0');
INSERT INTO `sys_dict` VALUES ('6', 'N', '否', 'yes_no', '是/否', '20', '0', '1', '2013-05-27 08:00:00', '1', '2021-03-14 00:11:06', null, '0');
INSERT INTO `sys_dict` VALUES ('93', 'String', 'String', 'gen_java_type', 'Java类型', '10', '0', '1', '2013-10-28 08:00:00', '1', '2021-03-01 23:52:12', null, '1');
INSERT INTO `sys_dict` VALUES ('94', 'Long', 'Long', 'gen_java_type', 'Java类型', '20', '0', '1', '2013-10-28 08:00:00', '1', '2021-03-01 23:52:12', null, '1');
INSERT INTO `sys_dict` VALUES ('96', '1', '男', 'sex', '性别', '10', '0', '1', '2013-10-28 08:00:00', '1', '2021-01-12 22:03:51', null, '0');
INSERT INTO `sys_dict` VALUES ('97', '2', '女', 'sex', '性别', '20', '0', '1', '2013-10-28 08:00:00', '1', '2021-01-12 22:03:51', null, '0');
INSERT INTO `sys_dict` VALUES ('98', 'Integer', 'Integer', 'gen_java_type', 'Java类型', '30', '0', '1', '2013-10-28 08:00:00', '1', '2021-03-01 23:52:12', null, '1');
INSERT INTO `sys_dict` VALUES ('99', 'Double', 'Double', 'gen_java_type', 'Java类型', '40', '0', '1', '2013-10-28 08:00:00', '1', '2021-03-01 23:52:12', null, '1');
INSERT INTO `sys_dict` VALUES ('100', 'java.util.Date', 'Date', 'gen_java_type', 'Java类型', '50', '0', '1', '2013-10-28 08:00:00', '1', '2021-03-01 23:52:12', null, '1');
INSERT INTO `sys_dict` VALUES ('111', '10', '待审核', 'sys_audit_type', '审核状态', '10', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('112', '20', '审核通过', 'sys_audit_type', '审核状态', '20', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('113', '30', '审核不通过', 'sys_audit_type', '审核状态', '30', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('114', 'Float', 'Float', 'gen_java_type', 'Java类型', '60', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('115', '1', '系统通知', 'sys_notice_type', '通知类型', '10', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('116', '2', '站外通知', 'sys_notice_type', '通知类型', '20', '0', null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for sys_files
-- ----------------------------
DROP TABLE IF EXISTS `sys_files`;
CREATE TABLE `sys_files` (
  `id` varchar(40) NOT NULL COMMENT '文件编号',
  `file_path` varchar(300) DEFAULT NULL COMMENT '文件路径',
  `file_newname` varchar(100) DEFAULT NULL COMMENT '文件名称',
  `file_old_name` varchar(100) DEFAULT NULL,
  `file_size` double DEFAULT NULL COMMENT '文件大小',
  `file_suffix` varchar(40) DEFAULT NULL COMMENT '文件后缀名',
  `file_type` varchar(10) DEFAULT NULL COMMENT '文件类型',
  `remark` text COMMENT '备注',
  `use_id` varchar(40) DEFAULT NULL COMMENT '用户ID',
  `upload_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_files
-- ----------------------------
INSERT INTO `sys_files` VALUES ('16164318527337792', '/upload/2021-03-23/16164318527337792.jpg', '16164318527337792.jpg', 'default.jpg', '53', '.jpg', 'img', '', '', '2021-03-23 00:50:52');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) DEFAULT '' COMMENT '请求方式',
  `operator_type` int(1) DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(50) DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) DEFAULT '' COMMENT '返回参数',
  `status` int(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=183 DEFAULT CHARSET=utf8 COMMENT='操作日志记录';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('167', '添加/修改角色', null, 'com.democxy.modules.sys.controller.RoleController.save()', 'POST', null, 'admin', null, '/admin/role/save', '0:0:0:0:0:0:0:1', null, '[{\"dataScope\":\"1\",\"id\":\"14\",\"menuIds\":[\"2070\",\"2067\",\"2077\",\"2066\",\"2065\",\"2076\",\"2064\",\"2074\",\"2063\",\"2062\",\"2073\",\"2061\",\"2072\",\"2060\",\"2071\",\"110\",\"111\",\"2\",\"112\",\"2059\",\"2069\",\"2068\"],\"permission\":\"sys:role\",\"roleFlag\":\"admin\",\"roleName\":\"管理员\",\"status\":\"1\"}]', '{\"code\":200,\"data\":\"添加成功\",\"msg\":\"操作成功\"}', '1', null, '2020-11-28 23:28:57');
INSERT INTO `sys_log` VALUES ('168', '添加/修改角色', null, 'com.democxy.modules.sys.controller.RoleController.save()', 'POST', null, 'admin', null, '/admin/role/save', '192.168.124.13', null, '[{\"dataScope\":\"1\",\"id\":\"15\",\"menuIds\":[\"2059\",\"2066\",\"2065\",\"2064\",\"2060\"],\"permission\":\"sys:role\",\"roleFlag\":\"common\",\"roleName\":\"普通用户\",\"status\":\"1\"}]', '{\"code\":200,\"data\":\"添加成功\",\"msg\":\"操作成功\"}', '1', null, '2020-11-28 23:38:43');
INSERT INTO `sys_log` VALUES ('169', '添加/修改角色', null, 'com.democxy.modules.sys.controller.RoleController.save()', 'POST', null, 'admin', null, '/admin/role/save', '0:0:0:0:0:0:0:1', null, '[{\"dataScope\":\"1\",\"id\":\"14\",\"menuIds\":[\"2070\",\"2067\",\"2077\",\"2066\",\"2065\",\"2076\",\"2064\",\"2074\",\"2063\",\"2062\",\"2073\",\"2061\",\"2072\",\"2060\",\"2071\",\"110\",\"111\",\"2\",\"112\",\"2059\",\"2069\",\"2068\"],\"permission\":\"sys:role\",\"roleFlag\":\"admin\",\"roleName\":\"管理员\",\"status\":\"1\"}]', '{\"code\":200,\"data\":\"添加成功\",\"msg\":\"操作成功\"}', '1', null, '2020-11-28 23:40:30');
INSERT INTO `sys_log` VALUES ('170', '添加/修改角色', null, 'com.democxy.modules.sys.controller.RoleController.save()', 'POST', null, 'admin', null, '/admin/role/save', '0:0:0:0:0:0:0:1', null, '[{\"dataScope\":\"1\",\"id\":\"14\",\"menuIds\":[\"2070\",\"2067\",\"2077\",\"2066\",\"2065\",\"2076\",\"2064\",\"2074\",\"2063\",\"2062\",\"2073\",\"2061\",\"2072\",\"2060\",\"2071\",\"110\",\"111\",\"2\",\"112\",\"2059\",\"2069\",\"2068\"],\"permission\":\"sys:role\",\"roleFlag\":\"admin\",\"roleName\":\"管理员\",\"status\":\"1\"}]', '{\"code\":200,\"data\":\"添加成功\",\"msg\":\"操作成功\"}', '1', null, '2020-11-28 23:41:39');
INSERT INTO `sys_log` VALUES ('171', '添加/修改角色', null, 'com.democxy.modules.sys.controller.RoleController.save()', 'POST', null, 'admin', null, '/admin/role/save', '0:0:0:0:0:0:0:1', null, '[{\"dataScope\":\"1\",\"id\":\"14\",\"menuIds\":[\"2070\",\"2067\",\"2077\",\"2066\",\"2065\",\"2076\",\"2064\",\"2074\",\"2063\",\"2062\",\"2073\",\"2061\",\"2072\",\"2060\",\"2071\",\"110\",\"111\",\"2\",\"112\",\"2059\",\"2069\",\"2068\"],\"permission\":\"sys:role\",\"roleFlag\":\"admin\",\"roleName\":\"管理员\",\"status\":\"1\"}]', '{\"code\":200,\"data\":\"添加成功\",\"msg\":\"操作成功\"}', '1', null, '2020-11-28 23:48:42');
INSERT INTO `sys_log` VALUES ('173', '添加/修改角色', null, 'com.democxy.modules.sys.controller.RoleController.save()', 'POST', null, 'admin', null, '/admin/role/save', '0:0:0:0:0:0:0:1', null, '[{\"dataScope\":\"1\",\"id\":\"14\",\"menuIds\":[\"2070\",\"2067\",\"2077\",\"2066\",\"2065\",\"2076\",\"2064\",\"2074\",\"2063\",\"2062\",\"2073\",\"2061\",\"2072\",\"2060\",\"2071\",\"110\",\"111\",\"2\",\"112\",\"2059\",\"2069\",\"2068\"],\"permission\":\"sys:role\",\"roleFlag\":\"admin\",\"roleName\":\"管理员\",\"status\":\"1\"}]', '{\"code\":200,\"data\":\"添加成功\",\"msg\":\"操作成功\"}', '1', null, '2020-11-29 00:20:08');
INSERT INTO `sys_log` VALUES ('174', '添加/修改角色', null, 'com.democxy.modules.sys.controller.RoleController.save()', 'POST', null, 'admin', null, '/admin/role/save', '127.0.0.1', null, '[{\"dataScope\":\"1\",\"id\":\"14\",\"menuIds\":[\"2070\",\"2078\",\"2077\",\"2076\",\"2074\",\"2073\",\"2072\",\"2071\",\"110\",\"111\",\"112\",\"2069\",\"2068\",\"2081\",\"2080\",\"2067\",\"2066\",\"2065\",\"2064\",\"2063\",\"2062\",\"2061\",\"2083\",\"2060\",\"2082\",\"2\",\"2059\",\"2079\"],\"permission\":\"sys:role\",\"roleFlag\":\"admin\",\"roleName\":\"管理员\",\"status\":\"1\"}]', '{\"code\":200,\"data\":\"添加成功\",\"msg\":\"操作成功\"}', '1', null, '2021-01-20 21:08:51');
INSERT INTO `sys_log` VALUES ('175', '删除文件', null, 'com.democxy.modules.sys.controller.SysFilesController.delById()', 'GET', null, 'admin', null, '/sys/sysFiles/del/16112389795313891', '0:0:0:0:0:0:0:1', null, '[\"16112389795313891\"]', '{\"code\":200,\"data\":\"删除成功\",\"msg\":\"操作成功\"}', '1', null, '2021-01-21 22:23:15');
INSERT INTO `sys_log` VALUES ('176', '删除文件', null, 'com.democxy.modules.sys.controller.SysFilesController.delById()', 'GET', null, 'admin', null, '/sys/sysFiles/del/16112389795316089', '0:0:0:0:0:0:0:1', null, '[\"16112389795316089\"]', '{\"code\":200,\"data\":\"删除成功\",\"msg\":\"操作成功\"}', '1', null, '2021-01-21 22:23:17');
INSERT INTO `sys_log` VALUES ('177', '删除文件', null, 'com.democxy.modules.sys.controller.SysFilesController.delById()', 'GET', null, 'admin', null, '/sys/sysFiles/del/16112389795317682', '0:0:0:0:0:0:0:1', null, '[\"16112389795317682\"]', '{\"code\":200,\"data\":\"删除成功\",\"msg\":\"操作成功\"}', '1', null, '2021-01-21 22:23:19');
INSERT INTO `sys_log` VALUES ('178', '删除文件', null, 'com.democxy.modules.sys.controller.SysFilesController.delById()', 'GET', null, 'admin', null, '/sys/sysFiles/del/16112389795319961', '0:0:0:0:0:0:0:1', null, '[\"16112389795319961\"]', '{\"code\":200,\"data\":\"删除成功\",\"msg\":\"操作成功\"}', '1', null, '2021-01-21 22:23:20');
INSERT INTO `sys_log` VALUES ('179', '添加/修改角色', null, 'com.democxy.modules.sys.controller.RoleController.save()', 'POST', null, 'admin', null, '/admin/role/save', '0:0:0:0:0:0:0:1', null, '[{\"dataScope\":\"1\",\"id\":\"14\",\"menuIds\":[\"2070\",\"2090\",\"2078\",\"2077\",\"2076\",\"2074\",\"2073\",\"2072\",\"2071\",\"110\",\"112\",\"2069\",\"2068\",\"2081\",\"2080\",\"2067\",\"2089\",\"2066\",\"2088\",\"2065\",\"2087\",\"2064\",\"2086\",\"2063\",\"2085\",\"2062\",\"2084\",\"2061\",\"2083\",\"2060\",\"2082\",\"2\",\"2059\",\"2079\"],\"permission\":\"sys:role\",\"roleFlag\":\"admin\",\"roleName\":\"管理员\",\"status\":\"1\"}]', '{\"code\":200,\"data\":\"添加成功\",\"msg\":\"操作成功\"}', '1', null, '2021-01-25 20:23:07');
INSERT INTO `sys_log` VALUES ('180', '添加/修改角色', null, 'com.democxy.modules.sys.controller.RoleController.save()', 'POST', null, 'admin', null, '/admin/role/save', '0:0:0:0:0:0:0:1', null, '[{\"dataScope\":\"1\",\"id\":\"14\",\"menuIds\":[\"2070\",\"2092\",\"2091\",\"2090\",\"2078\",\"2077\",\"2076\",\"2074\",\"2096\",\"2073\",\"2095\",\"2072\",\"2094\",\"2071\",\"2093\",\"110\",\"112\",\"2069\",\"2068\",\"2081\",\"2080\",\"2067\",\"2089\",\"2066\",\"2088\",\"2065\",\"2087\",\"2064\",\"2086\",\"2063\",\"2085\",\"2062\",\"2084\",\"2061\",\"2083\",\"2060\",\"2082\",\"2\",\"2059\",\"2079\"],\"permission\":\"sys:role\",\"roleFlag\":\"admin\",\"roleName\":\"管理员\",\"status\":\"1\"}]', '{\"code\":200,\"data\":\"添加成功\",\"msg\":\"操作成功\"}', '1', null, '2021-02-03 22:09:35');
INSERT INTO `sys_log` VALUES ('181', '添加/修改角色', null, 'com.democxy.modules.sys.controller.RoleController.save()', 'POST', null, 'admin', null, '/admin/role/save', '0:0:0:0:0:0:0:1', null, '[{\"dataScope\":\"1\",\"id\":\"14\",\"menuIds\":[\"2070\",\"2092\",\"2091\",\"2090\",\"2078\",\"2077\",\"2099\",\"2076\",\"2098\",\"2097\",\"2074\",\"2096\",\"2073\",\"2095\",\"2072\",\"2094\",\"2071\",\"2093\",\"110\",\"112\",\"2069\",\"2102\",\"2068\",\"2101\",\"2081\",\"2080\",\"2067\",\"2100\",\"2089\",\"2066\",\"2088\",\"2065\",\"2087\",\"2064\",\"2086\",\"2063\",\"2085\",\"2062\",\"2084\",\"2061\",\"2083\",\"2060\",\"2082\",\"2\",\"2059\",\"2079\"],\"permission\":\"sys:role\",\"roleFlag\":\"admin\",\"roleName\":\"管理员\",\"status\":\"1\"}]', '{\"code\":200,\"data\":\"添加成功\",\"msg\":\"操作成功\"}', '1', null, '2021-03-04 20:57:45');
INSERT INTO `sys_log` VALUES ('182', '添加/修改角色', null, 'com.democxy.modules.sys.controller.RoleController.save()', 'POST', null, 'admin', null, '/admin/role/save', '0:0:0:0:0:0:0:1', null, '[{\"dataScope\":\"1\",\"id\":\"14\",\"menuIds\":[\"2070\",\"2092\",\"2091\",\"2090\",\"2078\",\"2077\",\"2099\",\"2076\",\"2098\",\"2097\",\"2074\",\"2096\",\"2073\",\"2095\",\"2072\",\"2094\",\"2071\",\"2093\",\"110\",\"112\",\"2069\",\"2102\",\"2068\",\"2101\",\"2081\",\"2080\",\"2067\",\"2100\",\"2089\",\"2066\",\"2088\",\"2065\",\"2087\",\"2064\",\"2086\",\"2063\",\"2085\",\"2062\",\"2084\",\"2061\",\"2083\",\"2060\",\"2082\",\"2\",\"2059\",\"2079\"],\"permission\":\"sys:role\",\"roleFlag\":\"admin\",\"roleName\":\"管理员\",\"status\":\"1\"}]', '{\"code\":200,\"data\":\"添加成功\",\"msg\":\"操作成功\"}', '1', null, '2021-03-14 00:11:02');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `href` varchar(200) DEFAULT '#' COMMENT '请求地址',
  `target` varchar(20) DEFAULT '' COMMENT '打开方式（menuItem页签 menuBlank新窗口）',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2103 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('2', '系统监控', '0', '20', '#', 'menuItem', 'F', '0', '', 'fa fa-video-camera', 'admin', '2018-03-16 11:33:00', null, '2021-01-12 22:00:25', null);
INSERT INTO `sys_menu` VALUES ('107', '通知公告', '2046', '10', '/system/notice', 'menuItem', 'M', '0', 'system:notice:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2020-04-01 19:49:18', '通知公告菜单');
INSERT INTO `sys_menu` VALUES ('110', '操作日志', '2', '2', 'admin/sys/sysLog', '', 'M', '0', '', 'fa fa-500px', 'admin', '2018-03-16 11:33:00', null, '2020-11-28 23:15:07', null);
INSERT INTO `sys_menu` VALUES ('112', 'SQL监控', '2', '3', 'monitor/data', '', 'M', '0', '', 'fa fa-database', 'admin', '2018-03-16 11:33:00', null, '2020-11-29 10:19:26', null);
INSERT INTO `sys_menu` VALUES ('2059', '系统管理', '2066', null, null, null, 'F', null, '', 'fa fa-gears', null, '2020-11-04 23:37:25', null, '2020-11-29 13:33:46', null);
INSERT INTO `sys_menu` VALUES ('2060', '账号管理', '2059', null, 'admin/sys/account', null, 'M', null, '', 'fa fa-address-book', null, '2020-11-04 23:37:52', null, '2020-11-19 01:08:27', null);
INSERT INTO `sys_menu` VALUES ('2061', '角色管理', '2059', null, 'admin/sys/role', '_self', 'M', null, '', 'fa fa-chrome', null, '2020-11-04 23:40:49', null, '2020-11-19 01:08:35', null);
INSERT INTO `sys_menu` VALUES ('2062', '字典管理', '2059', null, 'admin/sys/dict', '_self', 'F', null, '', 'fa fa-cc', null, '2020-11-05 22:16:20', null, '2020-11-23 22:49:35', null);
INSERT INTO `sys_menu` VALUES ('2063', '菜单管理', '2059', null, 'admin/sys/menu', '_self', 'M', null, '', 'fa fa-align-justify', null, '2020-11-05 22:22:53', null, '2020-11-18 23:51:28', null);
INSERT INTO `sys_menu` VALUES ('2064', '删除', '2060', null, '', null, 'B', null, 'sys:account:del', null, null, '2020-11-05 22:38:11', null, '2020-11-19 23:38:46', null);
INSERT INTO `sys_menu` VALUES ('2065', '添加', '2060', null, '', null, 'B', null, 'sys:account:add', null, null, '2020-11-05 22:38:30', null, '2020-11-19 23:38:39', null);
INSERT INTO `sys_menu` VALUES ('2066', '系统管理', '0', null, null, null, 'F', null, null, null, null, '2020-11-18 23:14:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('2067', '编辑', '2060', null, null, null, 'B', null, 'sys:account:edit', null, null, '2020-11-19 23:39:29', null, '2020-11-19 23:39:35', null);
INSERT INTO `sys_menu` VALUES ('2068', '添加', '2061', null, '', null, 'B', null, 'sys:role:add', null, null, '2020-11-22 22:52:04', null, '2020-11-22 22:52:09', null);
INSERT INTO `sys_menu` VALUES ('2069', '编辑', '2061', null, null, null, 'B', null, 'sys:role:edit', null, null, '2020-11-22 22:52:37', null, '2020-11-22 22:53:08', null);
INSERT INTO `sys_menu` VALUES ('2070', '删除', '2061', null, null, null, 'B', null, 'sys:role:del', null, null, '2020-11-22 22:53:02', null, '2020-11-22 22:53:14', null);
INSERT INTO `sys_menu` VALUES ('2071', '添加', '2063', null, null, null, 'B', null, 'sys:menu:add', null, null, '2020-11-22 22:53:30', '', null, '');
INSERT INTO `sys_menu` VALUES ('2072', '添加', '2062', null, '', null, 'B', null, 'sys:dict:add', null, null, '2020-11-23 22:46:12', '', null, '');
INSERT INTO `sys_menu` VALUES ('2073', '删除', '2062', null, null, null, 'B', null, 'sys:dict:del', null, null, '2020-11-23 22:46:29', '', null, '');
INSERT INTO `sys_menu` VALUES ('2074', '编辑', '2062', null, null, null, 'B', null, 'sys:dict:edit', null, null, '2020-11-23 22:46:52', '', null, '');
INSERT INTO `sys_menu` VALUES ('2076', '查看', '2062', null, null, null, 'B', null, 'sys:dict:view', null, null, '2020-11-23 22:48:19', '', null, '');
INSERT INTO `sys_menu` VALUES ('2077', '定时任务', '2', null, 'admin/sys/taskJob', null, 'F', null, '', 'fa fa-align-justify', null, '2020-11-26 22:56:28', null, '2020-11-26 22:57:22', null);
INSERT INTO `sys_menu` VALUES ('2078', '文件管理', '2059', '1', 'sys/sysFiles', '', 'M', '0', '', 'fa fa-gears', 'democxy', '2020-12-01 00:00:00', 'democxy', '2020-12-01 00:00:00', '文件管理菜单');
INSERT INTO `sys_menu` VALUES ('2079', '文件管理查询', '2078', '1', '#', '', 'B', '0', 'sys:sysFiles:view', '#', 'democxy', '2020-12-01 00:00:00', 'democxy', '2020-12-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2080', '文件管理新增', '2078', '2', '#', '', 'B', '0', 'sys:sysFiles:add', '#', 'democxy', '2020-12-01 00:00:00', 'democxy', '2020-12-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2081', '文件管理修改', '2078', '3', '#', '', 'B', '0', 'sys:sysFiles:edit', '#', 'democxy', '2020-12-01 00:00:00', 'democxy', '2020-12-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2082', '文件管理保存', '2078', '4', '#', '', 'B', '0', 'sys:sysFiles:save', '#', 'democxy', '2020-12-01 00:00:00', 'democxy', '2020-12-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2083', '文件管理删除', '2078', '5', '#', '', 'B', '0', 'sys:sysFiles:del', '#', 'democxy', '2020-12-01 00:00:00', 'democxy', '2020-12-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2084', '代码生成', '2066', null, null, null, 'F', null, '', 'fa fa-bug', null, '2021-01-25 20:22:01', null, '2021-03-22 21:43:09', null);
INSERT INTO `sys_menu` VALUES ('2085', '方案管理', '2084', '1', 'gen/genTable', '', 'M', '0', '', 'fa fa-gears', 'democxy', '2020-12-01 00:00:00', null, '2021-01-25 20:22:59', null);
INSERT INTO `sys_menu` VALUES ('2086', '代码生成查询', '2085', '1', '#', '', 'B', '0', 'gen:genTable:view', '#', 'democxy', '2020-12-01 00:00:00', 'democxy', '2020-12-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2087', '代码生成新增', '2085', '2', '#', '', 'B', '0', 'gen:genTable:add', '#', 'democxy', '2020-12-01 00:00:00', 'democxy', '2020-12-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2088', '代码生成修改', '2085', '3', '#', '', 'B', '0', 'gen:genTable:edit', '#', 'democxy', '2020-12-01 00:00:00', 'democxy', '2020-12-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2089', '代码生成保存', '2085', '4', '#', '', 'B', '0', 'gen:genTable:save', '#', 'democxy', '2020-12-01 00:00:00', 'democxy', '2020-12-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2090', '代码生成删除', '2085', '5', '#', '', 'B', '0', 'gen:genTable:del', '#', 'democxy', '2020-12-01 00:00:00', 'democxy', '2020-12-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2097', '通知公告', '2066', '1', 'sys/notice', '', 'M', '0', '', 'fa fa-gears', 'democxy', '2020-12-01 00:00:00', null, '2021-03-04 20:57:21', null);
INSERT INTO `sys_menu` VALUES ('2098', '通知公告查询', '2097', '1', '#', '', 'B', '0', 'sys:notice:view', '#', 'democxy', '2020-12-01 00:00:00', 'democxy', '2020-12-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2099', '通知公告新增', '2097', '2', '#', '', 'B', '0', 'sys:notice:add', '#', 'democxy', '2020-12-01 00:00:00', 'democxy', '2020-12-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2100', '通知公告修改', '2097', '3', '#', '', 'B', '0', 'sys:notice:edit', '#', 'democxy', '2020-12-01 00:00:00', 'democxy', '2020-12-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2101', '通知公告保存', '2097', '4', '#', '', 'B', '0', 'sys:notice:save', '#', 'democxy', '2020-12-01 00:00:00', 'democxy', '2020-12-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2102', '通知公告删除', '2097', '5', '#', '', 'B', '0', 'sys:notice:del', '#', 'democxy', '2020-12-01 00:00:00', 'democxy', '2020-12-01 00:00:00', '');

-- ----------------------------
-- Table structure for sys_menu_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_role`;
CREATE TABLE `sys_menu_role` (
  `menu_id` varchar(11) NOT NULL,
  `role_id` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu_role
-- ----------------------------
INSERT INTO `sys_menu_role` VALUES ('2070', '16');
INSERT INTO `sys_menu_role` VALUES ('2067', '16');
INSERT INTO `sys_menu_role` VALUES ('2066', '16');
INSERT INTO `sys_menu_role` VALUES ('2065', '16');
INSERT INTO `sys_menu_role` VALUES ('2076', '16');
INSERT INTO `sys_menu_role` VALUES ('2064', '16');
INSERT INTO `sys_menu_role` VALUES ('2074', '16');
INSERT INTO `sys_menu_role` VALUES ('2063', '16');
INSERT INTO `sys_menu_role` VALUES ('2062', '16');
INSERT INTO `sys_menu_role` VALUES ('2073', '16');
INSERT INTO `sys_menu_role` VALUES ('2061', '16');
INSERT INTO `sys_menu_role` VALUES ('2072', '16');
INSERT INTO `sys_menu_role` VALUES ('2060', '16');
INSERT INTO `sys_menu_role` VALUES ('2071', '16');
INSERT INTO `sys_menu_role` VALUES ('110', '16');
INSERT INTO `sys_menu_role` VALUES ('111', '16');
INSERT INTO `sys_menu_role` VALUES ('2', '16');
INSERT INTO `sys_menu_role` VALUES ('112', '16');
INSERT INTO `sys_menu_role` VALUES ('2059', '16');
INSERT INTO `sys_menu_role` VALUES ('2069', '16');
INSERT INTO `sys_menu_role` VALUES ('2068', '16');
INSERT INTO `sys_menu_role` VALUES ('110', '17');
INSERT INTO `sys_menu_role` VALUES ('111', '17');
INSERT INTO `sys_menu_role` VALUES ('2', '17');
INSERT INTO `sys_menu_role` VALUES ('112', '17');
INSERT INTO `sys_menu_role` VALUES ('110', '18');
INSERT INTO `sys_menu_role` VALUES ('111', '18');
INSERT INTO `sys_menu_role` VALUES ('2', '18');
INSERT INTO `sys_menu_role` VALUES ('112', '18');
INSERT INTO `sys_menu_role` VALUES ('2059', '18');
INSERT INTO `sys_menu_role` VALUES ('2067', '18');
INSERT INTO `sys_menu_role` VALUES ('2066', '18');
INSERT INTO `sys_menu_role` VALUES ('2065', '18');
INSERT INTO `sys_menu_role` VALUES ('2064', '18');
INSERT INTO `sys_menu_role` VALUES ('2060', '18');
INSERT INTO `sys_menu_role` VALUES ('2070', '19');
INSERT INTO `sys_menu_role` VALUES ('2067', '19');
INSERT INTO `sys_menu_role` VALUES ('2066', '19');
INSERT INTO `sys_menu_role` VALUES ('2065', '19');
INSERT INTO `sys_menu_role` VALUES ('2076', '19');
INSERT INTO `sys_menu_role` VALUES ('2064', '19');
INSERT INTO `sys_menu_role` VALUES ('2074', '19');
INSERT INTO `sys_menu_role` VALUES ('2063', '19');
INSERT INTO `sys_menu_role` VALUES ('2062', '19');
INSERT INTO `sys_menu_role` VALUES ('2073', '19');
INSERT INTO `sys_menu_role` VALUES ('2061', '19');
INSERT INTO `sys_menu_role` VALUES ('2072', '19');
INSERT INTO `sys_menu_role` VALUES ('2060', '19');
INSERT INTO `sys_menu_role` VALUES ('2071', '19');
INSERT INTO `sys_menu_role` VALUES ('2059', '19');
INSERT INTO `sys_menu_role` VALUES ('2069', '19');
INSERT INTO `sys_menu_role` VALUES ('2068', '19');
INSERT INTO `sys_menu_role` VALUES ('2070', '20');
INSERT INTO `sys_menu_role` VALUES ('2067', '20');
INSERT INTO `sys_menu_role` VALUES ('2066', '20');
INSERT INTO `sys_menu_role` VALUES ('2065', '20');
INSERT INTO `sys_menu_role` VALUES ('2076', '20');
INSERT INTO `sys_menu_role` VALUES ('2064', '20');
INSERT INTO `sys_menu_role` VALUES ('2074', '20');
INSERT INTO `sys_menu_role` VALUES ('2063', '20');
INSERT INTO `sys_menu_role` VALUES ('2062', '20');
INSERT INTO `sys_menu_role` VALUES ('2073', '20');
INSERT INTO `sys_menu_role` VALUES ('2061', '20');
INSERT INTO `sys_menu_role` VALUES ('2072', '20');
INSERT INTO `sys_menu_role` VALUES ('2060', '20');
INSERT INTO `sys_menu_role` VALUES ('2071', '20');
INSERT INTO `sys_menu_role` VALUES ('2059', '20');
INSERT INTO `sys_menu_role` VALUES ('2069', '20');
INSERT INTO `sys_menu_role` VALUES ('2068', '20');
INSERT INTO `sys_menu_role` VALUES ('2070', '21');
INSERT INTO `sys_menu_role` VALUES ('2067', '21');
INSERT INTO `sys_menu_role` VALUES ('2066', '21');
INSERT INTO `sys_menu_role` VALUES ('2065', '21');
INSERT INTO `sys_menu_role` VALUES ('2076', '21');
INSERT INTO `sys_menu_role` VALUES ('2064', '21');
INSERT INTO `sys_menu_role` VALUES ('2074', '21');
INSERT INTO `sys_menu_role` VALUES ('2063', '21');
INSERT INTO `sys_menu_role` VALUES ('2062', '21');
INSERT INTO `sys_menu_role` VALUES ('2073', '21');
INSERT INTO `sys_menu_role` VALUES ('2061', '21');
INSERT INTO `sys_menu_role` VALUES ('2072', '21');
INSERT INTO `sys_menu_role` VALUES ('2060', '21');
INSERT INTO `sys_menu_role` VALUES ('2071', '21');
INSERT INTO `sys_menu_role` VALUES ('110', '21');
INSERT INTO `sys_menu_role` VALUES ('111', '21');
INSERT INTO `sys_menu_role` VALUES ('2', '21');
INSERT INTO `sys_menu_role` VALUES ('112', '21');
INSERT INTO `sys_menu_role` VALUES ('2059', '21');
INSERT INTO `sys_menu_role` VALUES ('2069', '21');
INSERT INTO `sys_menu_role` VALUES ('2068', '21');
INSERT INTO `sys_menu_role` VALUES ('2059', '15');
INSERT INTO `sys_menu_role` VALUES ('2066', '15');
INSERT INTO `sys_menu_role` VALUES ('2065', '15');
INSERT INTO `sys_menu_role` VALUES ('2064', '15');
INSERT INTO `sys_menu_role` VALUES ('2060', '15');
INSERT INTO `sys_menu_role` VALUES ('2070', '14');
INSERT INTO `sys_menu_role` VALUES ('2092', '14');
INSERT INTO `sys_menu_role` VALUES ('2091', '14');
INSERT INTO `sys_menu_role` VALUES ('2090', '14');
INSERT INTO `sys_menu_role` VALUES ('2078', '14');
INSERT INTO `sys_menu_role` VALUES ('2077', '14');
INSERT INTO `sys_menu_role` VALUES ('2099', '14');
INSERT INTO `sys_menu_role` VALUES ('2076', '14');
INSERT INTO `sys_menu_role` VALUES ('2098', '14');
INSERT INTO `sys_menu_role` VALUES ('2097', '14');
INSERT INTO `sys_menu_role` VALUES ('2074', '14');
INSERT INTO `sys_menu_role` VALUES ('2096', '14');
INSERT INTO `sys_menu_role` VALUES ('2073', '14');
INSERT INTO `sys_menu_role` VALUES ('2095', '14');
INSERT INTO `sys_menu_role` VALUES ('2072', '14');
INSERT INTO `sys_menu_role` VALUES ('2094', '14');
INSERT INTO `sys_menu_role` VALUES ('2071', '14');
INSERT INTO `sys_menu_role` VALUES ('2093', '14');
INSERT INTO `sys_menu_role` VALUES ('110', '14');
INSERT INTO `sys_menu_role` VALUES ('112', '14');
INSERT INTO `sys_menu_role` VALUES ('2069', '14');
INSERT INTO `sys_menu_role` VALUES ('2102', '14');
INSERT INTO `sys_menu_role` VALUES ('2068', '14');
INSERT INTO `sys_menu_role` VALUES ('2101', '14');
INSERT INTO `sys_menu_role` VALUES ('2081', '14');
INSERT INTO `sys_menu_role` VALUES ('2080', '14');
INSERT INTO `sys_menu_role` VALUES ('2067', '14');
INSERT INTO `sys_menu_role` VALUES ('2100', '14');
INSERT INTO `sys_menu_role` VALUES ('2089', '14');
INSERT INTO `sys_menu_role` VALUES ('2066', '14');
INSERT INTO `sys_menu_role` VALUES ('2088', '14');
INSERT INTO `sys_menu_role` VALUES ('2065', '14');
INSERT INTO `sys_menu_role` VALUES ('2087', '14');
INSERT INTO `sys_menu_role` VALUES ('2064', '14');
INSERT INTO `sys_menu_role` VALUES ('2086', '14');
INSERT INTO `sys_menu_role` VALUES ('2063', '14');
INSERT INTO `sys_menu_role` VALUES ('2085', '14');
INSERT INTO `sys_menu_role` VALUES ('2062', '14');
INSERT INTO `sys_menu_role` VALUES ('2084', '14');
INSERT INTO `sys_menu_role` VALUES ('2061', '14');
INSERT INTO `sys_menu_role` VALUES ('2083', '14');
INSERT INTO `sys_menu_role` VALUES ('2060', '14');
INSERT INTO `sys_menu_role` VALUES ('2082', '14');
INSERT INTO `sys_menu_role` VALUES ('2', '14');
INSERT INTO `sys_menu_role` VALUES ('2059', '14');
INSERT INTO `sys_menu_role` VALUES ('2079', '14');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `content` longtext COMMENT '内容',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  `create_by` varchar(40) DEFAULT NULL COMMENT '发布人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='通知公告';

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES ('2', '测试发布', '1', '<div id=\"layuimini-notice\" class=\"layui-layer-content\"><div style=\"text-align: justify;\"><div>界面足够简洁清爽。<br>一个接口几行代码而已直接初始化整个框架，无需复杂操作。<br>支持多tab，可以打开多窗口。<br>支持无限级菜单和对font-awesome图标库的完美支持。<br>失效以及报错菜单无法直接打开，并给出弹出层提示完美的线上用户体验。<br>url地址hash定位，可以清楚看到当前tab的地址信息。<br>刷新页面会保留当前的窗口，并且会定位当前窗口对应左侧菜单栏。<br>移动端的友好支持。</div></div></div><div><a class=\"layui-layer-btn1\"><br></a></div>', null, null);
INSERT INTO `sys_notice` VALUES ('3', '不要只是会用Redis，这些Redis常识你必须知道', '2', '的对方对方的', null, null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_name` varchar(100) NOT NULL COMMENT '角色名',
  `role_flag` varchar(100) DEFAULT NULL COMMENT '角色标识',
  `data_scope` varchar(255) DEFAULT NULL COMMENT '数据范围',
  `status` varchar(10) DEFAULT NULL COMMENT '角色状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '系统管理员', 'admin', '1', '1');
INSERT INTO `sys_role` VALUES ('14', '管理员', 'admin', '1', '1');
INSERT INTO `sys_role` VALUES ('15', '普通用户', 'common', '1', '1');

-- ----------------------------
-- Table structure for sys_task_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_task_job`;
CREATE TABLE `sys_task_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(255) DEFAULT NULL,
  `method_name` varchar(255) DEFAULT NULL,
  `method_params` varchar(255) DEFAULT NULL,
  `cron_type` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `task_status` char(10) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_task_job
-- ----------------------------
INSERT INTO `sys_task_job` VALUES ('1', 'demoTask', 'taskNoParams', '', '* * * * * ? ', '每秒执行', '0', '2021-01-13 20:52:16');
