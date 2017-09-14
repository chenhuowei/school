/*
Navicat MySQL Data Transfer

Source Server         : mine
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : school

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2016-12-04 16:49:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_专业目录
-- ----------------------------
DROP TABLE IF EXISTS `sys_专业目录`;
CREATE TABLE `sys_专业目录` (
  `ID` varchar(40) NOT NULL,
  `CREATE_TIME` varchar(20) DEFAULT NULL,
  `UPDATE_TIME` varchar(20) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `MAJOR_TYPE_ID` int(11) DEFAULT NULL,
  `MAJOR_TYPE` varchar(30) DEFAULT NULL,
  `NAME` varchar(30) DEFAULT NULL,
  `CODE` varchar(11) DEFAULT NULL,
  `INFO` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_专业目录
-- ----------------------------

-- ----------------------------
-- Table structure for sys_专业科目
-- ----------------------------
DROP TABLE IF EXISTS `sys_专业科目`;
CREATE TABLE `sys_专业科目` (
  `ID` varchar(40) NOT NULL,
  `CREATE_TIME` varchar(30) DEFAULT NULL,
  `UPDATE_TIME` varchar(30) DEFAULT NULL,
  `OPERATOR_ID` varchar(40) DEFAULT NULL,
  `OPERATOR` varchar(20) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `CODE` varchar(11) DEFAULT NULL,
  `CATEGORY` varchar(20) DEFAULT NULL,
  `SUBJECT_NAME` varchar(20) DEFAULT NULL,
  `INFO` varchar(100) DEFAULT NULL,
  `VERSION` varchar(20) DEFAULT NULL,
  `VOLUMES` varchar(10) DEFAULT NULL,
  `CREDITS` double(2,0) DEFAULT NULL,
  `APPLICATION` varchar(200) DEFAULT NULL,
  `IS_REQUEST` tinyint(1) DEFAULT NULL,
  `IS_PUBLICE` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_专业科目
-- ----------------------------
INSERT INTO `sys_专业科目` VALUES ('0417364c-3c9b-413f-aa94-c2f45ab1112a', '2016-10-13 15:47:05', null, null, null, '1', '备注文本300字以内', 'A1007', '理学', 'c语言入门', 'test', '2014', '1', '5', 'test', '1', '0');
INSERT INTO `sys_专业科目` VALUES ('0816b140-65fa-48a2-9184-f47928c71d0d', '2016-10-13 15:45:46', null, null, null, '1', '备注文本300字以内', 'A1005', '语言学', '普通话教程', 'test', '2013', '1', '3', 'test', '1', '0');
INSERT INTO `sys_专业科目` VALUES ('198bc0ce-0f92-4ab5-8d1b-906b7299ef96', '2016-10-13 15:48:45', null, null, null, '1', '备注文本300字以内', 'A1010', '理学', '物理基础应用', 'test', '2011', '1', '3', 'test', '1', '0');
INSERT INTO `sys_专业科目` VALUES ('229c1e4f-5651-44ab-8c29-3632ddb0075f', '2016-10-13 16:42:05', null, null, null, '1', '备注文本300字以内', 'A1020', '自然科学', '世界的奇妙之旅', '特色', '2016', '1', '3', 'test', '0', '1');
INSERT INTO `sys_专业科目` VALUES ('27e022f3-872b-4727-8167-41724c8425ae', '2016-10-13 15:45:00', null, null, null, '1', '备注文本300字以内', 'A1004', '语言学', '英语听说', 'test', '2016', '1', '4', 'test', '1', '0');
INSERT INTO `sys_专业科目` VALUES ('3cb15ea1-6c9a-4de9-a8db-51ead642f0c3', '2016-10-13 15:48:08', null, null, null, '1', '备注文本300字以内', 'A1009', '理学', '计算机基础', 'test', '2015', '1', '4', 'test', '1', '0');
INSERT INTO `sys_专业科目` VALUES ('477ab27f-e0fd-4e10-8fbd-09405202e1b2', '2016-10-13 16:39:44', '2016-10-13 16:42:47', null, null, '1', '备注文本300字以内', 'A1018', '法学', '生活与法律', 'test', '2010', '1', '3', 'test', '0', '1');
INSERT INTO `sys_专业科目` VALUES ('4a1acd9f-a70b-4934-82ff-02ac8020c772', '2016-10-13 15:51:14', null, null, null, '1', '备注文本300字以内', 'A1012', '理学', '物理师范应用学', 'test', '2013', '3', '4', 'test', '1', '0');
INSERT INTO `sys_专业科目` VALUES ('4ed6d190-f158-4f99-992e-6641651a92c9', '2016-10-13 15:46:25', null, null, null, '1', '备注文本300字以内', 'A1006', '体育学', '体育与生活', 'test', '2017', '1', '3', 'test', '1', '0');
INSERT INTO `sys_专业科目` VALUES ('87670ae8-d043-4822-8577-a210d5c023c8', '2016-10-13 17:06:41', null, null, null, '1', '备注文本300字以内', 'A1021', '理学', '电气工程理论', 'test', '2016', '1', '4', 'test', '1', '0');
INSERT INTO `sys_专业科目` VALUES ('8efb9c7d-80e3-4b70-90b7-d2d02a620521', '2016-10-13 15:53:13', null, null, null, '1', '备注文本300字以内', 'A1014', '理学', '分子世界', 'test', '2016', '1', '3', 'test', '1', '0');
INSERT INTO `sys_专业科目` VALUES ('a5e25daa-8020-4767-9888-fc8b0bea5262', '2016-10-13 16:41:17', null, null, null, '1', '备注文本300字以内', 'A1019', '民族学', '中华民族崛起之路', 'test', '2009', '1', '3', 'test', '0', '1');
INSERT INTO `sys_专业科目` VALUES ('bd9eb036-93c5-4583-9e43-b4c8a8a18052', '2016-10-13 15:54:07', null, null, null, '1', '备注文本300字以内', 'A1015', '理学', '化学与生活', 'test', '2016', '1', '2', 'test', '1', '0');
INSERT INTO `sys_专业科目` VALUES ('c1c8bfd9-12aa-4ccc-a1e0-6903cc363251', '2016-10-13 15:42:35', null, null, null, '1', '备注文本300字以内', 'A1002', '理学', '高等代数', 'test', '第三版', '1', '4', '计算机，数学', '1', '0');
INSERT INTO `sys_专业科目` VALUES ('ca2e8fb6-119f-479a-8c72-15ba18957b0d', '2016-10-13 15:41:33', null, null, null, '1', '备注文本300字以内', 'A1001', '理学', '数值分析', 'test', '第五版', '1', '5', '数学应用', '1', '0');
INSERT INTO `sys_专业科目` VALUES ('ca972c3b-9fd6-4038-8323-17a11ab6830b', '2016-10-13 15:49:59', null, null, null, '1', '备注文本300字以内', 'A1011', '理学', '光电应用学', 'test', '2012', '1', '4', 'test', '1', '0');
INSERT INTO `sys_专业科目` VALUES ('cf571db6-537b-4cfb-b470-821908db36bb', '2016-10-13 16:39:02', null, null, null, '1', '备注文本300字以内', 'A1017', '人文理学', '人类思想的进化', 'test', '2016', '1', '3', 'test', '0', '1');
INSERT INTO `sys_专业科目` VALUES ('db3fcbe0-39d4-4e8f-a46b-bde2250d45c8', '2016-10-13 15:47:32', null, null, null, '1', '备注文本300字以内', 'A1008', '理学', 'Android', 'test', '2017', '1', '5', 'test', '1', '0');
INSERT INTO `sys_专业科目` VALUES ('f1f6e17e-b229-4e07-9f6d-a335c5a8a51a', '2016-10-13 15:51:53', null, null, null, '1', '备注文本300字以内', 'A1013', '理学', '化学原理与应用', 'test', '2013', '1', '5', 'test', '1', '0');
INSERT INTO `sys_专业科目` VALUES ('f7aa0bd5-6b04-4f6b-bcab-cdbed630e01e', '2016-10-13 15:43:22', null, null, null, '1', '备注文本300字以内', 'A1003', '理学', 'java', 'test', '2016', '1', '5', '计算机，数学', '1', '0');
INSERT INTO `sys_专业科目` VALUES ('faa75173-4ef8-49f5-ad2b-4a1fcde2a4e7', '2016-10-13 15:54:43', null, null, null, '1', '备注文本300字以内', 'A1016', '理学', '数学教学教程', 'test', '2016', '1', '5', 'test', '1', '0');

-- ----------------------------
-- Table structure for sys_专业类型
-- ----------------------------
DROP TABLE IF EXISTS `sys_专业类型`;
CREATE TABLE `sys_专业类型` (
  `ID` varchar(40) NOT NULL,
  `CREATE_TIME` varchar(20) DEFAULT NULL,
  `UPDATE_TIME` varchar(20) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `TYPE` varchar(20) DEFAULT NULL,
  `INFO` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_专业类型
-- ----------------------------

-- ----------------------------
-- Table structure for sys_会话记录
-- ----------------------------
DROP TABLE IF EXISTS `sys_会话记录`;
CREATE TABLE `sys_会话记录` (
  `ID` varchar(40) NOT NULL,
  `FROM_USER_ID` varchar(40) DEFAULT NULL,
  `FROM_USER_NAME` varchar(20) DEFAULT NULL,
  `TO_USER_ID` varchar(40) DEFAULT NULL,
  `MESSAGE` varchar(300) DEFAULT NULL,
  `SEND_TIME` varchar(20) DEFAULT NULL,
  `STATUS` bit(1) DEFAULT b'1',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_会话记录
-- ----------------------------

-- ----------------------------
-- Table structure for sys_学生信息
-- ----------------------------
DROP TABLE IF EXISTS `sys_学生信息`;
CREATE TABLE `sys_学生信息` (
  `ID` varchar(40) NOT NULL,
  `CREATE_TIME` varchar(30) DEFAULT NULL,
  `UPDATE_TIME` varchar(30) DEFAULT NULL,
  `OPERATOR_ID` varchar(40) DEFAULT NULL,
  `OPERATOR` varchar(20) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `S_NUMBER` varchar(11) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `PASSWORD2` varchar(16) DEFAULT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `SEX` tinyint(1) DEFAULT NULL,
  `AGE` int(2) DEFAULT NULL,
  `BIRTH` varchar(30) DEFAULT NULL,
  `NATIONAL` varchar(10) DEFAULT NULL,
  `NATIVE_PLACE` varchar(50) DEFAULT NULL,
  `SCHOOL_OF_GRADUATION` varchar(50) DEFAULT NULL,
  `ADMISSION_DATE` varchar(30) DEFAULT NULL,
  `ID_CARD` varchar(20) DEFAULT NULL,
  `MOBILE` varchar(15) DEFAULT NULL,
  `EMAIL` varchar(20) DEFAULT NULL,
  `HOME_ADDRESS` varchar(50) DEFAULT NULL,
  `HOME_TEL` varchar(20) DEFAULT NULL,
  `PARENT_MOBILE` varchar(20) DEFAULT NULL,
  `HEAD_IMAGE` varchar(100) DEFAULT NULL,
  `ACADEMY_NAME` varchar(20) DEFAULT NULL,
  `GRADE` varchar(20) DEFAULT NULL,
  `CLASS_NAME` varchar(255) DEFAULT NULL,
  `CLASS_ID` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_学生信息
-- ----------------------------
INSERT INTO `sys_学生信息` VALUES ('08c72be9-e656-4bd4-9d4a-836c00f20ac0', '2016-10-12 22:41:18', null, null, null, '1', 'test', '1610008', 'e10adc3949ba59abbe56e057f20f883e', '123456', '徐明军', '1', '0', '2016-10-12', 'test', 'test', 'test', '2016-10-12', '440921199310569', '13068501300', 'test@qq.com', 'test', '0668863111', '189123456', null, '计算机学院', '2016', '1604', '6d04b565-7cf7-4310-9088-40a4e0a716c7');
INSERT INTO `sys_学生信息` VALUES ('0d162226-3315-499f-b8c7-8da92ca3d3c8', '2016-10-12 22:32:58', null, null, null, '1', 'test', '1610002', 'e10adc3949ba59abbe56e057f20f883e', '123456', '张慧媛', '0', '0', '2016-10-12', 'test', 'test', 'test', '2016-10-12', '440921199312103', '13068501300', 'test@qq.com', 'test', '06688631179', '15986221364', null, '物理学院', '2016', '1601', '590cb58a-67c5-4135-91c5-c614922f5703');
INSERT INTO `sys_学生信息` VALUES ('1ec9ae56-d696-40df-92f1-8de4ed0c60a9', '2016-10-12 22:40:08', null, null, null, '1', 'test', '1610007', 'e10adc3949ba59abbe56e057f20f883e', '123456', '曾文彦', '0', '0', '2016-10-12', 'test', 'test', 'test', '2016-10-12', '440921199612361', '13068510300', 'test@qq.com', 'test', '06688631179', '15986221303', null, '计算机学院', '2016', '1604', '6d04b565-7cf7-4310-9088-40a4e0a716c7');
INSERT INTO `sys_学生信息` VALUES ('21802392-f460-4c73-a667-fc2bc9a00d84', '2016-10-12 23:15:02', null, null, null, '1', 'test', '1610011', 'e10adc3949ba59abbe56e057f20f883e', '123456', '黄文燕', '0', '0', '2016-10-12', 'test', 'test', 'EST', '2016-10-12', '440921199310102', '13068501300', 'test@qq.com', 'EST', '06688631245', '156123456', null, '化学学院', '2016', '1606', 'c4da4786-d2b0-45c7-9db0-bcf4d5cbd1aa');
INSERT INTO `sys_学生信息` VALUES ('3a5b1faf-f76f-47f9-95d4-1c2db5bb6ab0', '2016-10-12 22:34:06', null, null, null, '1', 'test', '1610003', 'e10adc3949ba59abbe56e057f20f883e', '123456', '孔艳玲', '0', '0', '2016-10-12', 'test', 'test', 'test', '2016-10-12', '440921199310103569', '18813961234', 'test@qq.com', 'EST', '06688631179', '13068501300', null, '物理学院', '2016', '1602', '27ecde58-9cf3-4658-b5a1-2c5da4c30bf6');
INSERT INTO `sys_学生信息` VALUES ('4c0d311f-98a9-4274-a859-c43dbafbd911', '2016-10-12 23:16:25', null, null, null, '1', 'test', '1610012', 'e10adc3949ba59abbe56e057f20f883e', '123456', '李辉军', '1', '0', '2016-10-12', 'test', 'test', 'EST', '2016-10-12', '440918631010632', '15623569841', 'test@qq.com', 'test', '066886311456', '15612378965', null, '化学学院', '2016', '1606', 'c4da4786-d2b0-45c7-9db0-bcf4d5cbd1aa');
INSERT INTO `sys_学生信息` VALUES ('58a7eea2-7f7c-4c62-9adf-36c76661a1bb', '2016-10-12 23:25:00', null, null, null, '1', 'test', '1610015', 'e10adc3949ba59abbe56e057f20f883e', '123456', '潘子文', '1', '0', '2016-10-12', 'test', 'test', 'test', '2016-10-12', '440921199310658', '13068510233', 'test@q.com', 'test', '0668869312', '13068511234', null, '数学学院', '2016', '1603', '0c6a2691-1f6e-478d-ab8c-7fc5289bf331');
INSERT INTO `sys_学生信息` VALUES ('7de2d9ba-ba7d-43a4-a9ee-e562a08cdeba', '2016-10-12 23:28:46', null, null, null, '1', 'test', '1610018', 'e10adc3949ba59abbe56e057f20f883e', '123456', '刘伟涛', '1', '0', '2016-10-12', 'test', 'test', 'EST', '2016-10-12', '440912345689621', '13045696312', 'test@qq.com', 'EST', '06688631789', '15012345689', null, '数学学院', '2016', '1601', '82879c7b-ce46-46fa-8ac6-4119658d5d35');
INSERT INTO `sys_学生信息` VALUES ('97e6aad1-9927-4832-b023-acfde894f99d', '2016-10-12 22:31:43', '2016-10-22 17:10:03', null, null, '1', 'test', '1610001', 'e10adc3949ba59abbe56e057f20f883e', '123456', '陈志冉', '0', '0', '2016-10-12', 'test', 'test', 'EST', '2016-10-12', '440921179965211', '18813975059', 'test@qq.com', 'test', '06688631179', '18813975095', null, '物理学院', '2016', '1601', '590cb58a-67c5-4135-91c5-c614922f5703');
INSERT INTO `sys_学生信息` VALUES ('9890bac5-8d84-4550-b00c-865094efd0b9', '2016-10-12 23:13:48', null, null, null, '1', 'test', '1610010', 'e10adc3949ba59abbe56e057f20f883e', '123456', '魏阳志', '1', '0', '2016-10-12', 'test', 'test', 'EST', '2016-10-12', '440952123485695', '13068501236', 'test@qq.com', 'test', '06688631456', 'test', null, '化学学院', '2016', '1605', 'a4b89d96-699c-4321-88b2-bca4d5fd2cdd');
INSERT INTO `sys_学生信息` VALUES ('9bd1e7c9-a7c8-4ccc-a235-c7be2eac4441', '2016-10-12 23:26:11', null, null, null, '1', 'test ', '1610016', 'e10adc3949ba59abbe56e057f20f883e', '123456', '李浩杰', '1', '0', '2016-10-12', 'test', 'tes ', 'test ', '2016-10-12', '449521548512364', '13068510326', 'test@qq.com', 'test', '06688631179', '1568945123', null, '数学学院', '2016', '1603', '0c6a2691-1f6e-478d-ab8c-7fc5289bf331');
INSERT INTO `sys_学生信息` VALUES ('b1ad1749-a61c-4917-89fc-3f8e65b11923', '2016-10-12 23:23:41', null, null, null, '1', 'tes t', '1610014', 'e10adc3949ba59abbe56e057f20f883e', '123456', '陈旭浩', '1', '0', '2016-10-12', 'test', 'test ', 'test', '2016-10-12', '440812345670154', '13068501256', 'test@qq.com', 'test', '06688631148', '186123456', null, '数学学院', '2016', '1602', '45e438e9-2977-48c6-8353-3456b478b846');
INSERT INTO `sys_学生信息` VALUES ('b8b6241a-368c-4414-8196-e684a4849b9e', '2016-10-12 23:27:28', null, null, null, '1', 'test', '1610017', 'e10adc3949ba59abbe56e057f20f883e', '123456', '黎紫莹', '0', '0', '2016-10-12', 'test', 'test', 'test', '2016-10-12', '440921199645670', '13045678912', 'test@qq.com', 'test', '06681234567', '13212378969', null, '数学学院', '2016', '1602', '45e438e9-2977-48c6-8353-3456b478b846');
INSERT INTO `sys_学生信息` VALUES ('c52b21d7-1bc8-4524-9a86-a017bfecd6bf', '2016-10-12 22:35:29', null, null, null, '1', 'test', '1610004', 'e10adc3949ba59abbe56e057f20f883e', '123456', '赵岩昊', '1', '0', '2016-10-12', 'test', 'test', 'EST', '2016-10-12', '440984561287101', '13068501300', 'test@qq.com', 'test', '06688631035', '13068501423', null, '物理学院', '2016', '1602', '27ecde58-9cf3-4658-b5a1-2c5da4c30bf6');
INSERT INTO `sys_学生信息` VALUES ('c5934880-32f7-41cc-b7d7-1edb24bd2f80', '2016-10-12 23:12:15', null, null, null, '1', 'test', '1610009', 'e10adc3949ba59abbe56e057f20f883e', '123456', '冯林燕', '0', '0', '2016-10-12', 'test', 'test', 'EST', '2016-10-12', '440923568912345', '13068511236', 'test@qq.com', 'test', '06688631179', '13068521236', null, '化学学院', '2016', '1605', 'a4b89d96-699c-4321-88b2-bca4d5fd2cdd');
INSERT INTO `sys_学生信息` VALUES ('e4faced0-6344-4aa3-a078-024ac09ff396', '2016-10-12 23:22:17', '2016-10-14 22:45:47', null, null, '1', 'test', '1610013', 'e10adc3949ba59abbe56e057f20f883e', '123456', '曾燕灵', '0', '17', '1999-02-01', 'test', 'test', 'test', '2016-10-12', '440921199310103636', '13068503001', 'test@qq.com', 'test', '06688637520', '13068501236', null, '数学学院', '2016', '1601', '82879c7b-ce46-46fa-8ac6-4119658d5d35');
INSERT INTO `sys_学生信息` VALUES ('ee46a188-bee7-4171-a05c-b5b4c051b716', '2016-10-12 22:38:12', null, null, null, '1', 'test', '1610006', 'e10adc3949ba59abbe56e057f20f883e', '123456', '郑世明', '1', '0', '2016-10-12', 'test', 'test', 'test', '2016-10-12', '444092116693210', '13068501300', 'test@qq.com', 'test', '066886311179', '186123456', null, '计算机学院', '2016', '1603', '5cda1fe1-5e96-42ae-94b3-0f42295c421b');
INSERT INTO `sys_学生信息` VALUES ('f5e81833-19e9-4326-bf25-abd9217c4209', '2016-10-12 22:37:06', null, null, null, '1', 'test ', '1610005', 'e10adc3949ba59abbe56e057f20f883e', '123456', '杨琳', '0', '0', '2016-10-12', 'test', 'tes ', 'test ', '2016-10-12', '440921199310103695', '13068501300', 'test@qqc.om', 'test', '06688631230', '18813975056', null, '计算机学院', '2016', '1603', '5cda1fe1-5e96-42ae-94b3-0f42295c421b');

-- ----------------------------
-- Table structure for sys_学生考试
-- ----------------------------
DROP TABLE IF EXISTS `sys_学生考试`;
CREATE TABLE `sys_学生考试` (
  `ID` varchar(40) NOT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `TEST_RECORD_ID` varchar(40) DEFAULT NULL,
  `TEST_NAME` varchar(20) DEFAULT NULL,
  `TEST_CODE` varchar(20) DEFAULT NULL,
  `TEST_LOCATION` varchar(100) DEFAULT NULL,
  `TEST_NUMBER` varchar(20) DEFAULT NULL,
  `TEST_SCORE` double(3,0) DEFAULT NULL,
  `IS_PASS` tinyint(1) DEFAULT NULL,
  `IS_PAYMENT` tinyint(1) DEFAULT NULL,
  `IS_REGIS_SUCCESS` tinyint(1) DEFAULT NULL,
  `STUDENT_ID` varchar(40) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_学生考试
-- ----------------------------
INSERT INTO `sys_学生考试` VALUES ('7022c837-f0ae-455c-b303-2e1df88f0ba5', '1', '85357dbc-f28c-439a-b99a-6ae0e5aa0a9e', '全国计算机等级考试(java)', '12016002', null, '201623151137131', '96', '1', '1', '1', 'e4faced0-6344-4aa3-a078-024ac09ff396', null);
INSERT INTO `sys_学生考试` VALUES ('b41c3c9e-fe55-4322-aa10-9682c0993933', '1', '288a9e49-571b-4711-9d0e-2e6258dffafc', '英语四级考试', '12016001', null, '201623150358311', '80', '1', '1', '1', 'e4faced0-6344-4aa3-a078-024ac09ff396', null);

-- ----------------------------
-- Table structure for sys_学生选课
-- ----------------------------
DROP TABLE IF EXISTS `sys_学生选课`;
CREATE TABLE `sys_学生选课` (
  `SELECT_SUBJECT_ID` varchar(40) DEFAULT NULL,
  `STUDENT_ID` varchar(40) DEFAULT NULL,
  `ID` varchar(40) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_学生选课
-- ----------------------------
INSERT INTO `sys_学生选课` VALUES ('da461019-8aaf-422c-8f1f-8840279f0fe1', 'e4faced0-6344-4aa3-a078-024ac09ff396', '522fade5-824a-4ad1-be90-316d5e55f7fd');

-- ----------------------------
-- Table structure for sys_学院信息
-- ----------------------------
DROP TABLE IF EXISTS `sys_学院信息`;
CREATE TABLE `sys_学院信息` (
  `ID` varchar(40) NOT NULL,
  `CREATE_TIME` varchar(30) DEFAULT NULL,
  `UPDATE_TIME` varchar(30) DEFAULT NULL,
  `OPERATOR_ID` varchar(40) DEFAULT NULL,
  `OPERATOR` varchar(20) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `CODE` varchar(10) DEFAULT NULL,
  `HEAD` varchar(20) DEFAULT NULL,
  `HEAD_NUM` varchar(10) DEFAULT NULL,
  `HEAD_MOBILE` varchar(15) DEFAULT NULL,
  `OFFIC_TEL` varchar(20) DEFAULT NULL,
  `OFFIC_ADDRESS` varchar(20) DEFAULT NULL,
  `MAN_AMOUNT` int(3) DEFAULT NULL,
  `STUDENT_AMOUNT` int(3) DEFAULT NULL,
  `TEACHER_AMOUNT` int(3) DEFAULT NULL,
  `CLASS_AMOUNT` int(3) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_学院信息
-- ----------------------------
INSERT INTO `sys_学院信息` VALUES ('183d68d4-fab1-4d77-ad80-9e7273400c29', '2016-10-12 21:46:36', null, null, null, '1', 'test', '物理学院', '116002', 'system', null, '13068507963', '06688631123', 'test', null, null, null, '2');
INSERT INTO `sys_学院信息` VALUES ('1ec183ac-f960-4623-98fe-334c04e88413', '2016-10-12 21:48:20', null, null, null, '1', 'test', '计算机学院', '116004', 'manager', null, '13068594598', '06688637456', 'test', null, null, null, '2');
INSERT INTO `sys_学院信息` VALUES ('232d42ee-fe90-4389-aca6-fcdbdbda0b93', '2016-10-13 17:08:17', null, null, null, '1', 'test', '文学院', '116005', 'test', null, '13068501300', '06688631179', 'test', null, null, null, null);
INSERT INTO `sys_学院信息` VALUES ('51af9f87-526c-460e-af05-17709643f954', '2016-10-13 17:09:03', null, null, null, '1', 'test', '外国语学院', '116006', 'test123', null, '18813975602', '0668863170', 'test', null, null, null, null);
INSERT INTO `sys_学院信息` VALUES ('90979cc2-6bb8-41a7-8122-6160b4cf9604', '2016-10-12 21:47:26', null, null, null, '1', 'test', '化学学院', '116003', 'admin', null, '18813975059', '06688637147', 'test', null, null, null, '2');
INSERT INTO `sys_学院信息` VALUES ('cce3ef78-5cdf-4bf8-bf4e-df42e3d025ea', '2016-10-12 21:45:52', '2016-10-12 21:48:52', null, null, '1', 'test ok', '数学学院', '116001', 'test', null, '13068501300', '0668861111', 'test', null, null, null, '3');

-- ----------------------------
-- Table structure for sys_年级学年
-- ----------------------------
DROP TABLE IF EXISTS `sys_年级学年`;
CREATE TABLE `sys_年级学年` (
  `ID` varchar(40) NOT NULL,
  `GRADE` varchar(20) DEFAULT NULL,
  `SCHOOL_YEAR` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_年级学年
-- ----------------------------
INSERT INTO `sys_年级学年` VALUES ('048805d9-f14c-402d-acf6-3ccacc7b302a', '2016', '2016-2017');
INSERT INTO `sys_年级学年` VALUES ('25529003-a296-4e84-8208-faaebce947a3', '2016', '2017-2018');
INSERT INTO `sys_年级学年` VALUES ('a54ba300-70ef-4968-8512-6f701fe50e43', '2016', '2018-2019');
INSERT INTO `sys_年级学年` VALUES ('e1481765-a759-47df-9430-0ad70b0b8360', '2016', '2019-2020');

-- ----------------------------
-- Table structure for sys_意见回复
-- ----------------------------
DROP TABLE IF EXISTS `sys_意见回复`;
CREATE TABLE `sys_意见回复` (
  `ID` varchar(40) NOT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `OPERATOR_ID` varchar(40) DEFAULT NULL,
  `OPERATOR` varchar(20) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `CONTEXT` varchar(255) DEFAULT NULL,
  `REPLY_TIME` datetime DEFAULT NULL,
  `REPLY_MAN` varchar(255) DEFAULT NULL,
  `REPLY_MAN_NUM` int(11) DEFAULT NULL,
  `REPLY_MAN_MOBILE` varchar(255) DEFAULT NULL,
  `OPINION_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_意见回复
-- ----------------------------

-- ----------------------------
-- Table structure for sys_意见投递
-- ----------------------------
DROP TABLE IF EXISTS `sys_意见投递`;
CREATE TABLE `sys_意见投递` (
  `ID` varchar(40) NOT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `OPERATOR_ID` varchar(40) DEFAULT NULL,
  `OPERATOR` varchar(20) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `CONTEXT` varchar(500) DEFAULT NULL,
  `SEND_TIME` datetime DEFAULT NULL,
  `AUTHOR` varchar(20) DEFAULT NULL,
  `AUTHOR_NUM` varchar(11) DEFAULT NULL,
  `IS_ANONYMOUS` tinyint(1) DEFAULT NULL,
  `AUTHOR_MOBILE` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_意见投递
-- ----------------------------

-- ----------------------------
-- Table structure for sys_成绩登记
-- ----------------------------
DROP TABLE IF EXISTS `sys_成绩登记`;
CREATE TABLE `sys_成绩登记` (
  `ID` varchar(40) NOT NULL,
  `CREATE_TIME` varchar(20) DEFAULT NULL,
  `UPDATE_TIME` varchar(20) DEFAULT NULL,
  `OPERATOR_ID` varchar(40) DEFAULT NULL,
  `OPERATOR` varchar(20) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `SCHOOL_YEAR` varchar(30) DEFAULT NULL,
  `TERM` int(1) DEFAULT NULL,
  `SUBJECT_ID` varchar(40) DEFAULT NULL,
  `SUBJECT_VOLUMES` varchar(10) DEFAULT NULL,
  `SUBJECT_NAME` varchar(20) DEFAULT NULL,
  `SUBJECT_CODE` varchar(11) DEFAULT NULL,
  `SUBJECT_ISREQUIRED` tinyint(1) DEFAULT NULL,
  `SUBJECT_CREDITS` double(2,0) DEFAULT NULL,
  `COMMON_SCORE` double(3,0) DEFAULT NULL,
  `TEST_SCORE` double(3,0) DEFAULT NULL,
  `TOTAL_SCORE` double(3,0) DEFAULT NULL,
  `POINT` decimal(3,2) DEFAULT NULL,
  `IS_REBUILD` tinyint(1) DEFAULT NULL,
  `REBUILD_SCORE` double(3,0) DEFAULT NULL,
  `STUDENT_NUM` varchar(11) DEFAULT NULL,
  `STUDENT_ID` varchar(40) DEFAULT NULL,
  `TEACHER_NUM` varchar(11) DEFAULT NULL,
  `TEACHER_ID` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_成绩登记
-- ----------------------------
INSERT INTO `sys_成绩登记` VALUES ('25ddda60-cf9a-4c08-94e3-75a658996830', '2016-10-15 23:30:17', null, null, null, '1', null, '2016-2017', '1', null, '1', '高等代数', 'A1002', '1', '4', '60', '60', '60', '1.00', '0', null, null, 'e4faced0-6344-4aa3-a078-024ac09ff396', null, null);
INSERT INTO `sys_成绩登记` VALUES ('3047b7ee-d185-4fc5-8150-9ab47d34df1e', '2016-10-15 23:23:31', null, null, null, '1', null, '2017-2018', '1', null, '1', '数值分析', 'A1001', '1', '5', '60', '60', '60', '1.00', '0', null, null, 'e4faced0-6344-4aa3-a078-024ac09ff396', null, null);
INSERT INTO `sys_成绩登记` VALUES ('845bc6ba-856a-4319-a9b5-526d961c2977', '2016-10-15 23:24:58', '2016-10-15 23:27:54', null, null, '1', null, '2016-2017', '1', null, '1', '物理基础应用', 'A1010', '1', '3', '80', '20', '38', '1.00', '1', '80', null, 'e4faced0-6344-4aa3-a078-024ac09ff396', null, null);
INSERT INTO `sys_成绩登记` VALUES ('9c593517-be02-44d8-84e5-dfd49454b2c2', '2016-10-15 23:22:59', null, null, null, '1', null, '2016-2017', '2', null, '1', '高等代数', 'A1002', '1', '4', '80', '80', '80', '3.00', '0', null, null, 'e4faced0-6344-4aa3-a078-024ac09ff396', null, null);
INSERT INTO `sys_成绩登记` VALUES ('d70dbc37-09ef-4ae5-8d2f-cd9f1c28248f', '2016-10-15 23:23:21', null, null, null, '1', null, '2017-2018', '2', null, '1', '英语听说', 'A1004', '1', '4', '70', '70', '70', '2.00', '0', null, null, 'e4faced0-6344-4aa3-a078-024ac09ff396', null, null);
INSERT INTO `sys_成绩登记` VALUES ('fe5a994c-b289-47e6-ab20-feb0ff8ebe09', '2016-10-15 23:22:49', null, null, null, '1', null, '2016-2017', '1', null, '1', '数学教学教程', 'A1016', '1', '5', '90', '90', '90', '4.00', '0', null, null, 'e4faced0-6344-4aa3-a078-024ac09ff396', null, null);

-- ----------------------------
-- Table structure for sys_成绩统计
-- ----------------------------
DROP TABLE IF EXISTS `sys_成绩统计`;
CREATE TABLE `sys_成绩统计` (
  `ID` varchar(40) NOT NULL,
  `CREATE_TIME` varchar(20) DEFAULT NULL,
  `UPDATE_TIME` varchar(20) DEFAULT NULL,
  `OPERATOR_ID` varchar(40) DEFAULT NULL,
  `OPERATOR` varchar(20) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `SCHOOL_YEAR` varchar(10) DEFAULT NULL,
  `TERM` int(1) DEFAULT NULL,
  `REQUEST_CREDITS` double(3,0) DEFAULT NULL,
  `REQUEST_AVERAGE_POINT` double(3,0) DEFAULT NULL,
  `TOTAL_CREADITS` double(3,0) DEFAULT NULL,
  `TOTAL_POINT` double(5,2) DEFAULT NULL,
  `AVERAGE_POINT` double(3,2) DEFAULT NULL,
  `STUDENT_NUM` varchar(11) DEFAULT NULL,
  `STUDENT_ID` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_成绩统计
-- ----------------------------
INSERT INTO `sys_成绩统计` VALUES ('16fca297-297b-4132-b214-0e655696a2c4', null, null, null, null, '1', null, '2017-2018', '1', null, null, '5', '1.00', '1.00', null, 'e4faced0-6344-4aa3-a078-024ac09ff396');
INSERT INTO `sys_成绩统计` VALUES ('3589a4aa-47a6-4b43-9db5-524fb89ed315', null, null, null, null, '1', null, '2016-2017', '1', null, null, '12', '6.00', '2.00', null, 'e4faced0-6344-4aa3-a078-024ac09ff396');
INSERT INTO `sys_成绩统计` VALUES ('3d8dd92e-7ca9-404c-87c5-2410c0fc647a', null, null, null, null, '1', null, '2016-2017', '2', null, null, '4', '3.00', '3.00', null, 'e4faced0-6344-4aa3-a078-024ac09ff396');
INSERT INTO `sys_成绩统计` VALUES ('688ef98f-23da-4551-828c-6b15f1f0c714', null, null, null, null, '1', null, '2017-2018', '2', null, null, '4', '2.00', '2.00', null, 'e4faced0-6344-4aa3-a078-024ac09ff396');
INSERT INTO `sys_成绩统计` VALUES ('6a1788cd-3f04-494d-b356-35ef70d8a001', null, null, null, null, '1', null, '2016-2017', null, null, null, '16', '9.00', '2.25', null, 'e4faced0-6344-4aa3-a078-024ac09ff396');
INSERT INTO `sys_成绩统计` VALUES ('91bae853-8c0e-489e-9d3d-b1dad55d91b6', null, null, null, null, '1', null, '2017-2018', null, null, null, '9', '3.00', '1.50', null, 'e4faced0-6344-4aa3-a078-024ac09ff396');
INSERT INTO `sys_成绩统计` VALUES ('bc83bf4b-96b0-494e-bdb9-019e2eea5f9a', null, null, null, null, '1', null, null, null, null, null, '25', '12.00', '2.00', null, 'e4faced0-6344-4aa3-a078-024ac09ff396');

-- ----------------------------
-- Table structure for sys_教学地点
-- ----------------------------
DROP TABLE IF EXISTS `sys_教学地点`;
CREATE TABLE `sys_教学地点` (
  `ID` varchar(40) NOT NULL,
  `CREATE_TIME` varchar(20) DEFAULT NULL,
  `UPDATE_TIME` varchar(20) DEFAULT NULL,
  `OPERATOR_ID` varchar(40) DEFAULT NULL,
  `OPERATOR` varchar(20) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `BUILDING` varchar(20) DEFAULT NULL,
  `ROOM_NUMBER` varchar(10) DEFAULT NULL,
  `IS_OFFIC` tinyint(1) DEFAULT NULL,
  `CAPACITY` int(3) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_教学地点
-- ----------------------------
INSERT INTO `sys_教学地点` VALUES ('0529d0f5-639a-4e1b-b7e3-70218d1ccff0', '2016-10-12 23:35:57', null, null, null, '1', 'test', '志军实验大楼', '106', '0', '100');
INSERT INTO `sys_教学地点` VALUES ('5908a012-e11c-4346-99d9-d8011081322b', '2016-10-12 23:37:28', '2016-10-13 21:51:04', null, null, '1', 'test', '红琼大楼', '100', '0', '120');
INSERT INTO `sys_教学地点` VALUES ('5b5ca6af-5acd-496b-ac13-524b9971658e', '2016-10-12 23:34:46', null, null, null, '1', 'test', '红琼大楼', '403', '0', '60');
INSERT INTO `sys_教学地点` VALUES ('75e46681-dca0-472f-8e67-afa28f266b7f', '2016-10-12 23:32:45', null, null, null, '1', 'test', '万威大楼', 'A103', '1', '30');
INSERT INTO `sys_教学地点` VALUES ('762eee83-c58a-4eb1-9a3c-d8960615f7d3', '2016-10-12 23:35:34', null, null, null, '1', 'test', '志军实验大楼', '601', '1', '120');
INSERT INTO `sys_教学地点` VALUES ('943d63e7-51fe-4c1d-92ad-16a84c343867', '2016-10-12 23:36:30', null, null, null, '1', 'test', '志军实验大楼', '203', '0', '80');
INSERT INTO `sys_教学地点` VALUES ('a4b54a0f-2ad2-4bad-b63c-149dd3f7d285', '2016-10-12 23:33:12', null, null, null, '1', 'test', '万威大楼', 'B202', '0', '60');
INSERT INTO `sys_教学地点` VALUES ('b8c46a6d-a534-48b5-a2c0-804d5cd7a127', '2016-10-12 23:33:35', null, null, null, '1', 'test', '万威大楼', 'B203', '0', '100');
INSERT INTO `sys_教学地点` VALUES ('ea1ed7ff-b38b-4411-b8b3-6e6847c50af8', '2016-10-12 23:34:26', null, null, null, '1', 'test', '红琼大楼', '401', '0', '100');
INSERT INTO `sys_教学地点` VALUES ('f2eef8a9-36da-4904-b750-9cf1cd319fbf', '2016-10-12 23:31:58', '2016-10-12 23:32:14', null, null, '1', 'TEST ', '万威大楼', 'A102', '0', '120');
INSERT INTO `sys_教学地点` VALUES ('f987e0c8-501f-4629-ac48-9a332d52cfaa', '2016-10-12 23:31:30', null, null, null, '1', 'test', '万威大楼', 'A101', '0', '120');

-- ----------------------------
-- Table structure for sys_教工信息
-- ----------------------------
DROP TABLE IF EXISTS `sys_教工信息`;
CREATE TABLE `sys_教工信息` (
  `ID` varchar(40) NOT NULL,
  `CREATE_TIME` varchar(30) DEFAULT NULL,
  `UPDATE_TIME` varchar(30) DEFAULT NULL,
  `OPERATOR_ID` varchar(40) DEFAULT NULL,
  `OPERATOR` varchar(20) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `T_NUMBER` varchar(11) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `PASSWORD2` varchar(16) DEFAULT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `SEX` tinyint(1) DEFAULT NULL,
  `AGE` int(2) DEFAULT NULL,
  `BIRTH` varchar(30) DEFAULT NULL,
  `NATIONAL` varchar(10) DEFAULT NULL,
  `NATIVE_PLACE` varchar(50) DEFAULT NULL,
  `ACADEMIC_DEGREE` varchar(10) DEFAULT NULL,
  `SCHOOL_OF_GRADUATION` varchar(50) DEFAULT NULL,
  `JOIN_DATE` varchar(30) DEFAULT NULL,
  `ID_CARD` varchar(20) DEFAULT NULL,
  `MOBILE` varchar(15) DEFAULT NULL,
  `EMAIL` varchar(20) DEFAULT NULL,
  `HOME_ADDRESS` varchar(50) DEFAULT NULL,
  `HOME_TEL` varchar(20) DEFAULT NULL,
  `HEAD_IMAGE` varchar(100) DEFAULT NULL,
  `ACADEMY_NAME` varchar(20) DEFAULT NULL,
  `ACADEMY_ID` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_教工信息
-- ----------------------------
INSERT INTO `sys_教工信息` VALUES ('1950e6cd-e3f7-4c5b-853d-013e946168d2', '2016-10-12 21:55:24', null, null, null, '1', 'test', '1620004', 'e10adc3949ba59abbe56e057f20f883e', '123456', '赵欣颖', '0', '0', '2016-10-12', 'test', 'test', '硕士', 'test', '2016-10-12', '449123896547851', '13068952631', '99@qq.com', 'test', '06688631179', null, '物理学院', '183d68d4-fab1-4d77-ad80-9e7273400c29');
INSERT INTO `sys_教工信息` VALUES ('27119808-3624-41fc-ac90-15d7fb77b01f', '2016-10-12 22:00:44', null, null, null, '1', 'test', '1620008', 'e10adc3949ba59abbe56e057f20f883e', '123456', '陈俊涛', '1', '0', '2016-10-12', 'test', 'testtest', '博士', 'test', '2016-10-12', '440921236987445', '13068501203', 'test@qq.com', 'test', '06668123456', null, '化学学院', '90979cc2-6bb8-41a7-8122-6160b4cf9604');
INSERT INTO `sys_教工信息` VALUES ('2875ac8d-ea97-448f-939b-1a557ee15b32', '2016-10-13 17:10:59', null, null, null, '1', 'test', '1620012', 'e10adc3949ba59abbe56e057f20f883e', '123456', '杨颖秀', '0', '0', '2016-10-13', 'test', 'test', '研究生', 'test', '2016-10-13', '440921199612345', '13068501300', 'test@qq.oc', 'test', '06688631179', null, '文学院', '232d42ee-fe90-4389-aca6-fcdbdbda0b93');
INSERT INTO `sys_教工信息` VALUES ('29663061-1c67-46bb-8215-742d3839d7f2', '2016-10-12 21:54:03', null, null, null, '1', 'test', '1620003', 'e10adc3949ba59abbe56e057f20f883e', '123456', '魏阳林', '1', '11', '2005-06-02', 'test', 'test', '博士', 'EST', '2016-10-12', '440456789235869', '18813975059', 'test@qq.com', 'test', '066886314478', null, '物理学院', '183d68d4-fab1-4d77-ad80-9e7273400c29');
INSERT INTO `sys_教工信息` VALUES ('55c28b76-9206-4d4f-9ee5-430474fa7eca', '2016-10-13 16:45:10', null, null, null, '1', 'test', '1620009', 'e10adc3949ba59abbe56e057f20f883e', '123456', '张忠霖', '1', '0', '2016-10-13', 'test', 'test', '硕士', 'test', '2016-10-13', '440921199612036', '13068501600', 'test@qq.com', 'test', '06688631795', null, '物理学院', '183d68d4-fab1-4d77-ad80-9e7273400c29');
INSERT INTO `sys_教工信息` VALUES ('742d9e11-cce8-4b47-abb5-15d9f3217168', '2016-10-12 21:59:08', null, null, null, '1', 'test', '1620007', 'e10adc3949ba59abbe56e057f20f883e', '123456', '曾颖妍', '0', '0', '2016-10-12', 'test', 'test', '教授', 'EST', '2016-10-12', '440912345678901', '18813698540', 'test@qq.com', 'test', '06688631248', null, '化学学院', '90979cc2-6bb8-41a7-8122-6160b4cf9604');
INSERT INTO `sys_教工信息` VALUES ('876726ce-883a-43b3-9c1e-a7fbd4385533', '2016-10-12 21:51:04', '2016-10-12 22:01:29', null, null, '1', 'test', '1620001', 'e10adc3949ba59abbe56e057f20f883e', '123456', '陈慧恩', '0', '29', '1987-06-03', 'test', 'test', '硕士', 'test', '2016-10-12', '440921199645689', '13068501990', 'test@qq.com', 'test', '06688631189', null, '数学学院', 'cce3ef78-5cdf-4bf8-bf4e-df42e3d025ea');
INSERT INTO `sys_教工信息` VALUES ('a572047a-3521-4b46-ac98-056a784e3990', '2016-10-12 21:57:51', null, null, null, '1', 'test', '1620006', 'e10adc3949ba59abbe56e057f20f883e', '123456', '杨林伟', '1', '0', '2016-10-12', 'test', 'test', '博士', 'test', '2016-10-12', '440921199310103569', '13068501933', 'test@qq.com', 'test', '066886317895', null, '计算机学院', '1ec183ac-f960-4623-98fe-334c04e88413');
INSERT INTO `sys_教工信息` VALUES ('b325f73f-b7f9-49e9-b3b3-53a3a1e97577', '2016-10-13 17:12:17', null, null, null, '1', 'test', '1620011', 'e10adc3949ba59abbe56e057f20f883e', '123456', '潘晓霞', '0', '0', '2016-10-11', 'test', 'test', '研究生', 'EST', '2016-10-13', '440921199612345', '15627507540', 'test@qq.con', 'etrest', '006688631178', null, '外国语学院', '51af9f87-526c-460e-af05-17709643f954');
INSERT INTO `sys_教工信息` VALUES ('d56feca9-6848-4dbc-9a5f-cf0d8c3c8110', '2016-10-12 21:56:31', null, null, null, '1', 'test', '1620005', 'e10adc3949ba59abbe56e057f20f883e', '123456', '胡信东', '1', '0', '2016-10-12', 'test', 'test', '研究生', 'test', '2016-10-12', '447123456789012', '18645269120', 'test@qq.com', 'test', '0668896123', null, '计算机学院', '1ec183ac-f960-4623-98fe-334c04e88413');
INSERT INTO `sys_教工信息` VALUES ('df40a1ff-0f0b-4991-af1d-5ac3e13090e3', '2016-10-13 21:20:13', null, null, null, '1', 'test', '1620013', 'e10adc3949ba59abbe56e057f20f883e', '123456', '吴丽艳', '0', '0', '2016-10-13', 'test', 'test', '博士', 'test', '2016-10-13', '440921189603256', '13068501300', 'test@qq.com', 'test', '0668896314', null, '数学学院', 'cce3ef78-5cdf-4bf8-bf4e-df42e3d025ea');
INSERT INTO `sys_教工信息` VALUES ('f4acdac6-7206-41c7-abd2-4d4210147be3', '2016-10-13 16:46:31', null, null, null, '1', 'test', '1620010', 'e10adc3949ba59abbe56e057f20f883e', '123456', '何紫茵', '0', '0', '2016-10-13', 'test', 'test ', '研究生', 'test', '2016-10-13', '440962123587956', '13068501308', 'test@qq.com', 'test', '06688631179', null, '计算机学院', '1ec183ac-f960-4623-98fe-334c04e88413');
INSERT INTO `sys_教工信息` VALUES ('fd98ef33-ca1c-401a-8865-f6636ddcde85', '2016-10-12 21:52:39', '2016-10-14 22:28:23', null, null, '1', 'test ok', '1620002', 'e10adc3949ba59abbe56e057f20f883e', '123456', '林志阳', '1', '19', '1997-02-28', 'test ok', 'test', '教授', 'test', '2016-10-12', '449625588888888', '13068501300', 'test@qq.com', 'test', '06688631179', null, '数学学院', 'cce3ef78-5cdf-4bf8-bf4e-df42e3d025ea');

-- ----------------------------
-- Table structure for sys_数据字典
-- ----------------------------
DROP TABLE IF EXISTS `sys_数据字典`;
CREATE TABLE `sys_数据字典` (
  `ID` varchar(40) NOT NULL,
  `CREATE_TIME` varchar(30) DEFAULT NULL,
  `UPDATE_TIME` varchar(30) DEFAULT NULL,
  `OPERATOR_ID` varchar(40) DEFAULT NULL,
  `OPERATOR` varchar(20) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `TYPE` varchar(20) DEFAULT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `VALUE` varchar(20) DEFAULT NULL,
  `IS_EDIT` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_数据字典
-- ----------------------------
INSERT INTO `sys_数据字典` VALUES ('0b4012f1-cf18-495b-b648-116ad9007604', '2016-10-13 16:25:09', null, null, null, '1', 'test', 'category', '法学', '法学', '1');
INSERT INTO `sys_数据字典` VALUES ('0d41af1c-e307-4065-9312-a8bf54b1c214', '2016-09-16 15:55:16', null, null, null, '1', '备注文本300字以内', 'term', '2', '2', '1');
INSERT INTO `sys_数据字典` VALUES ('1cf7bd71-c182-40a6-93b0-658ea7ff3bdd', '2016-09-22 22:18:09', null, null, null, '1', 'test', 'category', '人文理学', ' 人文理学', '1');
INSERT INTO `sys_数据字典` VALUES ('1f213655-0ba9-4ccd-b3dc-a2ab032f01d9', '2016-09-16 15:55:04', null, null, null, '1', '备注文本300字以内', 'term', '1', '1', '1');
INSERT INTO `sys_数据字典` VALUES ('28d972ff-8e5f-49c3-9b71-2c1099078c5e', '2016-09-29 17:07:08', null, null, null, '1', '备注文本300字以内', 'sendStatus', '已过期', '2', '1');
INSERT INTO `sys_数据字典` VALUES ('29ce0856-660f-4580-8516-030de2e4d18f', '2016-09-16 15:54:28', null, null, null, '1', '备注文本300字以内', 'term', '不限制', ' ', '1');
INSERT INTO `sys_数据字典` VALUES ('404569a9-33ef-4b4c-a377-83437a1a9178', '2016-10-13 16:24:42', null, null, null, '1', 'test', 'category', '民族学', '民族学', '1');
INSERT INTO `sys_数据字典` VALUES ('661de831-4d2a-42bd-aee7-753d564b6e7f', '2016-09-24 10:44:01', '2016-09-24 15:35:13', null, null, '1', '备注文本300字以内', 'scoreScale', 'required', '7:3', '1');
INSERT INTO `sys_数据字典` VALUES ('78f4877a-643c-4962-9272-7a64c0ecefaa', '2016-09-22 22:19:28', null, null, null, '1', '备注文本300字以内', 'category', '自然科学', ' 自然科学', '1');
INSERT INTO `sys_数据字典` VALUES ('a3e82bfb-486e-4e2b-aea1-7c06a0a5f1a1', '2016-09-17 09:21:44', '2016-10-13 16:21:39', null, null, '1', '备注文本300字以内', 'category', '理学', '理学', '1');
INSERT INTO `sys_数据字典` VALUES ('acbdabf8-52bd-4be0-bf75-c37104f52fa4', '2016-09-18 23:20:21', '2016-10-13 16:22:14', null, null, '1', '备注文本300字以内', 'category', '语言学', ' 语言学', '1');
INSERT INTO `sys_数据字典` VALUES ('bc0fe42d-a160-43a6-bb3e-1fda4ff77753', '2016-09-24 10:45:45', null, null, null, '1', '备注文本300字以内', 'scoreScale', 'common', '6:4', '1');
INSERT INTO `sys_数据字典` VALUES ('bdd62c79-3d9b-4fd4-98f5-926387cc59c5', '2016-09-27 21:45:59', null, null, null, '1', '备注文本300字以内', 'grade', '2016', '2016', '1');
INSERT INTO `sys_数据字典` VALUES ('cc9456f4-e2ea-41eb-897b-8907acf75e81', '2016-09-29 17:06:19', null, null, null, '1', '备注文本300字以内', 'sendStatus', '未发送', '0', '1');
INSERT INTO `sys_数据字典` VALUES ('ea05d82d-d188-48f0-a54c-32c7d26377d3', '2016-09-16 11:00:48', null, null, null, '1', 'test', 'grade', '不限制', '', '1');
INSERT INTO `sys_数据字典` VALUES ('f14602e4-d141-4554-a39b-349a173d7454', '2016-09-29 17:06:45', null, null, null, '1', '备注文本300字以内', 'sendStatus', '已发送', '1', '1');

-- ----------------------------
-- Table structure for sys_权限信息
-- ----------------------------
DROP TABLE IF EXISTS `sys_权限信息`;
CREATE TABLE `sys_权限信息` (
  `ID` varchar(40) NOT NULL,
  `CREATE_TIME` varchar(20) DEFAULT NULL,
  `UPDATE_TIME` varchar(20) DEFAULT NULL,
  `OPERATOR_ID` varchar(40) DEFAULT NULL,
  `OPERATOR` varchar(20) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `PERM_NAME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_权限信息
-- ----------------------------
INSERT INTO `sys_权限信息` VALUES ('a520ad45-916d-4cd3-a7be-0e5c9ca6a335', '2016-10-19 23:27:23', null, null, null, '1', '', 'ADMIN:DELETE');
INSERT INTO `sys_权限信息` VALUES ('ad9bacae-0f11-4904-8069-aebe245f3a01', '2016-10-19 23:27:04', null, null, null, '1', '', 'ADMIN:CREATE');
INSERT INTO `sys_权限信息` VALUES ('bae84e1f-5923-4e0d-8548-76b7a1dae764', '2016-10-19 23:27:53', null, null, null, '1', '', 'ADMIN:EDIT');
INSERT INTO `sys_权限信息` VALUES ('c5e7f753-a56e-4155-b713-df182462818b', '2016-10-19 23:29:11', null, null, null, '1', '', 'ADMIN:PAGE');
INSERT INTO `sys_权限信息` VALUES ('f87bf03a-5ee6-42d7-a676-9dae58fea636', '2016-10-19 23:29:51', null, null, null, '1', '', 'ADMIN:QUERY');

-- ----------------------------
-- Table structure for sys_校务消息
-- ----------------------------
DROP TABLE IF EXISTS `sys_校务消息`;
CREATE TABLE `sys_校务消息` (
  `ID` varchar(40) NOT NULL,
  `CREATE_TIME` varchar(20) DEFAULT NULL,
  `UPDATE_TIME` varchar(20) DEFAULT NULL,
  `OPERATOR_ID` varchar(40) DEFAULT NULL,
  `OPERATOR` varchar(20) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `TITLE` varchar(30) DEFAULT NULL,
  `CONTEXT` varchar(255) DEFAULT NULL,
  `SEND_TIME` varchar(20) DEFAULT NULL,
  `AUTHOR_ID` varchar(40) DEFAULT NULL,
  `AUTHOR` varchar(255) DEFAULT NULL,
  `AUTHOR_NUM` varchar(11) DEFAULT NULL,
  `OFFIC_ADDRESS` varchar(255) DEFAULT NULL,
  `VALID_TIME` varchar(0) DEFAULT NULL,
  `OFFIC_TEL` varchar(255) DEFAULT NULL,
  `SEND_STATUS` int(2) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_校务消息
-- ----------------------------
INSERT INTO `sys_校务消息` VALUES ('30943d8e-b54d-45dc-8136-4566f9b03405', '2016-10-14 23:18:28', '2016-10-14 23:18:57', null, null, '1', 'test', '考试报名开始', 'test', '2016-10-14 23:18:57', '706c73aa-4b76-44f1-b9eb-5dd9062087f3', '陈慧哦', '1601236', 'test', null, '06688631179', '1');

-- ----------------------------
-- Table structure for sys_毕业就业率
-- ----------------------------
DROP TABLE IF EXISTS `sys_毕业就业率`;
CREATE TABLE `sys_毕业就业率` (
  `ID` varchar(40) NOT NULL,
  `ACADEMY` varchar(20) DEFAULT NULL,
  `EMPLOYMENT_RATE` double(6,3) DEFAULT NULL,
  `SCHOO_YEAR` varchar(20) DEFAULT NULL,
  `GRADUATION_YEAR` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_毕业就业率
-- ----------------------------
INSERT INTO `sys_毕业就业率` VALUES ('1123465', '数学', '78.940', null, '2015');
INSERT INTO `sys_毕业就业率` VALUES ('2342325325', '物理', '75.890', null, '2015');
INSERT INTO `sys_毕业就业率` VALUES ('456789', '数学', '79.010', null, '2014');
INSERT INTO `sys_毕业就业率` VALUES ('555555555555555555555555588798', '数学', '80.060', '', '2016');
INSERT INTO `sys_毕业就业率` VALUES ('789456', '化学', '82.370', null, '2016');
INSERT INTO `sys_毕业就业率` VALUES ('789963147', '物理', '66.510', null, '2014');
INSERT INTO `sys_毕业就业率` VALUES ('sdfsfssfesfsfsfsfse849848', '物理', '79.260', null, '2016');

-- ----------------------------
-- Table structure for sys_班级_科目
-- ----------------------------
DROP TABLE IF EXISTS `sys_班级_科目`;
CREATE TABLE `sys_班级_科目` (
  `ID` varchar(40) NOT NULL,
  `CLASS_ID` varchar(40) DEFAULT NULL,
  `SUBJECT_ARRANGEMENT_ID` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_班级_科目
-- ----------------------------
INSERT INTO `sys_班级_科目` VALUES ('00dcbd09-4e5f-4195-919d-d3b0aa594ff0', 'a4b89d96-699c-4321-88b2-bca4d5fd2cdd', 'bc4c09a6-1a3d-4598-8475-79384110e1f6');
INSERT INTO `sys_班级_科目` VALUES ('01799be5-8e39-40cb-94bc-e04d913bcb0a', '6d04b565-7cf7-4310-9088-40a4e0a716c7', 'a56f6161-fff0-4339-b96d-1d431886a675');
INSERT INTO `sys_班级_科目` VALUES ('068f4937-4b6d-4209-8c85-206c47973d0f', 'a4b89d96-699c-4321-88b2-bca4d5fd2cdd', '181f7a23-678d-44e4-a5e0-8acafabd3d82');
INSERT INTO `sys_班级_科目` VALUES ('0fce84e8-ad77-49e4-9f25-ff2f9e962a57', '27ecde58-9cf3-4658-b5a1-2c5da4c30bf6', '8f5ea586-241f-4a8d-9093-9a25dc57b167');
INSERT INTO `sys_班级_科目` VALUES ('1049fadc-a959-46e9-9b1a-a13731e60542', 'c4da4786-d2b0-45c7-9db0-bcf4d5cbd1aa', '84128c81-4e0c-4ed5-9b04-f45d4d669072');
INSERT INTO `sys_班级_科目` VALUES ('14db4734-375f-4b45-a1ac-73818f5a6b37', '0c6a2691-1f6e-478d-ab8c-7fc5289bf331', '2c51b6e2-f4b2-4154-a1e8-890d39c5ac9c');
INSERT INTO `sys_班级_科目` VALUES ('1c5cf493-460a-4012-82b9-61d860be6410', '590cb58a-67c5-4135-91c5-c614922f5703', '63d87559-a738-4482-b8ed-d41ea4ec0e2e');
INSERT INTO `sys_班级_科目` VALUES ('262c38ce-89ec-4426-abf1-fe579b5ca827', '6d04b565-7cf7-4310-9088-40a4e0a716c7', '5098ce93-5042-472e-81cf-04d1f6583cfa');
INSERT INTO `sys_班级_科目` VALUES ('2b6fff6d-e78e-4fcc-9bc4-ed6e50945c06', '82879c7b-ce46-46fa-8ac6-4119658d5d35', 'f2f4aa00-8de9-41cd-876e-a6f26bdcaaa7');
INSERT INTO `sys_班级_科目` VALUES ('2c7e2e14-a91d-4b40-94a5-b2b07d448bbe', '590cb58a-67c5-4135-91c5-c614922f5703', '561ea925-3528-4b26-ba4b-4b492eeadfe8');
INSERT INTO `sys_班级_科目` VALUES ('2d1b145c-4cd2-4b5e-b7f9-4879998a696c', '45e438e9-2977-48c6-8353-3456b478b846', 'b40bdc56-7981-47ea-ade0-1ead03ee78a4');
INSERT INTO `sys_班级_科目` VALUES ('3ad2b8c2-695b-4dbb-ba0e-f150ed240977', '27ecde58-9cf3-4658-b5a1-2c5da4c30bf6', 'df7705a8-6ae9-4f58-9f58-a20d7ae77d57');
INSERT INTO `sys_班级_科目` VALUES ('3c438233-f659-4f7b-8463-be9e674e5ecc', '82879c7b-ce46-46fa-8ac6-4119658d5d35', 'ec41938e-d515-4726-88a6-d3f4c4538d35');
INSERT INTO `sys_班级_科目` VALUES ('3de55db1-5092-4bfc-b082-06ee34ac84ab', '0c6a2691-1f6e-478d-ab8c-7fc5289bf331', 'b15de941-5891-4469-b199-f29f3e7fd22f');
INSERT INTO `sys_班级_科目` VALUES ('3ea0663b-6059-41c5-930a-3723ff811c20', '45e438e9-2977-48c6-8353-3456b478b846', '6d5a0e9f-0337-449a-8586-42940f0587df');
INSERT INTO `sys_班级_科目` VALUES ('409f1f90-e613-46fa-b839-5c0afb8e3515', '5cda1fe1-5e96-42ae-94b3-0f42295c421b', '482c0a74-f68c-4a2d-9047-370fe28879de');
INSERT INTO `sys_班级_科目` VALUES ('48a906b5-1c1b-4935-8562-02240951dcbd', '82879c7b-ce46-46fa-8ac6-4119658d5d35', '65916e5b-fa58-43a2-987d-f54d8c3d017d');
INSERT INTO `sys_班级_科目` VALUES ('4a2a7b66-eb7e-4e87-8821-5cf1dc73f43f', '590cb58a-67c5-4135-91c5-c614922f5703', 'b63e42e5-67cb-492e-aba4-c72a80f3d41a');
INSERT INTO `sys_班级_科目` VALUES ('513957de-237e-48b2-a0d2-822b2dae7dba', '0c6a2691-1f6e-478d-ab8c-7fc5289bf331', '03841408-0d7d-4e6b-90bd-e86b01b78d18');
INSERT INTO `sys_班级_科目` VALUES ('52ac376d-ea19-4c39-b211-2b198a8349d7', '5cda1fe1-5e96-42ae-94b3-0f42295c421b', 'b07ac059-fcc1-4b8a-9306-d74a250fa5ce');
INSERT INTO `sys_班级_科目` VALUES ('55dc4519-651e-4d25-a856-b3045fba6ae6', '5cda1fe1-5e96-42ae-94b3-0f42295c421b', '99fdfd6a-2f2d-4208-a9fc-9d706b331e9e');
INSERT INTO `sys_班级_科目` VALUES ('5a57551e-dd79-41e3-8a93-854d202da158', '82879c7b-ce46-46fa-8ac6-4119658d5d35', '0b7b4969-5a86-42d7-b750-31886a42993e');
INSERT INTO `sys_班级_科目` VALUES ('5f80931a-9659-436f-aae9-956029d1b7d7', '0c6a2691-1f6e-478d-ab8c-7fc5289bf331', '5ffd42bc-26cc-4656-be79-63e66dd13fe8');
INSERT INTO `sys_班级_科目` VALUES ('63fa27b7-9ad4-4285-bf72-c60fedcd46f7', '45e438e9-2977-48c6-8353-3456b478b846', 'c77fc06f-bdfe-447e-8180-0e783bb50748');
INSERT INTO `sys_班级_科目` VALUES ('68654b37-ff48-4608-8b61-dff977b95e28', '45e438e9-2977-48c6-8353-3456b478b846', '46088357-c7fa-4ac1-848d-5d2a4def83eb');
INSERT INTO `sys_班级_科目` VALUES ('6c57ce38-dd40-4068-bab4-782e20f2445c', '27ecde58-9cf3-4658-b5a1-2c5da4c30bf6', '66d7d6fa-a503-4733-967a-2a61022591ed');
INSERT INTO `sys_班级_科目` VALUES ('6e4438c0-e9d2-40d9-a1e2-e7c0c417b23c', '82879c7b-ce46-46fa-8ac6-4119658d5d35', '4561b314-82b5-4552-ae19-3ad39744c89d');
INSERT INTO `sys_班级_科目` VALUES ('7b199098-9fcf-44ad-b661-033e8c3fb6ed', '590cb58a-67c5-4135-91c5-c614922f5703', '57628b76-03cc-4238-8992-25f93e19d56e');
INSERT INTO `sys_班级_科目` VALUES ('8725787d-ae65-45ff-93fd-ff3ea92ce976', '5cda1fe1-5e96-42ae-94b3-0f42295c421b', '7465ca58-43a6-4a9f-8c4d-e1601553f2e9');
INSERT INTO `sys_班级_科目` VALUES ('8ec70a10-56cd-4c05-9f15-458679643641', 'c4da4786-d2b0-45c7-9db0-bcf4d5cbd1aa', 'b9de566c-05a7-41f4-a2ab-cb401e79fdd0');
INSERT INTO `sys_班级_科目` VALUES ('9705b564-11be-4ead-98b5-4e53b8e7e8bd', '0c6a2691-1f6e-478d-ab8c-7fc5289bf331', 'ebc909e8-161a-4193-b099-7d4b546237de');
INSERT INTO `sys_班级_科目` VALUES ('9730b5d4-be16-447d-880b-267afa0f0bc6', '27ecde58-9cf3-4658-b5a1-2c5da4c30bf6', 'b12400e9-ad9a-4c51-959a-6b0d4879ca2d');
INSERT INTO `sys_班级_科目` VALUES ('98208d5d-aaff-4e90-a42d-c9f4c21446ec', '6d04b565-7cf7-4310-9088-40a4e0a716c7', '513c1dd7-6f14-4c71-8279-733357288798');
INSERT INTO `sys_班级_科目` VALUES ('9c1320ff-cd94-4302-a039-fa8ad9bbe4c6', 'c4da4786-d2b0-45c7-9db0-bcf4d5cbd1aa', 'c67d277b-e9e0-49de-9f01-a872ee7de57d');
INSERT INTO `sys_班级_科目` VALUES ('a1ae8678-5040-4aa9-a269-87cddc3539a8', 'a4b89d96-699c-4321-88b2-bca4d5fd2cdd', 'cad6b73d-276e-4d45-a4cb-8ec62c2711fe');
INSERT INTO `sys_班级_科目` VALUES ('ad157e99-e8ba-425c-815a-4780535750ab', '6d04b565-7cf7-4310-9088-40a4e0a716c7', '231de58e-a9e0-48cb-9069-85dec970dd21');
INSERT INTO `sys_班级_科目` VALUES ('b061ac3e-e333-467b-8f99-14cff0ed2391', '590cb58a-67c5-4135-91c5-c614922f5703', 'f75dcbdc-a8af-47ca-a64c-ce4fa9e6d4ab');
INSERT INTO `sys_班级_科目` VALUES ('c03eaca2-aaef-489e-b376-69725aface49', 'a4b89d96-699c-4321-88b2-bca4d5fd2cdd', '91a913be-d664-4c97-a745-46114f96ae88');
INSERT INTO `sys_班级_科目` VALUES ('cebb8f9a-ee35-42a9-bbbb-1b5292c42b39', 'c4da4786-d2b0-45c7-9db0-bcf4d5cbd1aa', '9d100e07-4c5e-484a-b7ad-ab2a52e06e1b');
INSERT INTO `sys_班级_科目` VALUES ('d098d046-0c8f-4da9-bc30-d7e1410e17e5', '6d04b565-7cf7-4310-9088-40a4e0a716c7', '24db0ba2-2833-4f46-bdce-83b8dd44d81d');
INSERT INTO `sys_班级_科目` VALUES ('d29588a4-9327-40d2-b956-76db429ba941', '82879c7b-ce46-46fa-8ac6-4119658d5d35', '156e9d21-d6a6-42b4-a9c1-099b9e52c96f');
INSERT INTO `sys_班级_科目` VALUES ('d3448d3b-d804-4485-99cd-8702d6857cf3', 'c4da4786-d2b0-45c7-9db0-bcf4d5cbd1aa', 'f2b2e144-ef36-43de-bf02-1a8f62eb43e0');
INSERT INTO `sys_班级_科目` VALUES ('dde74d52-2c35-4374-bff3-26f014b657aa', 'a4b89d96-699c-4321-88b2-bca4d5fd2cdd', 'd337e48c-150f-4849-a8b2-b91b148d22fd');
INSERT INTO `sys_班级_科目` VALUES ('e44f70bc-7b52-4d0a-8f2d-309b57f23f7f', '5cda1fe1-5e96-42ae-94b3-0f42295c421b', '7a1b2906-ac11-4e43-954b-deed3337e666');
INSERT INTO `sys_班级_科目` VALUES ('e895ebc9-48d9-46a6-86aa-5fc7836ca035', '45e438e9-2977-48c6-8353-3456b478b846', '6b914481-b9c5-4335-a34b-ad1d3b541e2b');
INSERT INTO `sys_班级_科目` VALUES ('eaed1739-4a11-4564-807f-d708f80b717e', '27ecde58-9cf3-4658-b5a1-2c5da4c30bf6', '87885c5b-ccbc-4d6d-bd3b-1f764e39ec73');
INSERT INTO `sys_班级_科目` VALUES ('faaca16e-5070-4b36-8cfd-4e6392811a7d', '82879c7b-ce46-46fa-8ac6-4119658d5d35', '2bdb4092-5363-4790-89da-508a87e8c28b');
INSERT INTO `sys_班级_科目` VALUES ('fb678de1-08a2-4820-9b68-2956e45e60e4', '82879c7b-ce46-46fa-8ac6-4119658d5d35', 'b98672b0-965a-4805-af81-94e013e29cc1');

-- ----------------------------
-- Table structure for sys_班级信息
-- ----------------------------
DROP TABLE IF EXISTS `sys_班级信息`;
CREATE TABLE `sys_班级信息` (
  `ID` varchar(40) NOT NULL,
  `CREATE_TIME` varchar(30) DEFAULT NULL,
  `UPDATE_TIME` varchar(30) DEFAULT NULL,
  `OPERATOR_ID` varchar(40) DEFAULT NULL,
  `OPERATOR` varchar(20) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `GRADE` varchar(10) DEFAULT NULL,
  `NUMBER` varchar(10) DEFAULT NULL,
  `NAME` varchar(10) DEFAULT NULL,
  `MAJOR_ID` varchar(40) DEFAULT NULL,
  `MAJOR_CODE` varchar(20) DEFAULT NULL,
  `MAJOR` varchar(20) DEFAULT NULL,
  `ACADEMIC_DEGREE` varchar(10) DEFAULT NULL,
  `ACADEMIC_YEAR` int(1) DEFAULT NULL,
  `CAPACITY` int(3) DEFAULT NULL,
  `HEAD` varchar(20) DEFAULT NULL,
  `HEAD_NUM` varchar(11) DEFAULT NULL,
  `HEAD_MOBILE` varchar(15) DEFAULT NULL,
  `ACADEMY_NAME` varchar(20) DEFAULT NULL,
  `ACADEMY_ID` varchar(40) DEFAULT NULL,
  `SYLLABUS_ID` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_班级信息
-- ----------------------------
INSERT INTO `sys_班级信息` VALUES ('0c6a2691-1f6e-478d-ab8c-7fc5289bf331', '2016-10-12 22:09:15', null, null, null, '1', 'test', '2016', '03', '1603', null, null, '数学统计', '本科', '4', '60', 'test', null, '18813465896', '数学学院', 'cce3ef78-5cdf-4bf8-bf4e-df42e3d025ea', null);
INSERT INTO `sys_班级信息` VALUES ('27ecde58-9cf3-4658-b5a1-2c5da4c30bf6', '2016-10-12 22:03:38', null, null, null, '1', 'test', '2016', '02', '1602', null, null, '物理师范', '本科', '4', '60', 'test', null, '13078945612', '物理学院', '183d68d4-fab1-4d77-ad80-9e7273400c29', null);
INSERT INTO `sys_班级信息` VALUES ('45e438e9-2977-48c6-8353-3456b478b846', '2016-10-12 22:08:38', null, null, null, '1', 'test', '2016', '02', '1602', null, null, '计算与信息科学', '本科', '4', '60', 'test', null, '13812345678', '数学学院', 'cce3ef78-5cdf-4bf8-bf4e-df42e3d025ea', null);
INSERT INTO `sys_班级信息` VALUES ('590cb58a-67c5-4135-91c5-c614922f5703', '2016-10-12 22:02:58', null, null, null, '1', 'test', '2016', '01', '1601', null, null, '电子信息', '本科', '4', '60', 'test', null, '13068501300', '物理学院', '183d68d4-fab1-4d77-ad80-9e7273400c29', null);
INSERT INTO `sys_班级信息` VALUES ('5cda1fe1-5e96-42ae-94b3-0f42295c421b', '2016-10-12 22:04:21', null, null, null, '1', 'test', '2016', '03', '1603', null, null, '软件工程', '本科', '4', '60', 'test', null, '18813975623', '计算机学院', '1ec183ac-f960-4623-98fe-334c04e88413', null);
INSERT INTO `sys_班级信息` VALUES ('6d04b565-7cf7-4310-9088-40a4e0a716c7', '2016-10-12 22:05:14', null, null, null, '1', 'test', '2016', '04', '1604', null, null, '计算机应用', '本科', '4', '60', 'test', null, '18813692540', '计算机学院', '1ec183ac-f960-4623-98fe-334c04e88413', null);
INSERT INTO `sys_班级信息` VALUES ('82879c7b-ce46-46fa-8ac6-4119658d5d35', '2016-10-12 22:07:48', null, null, null, '1', 'test', '2016', '01', '1601', null, null, '数学应用', '本科', '4', '60', 'test', null, '13068501300', '数学学院', 'cce3ef78-5cdf-4bf8-bf4e-df42e3d025ea', null);
INSERT INTO `sys_班级信息` VALUES ('a4b89d96-699c-4321-88b2-bca4d5fd2cdd', '2016-10-12 22:06:08', null, null, null, '1', 'test', '2016', '05', '1605', null, null, '化学应用', '本科', '4', '60', 'test', null, '13068501300', '化学学院', '90979cc2-6bb8-41a7-8122-6160b4cf9604', null);
INSERT INTO `sys_班级信息` VALUES ('c4da4786-d2b0-45c7-9db0-bcf4d5cbd1aa', '2016-10-12 22:07:00', null, null, null, '1', 'test', '2016', '06', '1606', null, null, '化工技术', '本科', '4', '60', 'test', null, '13216851236', '化学学院', '90979cc2-6bb8-41a7-8122-6160b4cf9604', null);

-- ----------------------------
-- Table structure for sys_用户角色
-- ----------------------------
DROP TABLE IF EXISTS `sys_用户角色`;
CREATE TABLE `sys_用户角色` (
  `ID` varchar(40) NOT NULL,
  `USER_ID` varchar(40) DEFAULT NULL,
  `ROLE_ID` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_用户角色
-- ----------------------------
INSERT INTO `sys_用户角色` VALUES ('537cea53-39c8-488a-9af0-496e725d1fc8', '706c73aa-4b76-44f1-b9eb-5dd9062087f3', '38efcfc4-9686-4c77-ba45-1e85db4a61ec');
INSERT INTO `sys_用户角色` VALUES ('aa0269a6-cbe9-4835-a2c7-b249d87e08c6', 'a1f43b50-8ad8-46b0-bb48-c2b40441b254', '4862f3be-0399-4231-a2ae-c4be0ad9fb65');
INSERT INTO `sys_用户角色` VALUES ('adb32143-56af-4325-8863-e8e2caf934d1', '3bc91b18-d34d-493c-9794-12933b325c93', '38efcfc4-9686-4c77-ba45-1e85db4a61ec');
INSERT INTO `sys_用户角色` VALUES ('d73cca1e-c174-4819-85c1-3076f7618ab7', '706c73aa-4b76-44f1-b9eb-5dd9062087f3', '70fa2c90-beb4-4ae1-ae49-4c92562d051d');
INSERT INTO `sys_用户角色` VALUES ('e46ca443-18ad-4a16-8174-65163d931167', 'c5b03332-9faa-4890-99d3-071e4e3975ee', '1193112d-8111-433c-9670-39bf5a2eefa8');

-- ----------------------------
-- Table structure for sys_科目安排
-- ----------------------------
DROP TABLE IF EXISTS `sys_科目安排`;
CREATE TABLE `sys_科目安排` (
  `ID` varchar(40) NOT NULL,
  `SCHOOL_YEAR` varchar(10) DEFAULT NULL,
  `TERM` varchar(255) DEFAULT NULL,
  `SUBJECT_ID` varchar(40) DEFAULT NULL,
  `SUBJECT_NAME` varchar(20) DEFAULT NULL,
  `SUBJECT_CODE` varchar(11) DEFAULT NULL,
  `SUBJECT_VOLUMES` varchar(10) DEFAULT NULL,
  `TEACHER_NUM` varchar(11) DEFAULT NULL,
  `TEACHER_NAME` varchar(20) DEFAULT NULL,
  `TEACHER_ID` varchar(40) DEFAULT NULL,
  `WEEK_TIMES` int(2) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_科目安排
-- ----------------------------
INSERT INTO `sys_科目安排` VALUES ('03841408-0d7d-4e6b-90bd-e86b01b78d18', '2016-2017', '1', 'c1c8bfd9-12aa-4ccc-a1e0-6903cc363251', '高等代数', 'A1002', '1', '1620013', '吴丽艳', 'df40a1ff-0f0b-4991-af1d-5ac3e13090e3', '2');
INSERT INTO `sys_科目安排` VALUES ('0b7b4969-5a86-42d7-b750-31886a42993e', '2017-2018', '2', '27e022f3-872b-4727-8167-41724c8425ae', '英语听说', 'A1004', '1', null, null, null, '2');
INSERT INTO `sys_科目安排` VALUES ('156e9d21-d6a6-42b4-a9c1-099b9e52c96f', '2016-2017', '1', '27e022f3-872b-4727-8167-41724c8425ae', '英语听说', 'A1004', '1', '1620011', '潘晓霞', 'b325f73f-b7f9-49e9-b3b3-53a3a1e97577', '1');
INSERT INTO `sys_科目安排` VALUES ('181f7a23-678d-44e4-a5e0-8acafabd3d82', '2016-2017', '1', 'bd9eb036-93c5-4583-9e43-b4c8a8a18052', '化学与生活', 'A1015', '1', '1620008', '陈俊涛', '27119808-3624-41fc-ac90-15d7fb77b01f', '1');
INSERT INTO `sys_科目安排` VALUES ('231de58e-a9e0-48cb-9069-85dec970dd21', '2016-2017', '1', 'c1c8bfd9-12aa-4ccc-a1e0-6903cc363251', '高等代数', 'A1002', '1', '1620002', '林志阳', 'fd98ef33-ca1c-401a-8865-f6636ddcde85', '1');
INSERT INTO `sys_科目安排` VALUES ('24db0ba2-2833-4f46-bdce-83b8dd44d81d', '2016-2017', '1', '27e022f3-872b-4727-8167-41724c8425ae', '英语听说', 'A1004', '1', '1620011', '潘晓霞', 'b325f73f-b7f9-49e9-b3b3-53a3a1e97577', '1');
INSERT INTO `sys_科目安排` VALUES ('2bdb4092-5363-4790-89da-508a87e8c28b', '2016-2017', '1', '198bc0ce-0f92-4ab5-8d1b-906b7299ef96', '物理基础应用', 'A1010', '1', '1620004', '赵欣颖', '1950e6cd-e3f7-4c5b-853d-013e946168d2', '1');
INSERT INTO `sys_科目安排` VALUES ('2c51b6e2-f4b2-4154-a1e8-890d39c5ac9c', '2016-2017', '1', '0417364c-3c9b-413f-aa94-c2f45ab1112a', 'c语言入门', 'A1007', '1', '1620005', '胡信东', 'd56feca9-6848-4dbc-9a5f-cf0d8c3c8110', '2');
INSERT INTO `sys_科目安排` VALUES ('4561b314-82b5-4552-ae19-3ad39744c89d', '2017-2018', '1', 'ca2e8fb6-119f-479a-8c72-15ba18957b0d', '数值分析', 'A1001', '1', null, null, null, '2');
INSERT INTO `sys_科目安排` VALUES ('46088357-c7fa-4ac1-848d-5d2a4def83eb', '2016-2017', '1', 'ca2e8fb6-119f-479a-8c72-15ba18957b0d', '数值分析', 'A1001', '1', '1620002', '林志阳', 'fd98ef33-ca1c-401a-8865-f6636ddcde85', '2');
INSERT INTO `sys_科目安排` VALUES ('482c0a74-f68c-4a2d-9047-370fe28879de', '2016-2017', '1', '3cb15ea1-6c9a-4de9-a8db-51ead642f0c3', '计算机基础', 'A1009', '1', '1620006', '杨林伟', 'a572047a-3521-4b46-ac98-056a784e3990', '2');
INSERT INTO `sys_科目安排` VALUES ('5098ce93-5042-472e-81cf-04d1f6583cfa', '2016-2017', '1', '3cb15ea1-6c9a-4de9-a8db-51ead642f0c3', '计算机基础', 'A1009', '1', '1620006', '杨林伟', 'a572047a-3521-4b46-ac98-056a784e3990', '2');
INSERT INTO `sys_科目安排` VALUES ('513c1dd7-6f14-4c71-8279-733357288798', '2016-2017', '1', '0417364c-3c9b-413f-aa94-c2f45ab1112a', 'c语言入门', 'A1007', '1', '1620005', '胡信东', 'd56feca9-6848-4dbc-9a5f-cf0d8c3c8110', '2');
INSERT INTO `sys_科目安排` VALUES ('561ea925-3528-4b26-ba4b-4b492eeadfe8', '2016-2017', '1', '0816b140-65fa-48a2-9184-f47928c71d0d', '普通话教程', 'A1005', '1', '1620012', '杨颖秀', '2875ac8d-ea97-448f-939b-1a557ee15b32', '1');
INSERT INTO `sys_科目安排` VALUES ('57628b76-03cc-4238-8992-25f93e19d56e', '2016-2017', '1', '4a1acd9f-a70b-4934-82ff-02ac8020c772', '物理师范应用学', 'A1012', '3', '1620004', '赵欣颖', '1950e6cd-e3f7-4c5b-853d-013e946168d2', '2');
INSERT INTO `sys_科目安排` VALUES ('5ffd42bc-26cc-4656-be79-63e66dd13fe8', '2016-2017', '1', '27e022f3-872b-4727-8167-41724c8425ae', '英语听说', 'A1004', '1', '1620011', '潘晓霞', 'b325f73f-b7f9-49e9-b3b3-53a3a1e97577', '1');
INSERT INTO `sys_科目安排` VALUES ('63d87559-a738-4482-b8ed-d41ea4ec0e2e', '2016-2017', '1', 'c1c8bfd9-12aa-4ccc-a1e0-6903cc363251', '高等代数', 'A1002', '1', '1620001', '陈慧恩', '876726ce-883a-43b3-9c1e-a7fbd4385533', '1');
INSERT INTO `sys_科目安排` VALUES ('65916e5b-fa58-43a2-987d-f54d8c3d017d', '2016-2017', '1', 'c1c8bfd9-12aa-4ccc-a1e0-6903cc363251', '高等代数', 'A1002', '1', '1620001', '陈慧恩', '876726ce-883a-43b3-9c1e-a7fbd4385533', '2');
INSERT INTO `sys_科目安排` VALUES ('66d7d6fa-a503-4733-967a-2a61022591ed', '2016-2017', '1', '0816b140-65fa-48a2-9184-f47928c71d0d', '普通话教程', 'A1005', '1', '1620012', '杨颖秀', '2875ac8d-ea97-448f-939b-1a557ee15b32', '1');
INSERT INTO `sys_科目安排` VALUES ('6b914481-b9c5-4335-a34b-ad1d3b541e2b', '2016-2017', '1', 'c1c8bfd9-12aa-4ccc-a1e0-6903cc363251', '高等代数', 'A1002', '1', '1620013', '吴丽艳', 'df40a1ff-0f0b-4991-af1d-5ac3e13090e3', '2');
INSERT INTO `sys_科目安排` VALUES ('6d5a0e9f-0337-449a-8586-42940f0587df', '2016-2017', '1', '27e022f3-872b-4727-8167-41724c8425ae', '英语听说', 'A1004', '1', '1620011', '潘晓霞', 'b325f73f-b7f9-49e9-b3b3-53a3a1e97577', '1');
INSERT INTO `sys_科目安排` VALUES ('7465ca58-43a6-4a9f-8c4d-e1601553f2e9', '2016-2017', '1', 'db3fcbe0-39d4-4e8f-a46b-bde2250d45c8', 'Android', 'A1008', '1', '1620010', '何紫茵', 'f4acdac6-7206-41c7-abd2-4d4210147be3', '2');
INSERT INTO `sys_科目安排` VALUES ('7a1b2906-ac11-4e43-954b-deed3337e666', '2016-2017', '1', '0816b140-65fa-48a2-9184-f47928c71d0d', '普通话教程', 'A1005', '1', '1620012', '杨颖秀', '2875ac8d-ea97-448f-939b-1a557ee15b32', '1');
INSERT INTO `sys_科目安排` VALUES ('84128c81-4e0c-4ed5-9b04-f45d4d669072', '2016-2017', '1', 'bd9eb036-93c5-4583-9e43-b4c8a8a18052', '化学与生活', 'A1015', '1', '1620007', '曾颖妍', '742d9e11-cce8-4b47-abb5-15d9f3217168', '2');
INSERT INTO `sys_科目安排` VALUES ('87885c5b-ccbc-4d6d-bd3b-1f764e39ec73', '2016-2017', '1', '198bc0ce-0f92-4ab5-8d1b-906b7299ef96', '物理基础应用', 'A1010', '1', '1620003', '魏阳林', '29663061-1c67-46bb-8215-742d3839d7f2', '2');
INSERT INTO `sys_科目安排` VALUES ('8f5ea586-241f-4a8d-9093-9a25dc57b167', '2016-2017', '1', 'c1c8bfd9-12aa-4ccc-a1e0-6903cc363251', '高等代数', 'A1002', '1', '1620001', '陈慧恩', '876726ce-883a-43b3-9c1e-a7fbd4385533', '1');
INSERT INTO `sys_科目安排` VALUES ('91a913be-d664-4c97-a745-46114f96ae88', '2016-2017', '1', '0816b140-65fa-48a2-9184-f47928c71d0d', '普通话教程', 'A1005', '1', '1620012', '杨颖秀', '2875ac8d-ea97-448f-939b-1a557ee15b32', '1');
INSERT INTO `sys_科目安排` VALUES ('99fdfd6a-2f2d-4208-a9fc-9d706b331e9e', '2016-2017', '1', '0417364c-3c9b-413f-aa94-c2f45ab1112a', 'c语言入门', 'A1007', '1', '1620005', '胡信东', 'd56feca9-6848-4dbc-9a5f-cf0d8c3c8110', '2');
INSERT INTO `sys_科目安排` VALUES ('9d100e07-4c5e-484a-b7ad-ab2a52e06e1b', '2016-2017', '1', '8efb9c7d-80e3-4b70-90b7-d2d02a620521', '分子世界', 'A1014', '1', '1620007', '曾颖妍', '742d9e11-cce8-4b47-abb5-15d9f3217168', '1');
INSERT INTO `sys_科目安排` VALUES ('a56f6161-fff0-4339-b96d-1d431886a675', '2016-2017', '1', 'db3fcbe0-39d4-4e8f-a46b-bde2250d45c8', 'Android', 'A1008', '1', '1620010', '何紫茵', 'f4acdac6-7206-41c7-abd2-4d4210147be3', '2');
INSERT INTO `sys_科目安排` VALUES ('b07ac059-fcc1-4b8a-9306-d74a250fa5ce', '2016-2017', '1', 'c1c8bfd9-12aa-4ccc-a1e0-6903cc363251', '高等代数', 'A1002', '1', '1620013', '吴丽艳', 'df40a1ff-0f0b-4991-af1d-5ac3e13090e3', '1');
INSERT INTO `sys_科目安排` VALUES ('b12400e9-ad9a-4c51-959a-6b0d4879ca2d', '2016-2017', '1', '87670ae8-d043-4822-8577-a210d5c023c8', '电气工程理论', 'A1021', '1', '1620004', '赵欣颖', '1950e6cd-e3f7-4c5b-853d-013e946168d2', '2');
INSERT INTO `sys_科目安排` VALUES ('b15de941-5891-4469-b199-f29f3e7fd22f', '2016-2017', '1', '198bc0ce-0f92-4ab5-8d1b-906b7299ef96', '物理基础应用', 'A1010', '1', '1620009', '张忠霖', '55c28b76-9206-4d4f-9ee5-430474fa7eca', '1');
INSERT INTO `sys_科目安排` VALUES ('b40bdc56-7981-47ea-ade0-1ead03ee78a4', '2016-2017', '1', 'faa75173-4ef8-49f5-ad2b-4a1fcde2a4e7', '数学教学教程', 'A1016', '1', '1620013', '吴丽艳', 'df40a1ff-0f0b-4991-af1d-5ac3e13090e3', '2');
INSERT INTO `sys_科目安排` VALUES ('b63e42e5-67cb-492e-aba4-c72a80f3d41a', '2016-2017', '1', '198bc0ce-0f92-4ab5-8d1b-906b7299ef96', '物理基础应用', 'A1010', '1', '1620003', '魏阳林', '29663061-1c67-46bb-8215-742d3839d7f2', '2');
INSERT INTO `sys_科目安排` VALUES ('b98672b0-965a-4805-af81-94e013e29cc1', '2016-2017', '1', 'faa75173-4ef8-49f5-ad2b-4a1fcde2a4e7', '数学教学教程', 'A1016', '1', '1620013', '吴丽艳', 'df40a1ff-0f0b-4991-af1d-5ac3e13090e3', '2');
INSERT INTO `sys_科目安排` VALUES ('b9de566c-05a7-41f4-a2ab-cb401e79fdd0', '2016-2017', '1', '0816b140-65fa-48a2-9184-f47928c71d0d', '普通话教程', 'A1005', '1', '1620012', '杨颖秀', '2875ac8d-ea97-448f-939b-1a557ee15b32', '1');
INSERT INTO `sys_科目安排` VALUES ('bc4c09a6-1a3d-4598-8475-79384110e1f6', '2016-2017', '1', 'c1c8bfd9-12aa-4ccc-a1e0-6903cc363251', '高等代数', 'A1002', '1', '1620001', '陈慧恩', '876726ce-883a-43b3-9c1e-a7fbd4385533', '1');
INSERT INTO `sys_科目安排` VALUES ('c67d277b-e9e0-49de-9f01-a872ee7de57d', '2016-2017', '1', 'f1f6e17e-b229-4e07-9f6d-a335c5a8a51a', '化学原理与应用', 'A1013', '1', '1620008', '陈俊涛', '27119808-3624-41fc-ac90-15d7fb77b01f', '2');
INSERT INTO `sys_科目安排` VALUES ('c77fc06f-bdfe-447e-8180-0e783bb50748', '2016-2017', '1', '198bc0ce-0f92-4ab5-8d1b-906b7299ef96', '物理基础应用', 'A1010', '1', '1620003', '魏阳林', '29663061-1c67-46bb-8215-742d3839d7f2', '1');
INSERT INTO `sys_科目安排` VALUES ('cad6b73d-276e-4d45-a4cb-8ec62c2711fe', '2016-2017', '1', '8efb9c7d-80e3-4b70-90b7-d2d02a620521', '分子世界', 'A1014', '1', '1620007', '曾颖妍', '742d9e11-cce8-4b47-abb5-15d9f3217168', '2');
INSERT INTO `sys_科目安排` VALUES ('d337e48c-150f-4849-a8b2-b91b148d22fd', '2016-2017', '1', 'f1f6e17e-b229-4e07-9f6d-a335c5a8a51a', '化学原理与应用', 'A1013', '1', '1620008', '陈俊涛', '27119808-3624-41fc-ac90-15d7fb77b01f', '2');
INSERT INTO `sys_科目安排` VALUES ('df7705a8-6ae9-4f58-9f58-a20d7ae77d57', '2016-2017', '1', 'ca972c3b-9fd6-4038-8323-17a11ab6830b', '光电应用学', 'A1011', '1', '1620009', '张忠霖', '55c28b76-9206-4d4f-9ee5-430474fa7eca', '2');
INSERT INTO `sys_科目安排` VALUES ('ebc909e8-161a-4193-b099-7d4b546237de', '2016-2017', '1', 'ca2e8fb6-119f-479a-8c72-15ba18957b0d', '数值分析', 'A1001', '1', '1620002', '林志阳', 'fd98ef33-ca1c-401a-8865-f6636ddcde85', '2');
INSERT INTO `sys_科目安排` VALUES ('ec41938e-d515-4726-88a6-d3f4c4538d35', '2016-2017', '2', 'c1c8bfd9-12aa-4ccc-a1e0-6903cc363251', '高等代数', 'A1002', '1', '1620013', '吴丽艳', 'df40a1ff-0f0b-4991-af1d-5ac3e13090e3', '2');
INSERT INTO `sys_科目安排` VALUES ('f2b2e144-ef36-43de-bf02-1a8f62eb43e0', '2016-2017', '1', 'c1c8bfd9-12aa-4ccc-a1e0-6903cc363251', '高等代数', 'A1002', '1', '1620001', '陈慧恩', '876726ce-883a-43b3-9c1e-a7fbd4385533', '1');
INSERT INTO `sys_科目安排` VALUES ('f2f4aa00-8de9-41cd-876e-a6f26bdcaaa7', '2016-2017', '1', 'ca2e8fb6-119f-479a-8c72-15ba18957b0d', '数值分析', 'A1001', '1', '1620002', '林志阳', 'fd98ef33-ca1c-401a-8865-f6636ddcde85', '2');
INSERT INTO `sys_科目安排` VALUES ('f75dcbdc-a8af-47ca-a64c-ce4fa9e6d4ab', '2016-2017', '1', 'ca972c3b-9fd6-4038-8323-17a11ab6830b', '光电应用学', 'A1011', '1', '1620009', '张忠霖', '55c28b76-9206-4d4f-9ee5-430474fa7eca', '2');

-- ----------------------------
-- Table structure for sys_系统用户
-- ----------------------------
DROP TABLE IF EXISTS `sys_系统用户`;
CREATE TABLE `sys_系统用户` (
  `ID` varchar(40) NOT NULL,
  `CREATE_TIME` varchar(30) DEFAULT NULL,
  `UPDATE_TIME` varchar(30) DEFAULT NULL,
  `OPERATOR_ID` varchar(40) DEFAULT NULL,
  `OPERATOR` varchar(20) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `U_NUMBER` varchar(11) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `PASSWORD2` varchar(30) DEFAULT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `SEX` tinyint(1) NOT NULL,
  `AGE` int(2) DEFAULT NULL,
  `BIRTH` varchar(50) DEFAULT NULL,
  `ADDRESS` varchar(50) DEFAULT NULL,
  `MOBILE` varchar(15) DEFAULT NULL,
  `HOME_TEL` varchar(20) DEFAULT NULL,
  `ID_CARD` varchar(20) DEFAULT NULL,
  `EMAIL` varchar(20) DEFAULT NULL,
  `JOIN_DATE` varchar(30) DEFAULT NULL,
  `REGIS_TIME` varchar(30) DEFAULT NULL,
  `LAST_LOGIN_TIME` varchar(30) DEFAULT NULL,
  `LOGIN_IP` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_系统用户
-- ----------------------------
INSERT INTO `sys_系统用户` VALUES ('12e929f3-f69a-452b-b940-081943883564', '2016-10-19 23:01:56', null, null, null, '1', 'test', '1601004', 'e10adc3949ba59abbe56e057f20f883e', '123456', 'test', '0', '0', '2016-10-19', ' test', '13068501300', '06688631179', '440921199310103636', 'test@qq.com', '2016-10-19', '2016-10-19 23:01:56', null, null);
INSERT INTO `sys_系统用户` VALUES ('3bc91b18-d34d-493c-9794-12933b325c93', '2016-10-12 21:37:46', null, null, null, '1', 'test', '1601002', 'e10adc3949ba59abbe56e057f20f883e', '123456', '付安久', '1', '0', '2016-10-12', 'test', '18813975059', '06688631179', '440921199210368', 'chw@163.com', '2016-10-12', '2016-10-12 21:37:46', null, null);
INSERT INTO `sys_系统用户` VALUES ('706c73aa-4b76-44f1-b9eb-5dd9062087f3', '2016-09-14 09:23:49', '2016-10-12 21:39:43', null, null, '1', 'test', '1601236', 'e10adc3949ba59abbe56e057f20f883e', '123456', '陈慧哦', '0', '2', '2014-04-02', 'tst', '18813975059', '06688631179', '440921199310103536', '3900@dd.com', '2016-09-07', '2016-09-14 09:23:49', '2016-10-23 17:52:13', '127.0.0.1');
INSERT INTO `sys_系统用户` VALUES ('a1f43b50-8ad8-46b0-bb48-c2b40441b254', '2016-10-12 21:39:05', null, null, null, '1', 'test', '1601003', 'e10adc3949ba59abbe56e057f20f883e', '123456', '张宇杰', '1', '0', '2016-10-12', 'test', '13068501300', '06688637503', '440921199612365', 'test@qq.com', '2016-10-12', '2016-10-12 21:39:05', null, null);
INSERT INTO `sys_系统用户` VALUES ('c5b03332-9faa-4890-99d3-071e4e3975ee', '2016-10-12 21:36:32', null, null, null, '1', 'test', '1601001', 'e10adc3949ba59abbe56e057f20f883e', '123456', '陈晨钰', '0', '0', '2016-10-12', 'test', '13068501300', '06688631179', '440921199310103', '390099591@qq.com', '2016-10-12', '2016-10-12 21:36:32', '2016-10-22 10:35:47', '0:0:0:0:0:0:0:1');

-- ----------------------------
-- Table structure for sys_考试报名
-- ----------------------------
DROP TABLE IF EXISTS `sys_考试报名`;
CREATE TABLE `sys_考试报名` (
  `ID` varchar(40) NOT NULL,
  `CREATE_TIME` varchar(20) DEFAULT NULL,
  `UPDATE_TIME` varchar(20) DEFAULT NULL,
  `OPERATOR_ID` varchar(40) DEFAULT NULL,
  `OPERATOR` varchar(20) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `TEST_CODE` varchar(20) DEFAULT NULL,
  `TEST_NAME` varchar(20) DEFAULT NULL,
  `TEST_TIME` varchar(20) DEFAULT NULL,
  `REGIS_START_TIME` varchar(20) DEFAULT NULL,
  `REGIS_END_TIME` varchar(20) DEFAULT NULL,
  `MONEY` decimal(6,3) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_考试报名
-- ----------------------------
INSERT INTO `sys_考试报名` VALUES ('288a9e49-571b-4711-9d0e-2e6258dffafc', '2016-10-14', null, null, null, '0', 'test', '12016001', '英语四级考试', '2016-12-10', '2016-10-14', '2016-11-27', '30.000');
INSERT INTO `sys_考试报名` VALUES ('85357dbc-f28c-439a-b99a-6ae0e5aa0a9e', '2016-10-14', null, null, null, '0', 'test ', '12016002', '全国计算机等级考试(java)', '2016-12-11', '2016-10-14', '2016-11-30', '120.000');

-- ----------------------------
-- Table structure for sys_菜单下拉
-- ----------------------------
DROP TABLE IF EXISTS `sys_菜单下拉`;
CREATE TABLE `sys_菜单下拉` (
  `ID` varchar(40) NOT NULL,
  `TEXT` varchar(20) DEFAULT NULL,
  `ICON` varchar(100) DEFAULT NULL,
  `ICONCLS` varchar(20) DEFAULT NULL,
  `URL` varchar(100) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `WIDTH` double(3,0) DEFAULT NULL,
  `HEIGHT` double(3,0) DEFAULT NULL,
  `PID` varchar(40) DEFAULT NULL,
  `LEAF` bit(1) DEFAULT NULL,
  `TYPE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_菜单下拉
-- ----------------------------
INSERT INTO `sys_菜单下拉` VALUES ('2361ba9b-d4e5-4b9c-b3d1-93ab12bed085', '信息查询', '', null, ' ', '', null, null, '', null, 'teacher');
INSERT INTO `sys_菜单下拉` VALUES ('3126d220-dbf7-4bfc-b8b7-671e77eee479', '班级信息', '', null, 'teacher/classesPage.do', '', null, null, '8f7de033-b999-42dc-8ec0-ae2a0ce47fb2', '', 'teacher');
INSERT INTO `sys_菜单下拉` VALUES ('48f5ac56-6291-4034-a471-46e29b77dc38', '密码修改', '', null, 'teacher/editPasswordPage.do', '', null, null, 'f0d3e2b8-08dd-44f1-934e-45c81d44423b', '', 'teacher');
INSERT INTO `sys_菜单下拉` VALUES ('66f53474-5d29-4f93-982d-7bbc22020255', '我的课程表', '', null, 'teacher/syllabusPage.do', '', null, null, '2361ba9b-d4e5-4b9c-b3d1-93ab12bed085', '', 'teacher');
INSERT INTO `sys_菜单下拉` VALUES ('8f7de033-b999-42dc-8ec0-ae2a0ce47fb2', '教学服务', '', null, ' ', '', null, null, '', null, 'teacher');
INSERT INTO `sys_菜单下拉` VALUES ('959e9510-73e0-47e7-b2f8-8b2f82c4a83c', '信息维护', '', null, ' ', '', null, null, '', '\0', 'student');
INSERT INTO `sys_菜单下拉` VALUES ('9a375166-5689-4af1-9662-1c6ac44d55ba', '个人信息', '', null, 'teacher/personalPage.do', '', null, null, 'f0d3e2b8-08dd-44f1-934e-45c81d44423b', '', 'teacher');
INSERT INTO `sys_菜单下拉` VALUES ('befb30c4-cf96-4f74-9ec7-b5de50bfae75', '信息查询', '', null, ' ', '', null, null, '', '\0', 'student');
INSERT INTO `sys_菜单下拉` VALUES ('c866c4ba-fc3f-4573-b657-5a3d4457885d', '开设科目', '', null, 'teacher/selectSubjectPage.do', '', null, null, '2361ba9b-d4e5-4b9c-b3d1-93ab12bed085', '', 'teacher');
INSERT INTO `sys_菜单下拉` VALUES ('ca9a1e3a-3a3f-4567-a72e-7d5a14246dab', '个人信息', '', null, 'student/personalPage.do', '', null, null, '959e9510-73e0-47e7-b2f8-8b2f82c4a83c', '', 'student');
INSERT INTO `sys_菜单下拉` VALUES ('d7185c7d-fdda-451f-9d49-aa69e234b575', '密码修改', '', null, 'student/editPasswordPage.do', '', null, null, '959e9510-73e0-47e7-b2f8-8b2f82c4a83c', '', 'student');
INSERT INTO `sys_菜单下拉` VALUES ('f0d3e2b8-08dd-44f1-934e-45c81d44423b', '信息维护', '', null, ' ', '', null, null, '', null, 'teacher');

-- ----------------------------
-- Table structure for sys_菜单信息
-- ----------------------------
DROP TABLE IF EXISTS `sys_菜单信息`;
CREATE TABLE `sys_菜单信息` (
  `ID` varchar(40) NOT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `OPERATOR_ID` varchar(40) DEFAULT NULL,
  `OPERATOR` varchar(20) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `TEXT` varchar(50) DEFAULT NULL,
  `URL` varchar(50) DEFAULT NULL,
  `ICON` varchar(50) DEFAULT NULL,
  `ICONCLS` varchar(50) DEFAULT NULL,
  `PID` varchar(40) DEFAULT NULL,
  `LEAF` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_菜单信息
-- ----------------------------
INSERT INTO `sys_菜单信息` VALUES ('025a35f3-30da-4846-8860-8a7469748634', '2016-10-16 15:47:10', null, null, null, null, null, '角色信息', 'roleInfo/roleInfoPage.do', null, null, '88912fd0-ecec-408d-5774-613bedd319c9', '1');
INSERT INTO `sys_菜单信息` VALUES ('04f521d4-e74d-4780-9f9b-a41d7d159516', '2016-08-31 10:34:58', null, null, null, null, null, '用户服务', null, null, null, null, '0');
INSERT INTO `sys_菜单信息` VALUES ('0743c579-ae8b-4099-bb51-52b2101bdc87', '2016-09-11 17:02:13', null, null, null, null, null, '学生', 'student/studentPage.do', null, null, '04f521d4-e74d-4780-9f9b-a41d7d159516', '1');
INSERT INTO `sys_菜单信息` VALUES ('08dcf436-5072-480f-8e7a-860b91016905', '2016-09-07 22:59:00', null, null, null, null, null, '班级信息', 'classes/classesPage.do', null, null, '88912fd0-ecec-402d-a774-613bedd319c9', '1');
INSERT INTO `sys_菜单信息` VALUES ('0959a8a6-07e8-4cf3-be07-02473d806ce4', '2016-10-06 22:54:25', null, null, null, null, null, '师生菜单', 'menuList/menuListPage.do', null, null, '88912fd0-ecec-408d-5774-613bedd319c9', '1');
INSERT INTO `sys_菜单信息` VALUES ('1e67ecf6-4fec-41f9-8ddf-e433e7c12ba3', '2016-09-07 21:36:40', null, null, null, null, null, '学院信息', 'academy/academyPage.do', null, null, '88912fd0-ecec-402d-a774-613bedd319c9', '1');
INSERT INTO `sys_菜单信息` VALUES ('2fd8ab89-c92d-4baa-b342-b6cc3ba79611', '2016-09-10 16:59:08', null, null, null, null, null, '教工', 'teacher/teacherPage.do', null, null, '04f521d4-e74d-4780-9f9b-a41d7d159516', '1');
INSERT INTO `sys_菜单信息` VALUES ('58c64580-022a-4710-bcfc-cfde6b58d195', '2016-10-14 23:17:56', null, null, null, null, null, '校务信息', 'schoolMessage/schoolMessagePage.do', null, null, '88912fd0-ecec-402d-a774-613bedd319c9', '1');
INSERT INTO `sys_菜单信息` VALUES ('5f46be15-0107-44b2-b7cf-01b04744a6c6', '2016-10-22 22:48:43', null, null, null, null, null, '数据报表', 'charts/chartsPage.do', null, null, '88912fd0-ecec-408d-5774-613bedd319c9', '1');
INSERT INTO `sys_菜单信息` VALUES ('61ab2ce9-87e7-46fd-be2a-5a729367fec2', '2016-09-22 16:43:08', null, null, null, null, null, '教学地点', '/location/locationPage.do', null, null, '88912fd0-ecec-408d-5774-613bedd319c9', '1');
INSERT INTO `sys_菜单信息` VALUES ('6d78e586-60cc-4a6f-98a1-408b1b0e498c', '2016-09-08 21:19:32', null, null, null, null, null, '数据字典', 'dictionary/dictionaryPage.do', null, null, '88912fd0-ecec-408d-5774-613bedd319c9', '1');
INSERT INTO `sys_菜单信息` VALUES ('6fd5bb9d-80bf-4bb4-8aae-8c45b53c5fae', '2016-10-16 15:46:41', null, null, null, null, null, '权限信息', 'permissionInfo/permissionInfoPage.do', null, null, '88912fd0-ecec-408d-5774-613bedd319c9', '1');
INSERT INTO `sys_菜单信息` VALUES ('88912fd0-ecec-402d-a774-613bedd319c9', null, null, null, null, null, null, '校务服务', null, null, null, null, '0');
INSERT INTO `sys_菜单信息` VALUES ('88912fd0-ecec-408d-5774-613bedd319c9', null, null, null, null, null, null, '系统服务', null, null, null, null, '0');
INSERT INTO `sys_菜单信息` VALUES ('88912fd0-ecec-408d-a774-613bedd319c9', null, null, null, null, null, null, '课程服务', null, null, null, null, '0');
INSERT INTO `sys_菜单信息` VALUES ('88912fd0-ecec-4099d-a774-613bedd319c9', '2016-09-01 15:17:37', null, null, null, null, null, '管理员', '/user/adminPage.do', null, null, '04f521d4-e74d-4780-9f9b-a41d7d159516', '1');
INSERT INTO `sys_菜单信息` VALUES ('9cd9b9ff-6b5f-4438-8c93-e054feb2f01f', '2016-09-22 16:43:58', null, null, null, null, null, '科目信息', '/subject/subjectPage.do', null, null, '88912fd0-ecec-408d-a774-613bedd319c9', '1');
INSERT INTO `sys_菜单信息` VALUES ('b1f220bc-e40b-47d6-92e9-c1f7e6a92b17', '2016-10-14 23:13:05', null, null, null, null, null, '考试信息', 'testRecord/testRecordPage.do', null, null, '88912fd0-ecec-402d-a774-613bedd319c9', '1');
INSERT INTO `sys_菜单信息` VALUES ('ba7ba201-0fc1-47a9-be1d-e07f8e10b55c', '2016-09-22 16:41:54', null, null, null, null, null, '选课记录', '/selectSubject/selectSubjectPage.do', null, null, '88912fd0-ecec-408d-a774-613bedd319c9', '1');
INSERT INTO `sys_菜单信息` VALUES ('d11238b5-888a-4012-8a0e-660196411fab', '2016-10-22 16:25:27', null, null, null, null, null, '系统监控', null, null, null, null, '0');
INSERT INTO `sys_菜单信息` VALUES ('f5072fd6-302e-49d5-b6ce-56e5c398b31e', '2016-10-22 16:26:23', null, null, null, null, null, '系统监控', 'druid/index.html', null, null, 'd11238b5-888a-4012-8a0e-660196411fab', '1');

-- ----------------------------
-- Table structure for sys_角色信息
-- ----------------------------
DROP TABLE IF EXISTS `sys_角色信息`;
CREATE TABLE `sys_角色信息` (
  `ID` varchar(40) NOT NULL,
  `CREATE_TIME` varchar(20) DEFAULT NULL,
  `UPDATE_TIME` varchar(20) DEFAULT NULL,
  `OPERATOR_ID` varchar(40) DEFAULT NULL,
  `OPERATOR` varchar(20) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `ROLE_NAME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_角色信息
-- ----------------------------
INSERT INTO `sys_角色信息` VALUES ('1193112d-8111-433c-9670-39bf5a2eefa8', '2016-10-18 22:51:57', '2016-10-18 22:52:49', null, null, '1', '仅限系统服务的所有功能', 'admin');
INSERT INTO `sys_角色信息` VALUES ('38efcfc4-9686-4c77-ba45-1e85db4a61ec', '2016-10-18 22:59:13', null, null, null, '1', '仅限用户服务的所有功能', 'superuser');
INSERT INTO `sys_角色信息` VALUES ('4862f3be-0399-4231-a2ae-c4be0ad9fb65', '2016-10-18 23:01:16', null, null, null, '1', '仅限课程服务的所有功能', 'supersubject');
INSERT INTO `sys_角色信息` VALUES ('70fa2c90-beb4-4ae1-ae49-4c92562d051d', '2016-10-18 23:00:08', '2016-10-18 23:01:22', null, null, '1', '仅限校务服务的所有功能', 'supermanager');
INSERT INTO `sys_角色信息` VALUES ('bf3aacfe-61b0-4f7d-bae0-d48d67cd6ac0', '2016-10-18 23:02:09', null, null, null, '1', '校务服务系统的所有功能', 'superadmin');

-- ----------------------------
-- Table structure for sys_角色权限
-- ----------------------------
DROP TABLE IF EXISTS `sys_角色权限`;
CREATE TABLE `sys_角色权限` (
  `ROLE_ID` varchar(40) DEFAULT NULL,
  `PERMISSION_ID` varchar(40) DEFAULT NULL,
  `ID` varchar(40) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_角色权限
-- ----------------------------

-- ----------------------------
-- Table structure for sys_请假信息
-- ----------------------------
DROP TABLE IF EXISTS `sys_请假信息`;
CREATE TABLE `sys_请假信息` (
  `ID` varchar(40) NOT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `OPERATOR_ID` varchar(40) DEFAULT NULL,
  `OPERATOR` varchar(20) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `APPLICANT_TIME` datetime DEFAULT NULL,
  `APPLICANT` varchar(20) DEFAULT NULL,
  `APPLICANT_NUM` varchar(11) DEFAULT NULL,
  `RESON` varchar(300) DEFAULT NULL,
  `REQUEST_TIME` datetime DEFAULT NULL,
  `APPROVER` varchar(20) DEFAULT NULL,
  `APPROVER_NUM` varchar(11) DEFAULT NULL,
  `APPROVAL_TIME` datetime DEFAULT NULL,
  `LEADER_OPINION` varchar(300) DEFAULT NULL,
  `START_TIME` datetime DEFAULT NULL,
  `END_TIME` datetime DEFAULT NULL,
  `IS_CHECK_OK` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_请假信息
-- ----------------------------

-- ----------------------------
-- Table structure for sys_课程排版
-- ----------------------------
DROP TABLE IF EXISTS `sys_课程排版`;
CREATE TABLE `sys_课程排版` (
  `ID` varchar(40) NOT NULL,
  `CREATE_TIME` varchar(20) DEFAULT NULL,
  `UPDATE_TIME` varchar(20) DEFAULT NULL,
  `OPERATOR_ID` varchar(40) DEFAULT NULL,
  `OPERATOR` varchar(20) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `TEACHER_NAME` varchar(20) DEFAULT NULL,
  `T_NUMBER` varchar(11) DEFAULT NULL,
  `LOCATION_ID` varchar(40) DEFAULT NULL,
  `LOCATION_NAME` varchar(30) DEFAULT NULL,
  `CLASS_TIME` varchar(20) DEFAULT NULL,
  `CLASS_WEEK` varchar(10) DEFAULT NULL,
  `SUBJECT_CODE` varchar(40) DEFAULT NULL,
  `SUBJECT_NAME` varchar(20) DEFAULT NULL,
  `CLASS_ID` varchar(40) DEFAULT NULL,
  `ACADEMY_NAME` varchar(20) DEFAULT NULL,
  `CLASS_NAME` varchar(20) DEFAULT NULL,
  `SCHOOL_YEAR` varchar(20) DEFAULT NULL,
  `TERM` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_课程排版
-- ----------------------------
INSERT INTO `sys_课程排版` VALUES ('06532d65-2bcd-421b-840c-156a153e50c9', null, null, null, null, null, null, '曾颖妍', '1620007', '943d63e7-51fe-4c1d-92ad-16a84c343867', '志军实验大楼203', '5-6', '星期四', 'A1015', '化学与生活1', 'c4da4786-d2b0-45c7-9db0-bcf4d5cbd1aa', '化学学院', '1606', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('0b6e3381-4d8c-40f4-a119-5dd23998e9fc', null, null, null, null, null, null, '胡信东', '1620005', '0529d0f5-639a-4e1b-b7e3-70218d1ccff0', '志军实验大楼106', '1-2', '星期五', 'A1007', 'c语言入门1', '6d04b565-7cf7-4310-9088-40a4e0a716c7', '计算机学院', '1604', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('0d9397f4-2bfd-439b-816d-93fdf135dc96', null, null, null, null, null, null, '陈俊涛', '1620008', '5908a012-e11c-4346-99d9-d8011081322b', '红琼大楼100', '3-4', '星期二', 'A1015', '化学与生活1', 'a4b89d96-699c-4321-88b2-bca4d5fd2cdd', '化学学院', '1605', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('0dab2fce-36ce-409a-9dbd-fa0fcac22c0c', null, null, null, null, null, null, '林志阳', '1620002', 'a4b54a0f-2ad2-4bad-b63c-149dd3f7d285', '万威大楼B202', '1-2', '星期四', 'A1001', '数值分析1', '82879c7b-ce46-46fa-8ac6-4119658d5d35', '数学学院', '1601', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('126a6948-f3fa-4f57-b511-dad77ea006c2', null, null, null, null, null, null, '杨林伟', '1620006', 'f987e0c8-501f-4629-ac48-9a332d52cfaa', '万威大楼A101', '7-8', '星期五', 'A1009', '计算机基础1', '5cda1fe1-5e96-42ae-94b3-0f42295c421b', '计算机学院', '1603', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('13ece007-5d6a-4d7a-9ea1-c5cb944f299f', null, null, null, null, null, null, '陈俊涛', '1620008', '943d63e7-51fe-4c1d-92ad-16a84c343867', '志军实验大楼203', '1-2', '星期三', 'A1013', '化学原理与应用1', 'c4da4786-d2b0-45c7-9db0-bcf4d5cbd1aa', '化学学院', '1606', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('1936c5d3-bdc3-40d0-922c-74aa96463e2a', null, null, null, null, null, null, '林志阳', '1620002', '943d63e7-51fe-4c1d-92ad-16a84c343867', '志军实验大楼203', '5-6', '星期二', 'A1002', '高等代数1', '6d04b565-7cf7-4310-9088-40a4e0a716c7', '计算机学院', '1604', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('1c67accf-f0bb-4c27-9924-9e7f3607b3c4', null, null, null, null, null, null, '陈慧恩', '1620001', '0529d0f5-639a-4e1b-b7e3-70218d1ccff0', '志军实验大楼106', '7-8', '星期二', 'A1002', '高等代数1', 'c4da4786-d2b0-45c7-9db0-bcf4d5cbd1aa', '化学学院', '1606', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('20b53b5c-f4f5-4c13-81b2-2aa144bfb580', null, null, null, null, null, null, '何紫茵', '1620010', '5908a012-e11c-4346-99d9-d8011081322b', '红琼大楼100', '5-6', '星期三', 'A1008', 'Android1', '5cda1fe1-5e96-42ae-94b3-0f42295c421b', '计算机学院', '1603', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('21e52daa-fa5a-4391-8baf-9e93db523597', null, null, null, null, null, null, '陈慧恩', '1620001', 'f987e0c8-501f-4629-ac48-9a332d52cfaa', '万威大楼A101', '3-4', '星期五', 'A1002', '高等代数1', 'a4b89d96-699c-4321-88b2-bca4d5fd2cdd', '化学学院', '1605', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('25295457-ef06-42eb-ba50-c47676ffc820', null, null, null, null, null, null, '张忠霖', '1620009', '0529d0f5-639a-4e1b-b7e3-70218d1ccff0', '志军实验大楼106', '5-6', '星期二', 'A1011', '光电应用学1', '27ecde58-9cf3-4658-b5a1-2c5da4c30bf6', '物理学院', '1602', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('25fcfec3-2970-41d0-ad22-12526a302706', null, null, null, null, null, null, '陈俊涛', '1620008', '5908a012-e11c-4346-99d9-d8011081322b', '红琼大楼100', '3-4', '星期一', 'A1013', '化学原理与应用1', 'c4da4786-d2b0-45c7-9db0-bcf4d5cbd1aa', '化学学院', '1606', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('2717237f-1283-4c57-a8e0-b3f4e583a9bd', null, null, null, null, null, null, '赵欣颖', '1620004', '0529d0f5-639a-4e1b-b7e3-70218d1ccff0', '志军实验大楼106', '7-8', '星期三', 'A1021', '电气工程理论1', '27ecde58-9cf3-4658-b5a1-2c5da4c30bf6', '物理学院', '1602', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('28537d5b-3d4c-4d2a-b6e3-cb88cefd8f2c', null, null, null, null, null, null, '张忠霖', '1620009', 'f2eef8a9-36da-4904-b750-9cf1cd319fbf', '万威大楼A102', '7-8', '星期一', 'A1010', '物理基础应用1', '0c6a2691-1f6e-478d-ab8c-7fc5289bf331', '数学学院', '1603', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('286bddf2-ea5e-42aa-880d-aa23b5b5c975', null, null, null, null, null, null, '吴丽艳', '1620013', '5908a012-e11c-4346-99d9-d8011081322b', '红琼大楼100', '7-8', '星期五', 'A1016', '数学教学教程1', '45e438e9-2977-48c6-8353-3456b478b846', '数学学院', '1602', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('28ff8f1e-147b-4dd7-a882-65caafb931b9', null, null, null, null, null, null, '赵欣颖', '1620004', '0529d0f5-639a-4e1b-b7e3-70218d1ccff0', '志军实验大楼106', '5-6', '星期五', 'A1012', '物理师范应用学3', '590cb58a-67c5-4135-91c5-c614922f5703', '物理学院', '1601', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('296419ce-faf7-4108-a2f1-7dbb8784cb98', null, null, null, null, null, null, '林志阳', '1620002', '5b5ca6af-5acd-496b-ac13-524b9971658e', '红琼大楼403', '7-8', '星期三', 'A1001', '数值分析1', '0c6a2691-1f6e-478d-ab8c-7fc5289bf331', '数学学院', '1603', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('29657aad-4a03-4b8f-9473-2068b88f903b', null, null, null, null, null, null, '林志阳', '1620002', 'b8c46a6d-a534-48b5-a2c0-804d5cd7a127', '万威大楼B203', '3-4', '星期四', 'A1001', '数值分析1', '45e438e9-2977-48c6-8353-3456b478b846', '数学学院', '1602', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('2e727d51-168b-47c0-a27d-fa6a687c8cb0', null, null, null, null, null, null, '胡信东', '1620005', '5908a012-e11c-4346-99d9-d8011081322b', '红琼大楼100', '1-2', '星期三', 'A1007', 'c语言入门1', '0c6a2691-1f6e-478d-ab8c-7fc5289bf331', '数学学院', '1603', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('330cad4c-c99c-4bda-b918-3658c3a8141f', null, null, null, null, null, null, '张忠霖', '1620009', 'f987e0c8-501f-4629-ac48-9a332d52cfaa', '万威大楼A101', '5-6', '星期五', 'A1011', '光电应用学1', '27ecde58-9cf3-4658-b5a1-2c5da4c30bf6', '物理学院', '1602', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('3d4947b1-df58-4093-a6b3-fa16666896eb', null, null, null, null, null, null, '陈慧恩', '1620001', 'a4b54a0f-2ad2-4bad-b63c-149dd3f7d285', '万威大楼B202', '5-6', '星期五', 'A1002', '高等代数1', '82879c7b-ce46-46fa-8ac6-4119658d5d35', '数学学院', '1601', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('42cf79dd-bf85-4aff-ac91-4e258c28f4c8', null, null, null, null, null, null, '吴丽艳', '1620013', 'f987e0c8-501f-4629-ac48-9a332d52cfaa', '万威大楼A101', '1-2', '星期一', 'A1002', '高等代数1', '45e438e9-2977-48c6-8353-3456b478b846', '数学学院', '1602', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('45a38758-e797-4421-9e44-965989aaecf1', null, null, null, null, null, null, '杨林伟', '1620006', '5b5ca6af-5acd-496b-ac13-524b9971658e', '红琼大楼403', '7-8', '星期一', 'A1009', '计算机基础1', '5cda1fe1-5e96-42ae-94b3-0f42295c421b', '计算机学院', '1603', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('48f9425f-d68d-4ebe-9f78-2fc8a8324f0f', null, null, null, null, null, null, '胡信东', '1620005', '5b5ca6af-5acd-496b-ac13-524b9971658e', '红琼大楼403', '5-6', '星期一', 'A1007', 'c语言入门1', '6d04b565-7cf7-4310-9088-40a4e0a716c7', '计算机学院', '1604', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('4954742d-6447-47dc-b37f-0e5ec47d316d', null, null, null, null, null, null, '何紫茵', '1620010', '5908a012-e11c-4346-99d9-d8011081322b', '红琼大楼100', '1-2', '星期五', 'A1008', 'Android1', '5cda1fe1-5e96-42ae-94b3-0f42295c421b', '计算机学院', '1603', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('505250b4-95bd-42c4-8924-ffe905e0c574', null, null, null, null, null, null, '杨颖秀', '1620012', '5b5ca6af-5acd-496b-ac13-524b9971658e', '红琼大楼403', '3-4', '星期一', 'A1005', '普通话教程1', '27ecde58-9cf3-4658-b5a1-2c5da4c30bf6', '物理学院', '1602', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('531a7539-0f7c-481e-83ba-929a47346864', null, null, null, null, null, null, '陈俊涛', '1620008', '5b5ca6af-5acd-496b-ac13-524b9971658e', '红琼大楼403', '1-2', '星期一', 'A1013', '化学原理与应用1', 'a4b89d96-699c-4321-88b2-bca4d5fd2cdd', '化学学院', '1605', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('5918e8c9-062a-4648-b796-fa719df3fdd1', null, null, null, null, null, null, '张忠霖', '1620009', '5908a012-e11c-4346-99d9-d8011081322b', '红琼大楼100', '1-2', '星期一', 'A1011', '光电应用学1', '590cb58a-67c5-4135-91c5-c614922f5703', '物理学院', '1601', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('598f4ec1-671c-4fea-b953-79788a5a4461', null, null, null, null, null, null, '潘晓霞', '1620011', 'f987e0c8-501f-4629-ac48-9a332d52cfaa', '万威大楼A101', '7-8', '星期二', 'A1004', '英语听说1', '6d04b565-7cf7-4310-9088-40a4e0a716c7', '计算机学院', '1604', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('69752203-4938-44d9-b6cb-79f02e379500', null, null, null, null, null, null, '何紫茵', '1620010', '5b5ca6af-5acd-496b-ac13-524b9971658e', '红琼大楼403', '5-6', '星期五', 'A1008', 'Android1', '6d04b565-7cf7-4310-9088-40a4e0a716c7', '计算机学院', '1604', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('6abbd1d2-1ec5-4da4-958f-1bf4f07eaef5', null, null, null, null, null, null, '胡信东', '1620005', '5b5ca6af-5acd-496b-ac13-524b9971658e', '红琼大楼403', '7-8', '星期四', 'A1007', 'c语言入门1', '5cda1fe1-5e96-42ae-94b3-0f42295c421b', '计算机学院', '1603', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('71ca3fd4-6b6e-4055-a7fa-f17d91b736a5', null, null, null, null, null, null, '杨林伟', '1620006', '943d63e7-51fe-4c1d-92ad-16a84c343867', '志军实验大楼203', '3-4', '星期五', 'A1009', '计算机基础1', '6d04b565-7cf7-4310-9088-40a4e0a716c7', '计算机学院', '1604', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('780f3750-14f9-49da-8f1a-bf8e319db900', null, null, null, null, null, null, '吴丽艳', '1620013', 'f987e0c8-501f-4629-ac48-9a332d52cfaa', '万威大楼A101', '3-4', '星期三', 'A1016', '数学教学教程1', '45e438e9-2977-48c6-8353-3456b478b846', '数学学院', '1602', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('7a91b6f2-80e7-4d86-86c4-b81b589b3bb4', null, null, null, null, null, null, '杨林伟', '1620006', 'b8c46a6d-a534-48b5-a2c0-804d5cd7a127', '万威大楼B203', '3-4', '星期三', 'A1009', '计算机基础1', '6d04b565-7cf7-4310-9088-40a4e0a716c7', '计算机学院', '1604', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('7af8c489-13d3-4f5e-a331-387e0cc737e2', null, null, null, null, null, null, '赵欣颖', '1620004', '5b5ca6af-5acd-496b-ac13-524b9971658e', '红琼大楼403', '1-2', '星期五', 'A1010', '物理基础应用1', '82879c7b-ce46-46fa-8ac6-4119658d5d35', '数学学院', '1601', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('89018ff6-d8fe-4a76-be3b-a34f84603e07', null, null, null, null, null, null, '曾颖妍', '1620007', 'f987e0c8-501f-4629-ac48-9a332d52cfaa', '万威大楼A101', '5-6', '星期二', 'A1014', '分子世界1', 'c4da4786-d2b0-45c7-9db0-bcf4d5cbd1aa', '化学学院', '1606', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('8af75d14-f1ec-47f4-ba2c-a9f1cefbc0c4', null, null, null, null, null, null, '曾颖妍', '1620007', 'b8c46a6d-a534-48b5-a2c0-804d5cd7a127', '万威大楼B203', '7-8', '星期四', 'A1014', '分子世界1', 'a4b89d96-699c-4321-88b2-bca4d5fd2cdd', '化学学院', '1605', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('8bdf7cbb-d083-42a9-a051-2287c1daf0fc', null, null, null, null, null, null, '吴丽艳', '1620013', '5908a012-e11c-4346-99d9-d8011081322b', '红琼大楼100', '3-4', '星期四', 'A1002', '高等代数1', '5cda1fe1-5e96-42ae-94b3-0f42295c421b', '计算机学院', '1603', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('92addcce-9d97-4543-bf57-5a27be946f8d', null, null, null, null, null, null, '胡信东', '1620005', 'f2eef8a9-36da-4904-b750-9cf1cd319fbf', '万威大楼A102', '5-6', '星期五', 'A1007', 'c语言入门1', '5cda1fe1-5e96-42ae-94b3-0f42295c421b', '计算机学院', '1603', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('94792021-f3ed-48d6-8565-c610b2c68d6b', null, null, null, null, null, null, '林志阳', '1620002', 'f987e0c8-501f-4629-ac48-9a332d52cfaa', '万威大楼A101', '1-2', '星期二', 'A1001', '数值分析1', '45e438e9-2977-48c6-8353-3456b478b846', '数学学院', '1602', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('9bd7a600-490d-4a69-8445-84dd0336ab93', null, null, null, null, null, null, '潘晓霞', '1620011', 'a4b54a0f-2ad2-4bad-b63c-149dd3f7d285', '万威大楼B202', '7-8', '星期五', 'A1004', '英语听说1', '0c6a2691-1f6e-478d-ab8c-7fc5289bf331', '数学学院', '1603', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('a448df6f-8c51-43a8-a575-79f9f91d7eba', null, null, null, null, null, null, '吴丽艳', '1620013', '5908a012-e11c-4346-99d9-d8011081322b', '红琼大楼100', '5-6', '星期四', 'A1016', '数学教学教程1', '82879c7b-ce46-46fa-8ac6-4119658d5d35', '数学学院', '1601', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('a496c5a9-fe57-49fb-8d5f-e5408b41e615', null, null, null, null, null, null, '张忠霖', '1620009', '0529d0f5-639a-4e1b-b7e3-70218d1ccff0', '志军实验大楼106', '1-2', '星期四', 'A1011', '光电应用学1', '590cb58a-67c5-4135-91c5-c614922f5703', '物理学院', '1601', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('a5b2c726-6560-47c9-a912-4c07820408f7', null, null, null, null, null, null, '吴丽艳', '1620013', 'b8c46a6d-a534-48b5-a2c0-804d5cd7a127', '万威大楼B203', '5-6', '星期三', 'A1002', '高等代数1', '0c6a2691-1f6e-478d-ab8c-7fc5289bf331', '数学学院', '1603', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('a81490ea-1d39-4c5d-990c-ccc6b9dbd281', null, null, null, null, null, null, '林志阳', '1620002', 'b8c46a6d-a534-48b5-a2c0-804d5cd7a127', '万威大楼B203', '5-6', '星期四', 'A1001', '数值分析1', '0c6a2691-1f6e-478d-ab8c-7fc5289bf331', '数学学院', '1603', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('a944e801-7056-46ca-8ba0-081626815c38', null, null, null, null, null, null, '杨颖秀', '1620012', 'ea1ed7ff-b38b-4411-b8b3-6e6847c50af8', '红琼大楼401', '7-8', '星期一', 'A1005', '普通话教程1', 'c4da4786-d2b0-45c7-9db0-bcf4d5cbd1aa', '化学学院', '1606', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('a98914f4-0f0f-4ba9-9636-9cb51a849b12', null, null, null, null, null, null, '潘晓霞', '1620011', 'ea1ed7ff-b38b-4411-b8b3-6e6847c50af8', '红琼大楼401', '3-4', '星期三', 'A1004', '英语听说1', '82879c7b-ce46-46fa-8ac6-4119658d5d35', '数学学院', '1601', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('a9a621dd-785d-468a-9264-baf7b2c46e7f', null, null, null, null, null, null, '杨颖秀', '1620012', '0529d0f5-639a-4e1b-b7e3-70218d1ccff0', '志军实验大楼106', '3-4', '星期三', 'A1005', '普通话教程1', '590cb58a-67c5-4135-91c5-c614922f5703', '物理学院', '1601', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('aaeca20a-53f3-4271-95ed-1dfe74722b31', null, null, null, null, null, null, '陈慧恩', '1620001', 'f2eef8a9-36da-4904-b750-9cf1cd319fbf', '万威大楼A102', '1-2', '星期四', 'A1002', '高等代数1', '27ecde58-9cf3-4658-b5a1-2c5da4c30bf6', '物理学院', '1602', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('ae8c50e5-a9cb-4ffb-b302-05e90a97463e', null, null, null, null, null, null, '吴丽艳', '1620013', '5908a012-e11c-4346-99d9-d8011081322b', '红琼大楼100', '7-8', '星期三', 'A1016', '数学教学教程1', '82879c7b-ce46-46fa-8ac6-4119658d5d35', '数学学院', '1601', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('b8d00608-38c6-4b45-8540-682628b93832', null, null, null, null, null, null, '曾颖妍', '1620007', 'b8c46a6d-a534-48b5-a2c0-804d5cd7a127', '万威大楼B203', '5-6', '星期一', 'A1015', '化学与生活1', 'c4da4786-d2b0-45c7-9db0-bcf4d5cbd1aa', '化学学院', '1606', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('be16c2fa-a8a6-45dd-aa26-f8ba1509a665', null, null, null, null, null, null, '魏阳林', '1620003', 'a4b54a0f-2ad2-4bad-b63c-149dd3f7d285', '万威大楼B202', '1-2', '星期二', 'A1010', '物理基础应用1', '590cb58a-67c5-4135-91c5-c614922f5703', '物理学院', '1601', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('c1c7bde2-fc31-40b8-9f26-e747cfabbee8', null, null, null, null, null, null, '魏阳林', '1620003', 'f987e0c8-501f-4629-ac48-9a332d52cfaa', '万威大楼A101', '1-2', '星期五', 'A1010', '物理基础应用1', '27ecde58-9cf3-4658-b5a1-2c5da4c30bf6', '物理学院', '1602', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('c2e82296-b29a-4a31-b043-a3735d0f5f44', null, null, null, null, null, null, '陈慧恩', '1620001', '943d63e7-51fe-4c1d-92ad-16a84c343867', '志军实验大楼203', '3-4', '星期一', 'A1002', '高等代数1', '82879c7b-ce46-46fa-8ac6-4119658d5d35', '数学学院', '1601', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('c4698ef2-2d0c-41c2-acbb-c2539555d7df', null, null, null, null, null, null, '胡信东', '1620005', '5b5ca6af-5acd-496b-ac13-524b9971658e', '红琼大楼403', '1-2', '星期四', 'A1007', 'c语言入门1', '0c6a2691-1f6e-478d-ab8c-7fc5289bf331', '数学学院', '1603', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('c55b2fa6-a0f1-42ad-9390-c28937ca0bcc', null, null, null, null, null, null, '曾颖妍', '1620007', '5908a012-e11c-4346-99d9-d8011081322b', '红琼大楼100', '3-4', '星期三', 'A1014', '分子世界1', 'a4b89d96-699c-4321-88b2-bca4d5fd2cdd', '化学学院', '1605', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('c935bc1d-211b-45d9-b7aa-b308a69a6bef', null, null, null, null, null, null, '魏阳林', '1620003', '0529d0f5-639a-4e1b-b7e3-70218d1ccff0', '志军实验大楼106', '1-2', '星期三', 'A1010', '物理基础应用1', '590cb58a-67c5-4135-91c5-c614922f5703', '物理学院', '1601', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('cd3e1563-c954-439d-a3e9-7a9dcdb22e34', null, null, null, null, null, null, '林志阳', '1620002', 'b8c46a6d-a534-48b5-a2c0-804d5cd7a127', '万威大楼B203', '7-8', '星期一', 'A1001', '数值分析1', '82879c7b-ce46-46fa-8ac6-4119658d5d35', '数学学院', '1601', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('cda37e3c-066b-481d-9593-e957aca830c1', null, null, null, null, null, null, '陈俊涛', '1620008', 'ea1ed7ff-b38b-4411-b8b3-6e6847c50af8', '红琼大楼401', '1-2', '星期二', 'A1013', '化学原理与应用1', 'a4b89d96-699c-4321-88b2-bca4d5fd2cdd', '化学学院', '1605', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('d09fa00e-4281-49b1-afb3-ed5ceb4b1269', null, null, null, null, null, null, '杨颖秀', '1620012', '943d63e7-51fe-4c1d-92ad-16a84c343867', '志军实验大楼203', '7-8', '星期三', 'A1005', '普通话教程1', 'a4b89d96-699c-4321-88b2-bca4d5fd2cdd', '化学学院', '1605', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('d308e77c-10b4-4f0c-b5e7-f73a7dd3d7eb', null, null, null, null, null, null, '赵欣颖', '1620004', 'ea1ed7ff-b38b-4411-b8b3-6e6847c50af8', '红琼大楼401', '5-6', '星期二', 'A1012', '物理师范应用学3', '590cb58a-67c5-4135-91c5-c614922f5703', '物理学院', '1601', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('d43a9d4f-3d36-48c0-a5ed-cca07a032aff', null, null, null, null, null, null, '魏阳林', '1620003', 'b8c46a6d-a534-48b5-a2c0-804d5cd7a127', '万威大楼B203', '3-4', '星期二', 'A1010', '物理基础应用1', '45e438e9-2977-48c6-8353-3456b478b846', '数学学院', '1602', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('d8ef85ca-3078-4aa0-af11-88dd6155cce7', null, null, null, null, null, null, '何紫茵', '1620010', '0529d0f5-639a-4e1b-b7e3-70218d1ccff0', '志军实验大楼106', '7-8', '星期四', 'A1008', 'Android1', '6d04b565-7cf7-4310-9088-40a4e0a716c7', '计算机学院', '1604', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('dbbc1612-bbfd-4e69-ae71-774ad54f391c', null, null, null, null, null, null, '杨颖秀', '1620012', 'f2eef8a9-36da-4904-b750-9cf1cd319fbf', '万威大楼A102', '3-4', '星期二', 'A1005', '普通话教程1', '5cda1fe1-5e96-42ae-94b3-0f42295c421b', '计算机学院', '1603', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('e207665a-cf29-42b7-8751-36a3c2c1dd7f', null, null, null, null, null, null, '吴丽艳', '1620013', '0529d0f5-639a-4e1b-b7e3-70218d1ccff0', '志军实验大楼106', '5-6', '星期一', 'A1002', '高等代数1', '0c6a2691-1f6e-478d-ab8c-7fc5289bf331', '数学学院', '1603', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('e48c8664-fc51-4fd8-b606-9b402d9e24d2', null, null, null, null, null, null, '陈慧恩', '1620001', 'b8c46a6d-a534-48b5-a2c0-804d5cd7a127', '万威大楼B203', '7-8', '星期三', 'A1002', '高等代数1', '590cb58a-67c5-4135-91c5-c614922f5703', '物理学院', '1601', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('ec3ed451-e7ca-4262-9275-c1df99ea92f0', null, null, null, null, null, null, '吴丽艳', '1620013', '5b5ca6af-5acd-496b-ac13-524b9971658e', '红琼大楼403', '7-8', '星期二', 'A1002', '高等代数1', '45e438e9-2977-48c6-8353-3456b478b846', '数学学院', '1602', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('ed32b73c-345d-4bdc-bd36-57ca562b1e12', null, null, null, null, null, null, '潘晓霞', '1620011', 'b8c46a6d-a534-48b5-a2c0-804d5cd7a127', '万威大楼B203', '1-2', '星期四', 'A1004', '英语听说1', '45e438e9-2977-48c6-8353-3456b478b846', '数学学院', '1602', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('f05243fe-5282-432a-b9a7-5af26c8ad9c2', null, null, null, null, null, null, '赵欣颖', '1620004', '5b5ca6af-5acd-496b-ac13-524b9971658e', '红琼大楼403', '3-4', '星期五', 'A1021', '电气工程理论1', '27ecde58-9cf3-4658-b5a1-2c5da4c30bf6', '物理学院', '1602', '2016-2017', '1');
INSERT INTO `sys_课程排版` VALUES ('f8d3566a-5012-4b9c-8952-6a269dc7f620', null, null, null, null, null, null, '魏阳林', '1620003', 'ea1ed7ff-b38b-4411-b8b3-6e6847c50af8', '红琼大楼401', '3-4', '星期四', 'A1010', '物理基础应用1', '27ecde58-9cf3-4658-b5a1-2c5da4c30bf6', '物理学院', '1602', '2016-2017', '1');

-- ----------------------------
-- Table structure for sys_选课记录
-- ----------------------------
DROP TABLE IF EXISTS `sys_选课记录`;
CREATE TABLE `sys_选课记录` (
  `ID` varchar(40) NOT NULL,
  `CREATE_TIME` varchar(20) DEFAULT NULL,
  `UPDATE_TIME` varchar(20) DEFAULT NULL,
  `OPERATOR_ID` varchar(40) DEFAULT NULL,
  `OPERATOR` varchar(20) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `SUBJECT_ID` varchar(40) DEFAULT NULL,
  `SUBJECT_CODE` varchar(20) DEFAULT NULL,
  `SUBJECT_NAME` varchar(20) DEFAULT NULL,
  `TEACHER_ID` varchar(40) DEFAULT NULL,
  `TEACHER_NAME` varchar(20) DEFAULT NULL,
  `START_TIME` varchar(20) DEFAULT NULL,
  `END_TIME` varchar(20) DEFAULT NULL,
  `LOCATION_ID` varchar(40) DEFAULT NULL,
  `LOCATION_NAME` varchar(20) DEFAULT NULL,
  `CLASS_TIME` varchar(20) DEFAULT NULL,
  `CAPACITY` int(3) DEFAULT NULL,
  `CLASS_WEEK` varchar(10) DEFAULT NULL,
  `TOTAL_SCORE` double(3,0) DEFAULT NULL,
  `SCHOOL_YEAR` varchar(20) DEFAULT NULL,
  `TERM` varchar(10) DEFAULT NULL,
  `CATAGORY` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_选课记录
-- ----------------------------
INSERT INTO `sys_选课记录` VALUES ('33bc2083-83c8-406b-a5fe-0c3fcf172c6a', '2016-10-13 16:47:39', '2016-10-14 22:20:11', null, null, '0', 'test', 'cf571db6-537b-4cfb-b470-821908db36bb', 'A1017', '人类思想的进化1', '1950e6cd-e3f7-4c5b-853d-013e946168d2', '赵欣颖', '第二周', '第十六周', 'f2eef8a9-36da-4904-b750-9cf1cd319fbf', '万威大楼A102', '9-10', null, '星期二', null, '2016-2017', '1', '人文理学');
INSERT INTO `sys_选课记录` VALUES ('ae6563c4-3347-41f9-8641-8b3c0e98cb4c', '2016-10-13 16:25:37', '2016-10-13 16:46:54', null, null, '0', 'test', 'db3fcbe0-39d4-4e8f-a46b-bde2250d45c8', 'A1008', 'Android1', 'd56feca9-6848-4dbc-9a5f-cf0d8c3c8110', '胡信东', '第二周', '第十六周', 'f987e0c8-501f-4629-ac48-9a332d52cfaa', '万威大楼A101', '9-10', null, '星期日', null, '2016-2017', '1', '理学');
INSERT INTO `sys_选课记录` VALUES ('bb806e15-d893-4a74-b270-e3d99b0db2bb', '2016-10-13 16:48:20', '2016-10-13 16:48:41', null, null, '0', 'test', 'a5e25daa-8020-4767-9888-fc8b0bea5262', 'A1019', '中华民族崛起之路1', '742d9e11-cce8-4b47-abb5-15d9f3217168', '曾颖妍', '第二周', '第十六周', 'ea1ed7ff-b38b-4411-b8b3-6e6847c50af8', '红琼大楼401', '9-10', null, '星期日', null, '2016-2017', '1', '民族学');
INSERT INTO `sys_选课记录` VALUES ('da461019-8aaf-422c-8f1f-8840279f0fe1', '2016-10-13 16:08:57', '2016-10-13 16:47:26', null, null, '0', 'test ok', '477ab27f-e0fd-4e10-8fbd-09405202e1b2', 'A1018', '生活与法律1', 'fd98ef33-ca1c-401a-8865-f6636ddcde85', '林志阳', '第二周', '第十六周', 'f987e0c8-501f-4629-ac48-9a332d52cfaa', '万威大楼A101', '9-10', null, '星期四', null, '2016-2017', '1', '法学');
INSERT INTO `sys_选课记录` VALUES ('f58e78c0-623a-4561-b0fa-d6faa56720bb', '2016-10-13 16:48:55', '2016-10-13 16:49:16', null, null, '0', 'test', '229c1e4f-5651-44ab-8c29-3632ddb0075f', 'A1020', '世界的奇妙之旅1', '1950e6cd-e3f7-4c5b-853d-013e946168d2', '赵欣颖', '第二周', '第十六周', 'b8c46a6d-a534-48b5-a2c0-804d5cd7a127', '万威大楼B203', '9-10', null, '星期日', null, '2016-2017', '1', '自然科学');
