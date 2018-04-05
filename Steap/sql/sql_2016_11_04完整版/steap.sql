/*
Navicat MySQL Data Transfer

Source Server         : program
Source Server Version : 50629
Source Host           : 127.0.0.1:3306
Source Database       : steap

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2016-11-04 16:40:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for complete_material
-- ----------------------------
DROP TABLE IF EXISTS `complete_material`;
CREATE TABLE `complete_material` (
  `completeId` varchar(40) NOT NULL COMMENT '完善资料编号',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `fileId` int(11) NOT NULL,
  PRIMARY KEY (`completeId`),
  KEY `FK_Reference_27` (`projectId`),
  KEY `FK_Reference_30` (`fileId`),
  CONSTRAINT `FK_Reference_27` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`),
  CONSTRAINT `FK_Reference_30` FOREIGN KEY (`fileId`) REFERENCES `t_files_index` (`fileId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='完善资料表\r\n';

-- ----------------------------
-- Records of complete_material
-- ----------------------------

-- ----------------------------
-- Table structure for complete_verify
-- ----------------------------
DROP TABLE IF EXISTS `complete_verify`;
CREATE TABLE `complete_verify` (
  `verifyId` int(11) NOT NULL COMMENT '项目审核编号',
  `completeId` varchar(40) NOT NULL,
  PRIMARY KEY (`verifyId`,`completeId`),
  KEY `FK_Reference_verifyId` (`verifyId`),
  KEY `FK_Reference_materialId` (`completeId`),
  CONSTRAINT `FK_Reference_completeId` FOREIGN KEY (`completeId`) REFERENCES `complete_material` (`completeId`),
  CONSTRAINT `FK_Reference_verifyId` FOREIGN KEY (`verifyId`) REFERENCES `project_verify` (`verifyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='审核完善资料表';

-- ----------------------------
-- Records of complete_verify
-- ----------------------------

-- ----------------------------
-- Table structure for dic_system_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dic_system_dictionary`;
CREATE TABLE `dic_system_dictionary` (
  `dictionaryOptionId` varchar(40) NOT NULL,
  `dictionaryOptionName` varchar(50) DEFAULT NULL,
  `upDictionaryOptionId` varchar(40) DEFAULT NULL,
  `isUse` bit(1) DEFAULT b'1',
  `description` varchar(200) DEFAULT NULL,
  `sortNo` int(11) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `englishName` varchar(100) DEFAULT NULL,
  `dataType` varchar(100) DEFAULT NULL,
  `remark1` varchar(50) DEFAULT NULL,
  `remark2` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`dictionaryOptionId`),
  KEY `FK_DIC` (`upDictionaryOptionId`),
  CONSTRAINT `FK_DIC` FOREIGN KEY (`upDictionaryOptionId`) REFERENCES `dic_system_dictionary` (`dictionaryOptionId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字典表';

-- ----------------------------
-- Records of dic_system_dictionary
-- ----------------------------
INSERT INTO `dic_system_dictionary` VALUES ('1', '字典列表', null, '', '字典列表', '0', '0', 'dictionaryList', '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('100', '项目状态', '1', '', '项目状态', '0', '0', 'projectStatus', '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('100001', '已登记', '100', '', '已登记', '0', '0', 'recorded', '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('100002', '已确定验收负责部门', '100', '', '已确定验收负责部门', '0', '0', 'charged', '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('100003', '已领取验收项目资料', '100', '', '已领取验收项目资料', '0', '0', 'recieved', '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('100004', '已审查', '100', '', '已审查', '0', '0', 'verified', '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('100005', '已现场考察', '100', '', '已企业现场考场', '0', '0', '', '字符型', '', null);
INSERT INTO `dic_system_dictionary` VALUES ('100006', '已创建项目会议', '100', '', '已创建项目会议', '0', '0', '', '字符型', '', null);
INSERT INTO `dic_system_dictionary` VALUES ('100007', '已评审', '100', '', '已评审', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('100008', '已评估', '100', '', '已评估', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('100009', '已通过审核', '100', '', '已通过审核', '0', '0', '', '字符型', '', '');
INSERT INTO `dic_system_dictionary` VALUES ('200', '会议状态', '1', '', '会议状态', '0', '0', 'meetingStatus', '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('200001', '准备中', '200', '', '准备中', '0', '0', 'preparing', '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('200002', '召开中', '200', '', '召开中', '0', '0', 'holding', '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('200003', '已完成', '200', '', '已完成', '0', '0', 'finished', '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('300', '文件类型', '1', '', '文件类型', '0', '0', 'fileType', '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('300001', '验收意见初稿', '300', '', '验收意见初稿', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('300002', '科技项目验收申请书', '300', '', '科技项目验收申请书', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('300003', '承诺书', '300', '', '承诺书', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('300004', '计划任务书', '300', '', '计划任务书', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('300005', '项目实施工作总结报告', '300', '', '项目实施工作总结报告', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('300006', '项目实施技术总结报告', '300', '', '项目实施技术总结报告', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('300007', '项目立项后相关证明材料', '300', '', '项目立项后相关证明材料', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('300008', '科技项目验收财务资料一套', '300', '', '科技项目验收财务资料一套', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('400', '图片类型', '1', '', '图片类型', '0', '0', 'pictureType', '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('400001', '考察照片', '400', '', '考察照片', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('400002', '廉洁承诺书', '400', '', '廉洁承诺书', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('400003', '真实性承诺书', '400', '', '真实性承诺书', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('400004', '审计报告', '400', '', '审计报告图片', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('500', '机构', '1', '', '机构', '0', '0', 'institution', '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('500001', '专项管理机构业务处室', '500', '', '专项管理机构业务处室', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('500002', '局纪检监察领导', '500', '', '局纪检监察领导', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('600', '领域', '1', '', '领域', '0', '0', 'domin', '字符型', '', null);
INSERT INTO `dic_system_dictionary` VALUES ('600001', '能源与节能环保领域', '600', '', '能源与节能环保领域', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('600002', '现代服务业领域', '600', '', '现代服务业领域', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('600003', '交通运输领域', '600', '', '交通运输领域', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('600004', '信息领域', '600', '', '信息领域', '0', '0', null, '字符型', null, null);

-- ----------------------------
-- Table structure for enterprise_inspect
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_inspect`;
CREATE TABLE `enterprise_inspect` (
  `inspectId` varchar(10) NOT NULL COMMENT '考察编号',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `inspectPerson` varchar(100) NOT NULL,
  `inspectDate` date DEFAULT NULL,
  `inspectResult` longtext NOT NULL,
  `isAudit` bit(1) NOT NULL DEFAULT b'0',
  `inspectStatus` varchar(10) DEFAULT NULL COMMENT '考察状态',
  PRIMARY KEY (`inspectId`),
  KEY `FK_Reference_3` (`projectId`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业考察表';

-- ----------------------------
-- Records of enterprise_inspect
-- ----------------------------

-- ----------------------------
-- Table structure for evaluation_result
-- ----------------------------
DROP TABLE IF EXISTS `evaluation_result`;
CREATE TABLE `evaluation_result` (
  `evaluateResultId` varchar(40) NOT NULL COMMENT '评审结果编号',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `evaluateResult` longtext NOT NULL COMMENT '评审意见',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `checkDate` date NOT NULL,
  PRIMARY KEY (`evaluateResultId`),
  UNIQUE KEY `projectId` (`projectId`),
  UNIQUE KEY `projectId_2` (`projectId`),
  UNIQUE KEY `projectId_3` (`projectId`),
  KEY `FK_Reference_17` (`projectId`),
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评审结果表';

-- ----------------------------
-- Records of evaluation_result
-- ----------------------------

-- ----------------------------
-- Table structure for inspect_audit
-- ----------------------------
DROP TABLE IF EXISTS `inspect_audit`;
CREATE TABLE `inspect_audit` (
  `auditId` varchar(40) NOT NULL COMMENT '审计编号',
  `inspectId` varchar(10) NOT NULL COMMENT '考察编号',
  `financeUnit` varchar(30) NOT NULL COMMENT '财务单位\r\n            ',
  `auditingPerson` varchar(100) NOT NULL COMMENT '审计人员',
  `auditDate` date NOT NULL COMMENT '审计日期',
  PRIMARY KEY (`auditId`),
  KEY `FK_Reference_16` (`inspectId`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`inspectId`) REFERENCES `enterprise_inspect` (`inspectId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目审计表\r\n';

-- ----------------------------
-- Records of inspect_audit
-- ----------------------------

-- ----------------------------
-- Table structure for institution_notify
-- ----------------------------
DROP TABLE IF EXISTS `institution_notify`;
CREATE TABLE `institution_notify` (
  `notifyId` varchar(40) NOT NULL COMMENT '通知编号',
  `meetingId` varchar(7) NOT NULL COMMENT '会议编号',
  `institutionName` varchar(30) NOT NULL COMMENT '部门名称',
  `notifier` varchar(30) NOT NULL COMMENT '通知人',
  `notifyDate` date DEFAULT NULL COMMENT '通知日期',
  `notifyMethod` varchar(10) DEFAULT NULL COMMENT '通知方式',
  `contactPerson` varchar(30) NOT NULL,
  `notifyResult` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`notifyId`),
  KEY `FK_Reference_34` (`meetingId`),
  CONSTRAINT `FK_Reference_34` FOREIGN KEY (`meetingId`) REFERENCES `t_meeting_base_info` (`meetingId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机构通知表';

-- ----------------------------
-- Records of institution_notify
-- ----------------------------

-- ----------------------------
-- Table structure for issue_certificate
-- ----------------------------
DROP TABLE IF EXISTS `issue_certificate`;
CREATE TABLE `issue_certificate` (
  `issueId` varchar(40) NOT NULL COMMENT '发放编号',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `issuePerson` varchar(30) NOT NULL COMMENT '发放人',
  `issueDate` date DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`issueId`),
  KEY `FK_Reference_20` (`projectId`),
  CONSTRAINT `FK_Reference_20` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='证书发放表';

-- ----------------------------
-- Records of issue_certificate
-- ----------------------------

-- ----------------------------
-- Table structure for project_accept
-- ----------------------------
DROP TABLE IF EXISTS `project_accept`;
CREATE TABLE `project_accept` (
  `acceptId` varchar(40) NOT NULL COMMENT '项目接收编号',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `recordDate` date NOT NULL COMMENT '登记日期',
  `recordPerson` varchar(30) NOT NULL COMMENT '登记人',
  `chargeUnit` varchar(30) DEFAULT NULL COMMENT '负责部门',
  `chargePerson` varchar(30) DEFAULT NULL COMMENT '负责人',
  `distributionDate` date DEFAULT NULL COMMENT '分配时间',
  `receiveDate` date DEFAULT NULL COMMENT '领取时间',
  `receivePerson` varchar(30) DEFAULT NULL COMMENT '领取人',
  `receiveResult` longtext,
  `remark1` varchar(50) DEFAULT NULL COMMENT '备注1',
  `remark2` varchar(50) DEFAULT NULL COMMENT '备注2',
  `remark3` varchar(50) DEFAULT NULL COMMENT '备注3',
  PRIMARY KEY (`acceptId`),
  KEY `FK_Reference_5` (`projectId`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目接收表';

-- ----------------------------
-- Records of project_accept
-- ----------------------------

-- ----------------------------
-- Table structure for project_censor
-- ----------------------------
DROP TABLE IF EXISTS `project_censor`;
CREATE TABLE `project_censor` (
  `censorId` varchar(40) NOT NULL COMMENT '审查Id',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `censorDate` date NOT NULL COMMENT '审查时间',
  `censorPerson` varchar(30) NOT NULL COMMENT '审查人',
  `censorResult` longtext NOT NULL COMMENT '审查意见',
  PRIMARY KEY (`censorId`),
  KEY `FK_Reference_2` (`projectId`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目审查表';

-- ----------------------------
-- Records of project_censor
-- ----------------------------

-- ----------------------------
-- Table structure for project_material
-- ----------------------------
DROP TABLE IF EXISTS `project_material`;
CREATE TABLE `project_material` (
  `materialId` varchar(40) NOT NULL,
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `fileId` int(11) NOT NULL,
  PRIMARY KEY (`materialId`),
  UNIQUE KEY `fileId` (`fileId`),
  KEY `FK_Reference_18` (`projectId`),
  KEY `FK_Reference_29` (`fileId`),
  CONSTRAINT `FK_FILE` FOREIGN KEY (`fileId`) REFERENCES `t_files_index` (`fileId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目资料表\r\n';

-- ----------------------------
-- Records of project_material
-- ----------------------------

-- ----------------------------
-- Table structure for project_meeting
-- ----------------------------
DROP TABLE IF EXISTS `project_meeting`;
CREATE TABLE `project_meeting` (
  `meetingId` varchar(7) NOT NULL COMMENT '会议编号',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `notifyDate` date DEFAULT NULL,
  `notifyMethod` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`meetingId`,`projectId`),
  KEY `FK_Reference_9` (`projectId`),
  CONSTRAINT `FK_MEETING` FOREIGN KEY (`meetingId`) REFERENCES `t_meeting_base_info` (`meetingId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`meetingId`) REFERENCES `t_meeting_base_info` (`meetingId`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目会议表';

-- ----------------------------
-- Records of project_meeting
-- ----------------------------

-- ----------------------------
-- Table structure for project_verify
-- ----------------------------
DROP TABLE IF EXISTS `project_verify`;
CREATE TABLE `project_verify` (
  `verifyId` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `completeDescription` longtext COMMENT '资料完善说明',
  `verifyFileNum` int(11) DEFAULT NULL,
  `verifyPerson` varchar(30) DEFAULT NULL,
  `verifyDate` date DEFAULT NULL,
  `verifyResult` longtext,
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`verifyId`),
  KEY `FK_Reference_19` (`projectId`),
  CONSTRAINT `FK_Reference_19` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目审核表';

-- ----------------------------
-- Records of project_verify
-- ----------------------------

-- ----------------------------
-- Table structure for role_module
-- ----------------------------
DROP TABLE IF EXISTS `role_module`;
CREATE TABLE `role_module` (
  `roleId` varchar(40) NOT NULL COMMENT '编号',
  `moduleId` varchar(40) NOT NULL DEFAULT '',
  PRIMARY KEY (`roleId`,`moduleId`),
  KEY `FK_MODULE` (`moduleId`),
  CONSTRAINT `FK_MODULE` FOREIGN KEY (`moduleId`) REFERENCES `t_base_defined_url` (`moduleId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`roleId`) REFERENCES `t_role_base_info` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Records of role_module
-- ----------------------------
INSERT INTO `role_module` VALUES ('c49b4a97-7a92-11e6-a8a9-206a8ab73904', '11');
INSERT INTO `role_module` VALUES ('dd868784-7a92-11e6-a8a9-206a8ab73904', '11');
INSERT INTO `role_module` VALUES ('c49b4a97-7a92-11e6-a8a9-206a8ab73904', '11001');
INSERT INTO `role_module` VALUES ('c49b4a97-7a92-11e6-a8a9-206a8ab73904', '11002');
INSERT INTO `role_module` VALUES ('dd868784-7a92-11e6-a8a9-206a8ab73904', '11003');
INSERT INTO `role_module` VALUES ('dd868784-7a92-11e6-a8a9-206a8ab73904', '11004');
INSERT INTO `role_module` VALUES ('dd868784-7a92-11e6-a8a9-206a8ab73904', '11005');
INSERT INTO `role_module` VALUES ('dd868784-7a92-11e6-a8a9-206a8ab73904', '12');
INSERT INTO `role_module` VALUES ('f3a432bb-7a92-11e6-a8a9-206a8ab73904', '12');
INSERT INTO `role_module` VALUES ('f3a432bb-7a92-11e6-a8a9-206a8ab73904', '12001');
INSERT INTO `role_module` VALUES ('f3a432bb-7a92-11e6-a8a9-206a8ab73904', '12002');
INSERT INTO `role_module` VALUES ('f3a432bb-7a92-11e6-a8a9-206a8ab73904', '12003');
INSERT INTO `role_module` VALUES ('f3a432bb-7a92-11e6-a8a9-206a8ab73904', '12004');
INSERT INTO `role_module` VALUES ('dd868784-7a92-11e6-a8a9-206a8ab73904', '12005');
INSERT INTO `role_module` VALUES ('dd868784-7a92-11e6-a8a9-206a8ab73904', '12006');
INSERT INTO `role_module` VALUES ('dd868784-7a92-11e6-a8a9-206a8ab73904', '12007');
INSERT INTO `role_module` VALUES ('09c7eff4-7a93-11e6-a8a9-206a8ab73904', '13');
INSERT INTO `role_module` VALUES ('09c7eff4-7a93-11e6-a8a9-206a8ab73904', '13002');
INSERT INTO `role_module` VALUES ('dd868784-7a92-11e6-a8a9-206a8ab73904', '14');
INSERT INTO `role_module` VALUES ('dd868784-7a92-11e6-a8a9-206a8ab73904', '14001');
INSERT INTO `role_module` VALUES ('dd868784-7a92-11e6-a8a9-206a8ab73904', '14002');
INSERT INTO `role_module` VALUES ('dd868784-7a92-11e6-a8a9-206a8ab73904', '14003');
INSERT INTO `role_module` VALUES ('2c604a17-7a93-11e6-a8a9-206a8ab73904', '15');
INSERT INTO `role_module` VALUES ('2c604a17-7a93-11e6-a8a9-206a8ab73904', '15001');
INSERT INTO `role_module` VALUES ('2c604a17-7a93-11e6-a8a9-206a8ab73904', '15002');
INSERT INTO `role_module` VALUES ('2c604a17-7a93-11e6-a8a9-206a8ab73904', '15003');
INSERT INTO `role_module` VALUES ('2c604a17-7a93-11e6-a8a9-206a8ab73904', '15004');
INSERT INTO `role_module` VALUES ('2c604a17-7a93-11e6-a8a9-206a8ab73904', '15005');
INSERT INTO `role_module` VALUES ('2c604a17-7a93-11e6-a8a9-206a8ab73904', '15006');

-- ----------------------------
-- Table structure for specialist_arrangement
-- ----------------------------
DROP TABLE IF EXISTS `specialist_arrangement`;
CREATE TABLE `specialist_arrangement` (
  `meetingId` varchar(7) NOT NULL COMMENT '会议编号',
  `specialistId` varchar(8) NOT NULL,
  `leader` varchar(8) DEFAULT NULL COMMENT '会议组长',
  `isAgree` bit(1) DEFAULT b'0',
  `source` varchar(50) DEFAULT NULL,
  `isPromise` bit(1) DEFAULT b'0',
  PRIMARY KEY (`meetingId`,`specialistId`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`meetingId`) REFERENCES `t_meeting_base_info` (`meetingId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of specialist_arrangement
-- ----------------------------

-- ----------------------------
-- Table structure for specialist_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `specialist_evaluation`;
CREATE TABLE `specialist_evaluation` (
  `specialistId` varchar(8) NOT NULL,
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `reviewSuggestion` longtext NOT NULL COMMENT '评审意见',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`specialistId`,`projectId`),
  KEY `FK_Reference_37` (`projectId`),
  CONSTRAINT `FK_Reference_37` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专家评审表';

-- ----------------------------
-- Records of specialist_evaluation
-- ----------------------------

-- ----------------------------
-- Table structure for specialist_library
-- ----------------------------
DROP TABLE IF EXISTS `specialist_library`;
CREATE TABLE `specialist_library` (
  `specialistId` varchar(8) NOT NULL COMMENT '专家编号',
  `name` varchar(10) NOT NULL COMMENT '姓名\r\n            ',
  `sex` varchar(6) NOT NULL COMMENT '性别',
  `password` varchar(16) DEFAULT NULL,
  `signaturePass` varchar(16) DEFAULT NULL,
  `birthday` date NOT NULL COMMENT '出生年月',
  `engageDomain` varchar(16) NOT NULL COMMENT '从事专业\r\n            ',
  `duty` varchar(10) NOT NULL COMMENT '职务',
  `title` varchar(20) NOT NULL COMMENT '职称',
  `telephone` varchar(13) NOT NULL COMMENT '联系电话',
  `email` varchar(100) DEFAULT NULL,
  `signature` varchar(50) DEFAULT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  `workUnit` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`specialistId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专家库';

-- ----------------------------
-- Records of specialist_library
-- ----------------------------
INSERT INTO `specialist_library` VALUES ('SL100001', '小灵之', '女', '123456', null, '1973-11-05', '现代服务业领域', '讲师', '教授', '13384653456', '12345@163.com', null, null, '太原科技大学');
INSERT INTO `specialist_library` VALUES ('SL100002', '风格和健康', '男', '123456', null, '1955-11-15', '信息领域', 'vhjkl', '过后就哭了', '123454567', '123454567@163.com', null, null, '科技哭');
INSERT INTO `specialist_library` VALUES ('SL100003', 'Tom', '男', '123456', null, '1991-11-11', '交通运输领域', '秘密', '教授', '21345663367', '21345663367@163.com', null, null, 'ABC');
INSERT INTO `specialist_library` VALUES ('SL100004', 'Tom', '男', '123456', null, '2016-11-02', '交通运输领域', '秘密', '教授', '23456789567', '345678@163.com', null, null, 'ABC');

-- ----------------------------
-- Table structure for specialist_recommend
-- ----------------------------
DROP TABLE IF EXISTS `specialist_recommend`;
CREATE TABLE `specialist_recommend` (
  `specialistId` varchar(8) NOT NULL COMMENT '专家编号',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `name` varchar(30) NOT NULL COMMENT '姓名\r\n            ',
  `sex` varchar(6) NOT NULL COMMENT '性别',
  `password` varchar(16) DEFAULT NULL,
  `signaturePass` varchar(16) DEFAULT NULL,
  `birthday` date NOT NULL COMMENT '出生年月',
  `engageDomain` varchar(16) NOT NULL COMMENT '从事专业\r\n            ',
  `duty` varchar(10) NOT NULL COMMENT '职务',
  `title` varchar(20) NOT NULL COMMENT '职称',
  `telephone` varchar(13) NOT NULL COMMENT '联系电话',
  `email` varchar(100) DEFAULT NULL,
  `signature` varchar(50) DEFAULT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  `workUnit` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`specialistId`),
  KEY `FK_Reference_28` (`projectId`),
  CONSTRAINT `FK_Reference_28` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专家推荐表';

-- ----------------------------
-- Records of specialist_recommend
-- ----------------------------

-- ----------------------------
-- Table structure for t_base_defined_url
-- ----------------------------
DROP TABLE IF EXISTS `t_base_defined_url`;
CREATE TABLE `t_base_defined_url` (
  `id` varchar(40) NOT NULL COMMENT '机构编号',
  `moduleId` varchar(40) NOT NULL COMMENT '机构名称',
  `moduleName` varchar(100) NOT NULL COMMENT '是否启用',
  `moduleURL` varchar(200) DEFAULT NULL COMMENT '备注',
  `memo1` varchar(100) DEFAULT NULL,
  `momo2` varchar(100) DEFAULT NULL,
  `inUse` bit(1) DEFAULT b'1',
  `sortNo` int(11) DEFAULT NULL,
  `menuClass` int(11) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `moduleId` (`moduleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_base_defined_url
-- ----------------------------
INSERT INTO `t_base_defined_url` VALUES ('00bfacb5-723b-4268-8d1c-903068ad46d1', '15001', '部门管理', 'admin/unit/unit.jsp', '机构管理', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('03686ac8-71d6-11e6-a8a9-206a8ab73904', '15005', '角色管理', 'admin/sys/user/role.jsp', '角色管理', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('05284357-cc85-48dd-82eb-bffc33fcb44b', '11003', '领取验收资料', 'admin/receiveMaterial/getInvestigate.jsp', '领取验收资料', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('0ddfc928-78a5-11e6-a8a9-206a8ab73904', '12001', '创建会议', 'toMeetingManagePage.action', '创建会议', '', '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('121e2105-a54d-499a-bfc5-f6a90335bb5b', '14001', '验收项目资料完善', 'admin/perfectMaterial/ProjectSearch.jsp', '验收项目资料完善', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('1a8e63cf-99c8-47b2-b1a3-f0b49ba2dd68', '14', '验收后管理', null, '验收后管理', null, '', '0', '1', '0');
INSERT INTO `t_base_defined_url` VALUES ('24515a20-db8d-4ca1-ae8b-47dbcfcb65e3', '11002', '确定负责部门', 'admin/receiveMaterial/registerConfirm.jsp', '确定负责部门', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('2b1e1669-92ca-4b40-869e-e5f1d5721dbc', '15', '系统管理', null, '系统管理', null, '', '0', '1', '0');
INSERT INTO `t_base_defined_url` VALUES ('3f79c31d-78a5-11e6-a8a9-206a8ab73904', '12005', '通知企业', 'toMeetingManagePage2.action', '验收资料编制', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('441b3f60-ca17-490c-8e90-939b8a613670', '15002', '用户管理', 'admin/sys/user/user.jsp', '用户管理', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('5102bc52-a570-4011-91f4-23818b61d790', '13002', '会议主持人', null, '会议主持人', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('5f9a4e38-b7bb-40a4-9eef-254869e1c0df', '11', '接受验收材料', null, '接受验收材料', null, '', '0', '1', '0');
INSERT INTO `t_base_defined_url` VALUES ('62a038b2-78a5-11e6-a8a9-206a8ab73904', '12006', '企业准备资料上传', 'toMeetingManagePage2.action', '起草会议通知', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('749306a0-3272-46ca-b034-fb93943b3c94', '15004', '模块管理', 'admin/module/module.jsp', '模块管理', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('7d68d036-6c66-4ff4-86bd-afd0f484cdd0', '11001', '登记验收材料', 'admin/receiveMaterial/registerConfirm.jsp', '登记验收材料', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('82c85d89-78a5-11e6-a8a9-206a8ab73904', '12007', '资料编制', 'toMeetingManagePage2.action', '通知相关人员', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('8d81507d-a793-45ff-9f24-0b176437ca77', '14002', '专家意见修改审核', 'admin/meeting/ProjectSearch.jsp', '专家意见修改审核', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('9a55f82e-a59f-459e-8856-a54a514d8604', '15006', '专家管理', 'admin/specialist/specialist.jsp', '专家管理', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('a6150286-7b28-11e6-80ce-9890969cdf45', '12002', '确定验收专家', 'toMeetingManagePage.action', '确定验收专家 ', '', '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('a87707c7-9136-4558-99dd-a286cec60883', '13', '验收会议管理', null, '验收会议管理', null, '', '0', '1', '0');
INSERT INTO `t_base_defined_url` VALUES ('b8a3ef4b-7b28-11e6-80ce-9890969cdf45', '12003', '通知相关人员', 'toMeetingManagePage.action', '通知相关人员', '', '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('c8889fff-c6ef-493d-a526-6a3491b77f86', '13001', '专家项目验收评审', null, '专家项目验收评审', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('ce486cea-7b28-11e6-80ce-9890969cdf45', '12004', '创建会议议程', 'toMeetingManagePage.action', '创建会议议程', '', '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('d0de4967-615b-4f65-a0f6-57c7d7416466', '12', '验收会前准备', 'toMeetingManagePage.action', '验收会前准备', '', '', '0', '1', '0');
INSERT INTO `t_base_defined_url` VALUES ('ef69b324-6d10-4f75-9a97-908cc6c60a1d', '11005', '企业现场考察', 'admin/receiveMaterial/EnterpriseInvestigate.jsp', '企业现场考察', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('f25a8b99-2ccc-4473-90a2-4201d4e9c33d', '14003', '验收证书发放', 'admin/issue/issue_certificate.jsp', '验收证书发放', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('f6349cf8-782a-4cb8-89d7-06659aa363d3', '15003', '字典管理', 'admin/sys/dictionary/dictionary.jsp', '字典管理', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('f7f90dac-3882-406b-8896-04ce8b256039', '11004', '审查验收资料', 'admin/receiveMaterial/getInvestigate.jsp', '审查验收资料', null, '', '0', '2', '0');

-- ----------------------------
-- Table structure for t_files_index
-- ----------------------------
DROP TABLE IF EXISTS `t_files_index`;
CREATE TABLE `t_files_index` (
  `fileId` int(11) NOT NULL AUTO_INCREMENT,
  `fileType` varchar(6) DEFAULT NULL,
  `originalName` varchar(50) DEFAULT NULL,
  `currentName` varchar(50) DEFAULT NULL,
  `uploadTime` datetime DEFAULT NULL,
  `fileSize` varchar(10) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`fileId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_files_index
-- ----------------------------

-- ----------------------------
-- Table structure for t_meeting_base_info
-- ----------------------------
DROP TABLE IF EXISTS `t_meeting_base_info`;
CREATE TABLE `t_meeting_base_info` (
  `meetingId` varchar(7) NOT NULL COMMENT '会议编号',
  `hostId` varchar(40) DEFAULT NULL COMMENT '编号',
  `meetingName` varchar(60) DEFAULT NULL,
  `meetingTime` datetime NOT NULL COMMENT '会议时间',
  `meetingPlace` varchar(60) DEFAULT NULL,
  `meetingNotice` varchar(50) DEFAULT NULL,
  `meetingStatus` varchar(6) DEFAULT '200001' COMMENT '会议状态',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`meetingId`),
  KEY `FK_Reference_33` (`hostId`),
  CONSTRAINT `FK_Reference_33` FOREIGN KEY (`hostId`) REFERENCES `t_user_base_info` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会议基本信息表';

-- ----------------------------
-- Records of t_meeting_base_info
-- ----------------------------

-- ----------------------------
-- Table structure for t_pictures_index
-- ----------------------------
DROP TABLE IF EXISTS `t_pictures_index`;
CREATE TABLE `t_pictures_index` (
  `pictureId` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `pictureType` varchar(6) DEFAULT NULL COMMENT '图片类型',
  `originalName` varchar(50) DEFAULT NULL COMMENT '图片原始名称',
  `currentName` varchar(50) DEFAULT NULL,
  `uploadTime` datetime DEFAULT NULL,
  `pictureSize` varchar(10) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`pictureId`),
  KEY `FK_Reference_26` (`projectId`),
  CONSTRAINT `FK_Reference_26` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片';

-- ----------------------------
-- Records of t_pictures_index
-- ----------------------------

-- ----------------------------
-- Table structure for t_project_base_info
-- ----------------------------
DROP TABLE IF EXISTS `t_project_base_info`;
CREATE TABLE `t_project_base_info` (
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `projectName` varchar(100) DEFAULT NULL,
  `applicant` varchar(50) DEFAULT NULL,
  `applicationDate` date NOT NULL COMMENT '申请日期',
  `contactPerson` varchar(30) NOT NULL COMMENT '联系人',
  `telephone` varchar(13) NOT NULL COMMENT '联系电话',
  `domain` varchar(16) NOT NULL COMMENT '所属领域',
  `projectFunds` float(7,3) DEFAULT NULL,
  `status` varchar(6) DEFAULT '100001' COMMENT '当前状态',
  `certificate` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否发放证书',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目基本信息表\r\n';

-- ----------------------------
-- Records of t_project_base_info
-- ----------------------------

-- ----------------------------
-- Table structure for t_role_base_info
-- ----------------------------
DROP TABLE IF EXISTS `t_role_base_info`;
CREATE TABLE `t_role_base_info` (
  `roleId` varchar(40) NOT NULL COMMENT '编号',
  `roleName` varchar(50) DEFAULT NULL,
  `isUse` bit(1) DEFAULT b'1',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `remark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户基本信息表';

-- ----------------------------
-- Records of t_role_base_info
-- ----------------------------
INSERT INTO `t_role_base_info` VALUES ('09c7eff4-7a93-11e6-a8a9-206a8ab73904', '会议主持人', '', '会议主持人员', '会议主持人员');
INSERT INTO `t_role_base_info` VALUES ('2c604a17-7a93-11e6-a8a9-206a8ab73904', '系统管理员', '', '系统管理员', '系统管理员');
INSERT INTO `t_role_base_info` VALUES ('c49b4a97-7a92-11e6-a8a9-206a8ab73904', '项目验收资料登记人', '', '项目验收资料登记人', '项目验收资料登记人');
INSERT INTO `t_role_base_info` VALUES ('dd868784-7a92-11e6-a8a9-206a8ab73904', '项目验收负责人', '', '项目验收负责人', '项目验收负责人');
INSERT INTO `t_role_base_info` VALUES ('f3a432bb-7a92-11e6-a8a9-206a8ab73904', '会议创建人', '', '会议创建人员', '会议创建人员');

-- ----------------------------
-- Table structure for t_templeate_base_info
-- ----------------------------
DROP TABLE IF EXISTS `t_templeate_base_info`;
CREATE TABLE `t_templeate_base_info` (
  `templateId` varchar(40) NOT NULL COMMENT '模板编号',
  `templateName` varchar(10) NOT NULL COMMENT '模板名称',
  `templateURL` longtext NOT NULL COMMENT '内容(url)',
  `remark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`templateId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_templeate_base_info
-- ----------------------------

-- ----------------------------
-- Table structure for t_unit_base_info
-- ----------------------------
DROP TABLE IF EXISTS `t_unit_base_info`;
CREATE TABLE `t_unit_base_info` (
  `unitId` varchar(40) NOT NULL COMMENT '部门编号',
  `unitName` varchar(30) NOT NULL COMMENT '名称',
  `upUnitId` varchar(40) DEFAULT NULL COMMENT '上级部门编号',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`unitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门信息表';

-- ----------------------------
-- Records of t_unit_base_info
-- ----------------------------
INSERT INTO `t_unit_base_info` VALUES ('10', '科技评估中心', '', '');
INSERT INTO `t_unit_base_info` VALUES ('10001', '主任办公室', '10', '主任办公室');
INSERT INTO `t_unit_base_info` VALUES ('10002', '项目评估部', '10', '项目评估部');
INSERT INTO `t_unit_base_info` VALUES ('10003', '成果评价部', '10', '成果评价部');

-- ----------------------------
-- Table structure for t_user_account
-- ----------------------------
DROP TABLE IF EXISTS `t_user_account`;
CREATE TABLE `t_user_account` (
  `uaId` varchar(40) NOT NULL,
  `uId` varchar(40) NOT NULL,
  `account` varchar(30) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`uaId`),
  KEY `FK_UC_UID` (`uId`),
  CONSTRAINT `FK_UC_UID` FOREIGN KEY (`uId`) REFERENCES `t_user_base_info` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_account
-- ----------------------------
INSERT INTO `t_user_account` VALUES ('738e9ece-89f7-11e6-81ea-208984976338', 'U100002', '项目登记人', '123456');
INSERT INTO `t_user_account` VALUES ('7df4af79-89f7-11e6-81ea-208984976338', 'U100003', '项目负责人', '123456');
INSERT INTO `t_user_account` VALUES ('8487ebdf-89f7-11e6-81ea-208984976338', 'U100004', '会议创建人', '123456');
INSERT INTO `t_user_account` VALUES ('89fad9af-89f7-11e6-81ea-208984976338', 'U100005', '会议主持人', '123456');
INSERT INTO `t_user_account` VALUES ('900d1b02-89f7-11e6-81ea-208984976338', 'U100006', '系统管理员', '123456');
INSERT INTO `t_user_account` VALUES ('9628a231-89f7-11e6-81ea-208984976338', 'U100001', 'root', '123456');

-- ----------------------------
-- Table structure for t_user_base_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_base_info`;
CREATE TABLE `t_user_base_info` (
  `userId` varchar(40) NOT NULL COMMENT '编号',
  `unitId` varchar(40) NOT NULL COMMENT '部门编号',
  `userName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `name` varchar(30) NOT NULL,
  `sex` varchar(6) NOT NULL COMMENT '性别',
  `password` varchar(16) NOT NULL COMMENT '密码',
  `duty` varchar(10) NOT NULL COMMENT '职位',
  `telephone` varchar(13) NOT NULL,
  PRIMARY KEY (`userId`),
  KEY `FK_Reference_32` (`unitId`),
  CONSTRAINT `FK_Reference_32` FOREIGN KEY (`unitId`) REFERENCES `t_unit_base_info` (`unitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_user_base_info
-- ----------------------------
INSERT INTO `t_user_base_info` VALUES ('U100001', '10001', null, 'admin', '男', '123456', '高级管理员', '18435155316');
INSERT INTO `t_user_base_info` VALUES ('U100002', '10001', null, '项目验收登记人员', '男', '123456', '项目验收登记人员', '18435155227');
INSERT INTO `t_user_base_info` VALUES ('U100003', '10001', null, '项目验收负责人', '男', '123456', '项目验收负责人', '18435156270');
INSERT INTO `t_user_base_info` VALUES ('U100004', '10001', null, '会议创建人员', '男', '123456', '会议创建人员', '18435155317');
INSERT INTO `t_user_base_info` VALUES ('U100005', '10001', null, '会议主持人', '男', '123456', '会议主持人', '18435155318');
INSERT INTO `t_user_base_info` VALUES ('U100006', '10001', null, '系统管理员', '男', '123456', '系统管理员', '18435155319');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `userId` varchar(40) NOT NULL COMMENT '编号',
  `roleId` varchar(40) NOT NULL COMMENT '编号',
  PRIMARY KEY (`userId`,`roleId`),
  KEY `FK_Reference_36` (`roleId`),
  CONSTRAINT `FK_Reference_36` FOREIGN KEY (`roleId`) REFERENCES `t_role_base_info` (`roleId`),
  CONSTRAINT `FK_USER` FOREIGN KEY (`userId`) REFERENCES `t_user_base_info` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('U100005', '09c7eff4-7a93-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100001', '2c604a17-7a93-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100006', '2c604a17-7a93-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100001', 'c49b4a97-7a92-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100002', 'c49b4a97-7a92-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100001', 'dd868784-7a92-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100003', 'dd868784-7a92-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100001', 'f3a432bb-7a92-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100004', 'f3a432bb-7a92-11e6-a8a9-206a8ab73904');

-- ----------------------------
-- View structure for v_complete_material_file
-- ----------------------------
DROP VIEW IF EXISTS `v_complete_material_file`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `v_complete_material_file` AS select `complete_material`.`fileId` AS `fileId`,`complete_material`.`completeId` AS `completeId`,`complete_material`.`projectId` AS `projectId`,`t_files_index`.`fileType` AS `fileType`,`t_files_index`.`originalName` AS `originalName`,`t_files_index`.`currentName` AS `currentName`,`t_files_index`.`uploadTime` AS `uploadTime`,`t_files_index`.`fileSize` AS `fileSize`,`t_files_index`.`remark` AS `remark` from (`complete_material` join `t_files_index` on((`complete_material`.`fileId` = `t_files_index`.`fileId`))) ;

-- ----------------------------
-- View structure for v_project_accept_info
-- ----------------------------
DROP VIEW IF EXISTS `v_project_accept_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `v_project_accept_info` AS select `tpbi`.`projectId` AS `projectId`,`tpbi`.`projectName` AS `projectName`,`tpbi`.`applicant` AS `applicant`,`tpbi`.`applicationDate` AS `applicationDate`,`tpbi`.`contactPerson` AS `contactPerson`,`tpbi`.`telephone` AS `telephone`,`tpbi`.`domain` AS `domain`,`tpbi`.`projectFunds` AS `projectFunds`,`tpbi`.`status` AS `status`,`tpbi`.`certificate` AS `certificate`,`tpbi`.`remark` AS `remark`,`pa`.`recordDate` AS `recordDate`,`pa`.`recordPerson` AS `recordPerson`,`pa`.`chargePerson` AS `chargePerson`,`pa`.`chargeUnit` AS `chargeUnit`,`pa`.`distributionDate` AS `distributionDate`,`pa`.`receiveDate` AS `receiveDate`,`pa`.`receivePerson` AS `receivePerson`,`pa`.`receiveResult` AS `receiveResult`,`pa`.`remark1` AS `remark1`,`pa`.`remark2` AS `remark2`,`pa`.`remark3` AS `remark3`,`pc`.`censorDate` AS `censorDate`,`pc`.`censorPerson` AS `censorPerson`,`pc`.`censorResult` AS `censorResult`,`ei`.`inspectPerson` AS `inspectPerson`,`ei`.`inspectDate` AS `inspectDate`,`ei`.`inspectResult` AS `inspectResult`,`ei`.`isAudit` AS `isAudit`,`ia`.`financeUnit` AS `financeUnit`,`ia`.`auditingPerson` AS `auditingPerson`,`ia`.`auditDate` AS `auditDate` from ((((`t_project_base_info` `tpbi` left join `project_accept` `pa` on((`tpbi`.`projectId` = `pa`.`projectId`))) left join `project_censor` `pc` on((`tpbi`.`projectId` = `pc`.`projectId`))) left join `enterprise_inspect` `ei` on((`tpbi`.`projectId` = `ei`.`projectId`))) left join `inspect_audit` `ia` on((`ei`.`inspectId` = `ia`.`inspectId`))) ;

-- ----------------------------
-- View structure for v_project_material_file
-- ----------------------------
DROP VIEW IF EXISTS `v_project_material_file`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `v_project_material_file` AS select `project_material`.`fileId` AS `fileId`,`project_material`.`materialId` AS `materialId`,`project_material`.`projectId` AS `projectId`,`t_files_index`.`fileType` AS `fileType`,`t_files_index`.`originalName` AS `originalName`,`t_files_index`.`currentName` AS `currentName`,`t_files_index`.`uploadTime` AS `uploadTime`,`t_files_index`.`fileSize` AS `fileSize`,`t_files_index`.`remark` AS `remark` from (`project_material` join `t_files_index` on((`project_material`.`fileId` = `t_files_index`.`fileId`))) ;

-- ----------------------------
-- View structure for v_project_meeting_notify
-- ----------------------------
DROP VIEW IF EXISTS `v_project_meeting_notify`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `v_project_meeting_notify` AS select `t_project_base_info`.`projectId` AS `projectId`,`t_project_base_info`.`projectName` AS `projectName`,`t_project_base_info`.`applicant` AS `applicant`,`t_project_base_info`.`applicationDate` AS `applicationDate`,`t_project_base_info`.`contactPerson` AS `contactPerson`,`t_project_base_info`.`telephone` AS `telephone`,`t_project_base_info`.`domain` AS `domain`,`t_project_base_info`.`projectFunds` AS `projectFunds`,`t_project_base_info`.`status` AS `status`,`t_project_base_info`.`certificate` AS `certificate`,`t_project_base_info`.`remark` AS `remark`,`project_meeting`.`meetingId` AS `meetingId`,`project_meeting`.`notifyDate` AS `notifyDate`,`project_meeting`.`notifyMethod` AS `notifyMethod` from (`t_project_base_info` join `project_meeting` on((`t_project_base_info`.`projectId` = `project_meeting`.`projectId`))) ;
