/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306111
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : steap

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-03-07 08:29:27
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
  PRIMARY KEY  (`completeId`),
  KEY `FK_Reference_27` (`projectId`),
  KEY `FK_Reference_30` (`fileId`),
  CONSTRAINT `FK_Reference_27` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`),
  CONSTRAINT `FK_Reference_30` FOREIGN KEY (`fileId`) REFERENCES `t_files_index` (`fileId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='完善资料表\r\n';

-- ----------------------------
-- Records of complete_material
-- ----------------------------
INSERT INTO `complete_material` VALUES ('0d0f87ac-0b14-459e-b715-56b101598084', '1234523', '75');
INSERT INTO `complete_material` VALUES ('28f92542-250e-49cf-bb17-62464ad1e06f', '1234523', '73');
INSERT INTO `complete_material` VALUES ('42f23347-527b-4f28-9c1e-e59771158370', '1234523', '72');
INSERT INTO `complete_material` VALUES ('7db8b21e-f675-48ea-897e-a81c121588ec', '123546897', '76');
INSERT INTO `complete_material` VALUES ('953e131e-94eb-4c33-8e09-d87f7e3b9935', '1234523', '71');
INSERT INTO `complete_material` VALUES ('a7ebc1cd-77ab-46e5-af09-a8a18ebffcde', '1234523', '74');

-- ----------------------------
-- Table structure for complete_verify
-- ----------------------------
DROP TABLE IF EXISTS `complete_verify`;
CREATE TABLE `complete_verify` (
  `verifyId` int(11) NOT NULL COMMENT '项目审核编号',
  `completeId` varchar(40) NOT NULL,
  PRIMARY KEY  (`verifyId`,`completeId`),
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
  `dictionaryOptionName` varchar(50) default NULL,
  `upDictionaryOptionId` varchar(40) default NULL,
  `isUse` bit(1) default '',
  `description` varchar(200) default NULL,
  `sortNo` int(11) default NULL,
  `flag` int(11) default NULL,
  `englishName` varchar(100) default NULL,
  `dataType` varchar(100) default NULL,
  `remark1` varchar(50) default NULL,
  `remark2` varchar(50) default NULL,
  PRIMARY KEY  (`dictionaryOptionId`),
  KEY `FK_DIC` (`upDictionaryOptionId`),
  CONSTRAINT `FK_DIC` FOREIGN KEY (`upDictionaryOptionId`) REFERENCES `dic_system_dictionary` (`dictionaryOptionId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字典表';

-- ----------------------------
-- Records of dic_system_dictionary
-- ----------------------------
INSERT INTO `dic_system_dictionary` VALUES ('', '化工与轻工技术领域', '600', '', '化工与轻工技术领域', '5', '5', '', '字符型', '', '');
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
INSERT INTO `dic_system_dictionary` VALUES ('600001', '计算机、通讯技术领域', '600', '', '计算机、通讯技术领域', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('600002', '电气自动化领域', '600', '', '电气自动化领域', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('600003', '电子信息领域', '600', '', '电子信息领域', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('600004', '机械装备与制造技术领域', '600', '', '机械装备与制造技术领域', '0', '0', null, '字符型', null, null);

-- ----------------------------
-- Table structure for enterprise_inspect
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_inspect`;
CREATE TABLE `enterprise_inspect` (
  `inspectId` varchar(10) NOT NULL COMMENT '考察编号',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `inspectPerson` varchar(100) NOT NULL,
  `inspectDate` date default NULL,
  `inspectResult` longtext NOT NULL,
  `isAudit` bit(1) NOT NULL default '\0',
  `inspectStatus` varchar(10) default NULL COMMENT '考察状态',
  `enterpriseReceiver` varchar(30) default NULL,
  PRIMARY KEY  (`inspectId`),
  KEY `FK_Reference_3` (`projectId`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业考察表';

-- ----------------------------
-- Records of enterprise_inspect
-- ----------------------------
INSERT INTO `enterprise_inspect` VALUES ('EI10000001', 'asdsadfasdf', '郝菲菲,张亮', '2016-11-25', '考察结果如下：考察结果如下：考察结果如下：考察结果如下：\r\n考察结果如下：考察结果如下：\r\n\r\n\r\n考察结果如下：考察结果如下：', '', '已提交', null);
INSERT INTO `enterprise_inspect` VALUES ('EI10000002', '2016-gx-04', '冯美荣，李长有，何成文', '2017-02-28', '考察结果', '', '已提交', '张三，李四');
INSERT INTO `enterprise_inspect` VALUES ('EI10000003', '20170301', '王赟、梁智', '2017-03-02', '有生产及研发场地，正在进行生产', '\0', '已提交', '张某某');
INSERT INTO `enterprise_inspect` VALUES ('EI10000004', '20120405', '李长有、何成文', '2017-03-01', '齐全', '', '已提交', '张三');
INSERT INTO `enterprise_inspect` VALUES ('EI10000005', '239589', '王赟、梁智', '2017-03-01', '具备研发及生产条件', '\0', '已提交', '闫主任');
INSERT INTO `enterprise_inspect` VALUES ('EI10000006', '1245566', '李长有，何成文', '2017-03-01', '现场在经济区', '\0', '已提交', '张三三');
INSERT INTO `enterprise_inspect` VALUES ('EI10000007', '123546897', '李长有，何成文', '2017-03-01', '现场考察', '', '已提交', '牛部长');
INSERT INTO `enterprise_inspect` VALUES ('EI10000008', '1234523', '王赟、梁智', '2017-03-01', '具备研发和生产场地', '', '已提交', '吕博士');

-- ----------------------------
-- Table structure for evaluation_result
-- ----------------------------
DROP TABLE IF EXISTS `evaluation_result`;
CREATE TABLE `evaluation_result` (
  `evaluateResultId` varchar(40) NOT NULL COMMENT '评审结果编号',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `evaluateResult` longtext NOT NULL COMMENT '评审意见',
  `remark` varchar(50) default '0' COMMENT '备注',
  `checkDate` date NOT NULL,
  PRIMARY KEY  (`evaluateResultId`),
  UNIQUE KEY `projectId` (`projectId`),
  UNIQUE KEY `projectId_2` (`projectId`),
  UNIQUE KEY `projectId_3` (`projectId`),
  KEY `FK_Reference_17` (`projectId`),
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评审结果表';

-- ----------------------------
-- Records of evaluation_result
-- ----------------------------
INSERT INTO `evaluation_result` VALUES ('12cc105d-4fa9-1035-9283-351ef77f9670', '123546897', '阿斯顿发送到反是的发生的发是的发送到发送到阿萨德发生的发生的发生地方阿萨德发生的发生的发是打发士大夫', '1', '2017-03-01');
INSERT INTO `evaluation_result` VALUES ('3d1be260-4fa9-1035-9283-351ef77f9670', '1234523', '4444444444444444444444444444444444444444444444444444', '1', '2017-03-01');

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
  `enterpriseReceiver2` varchar(30) default NULL,
  PRIMARY KEY  (`auditId`),
  KEY `FK_Reference_16` (`inspectId`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`inspectId`) REFERENCES `enterprise_inspect` (`inspectId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目审计表\r\n';

-- ----------------------------
-- Records of inspect_audit
-- ----------------------------
INSERT INTO `inspect_audit` VALUES ('75e31674-4dd3-1035-9ef3-9631346f9394', 'EI10000002', '金鼎事务所', '王会计', '2017-02-28', '李四会计');
INSERT INTO `inspect_audit` VALUES ('9c581178-325c-1035-812b-203bc734aecc', 'EI10000001', '审计单位1', '审计员1', '2016-11-30', null);
INSERT INTO `inspect_audit` VALUES ('9c6b0c49-4fa5-1035-9283-351ef77f9670', 'EI10000007', '立新会计事务所', '李四', '2017-03-01', '牛会计');
INSERT INTO `inspect_audit` VALUES ('9e6021d9-4fa5-1035-9283-351ef77f9670', 'EI10000008', '太原市博林会计师事务所', '吕娜', '2017-03-01', '吕博士');

-- ----------------------------
-- Table structure for institution_notify
-- ----------------------------
DROP TABLE IF EXISTS `institution_notify`;
CREATE TABLE `institution_notify` (
  `notifyId` varchar(40) NOT NULL COMMENT '通知编号',
  `meetingId` varchar(7) NOT NULL COMMENT '会议编号',
  `institutionName` varchar(30) NOT NULL COMMENT '部门名称',
  `notifier` varchar(30) NOT NULL COMMENT '通知人',
  `notifyDate` date default NULL COMMENT '通知日期',
  `notifyMethod` varchar(10) default NULL COMMENT '通知方式',
  `contactPerson` varchar(30) NOT NULL,
  `notifyResult` varchar(50) default NULL,
  PRIMARY KEY  (`notifyId`),
  KEY `FK_Reference_34` (`meetingId`),
  CONSTRAINT `FK_Reference_34` FOREIGN KEY (`meetingId`) REFERENCES `t_meeting_base_info` (`meetingId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机构通知表';

-- ----------------------------
-- Records of institution_notify
-- ----------------------------
INSERT INTO `institution_notify` VALUES ('175f9e52-325d-1035-812b-203bc734aecc', 'M100001', '专项管理机构业务处室', 'U100004', '2017-01-01', '电话', '业务处室1', '同意');
INSERT INTO `institution_notify` VALUES ('6288de45-325d-1035-812b-203bc734aecc', 'M100001', '专项管理机构业务处室', 'U100004', '2017-01-01', '电话', '业务处室1', '同意');
INSERT INTO `institution_notify` VALUES ('628f7f94-325d-1035-812b-203bc734aecc', 'M100001', '专项管理机构业务处室', 'U100004', '2017-01-01', '电话', '业务处室1', '同意');
INSERT INTO `institution_notify` VALUES ('628f8118-325d-1035-812b-203bc734aecc', 'M100001', '局纪检监察领导', 'U100004', '2017-01-01', '电话', '监察领导1', '已通知');
INSERT INTO `institution_notify` VALUES ('6297c111-325d-1035-812b-203bc734aecc', 'M100001', '专项管理机构业务处室', 'U100004', '2017-01-01', '电话', '业务处室1', '同意');
INSERT INTO `institution_notify` VALUES ('6297c2d2-325d-1035-812b-203bc734aecc', 'M100001', '局纪检监察领导', 'U100004', '2017-01-01', '电话', '监察领导1', '已通知');
INSERT INTO `institution_notify` VALUES ('629ad2d2-325d-1035-812b-203bc734aecc', 'M100001', '专项管理机构业务处室', 'U100004', '2017-01-01', 'email', '业务处室联系人2', '已通知');
INSERT INTO `institution_notify` VALUES ('62a1eca7-325d-1035-812b-203bc734aecc', 'M100001', '专项管理机构业务处室', 'U100004', '2017-01-01', '电话', '业务处室1', '同意');
INSERT INTO `institution_notify` VALUES ('62a1ee27-325d-1035-812b-203bc734aecc', 'M100001', '局纪检监察领导', 'U100004', '2017-01-01', '电话', '监察领导1', '已通知');
INSERT INTO `institution_notify` VALUES ('62a1ee71-325d-1035-812b-203bc734aecc', 'M100001', '专项管理机构业务处室', 'U100004', '2017-01-01', 'email', '业务处室联系人2', '已通知');
INSERT INTO `institution_notify` VALUES ('62a1eeb1-325d-1035-812b-203bc734aecc', 'M100001', '局纪检监察领导', 'U100004', '2017-01-01', '电话', '监察领导2', '已通知');

-- ----------------------------
-- Table structure for issue_certificate
-- ----------------------------
DROP TABLE IF EXISTS `issue_certificate`;
CREATE TABLE `issue_certificate` (
  `issueId` varchar(40) NOT NULL COMMENT '发放编号',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `issuePerson` varchar(30) NOT NULL COMMENT '发放人',
  `issueDate` date default NULL,
  `remark` varchar(50) default NULL COMMENT '备注',
  `holder` varchar(30) default NULL,
  `holderPhone` varchar(16) default NULL,
  `holdDate` date default NULL,
  PRIMARY KEY  (`issueId`),
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
  `chargeUnit` varchar(30) default NULL COMMENT '负责部门',
  `chargePerson` varchar(30) default NULL COMMENT '负责人',
  `distributionDate` date default NULL COMMENT '分配时间',
  `receiveDate` date default NULL COMMENT '领取时间',
  `receivePerson` varchar(30) default NULL COMMENT '领取人',
  `receiveResult` longtext,
  `remark1` varchar(50) default NULL COMMENT '备注1',
  `remark2` varchar(50) default NULL COMMENT '备注2',
  `remark3` varchar(50) default NULL COMMENT '备注3',
  PRIMARY KEY  (`acceptId`),
  KEY `FK_Reference_5` (`projectId`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目接收表';

-- ----------------------------
-- Records of project_accept
-- ----------------------------
INSERT INTO `project_accept` VALUES ('08ac1502-f5ec-1034-a891-e94ab6b259a6', '2016-gx-06', '2016-11-07', 'U100002', '主任', 'U100003 ', '2016-11-07', '2016-11-07', 'U100003', '技术5份/审计2份', null, null, null);
INSERT INTO `project_accept` VALUES ('110a4232-4f6e-1035-9283-351ef77f9670', '20170301', '2017-03-01', 'U100008', '成果评价部', 'U100010 ', '2017-03-01', '2017-03-01', 'U100010', '齐全', null, null, null);
INSERT INTO `project_accept` VALUES ('3f503be9-4f74-1035-9283-351ef77f9670', '1245566', '2017-03-02', 'U100008', '项目评估部', 'U100012 ', '2017-03-01', '2017-03-01', 'U100012', '1套', null, null, null);
INSERT INTO `project_accept` VALUES ('64659cf6-f5ec-1034-a891-e94ab6b259a6', '2016-gx-05', '2016-11-07', 'U100002', '项目评估部', 'U100012 ', '2017-02-27', '2016-11-07', 'U100003', '缺少审计报告', null, null, null);
INSERT INTO `project_accept` VALUES ('767e819d-01a7-1035-9c45-929d5f03f2b7', 'asdsadfasdf', '2016-11-22', 'U100009', '主任', 'U100003 ', '2017-01-23', '2016-12-09', 'U100003', '已领取', null, null, null);
INSERT INTO `project_accept` VALUES ('7aeb4d89-4f6e-1035-9283-351ef77f9670', '20120405', '2017-03-01', 'U100008', '项目评估部', 'U100012 ', '2017-03-01', '2017-03-01', 'U100012', 'lll', null, null, null);
INSERT INTO `project_accept` VALUES ('87935b02-f5ec-1034-a891-e94ab6b259a6', '2016-gx-07', '2016-11-07', 'U100002', '项目评估部', 'U100012 ', '2017-02-09', '2016-11-07', 'U100003', '3333', null, null, null);
INSERT INTO `project_accept` VALUES ('89286d65-4fa4-1035-9283-351ef77f9670', '123546897', '2017-03-01', 'U100008', '项目评估部', 'U100012 ', '2017-03-01', '2017-03-01', 'U100012', '领取', null, null, null);
INSERT INTO `project_accept` VALUES ('bb74d4be-f5ec-1034-a891-e94ab6b259a6', '2016-gx-08', '2016-11-03', 'U100002', '项目评估部', 'U100012 ', '2017-02-27', '2016-11-07', 'U100003', '46666', null, null, null);
INSERT INTO `project_accept` VALUES ('f523169c-4f73-1035-9283-351ef77f9670', '239589', '2017-03-01', 'U100008', '成果评价部', 'U100010 ', '2017-03-01', '2017-03-01', 'U100010', '资料齐全', null, null, null);
INSERT INTO `project_accept` VALUES ('f6662af6-f5eb-1034-a891-e94ab6b259a6', '2016-gx-04', '2016-11-07', 'U100002', '项目评估部', 'U100012 ', '2017-02-27', '2016-11-07', 'U100003', '5555', null, null, null);
INSERT INTO `project_accept` VALUES ('f9e90d7f-4fa4-1035-9283-351ef77f9670', '1234523', '2017-03-01', 'U100008', '成果评价部', 'U100010 ', '2017-03-01', '2017-03-01', 'U100010', '完整', null, null, null);

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
  PRIMARY KEY  (`censorId`),
  KEY `FK_Reference_2` (`projectId`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目审查表';

-- ----------------------------
-- Records of project_censor
-- ----------------------------
INSERT INTO `project_censor` VALUES ('22113777-4f6f-1035-9283-351ef77f9670', '20120405', '2017-03-01', 'U100012', 'lll');
INSERT INTO `project_censor` VALUES ('3bf69c55-4f74-1035-9283-351ef77f9670', '239589', '2017-03-01', 'U100010', '符合验收要求');
INSERT INTO `project_censor` VALUES ('49683345-4fa5-1035-9283-351ef77f9670', '1234523', '2017-03-01', 'U100010', '完整');
INSERT INTO `project_censor` VALUES ('5a2c1962-3259-1035-812b-203bc734aecc', 'asdsadfasdf', '2016-11-23', 'U100003', '已审查');
INSERT INTO `project_censor` VALUES ('6426cbf8-4f74-1035-9283-351ef77f9670', '1245566', '2017-03-01', 'U100012', '齐全');
INSERT INTO `project_censor` VALUES ('66e16e4d-4dd2-1035-9ef3-9631346f9394', '2016-gx-04', '2017-02-27', 'U100012', '审查存在问题');
INSERT INTO `project_censor` VALUES ('6f2aa84e-4fa5-1035-9283-351ef77f9670', '123546897', '2017-03-01', 'U100012', '基本齐全');
INSERT INTO `project_censor` VALUES ('7f3bd530-f5ef-1034-a891-e94ab6b259a6', '2016-gx-06', '2016-11-07', 'U100003', '1、缺少骑缝章\n2、附件中缺少');
INSERT INTO `project_censor` VALUES ('7f989479-4dd2-1035-9ef3-9631346f9394', '2016-gx-05', '2017-02-14', 'U100012', '阿斯蒂芬');
INSERT INTO `project_censor` VALUES ('9d9d8e4b-4dd2-1035-9ef3-9631346f9394', '2016-gx-07', '2017-02-27', 'U100012', '阿斯蒂芬');
INSERT INTO `project_censor` VALUES ('a08d3b72-4f6e-1035-9283-351ef77f9670', '20170301', '2017-03-01', 'U100010', '111');
INSERT INTO `project_censor` VALUES ('aae8a502-4dd2-1035-9ef3-9631346f9394', '2016-gx-08', '2017-02-27', 'U100012', '是的发送到发送到');

-- ----------------------------
-- Table structure for project_material
-- ----------------------------
DROP TABLE IF EXISTS `project_material`;
CREATE TABLE `project_material` (
  `materialId` varchar(40) NOT NULL,
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `fileId` int(11) NOT NULL,
  PRIMARY KEY  (`materialId`),
  UNIQUE KEY `fileId` (`fileId`),
  KEY `FK_Reference_18` (`projectId`),
  KEY `FK_Reference_29` (`fileId`),
  CONSTRAINT `FK_FILE` FOREIGN KEY (`fileId`) REFERENCES `t_files_index` (`fileId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目资料表\r\n';

-- ----------------------------
-- Records of project_material
-- ----------------------------
INSERT INTO `project_material` VALUES ('01e46185-4f76-1035-9283-351ef77f9670', '239589', '33');
INSERT INTO `project_material` VALUES ('052c126a-4f76-1035-9283-351ef77f9670', '239589', '34');
INSERT INTO `project_material` VALUES ('094d6b11-4f76-1035-9283-351ef77f9670', '239589', '35');
INSERT INTO `project_material` VALUES ('09908471-4f71-1035-9283-351ef77f9670', '2016-gx-04', '6');
INSERT INTO `project_material` VALUES ('0b4c08b7-4f77-1035-9283-351ef77f9670', '239589', '50');
INSERT INTO `project_material` VALUES ('0d45f1e2-4f76-1035-9283-351ef77f9670', '239589', '36');
INSERT INTO `project_material` VALUES ('120c7eee-4f76-1035-9283-351ef77f9670', '239589', '37');
INSERT INTO `project_material` VALUES ('14f1fd81-4fa7-1035-9283-351ef77f9670', '123546897', '69');
INSERT INTO `project_material` VALUES ('164c505d-4f76-1035-9283-351ef77f9670', '239589', '38');
INSERT INTO `project_material` VALUES ('1a9c36f1-4f76-1035-9283-351ef77f9670', '239589', '39');
INSERT INTO `project_material` VALUES ('24046c6e-4fa6-1035-9283-351ef77f9670', '123546897', '52');
INSERT INTO `project_material` VALUES ('279c7937-4fa6-1035-9283-351ef77f9670', '123546897', '53');
INSERT INTO `project_material` VALUES ('27c25011-4f72-1035-9283-351ef77f9670', '20170301', '19');
INSERT INTO `project_material` VALUES ('2a402dc3-4fa6-1035-9283-351ef77f9670', '123546897', '54');
INSERT INTO `project_material` VALUES ('2d8dcf2b-4fa6-1035-9283-351ef77f9670', '123546897', '55');
INSERT INTO `project_material` VALUES ('310f0c51-4fa6-1035-9283-351ef77f9670', '123546897', '56');
INSERT INTO `project_material` VALUES ('31524f6a-4f72-1035-9283-351ef77f9670', '2016-gx-04', '20');
INSERT INTO `project_material` VALUES ('3156c3be-4f76-1035-9283-351ef77f9670', '239589', '40');
INSERT INTO `project_material` VALUES ('33fb0c9d-4fa6-1035-9283-351ef77f9670', '123546897', '57');
INSERT INTO `project_material` VALUES ('370dbf96-4fa6-1035-9283-351ef77f9670', '123546897', '58');
INSERT INTO `project_material` VALUES ('3e5342d9-4fa6-1035-9283-351ef77f9670', '123546897', '59');
INSERT INTO `project_material` VALUES ('45eadc43-4f73-1035-9283-351ef77f9670', '2016-gx-04', '30');
INSERT INTO `project_material` VALUES ('4cbc5dde-4f72-1035-9283-351ef77f9670', '2016-gx-04', '22');
INSERT INTO `project_material` VALUES ('4fc721ca-4f72-1035-9283-351ef77f9670', '2016-gx-04', '23');
INSERT INTO `project_material` VALUES ('51256cfd-4f71-1035-9283-351ef77f9670', '20170301', '7');
INSERT INTO `project_material` VALUES ('52d5412d-4f77-1035-9283-351ef77f9670', '1245566', '51');
INSERT INTO `project_material` VALUES ('547b094d-4f71-1035-9283-351ef77f9670', '2016-gx-04', '8');
INSERT INTO `project_material` VALUES ('55f9aeeb-4f72-1035-9283-351ef77f9670', '2016-gx-04', '24');
INSERT INTO `project_material` VALUES ('5ae1f30d-4f72-1035-9283-351ef77f9670', '2016-gx-04', '25');
INSERT INTO `project_material` VALUES ('5c7b00b6-4fa7-1035-9283-351ef77f9670', '1234523', '70');
INSERT INTO `project_material` VALUES ('614cb9fa-4f71-1035-9283-351ef77f9670', '2016-gx-04', '9');
INSERT INTO `project_material` VALUES ('6a4fab47-4fa6-1035-9283-351ef77f9670', '1234523', '60');
INSERT INTO `project_material` VALUES ('6e754801-3269-1035-812b-203bc734aecc', 'asdsadfasdf', '5');
INSERT INTO `project_material` VALUES ('6f4d8f71-4f72-1035-9283-351ef77f9670', '20170301', '26');
INSERT INTO `project_material` VALUES ('6f80ea69-4fa6-1035-9283-351ef77f9670', '1234523', '61');
INSERT INTO `project_material` VALUES ('70894e33-4f72-1035-9283-351ef77f9670', '20170301', '27');
INSERT INTO `project_material` VALUES ('746e846a-4fa6-1035-9283-351ef77f9670', '1234523', '62');
INSERT INTO `project_material` VALUES ('790127f1-4fa6-1035-9283-351ef77f9670', '1234523', '63');
INSERT INTO `project_material` VALUES ('7c37427f-4f76-1035-9283-351ef77f9670', '239589', '41');
INSERT INTO `project_material` VALUES ('7e7ce2ee-4fa6-1035-9283-351ef77f9670', '1234523', '64');
INSERT INTO `project_material` VALUES ('82eb5bf2-4fa6-1035-9283-351ef77f9670', '1234523', '65');
INSERT INTO `project_material` VALUES ('85dd57ac-4fa6-1035-9283-351ef77f9670', '1234523', '66');
INSERT INTO `project_material` VALUES ('8755ffed-4fa6-1035-9283-351ef77f9670', '1234523', '67');
INSERT INTO `project_material` VALUES ('8d7612b5-4f73-1035-9283-351ef77f9670', '20170301', '31');
INSERT INTO `project_material` VALUES ('98af1682-4f71-1035-9283-351ef77f9670', '20170301', '11');
INSERT INTO `project_material` VALUES ('a2d7b419-4f76-1035-9283-351ef77f9670', '1245566', '42');
INSERT INTO `project_material` VALUES ('a6a6202f-4f76-1035-9283-351ef77f9670', '1245566', '43');
INSERT INTO `project_material` VALUES ('aa5ee20a-4f71-1035-9283-351ef77f9670', '20170301', '12');
INSERT INTO `project_material` VALUES ('accd5256-4f76-1035-9283-351ef77f9670', '1245566', '44');
INSERT INTO `project_material` VALUES ('b10c34da-4f76-1035-9283-351ef77f9670', '1245566', '45');
INSERT INTO `project_material` VALUES ('b5fcaedd-4f76-1035-9283-351ef77f9670', '1245566', '46');
INSERT INTO `project_material` VALUES ('b5ff6c1b-4f71-1035-9283-351ef77f9670', '20170301', '13');
INSERT INTO `project_material` VALUES ('b6d760f4-4f72-1035-9283-351ef77f9670', '2016-gx-04', '28');
INSERT INTO `project_material` VALUES ('b9f9ec97-4f76-1035-9283-351ef77f9670', '1245566', '47');
INSERT INTO `project_material` VALUES ('be8b0374-4f76-1035-9283-351ef77f9670', '1245566', '48');
INSERT INTO `project_material` VALUES ('c3c1b508-4f76-1035-9283-351ef77f9670', '1245566', '49');
INSERT INTO `project_material` VALUES ('cd68e13e-4fa6-1035-9283-351ef77f9670', '1234523', '68');
INSERT INTO `project_material` VALUES ('cd96d79b-325e-1035-812b-203bc734aecc', 'asdsadfasdf', '2');
INSERT INTO `project_material` VALUES ('d3321ec5-4f71-1035-9283-351ef77f9670', '20170301', '14');
INSERT INTO `project_material` VALUES ('d5014339-4f73-1035-9283-351ef77f9670', '20170301', '32');
INSERT INTO `project_material` VALUES ('daaaf9ac-4f71-1035-9283-351ef77f9670', '20170301', '15');
INSERT INTO `project_material` VALUES ('dfe3dec4-4f71-1035-9283-351ef77f9670', '20170301', '16');
INSERT INTO `project_material` VALUES ('e038be30-4f71-1035-9283-351ef77f9670', '20170301', '17');
INSERT INTO `project_material` VALUES ('ef08b864-4f71-1035-9283-351ef77f9670', '20170301', '18');
INSERT INTO `project_material` VALUES ('fe5fd1d1-4f72-1035-9283-351ef77f9670', '20170301', '29');

-- ----------------------------
-- Table structure for project_meeting
-- ----------------------------
DROP TABLE IF EXISTS `project_meeting`;
CREATE TABLE `project_meeting` (
  `meetingId` varchar(7) NOT NULL COMMENT '会议编号',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `notifyDate` date default NULL,
  `notifyMethod` varchar(10) default NULL,
  PRIMARY KEY  (`meetingId`,`projectId`),
  KEY `FK_Reference_9` (`projectId`),
  CONSTRAINT `FK_MEETING` FOREIGN KEY (`meetingId`) REFERENCES `t_meeting_base_info` (`meetingId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`meetingId`) REFERENCES `t_meeting_base_info` (`meetingId`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目会议表';

-- ----------------------------
-- Records of project_meeting
-- ----------------------------
INSERT INTO `project_meeting` VALUES ('M100001', 'asdsadfasdf', null, null);
INSERT INTO `project_meeting` VALUES ('M100002', '2016-gx-04', '2017-03-01', '电话');
INSERT INTO `project_meeting` VALUES ('M100002', '20170301', '2017-03-01', '电话');
INSERT INTO `project_meeting` VALUES ('M100003', '1245566', '2017-03-01', '电话');
INSERT INTO `project_meeting` VALUES ('M100003', '239589', '2017-03-01', '电话');
INSERT INTO `project_meeting` VALUES ('M100004', '1234523', '2017-03-01', '电话');
INSERT INTO `project_meeting` VALUES ('M100004', '123546897', '2017-03-01', '电话');

-- ----------------------------
-- Table structure for project_verify
-- ----------------------------
DROP TABLE IF EXISTS `project_verify`;
CREATE TABLE `project_verify` (
  `verifyId` int(11) NOT NULL auto_increment,
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `completeDescription` longtext COMMENT '资料完善说明',
  `verifyFileNum` int(11) default NULL,
  `verifyPerson` varchar(30) default NULL,
  `verifyDate` date default NULL,
  `verifyResult` longtext,
  `remark` varchar(50) default NULL COMMENT '备注',
  PRIMARY KEY  (`verifyId`),
  KEY `FK_Reference_19` (`projectId`),
  CONSTRAINT `FK_Reference_19` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目审核表';

-- ----------------------------
-- Records of project_verify
-- ----------------------------
INSERT INTO `project_verify` VALUES ('1', '1234523', '', '0', null, null, null, null);
INSERT INTO `project_verify` VALUES ('2', '1234523', '已补充调整申请', '0', 'U100008', '2017-03-08', 'asdfasdfasdfasdf', null);

-- ----------------------------
-- Table structure for role_module
-- ----------------------------
DROP TABLE IF EXISTS `role_module`;
CREATE TABLE `role_module` (
  `roleId` varchar(40) NOT NULL COMMENT '编号',
  `moduleId` varchar(40) NOT NULL default '',
  PRIMARY KEY  (`roleId`,`moduleId`),
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
INSERT INTO `role_module` VALUES ('09c7eff4-7a93-11e6-a8a9-206a8ab73904', '12');
INSERT INTO `role_module` VALUES ('dd868784-7a92-11e6-a8a9-206a8ab73904', '12');
INSERT INTO `role_module` VALUES ('f3a432bb-7a92-11e6-a8a9-206a8ab73904', '12');
INSERT INTO `role_module` VALUES ('f3a432bb-7a92-11e6-a8a9-206a8ab73904', '12001');
INSERT INTO `role_module` VALUES ('09c7eff4-7a93-11e6-a8a9-206a8ab73904', '12002');
INSERT INTO `role_module` VALUES ('f3a432bb-7a92-11e6-a8a9-206a8ab73904', '12002');
INSERT INTO `role_module` VALUES ('f3a432bb-7a92-11e6-a8a9-206a8ab73904', '12003');
INSERT INTO `role_module` VALUES ('09c7eff4-7a93-11e6-a8a9-206a8ab73904', '12004');
INSERT INTO `role_module` VALUES ('f3a432bb-7a92-11e6-a8a9-206a8ab73904', '12004');
INSERT INTO `role_module` VALUES ('dd868784-7a92-11e6-a8a9-206a8ab73904', '12005');
INSERT INTO `role_module` VALUES ('dd868784-7a92-11e6-a8a9-206a8ab73904', '12006');
INSERT INTO `role_module` VALUES ('dd868784-7a92-11e6-a8a9-206a8ab73904', '12007');
INSERT INTO `role_module` VALUES ('09c7eff4-7a93-11e6-a8a9-206a8ab73904', '13');
INSERT INTO `role_module` VALUES ('09c7eff4-7a93-11e6-a8a9-206a8ab73904', '13001');
INSERT INTO `role_module` VALUES ('09c7eff4-7a93-11e6-a8a9-206a8ab73904', '13002');
INSERT INTO `role_module` VALUES ('07708e57-4ada-1035-9ef3-9631346f9394', '14');
INSERT INTO `role_module` VALUES ('dd868784-7a92-11e6-a8a9-206a8ab73904', '14');
INSERT INTO `role_module` VALUES ('dd868784-7a92-11e6-a8a9-206a8ab73904', '14001');
INSERT INTO `role_module` VALUES ('dd868784-7a92-11e6-a8a9-206a8ab73904', '14002');
INSERT INTO `role_module` VALUES ('07708e57-4ada-1035-9ef3-9631346f9394', '14003');
INSERT INTO `role_module` VALUES ('2c604a17-7a93-11e6-a8a9-206a8ab73904', '15');
INSERT INTO `role_module` VALUES ('2c604a17-7a93-11e6-a8a9-206a8ab73904', '15001');
INSERT INTO `role_module` VALUES ('2c604a17-7a93-11e6-a8a9-206a8ab73904', '15002');
INSERT INTO `role_module` VALUES ('2c604a17-7a93-11e6-a8a9-206a8ab73904', '15003');
INSERT INTO `role_module` VALUES ('2c604a17-7a93-11e6-a8a9-206a8ab73904', '15004');
INSERT INTO `role_module` VALUES ('2c604a17-7a93-11e6-a8a9-206a8ab73904', '15005');
INSERT INTO `role_module` VALUES ('2c604a17-7a93-11e6-a8a9-206a8ab73904', '15006');
INSERT INTO `role_module` VALUES ('2c604a17-7a93-11e6-a8a9-206a8ab73904', '15007');

-- ----------------------------
-- Table structure for specialist_arrangement
-- ----------------------------
DROP TABLE IF EXISTS `specialist_arrangement`;
CREATE TABLE `specialist_arrangement` (
  `meetingId` varchar(7) NOT NULL COMMENT '会议编号',
  `specialistId` varchar(8) NOT NULL,
  `leader` varchar(8) default NULL COMMENT '会议组长',
  `isAgree` bit(1) default '\0',
  `source` varchar(50) default NULL,
  `isPromise` bit(1) default '\0',
  PRIMARY KEY  (`meetingId`,`specialistId`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`meetingId`) REFERENCES `t_meeting_base_info` (`meetingId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of specialist_arrangement
-- ----------------------------
INSERT INTO `specialist_arrangement` VALUES ('M100001', 'SL100007', null, '\0', 'null', '\0');
INSERT INTO `specialist_arrangement` VALUES ('M100001', 'SL100008', null, '\0', 'null', '\0');
INSERT INTO `specialist_arrangement` VALUES ('M100002', 'SL100001', '组长', '', 'null', '');
INSERT INTO `specialist_arrangement` VALUES ('M100002', 'SL100002', null, '\0', 'null', '\0');
INSERT INTO `specialist_arrangement` VALUES ('M100002', 'SL100003', null, '', 'null', '');
INSERT INTO `specialist_arrangement` VALUES ('M100002', 'SL100004', null, '\0', 'null', '\0');
INSERT INTO `specialist_arrangement` VALUES ('M100002', 'SL100006', '副组长', '\0', 'null', '\0');
INSERT INTO `specialist_arrangement` VALUES ('M100003', 'SL100004', null, '\0', 'null', '\0');
INSERT INTO `specialist_arrangement` VALUES ('M100003', 'SL100005', '副组长', '', 'null', '');
INSERT INTO `specialist_arrangement` VALUES ('M100003', 'SL100006', null, '\0', 'null', '\0');
INSERT INTO `specialist_arrangement` VALUES ('M100003', 'SL100007', null, '', 'null', '');
INSERT INTO `specialist_arrangement` VALUES ('M100003', 'SL100008', '组长', '', 'null', '');
INSERT INTO `specialist_arrangement` VALUES ('M100004', 'SL100009', '副组长', '', 'null', '');
INSERT INTO `specialist_arrangement` VALUES ('M100004', 'SL100010', '组长', '', 'null', '');

-- ----------------------------
-- Table structure for specialist_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `specialist_evaluation`;
CREATE TABLE `specialist_evaluation` (
  `specialistId` varchar(8) NOT NULL,
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `reviewSuggestion` longtext NOT NULL COMMENT '评审意见',
  `remark` varchar(50) default '0' COMMENT '备注',
  PRIMARY KEY  (`specialistId`,`projectId`),
  KEY `FK_Reference_37` (`projectId`),
  CONSTRAINT `FK_Reference_37` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专家评审表';

-- ----------------------------
-- Records of specialist_evaluation
-- ----------------------------
INSERT INTO `specialist_evaluation` VALUES ('SL100001', '2016-gx-04', '88888888888888888888888888888888888888<div class=\"div-container\" style=\"display: block; float: right; width: 400px; height: 180px;\"><img src=\"signature/dd3db359-70ea-4ccc-abf5-f797a2de22bc.JPG\" style=\"float: left; width: 400px; height: 180px;\"></div>', '1');
INSERT INTO `specialist_evaluation` VALUES ('SL100001', '20170301', '12313123132<div class=\"div-container\" style=\"display: block; float: right; width: 400px; height: 180px;\"><img src=\"signature/dd3db359-70ea-4ccc-abf5-f797a2de22bc.JPG\" style=\"float: left; width: 400px; height: 180px;\"></div>', '1');
INSERT INTO `specialist_evaluation` VALUES ('SL100003', '2016-gx-04', 'fffffffff<div class=\"div-container\" style=\"display: block; float: right; width: 400px; height: 180px;\"><img src=\"signature/d622c911-8600-4a7e-82cc-0b7054f1b038.JPG\" style=\"float: left; width: 400px; height: 180px;\"></div>', '1');
INSERT INTO `specialist_evaluation` VALUES ('SL100005', '1245566', 'asdfas<span style=\"font-size:28px;\">dfasdfjkl;</span>asj来<span style=\"font-size:24px;\">得及开发大家</span>付款拉丝绝地反<h1>击阿萨德发斯蒂<b><span style=\"color:rgb(106,168,79);\">芬阿萨德法师打发斯蒂芬阿斯顿</span></b>发送到</h1><div class=\"div-container\" style=\"display: block; float: right; width: 400px; height: 180px;\"><img src=\"signature/1cae863f-11dc-44a0-b470-55d226f2ba32.JPG\" style=\"float: left; width: 400px; height: 180px;\"></div>', '1');
INSERT INTO `specialist_evaluation` VALUES ('SL100005', '239589', '阿斯顿发送到阿斯顿发萨水电费<div>按商定高富帅党费各</div><div class=\"div-container\" style=\"display: block; float: right; width: 400px; height: 180px;\"><img src=\"signature/1cae863f-11dc-44a0-b470-55d226f2ba32.JPG\" style=\"float: left; width: 400px; height: 180px;\"></div>', '1');
INSERT INTO `specialist_evaluation` VALUES ('SL100007', '1245566', '<h1>fdsfwqfqf</h1><div class=\"div-container\" style=\"display: block; float: right; width: 400px; height: 180px;\"><img src=\"signature/709e6b75-ebc0-49ac-9e89-9f036220ee56.jpg\" style=\"float: left; width: 400px; height: 180px;\"></div>', '1');
INSERT INTO `specialist_evaluation` VALUES ('SL100007', '239589', '<h3>gdfhjfsgdsgs</h3>', '0');
INSERT INTO `specialist_evaluation` VALUES ('SL100008', '1245566', '1.技术创新点需进一步凝练；<div>2.财务支出与预算不符，应附上调整申请</div><div class=\"div-container\" style=\"display: block; float: right; width: 400px; height: 180px;\"><img src=\"signature/59f89bf5-fc5f-4217-a1fd-59972f5cd53a.BMP\" style=\"float: left; width: 400px; height: 180px;\"></div>', '1');
INSERT INTO `specialist_evaluation` VALUES ('SL100008', '239589', '无<div class=\"div-container\" style=\"display: block; float: right; width: 400px; height: 180px;\"><img src=\"signature/59f89bf5-fc5f-4217-a1fd-59972f5cd53a.BMP\" style=\"float: left; width: 400px; height: 180px;\"></div>', '1');
INSERT INTO `specialist_evaluation` VALUES ('SL100009', '1234523', '经费支出调整申请需项目组长签字，单位盖章<div class=\"div-container\" style=\"display: block; float: right; width: 400px; height: 180px;\"><img src=\"signature/3a468593-f45a-4462-b2a5-58c0b93e5843.JPG\" style=\"float: left; width: 400px; height: 180px;\"></div>', '1');
INSERT INTO `specialist_evaluation` VALUES ('SL100009', '123546897', '经费使用与预算不符，需附调整申请<div class=\"div-container\" style=\"display: block; float: right; width: 400px; height: 180px;\"><img src=\"signature/3a468593-f45a-4462-b2a5-58c0b93e5843.JPG\" style=\"float: left; width: 400px; height: 180px;\"></div>', '1');
INSERT INTO `specialist_evaluation` VALUES ('SL100010', '1234523', '验收意见<div>基本齐全，任务完成。</div><div>综上所述，通过验收</div><div class=\"div-container\" style=\"display: block; float: right; width: 400px; height: 180px;\"><img src=\"signature/dacf0cc9-6c40-4598-99a9-4af13c8c238b.jpg\" style=\"float: left; width: 400px; height: 180px;\"></div>', '1');
INSERT INTO `specialist_evaluation` VALUES ('SL100010', '123546897', '验收意见<div>基本齐全，任务完成。</div><div>综上所述，通过验收</div><div class=\"div-container\" style=\"display: block; float: right; width: 400px; height: 180px;\"><img src=\"signature/dacf0cc9-6c40-4598-99a9-4af13c8c238b.jpg\" style=\"float: left; width: 400px; height: 180px;\"></div>', '1');

-- ----------------------------
-- Table structure for specialist_library
-- ----------------------------
DROP TABLE IF EXISTS `specialist_library`;
CREATE TABLE `specialist_library` (
  `specialistId` varchar(8) NOT NULL COMMENT '专家编号',
  `name` varchar(10) NOT NULL COMMENT '姓名\r\n            ',
  `sex` varchar(6) NOT NULL COMMENT '性别',
  `account` varchar(30) default NULL,
  `password` varchar(16) default NULL,
  `signaturePass` varchar(16) default NULL,
  `birthday` date NOT NULL COMMENT '出生年月',
  `engageDomain` varchar(16) NOT NULL COMMENT '从事专业\r\n            ',
  `duty` varchar(10) NOT NULL COMMENT '职务',
  `title` varchar(20) NOT NULL COMMENT '职称',
  `telephone` varchar(13) NOT NULL COMMENT '联系电话',
  `email` varchar(100) default NULL,
  `signature` varchar(50) default NULL,
  `lastLoginTime` datetime default NULL,
  `workUnit` varchar(30) default NULL,
  PRIMARY KEY  (`specialistId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专家库';

-- ----------------------------
-- Records of specialist_library
-- ----------------------------
INSERT INTO `specialist_library` VALUES ('SL100001', '小灵之', '女', 'zj001', '123456', '456123', '1973-11-05', '计算机、通讯技术领域', '讲师', '教授', '13384653456', '12345@163.com', 'dd3db359-70ea-4ccc-abf5-f797a2de22bc.JPG', null, '太原科技大学');
INSERT INTO `specialist_library` VALUES ('SL100002', '风格和健康', '女', 'zj002', '123456', null, '1955-11-15', '电子信息领域', 'vhjkl', '高工', '123454567', '123454567@163.com', null, null, '科技哭');
INSERT INTO `specialist_library` VALUES ('SL100003', 'Tom', '男', 'zj004', '123456', '456123', '1991-11-11', '电子信息领域', '秘密', '教授', '21345663367', '21345663367@163.com', 'd622c911-8600-4a7e-82cc-0b7054f1b038.JPG', null, 'ABC');
INSERT INTO `specialist_library` VALUES ('SL100004', '王腾', '男', 'zj003', '654321', '001', '1975-11-02', '计算机、通讯技术领域', '秘密', '教授', '12345698789', '345678@163.com', '9430f628-d7d0-418c-b08f-bee2f86e8257.JPG', null, 'ABC');
INSERT INTO `specialist_library` VALUES ('SL100005', '张子刚', '男', 'zjg', '123456', '456123', '1968-05-22', '电气自动化领域', '院长', '教授', '035123888888', 'zhangzig@163.com', '1cae863f-11dc-44a0-b470-55d226f2ba32.JPG', null, '太原科技大学');
INSERT INTO `specialist_library` VALUES ('SL100006', '黄云飞', '女', 'zj005', '123456', '123456', '1971-01-23', '电子信息领域', '无', '教授', '13735809080', 'huangyunfei@163.com', 'e0d76ec1-0af9-4f62-bec3-08e5a66e649d.jpg', null, '太原理工大学');
INSERT INTO `specialist_library` VALUES ('SL100007', '王强', '男', 'wangqiang', '123456', 'wangqiang', '1974-01-23', '电气自动化领域', '院长', '教授', '13993221111', 'wangqiang@163.com', '709e6b75-ebc0-49ac-9e89-9f036220ee56.jpg', null, '山西大学');
INSERT INTO `specialist_library` VALUES ('SL100008', '高飞', '男', 'gaofei', '123456', '001', '1969-03-14', '电气自动化领域', '副所长', '研究员', '035123888888', 'gaofei@126.com', '59f89bf5-fc5f-4217-a1fd-59972f5cd53a.BMP', null, '自动化研究所');
INSERT INTO `specialist_library` VALUES ('SL100009', '白仙红', '女', 'bxh', '123456', '002', '1975-03-12', '电子信息领域', '院长', '副教授', '15936547895', 'adf@456.com', '3a468593-f45a-4462-b2a5-58c0b93e5843.JPG', null, '财税专科学校');
INSERT INTO `specialist_library` VALUES ('SL100010', '孙桓五', '男', 'shw', '123456', '123456', '1975-03-11', '电气自动化领域', '阿斯顿发送到', '爱的飒飒的', '13112345646', 'asdfaas@dd.com', 'f7e70976-f3e2-447b-9e3f-24179d0960fa.jpg', null, '太原理工大学');

-- ----------------------------
-- Table structure for specialist_recommend
-- ----------------------------
DROP TABLE IF EXISTS `specialist_recommend`;
CREATE TABLE `specialist_recommend` (
  `specialistId` varchar(8) NOT NULL COMMENT '专家编号',
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `name` varchar(30) NOT NULL COMMENT '姓名\r\n            ',
  `sex` varchar(6) NOT NULL COMMENT '性别',
  `password` varchar(16) default NULL,
  `signaturePass` varchar(16) default NULL,
  `birthday` date NOT NULL COMMENT '出生年月',
  `engageDomain` varchar(16) NOT NULL COMMENT '从事专业\r\n            ',
  `duty` varchar(10) NOT NULL COMMENT '职务',
  `title` varchar(20) NOT NULL COMMENT '职称',
  `telephone` varchar(13) NOT NULL COMMENT '联系电话',
  `email` varchar(100) default NULL,
  `signature` varchar(50) default NULL,
  `lastLoginTime` datetime default NULL,
  `workUnit` varchar(30) default NULL,
  PRIMARY KEY  (`specialistId`),
  KEY `FK_Reference_28` (`projectId`),
  CONSTRAINT `FK_Reference_28` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专家推荐表';

-- ----------------------------
-- Records of specialist_recommend
-- ----------------------------
INSERT INTO `specialist_recommend` VALUES ('SR100001', 'asdsadfasdf', '王强', '男', null, null, '1974-01-23', '电气自动化领域', '院长', '教授', '13993221111', 'wangqiang@163.com', null, null, '山西大学');
INSERT INTO `specialist_recommend` VALUES ('SR100002', 'asdsadfasdf', '高飞', '男', null, null, '1969-03-14', '电气自动化领域', '副所长', '研究员', '035123888888', 'gaofei@126.com', null, null, '自动化研究所');

-- ----------------------------
-- Table structure for t_base_defined_url
-- ----------------------------
DROP TABLE IF EXISTS `t_base_defined_url`;
CREATE TABLE `t_base_defined_url` (
  `id` varchar(40) NOT NULL COMMENT '机构编号',
  `moduleId` varchar(40) NOT NULL COMMENT '机构名称',
  `moduleName` varchar(100) NOT NULL COMMENT '是否启用',
  `moduleURL` varchar(200) default NULL COMMENT '备注',
  `memo1` varchar(100) default NULL,
  `momo2` varchar(100) default NULL,
  `inUse` bit(1) default '',
  `sortNo` int(11) default NULL,
  `menuClass` int(11) default NULL,
  `flag` int(11) default NULL,
  PRIMARY KEY  (`id`),
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
INSERT INTO `t_base_defined_url` VALUES ('24515a20-db8d-4ca1-ae8b-47dbcfcb65e3', '11002', '确定负责部门', 'admin/receiveMaterial/ConfirmDepartment.jsp', '确定负责部门', null, '', '0', '2', '0');
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
INSERT INTO `t_base_defined_url` VALUES ('f1b1e51b-3fc0-1035-b4b5-ee6636dcaed3', '15007', '评审意见管理', 'admin/sys/opinion/evaluationOpinion.jsp', '评审意见管理', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('f25a8b99-2ccc-4473-90a2-4201d4e9c33d', '14003', '验收证书发放', 'admin/issue/issue_certificate.jsp', '验收证书发放', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('f6349cf8-782a-4cb8-89d7-06659aa363d3', '15003', '字典管理', 'admin/sys/dictionary/dictionary.jsp', '字典管理', null, '', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('f7f90dac-3882-406b-8896-04ce8b256039', '11004', '审查验收资料', 'admin/receiveMaterial/getInvestigate.jsp', '审查验收资料', null, '', '0', '2', '0');

-- ----------------------------
-- Table structure for t_files_index
-- ----------------------------
DROP TABLE IF EXISTS `t_files_index`;
CREATE TABLE `t_files_index` (
  `fileId` int(11) NOT NULL auto_increment,
  `fileType` varchar(6) default NULL,
  `originalName` varchar(50) default NULL,
  `currentName` varchar(50) default NULL,
  `uploadTime` datetime default NULL,
  `fileSize` varchar(10) default NULL,
  `remark` varchar(50) default NULL,
  PRIMARY KEY  (`fileId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_files_index
-- ----------------------------
INSERT INTO `t_files_index` VALUES ('2', '300001', 'ceshi.doc', 'f39bcf17-9d55-479f-8e93-3522f618e2d6.pdf', '2017-01-23 09:52:39', '11KB', null);
INSERT INTO `t_files_index` VALUES ('5', '300002', 'ceshi.doc', '1cd94bf8-264f-4f98-8276-5b5e4c6bcb3e.pdf', '2017-01-23 11:08:44', '11KB', null);
INSERT INTO `t_files_index` VALUES ('6', '300001', '测试说明.doc', '38aab577-9771-42ef-8a80-db8afe85ed13.pdf', '2017-03-01 09:44:14', '30KB', null);
INSERT INTO `t_files_index` VALUES ('7', '300001', '测试说明.doc', 'cfb3f3aa-b72b-4682-91ab-f789c1a81f8f.pdf', '2017-03-01 09:46:14', '30KB', null);
INSERT INTO `t_files_index` VALUES ('8', '300002', '系统使用手册.pdf', '8b142aa0-8c65-445a-a93a-fbc38a5c39d0.pdf', '2017-03-01 09:48:20', '4558KB', null);
INSERT INTO `t_files_index` VALUES ('9', '300003', '系统使用手册.pdf', 'a6149335-1026-4f46-bab2-97157af037ea.pdf', '2017-03-01 09:48:41', '4558KB', null);
INSERT INTO `t_files_index` VALUES ('11', '300001', '测试说明.doc', '642b3492-00dd-4393-9bcb-74d4511e5cd1.pdf', '2017-03-01 09:47:43', '30KB', null);
INSERT INTO `t_files_index` VALUES ('12', '300002', '系统使用手册.pdf', '682be978-4de7-4173-986b-54f25872b2ef.pdf', '2017-03-01 09:50:44', '4558KB', null);
INSERT INTO `t_files_index` VALUES ('13', '300004', '系统使用手册.pdf', '14bccb61-c7b4-49c7-bc6c-b4151933f553.pdf', '2017-03-01 09:51:04', '4558KB', null);
INSERT INTO `t_files_index` VALUES ('14', '300005', '系统使用手册.pdf', '0f6546e1-f035-49a7-a7ea-4e02b3342187.pdf', '2017-03-01 09:51:53', '4558KB', null);
INSERT INTO `t_files_index` VALUES ('15', '300006', '系统使用手册.pdf', '73707a66-a9d4-45a1-afa9-e1cc2fd8052f.pdf', '2017-03-01 09:52:05', '4558KB', null);
INSERT INTO `t_files_index` VALUES ('16', '300007', '系统使用手册.pdf', '2a46bfcd-6baa-46e2-baa9-89b5f18d2d98.pdf', '2017-03-01 09:52:14', '4558KB', null);
INSERT INTO `t_files_index` VALUES ('17', '300001', '出租.doc', '6c9429c5-60d9-480b-b41c-9fe90e6aa240.pdf', '2017-03-01 09:47:27', '27KB', null);
INSERT INTO `t_files_index` VALUES ('18', '300003', '系统使用手册.pdf', '9ee8c853-b7a6-47a7-aa9b-ee15e2b3b545.pdf', '2017-03-01 09:52:39', '4558KB', null);
INSERT INTO `t_files_index` VALUES ('19', '300001', '出租.doc', '4191dff9-b4b6-46cd-adb1-3b9fd38debfb.pdf', '2017-03-01 09:46:39', '27KB', null);
INSERT INTO `t_files_index` VALUES ('20', '300004', '系统使用手册.pdf', 'c5c28e5d-cbd9-4b92-a3c2-894bea2a891e.pdf', '2017-03-01 09:54:30', '4558KB', null);
INSERT INTO `t_files_index` VALUES ('22', '300005', '系统使用手册.pdf', '97761112-b203-4822-9904-98c67910efe1.pdf', '2017-03-01 09:55:16', '4558KB', null);
INSERT INTO `t_files_index` VALUES ('23', '300006', '系统使用手册.pdf', '93a38341-088e-4886-8b23-44a20a3add2b.pdf', '2017-03-01 09:55:22', '4558KB', null);
INSERT INTO `t_files_index` VALUES ('24', '300007', '系统使用手册.pdf', 'ca06264a-3039-4e75-a8e8-b1f4f31080fe.pdf', '2017-03-01 09:55:32', '4558KB', null);
INSERT INTO `t_files_index` VALUES ('25', '300008', '系统使用手册.pdf', '87d44186-4153-4fd2-8eb9-21036436a07d.pdf', '2017-03-01 09:55:40', '4558KB', null);
INSERT INTO `t_files_index` VALUES ('26', '300001', '出租.doc', '84b012cd-7314-40cb-9454-2b34b50e61b3.pdf', '2017-03-01 09:46:25', '27KB', null);
INSERT INTO `t_files_index` VALUES ('27', '300008', '值班消息.pdf', 'fabf8d56-f3e1-4109-a33f-90eb265792a6.pdf', '2017-03-01 09:56:17', '38KB', null);
INSERT INTO `t_files_index` VALUES ('28', '300001', '测试说明.doc', 'fe4f6989-f810-418d-8415-b71f5df3af63.pdf', '2017-03-01 09:46:14', '30KB', null);
INSERT INTO `t_files_index` VALUES ('29', '300001', '测试说明.doc', '4aeae34b-092b-4c05-865c-dcdab156849a.pdf', '2017-03-01 09:46:14', '30KB', null);
INSERT INTO `t_files_index` VALUES ('30', '300001', '测试说明.doc', '91d2373b-4929-40fc-ad98-97b0cc22e975.pdf', '2017-03-01 09:46:14', '30KB', null);
INSERT INTO `t_files_index` VALUES ('31', '300001', '测试说明.doc', 'c50f1e77-b680-4e1f-ade5-83d3baee470a.pdf', '2017-03-01 09:49:25', '30KB', null);
INSERT INTO `t_files_index` VALUES ('32', '300001', '测试说明.doc', 'f2563185-1d4a-457d-9e4b-085d7582d8f2.pdf', '2017-03-01 09:48:26', '30KB', null);
INSERT INTO `t_files_index` VALUES ('33', '300002', '值班消息.pdf', '7bbcb01c-bb47-4b75-9e14-9e8302e3aab5.pdf', '2017-03-01 10:21:49', '38KB', null);
INSERT INTO `t_files_index` VALUES ('34', '300003', '值班消息.pdf', 'a4cb9bae-913e-4c2a-bc1b-14cabdb993ff.pdf', '2017-03-01 10:21:54', '38KB', null);
INSERT INTO `t_files_index` VALUES ('35', '300004', '值班消息.pdf', 'bcf40588-03b4-4b15-b72e-edc2a5719c97.pdf', '2017-03-01 10:22:01', '38KB', null);
INSERT INTO `t_files_index` VALUES ('36', '300005', '值班消息.pdf', 'b0db9c18-7234-4a44-887b-0f842d7fcc67.pdf', '2017-03-01 10:22:08', '38KB', null);
INSERT INTO `t_files_index` VALUES ('37', '300006', '值班消息.pdf', '3ddb1c02-5cec-42a2-8757-7f4f5b0b6e6d.pdf', '2017-03-01 10:22:16', '38KB', null);
INSERT INTO `t_files_index` VALUES ('38', '300007', '值班消息.pdf', 'c0b91c26-ca82-4d8f-8e5b-7c262a207830.pdf', '2017-03-01 10:22:23', '38KB', null);
INSERT INTO `t_files_index` VALUES ('39', '300008', '值班消息.pdf', '598df7c6-001a-4692-a840-85e3d8fcd8d0.pdf', '2017-03-01 10:22:30', '38KB', null);
INSERT INTO `t_files_index` VALUES ('40', '300001', '测试说明.doc', '986f3026-a50f-4007-9745-b827d2d94f4c.pdf', '2017-03-01 10:21:08', '30KB', null);
INSERT INTO `t_files_index` VALUES ('41', '300001', '测试说明.doc', '5e6764bd-5c77-4bfe-ba08-018d9276adfa.pdf', '2017-03-01 10:23:14', '30KB', null);
INSERT INTO `t_files_index` VALUES ('42', '300002', '系统使用手册.pdf', '2bef2d0e-493d-49ba-bf8b-f5ecb07e9742.pdf', '2017-03-01 10:26:19', '4558KB', null);
INSERT INTO `t_files_index` VALUES ('43', '300003', '系统使用手册.pdf', '9bfa792c-6600-464d-b5cb-65426fb1df07.pdf', '2017-03-01 10:26:25', '4558KB', null);
INSERT INTO `t_files_index` VALUES ('44', '300004', '系统使用手册.pdf', 'aa4f64ed-5eb4-4044-97e4-348e0748d56e.pdf', '2017-03-01 10:26:36', '4558KB', null);
INSERT INTO `t_files_index` VALUES ('45', '300005', '系统使用手册.pdf', 'a8ce96aa-1c09-4187-88fd-b6102297ba88.pdf', '2017-03-01 10:26:43', '4558KB', null);
INSERT INTO `t_files_index` VALUES ('46', '300006', '系统使用手册.pdf', 'a9a5814d-8d1d-43f0-8518-1805ad275200.pdf', '2017-03-01 10:26:51', '4558KB', null);
INSERT INTO `t_files_index` VALUES ('47', '300007', '系统使用手册.pdf', '9bc89737-8373-4742-8fba-d9ea9a020d7b.pdf', '2017-03-01 10:26:58', '4558KB', null);
INSERT INTO `t_files_index` VALUES ('48', '300008', '系统使用手册.pdf', 'c6b9ebc3-6a08-4914-a100-ac15216af132.pdf', '2017-03-01 10:27:05', '4558KB', null);
INSERT INTO `t_files_index` VALUES ('49', '300001', '测试说明.doc', '77ad2c1d-f4cc-409a-8852-aeff8fba9ba2.pdf', '2017-03-01 10:25:13', '30KB', null);
INSERT INTO `t_files_index` VALUES ('50', '300001', '测试说明.doc', 'c12f840c-7086-4626-8116-5b253d34fe27.pdf', '2017-03-01 10:23:23', '30KB', null);
INSERT INTO `t_files_index` VALUES ('51', '300001', '测试说明.doc', '0685e239-fdd5-49f9-8524-a28e4624c0ba.pdf', '2017-03-01 10:25:50', '30KB', null);
INSERT INTO `t_files_index` VALUES ('52', '300002', '山西省科研项目经费和科技活动经费管理办法.pdf', 'dd52c0ed-9bdc-44d8-b4e4-547254ca0fd6.pdf', '2017-03-01 16:06:22', '3800KB', null);
INSERT INTO `t_files_index` VALUES ('53', '300003', '山西省科研项目经费和科技活动经费管理办法.pdf', '57190184-3865-4fb5-b2ba-5904242deb2f.pdf', '2017-03-01 16:06:28', '3800KB', null);
INSERT INTO `t_files_index` VALUES ('54', '300004', '山西省科研项目经费和科技活动经费管理办法.pdf', 'cf6958d7-0acc-428c-b13f-4a1727a61e9c.pdf', '2017-03-01 16:06:32', '3800KB', null);
INSERT INTO `t_files_index` VALUES ('55', '300005', '山西省科研项目经费和科技活动经费管理办法.pdf', 'de053247-6e8a-4cc8-b891-46c3ae6141d7.pdf', '2017-03-01 16:06:38', '3800KB', null);
INSERT INTO `t_files_index` VALUES ('56', '300006', '山西省科研项目经费和科技活动经费管理办法.pdf', '9a0c2790-bcc6-4bf4-8a0c-782cb03581a8.pdf', '2017-03-01 16:06:44', '3800KB', null);
INSERT INTO `t_files_index` VALUES ('57', '300007', '山西省科研项目经费和科技活动经费管理办法.pdf', '59e32441-9d1e-413e-a234-648199cbefba.pdf', '2017-03-01 16:06:49', '3800KB', null);
INSERT INTO `t_files_index` VALUES ('58', '300008', '山西省科研项目经费和科技活动经费管理办法.pdf', '36794fb3-5b66-4f94-8955-196df08b64f9.pdf', '2017-03-01 16:06:54', '3800KB', null);
INSERT INTO `t_files_index` VALUES ('59', '300001', '附件（科技展品登记表）.doc', 'b73346fc-1ec6-4abe-9c9b-a484275db805.pdf', '2017-03-01 16:05:06', '15KB', null);
INSERT INTO `t_files_index` VALUES ('60', '300002', '情况说明2.pdf', 'b09bce3f-67c3-4e79-ad4f-176f965f9db6.pdf', '2017-03-01 16:08:20', '100KB', null);
INSERT INTO `t_files_index` VALUES ('61', '300003', '情况说明2.pdf', '66f61f51-1292-4a3c-83c7-e9f5fa29e640.pdf', '2017-03-01 16:08:29', '100KB', null);
INSERT INTO `t_files_index` VALUES ('62', '300004', '情况说明2.pdf', 'b29f907b-5865-4424-8132-0152e2683c9d.pdf', '2017-03-01 16:08:37', '100KB', null);
INSERT INTO `t_files_index` VALUES ('63', '300005', '情况说明2.pdf', '5d6d46e3-ae4b-4dbe-b056-3307f09fb36b.pdf', '2017-03-01 16:08:45', '100KB', null);
INSERT INTO `t_files_index` VALUES ('64', '300006', '情况说明2.pdf', '094201b2-0426-49c0-af28-ce77a77b8a39.pdf', '2017-03-01 16:08:54', '100KB', null);
INSERT INTO `t_files_index` VALUES ('65', '300007', '情况说明2.pdf', 'fef50cee-1196-418e-ba7b-4f9bb2d37f5a.pdf', '2017-03-01 16:09:01', '100KB', null);
INSERT INTO `t_files_index` VALUES ('66', '300001', '情况说明2.docx', 'a827c9bb-6678-466e-8628-99b8223ac299.pdf', '2017-03-01 16:07:03', '17KB', null);
INSERT INTO `t_files_index` VALUES ('67', '300008', '情况说明2.pdf', '07c8bad2-16cb-45d4-b991-6be4d9dcc4df.pdf', '2017-03-01 16:09:09', '100KB', null);
INSERT INTO `t_files_index` VALUES ('68', '300001', '情况说明2.docx', '33de6f4c-72f0-4ade-a635-a3cd37cc771a.pdf', '2017-03-01 16:06:20', '17KB', null);
INSERT INTO `t_files_index` VALUES ('69', '300001', '院所成果征集名单.doc', '6f46ef7c-1cc3-4065-acff-972dd263d2fa.pdf', '2017-03-01 16:05:35', '20KB', null);
INSERT INTO `t_files_index` VALUES ('70', '300001', '科技服务协议 -西屋.doc', '3c999dfe-3628-45fe-a14a-82777c3fa4fd.pdf', '2017-03-01 16:07:55', '25KB', null);
INSERT INTO `t_files_index` VALUES ('71', '300007', '星火项目.doc', 'ed8533e3-81a0-4082-b70f-66f61effcba4.doc', '2017-03-01 17:02:15', '40KB', null);
INSERT INTO `t_files_index` VALUES ('72', '300007', '情况说明2.docx', 'd4d08ab5-603e-42f0-9793-e70cf8246d3a.docx', '2017-03-01 17:04:16', '17KB', null);
INSERT INTO `t_files_index` VALUES ('73', '300002', '科技服务协议 -急救中心最终.doc', 'd643344b-66c1-4127-93a3-380861149b81.doc', '2017-03-01 17:54:09', '18KB', null);
INSERT INTO `t_files_index` VALUES ('74', '300002', '科技服务协议 -急救中心最终.doc', 'a50f7f4d-6974-4368-afee-11e47391f280.doc', '2017-03-01 17:54:19', '18KB', null);
INSERT INTO `t_files_index` VALUES ('75', '300002', '科技服务协议 -急救中心最终.doc', 'f3fba407-0385-41c5-93eb-10addeb61f7a.doc', '2017-03-01 17:55:24', '18KB', null);
INSERT INTO `t_files_index` VALUES ('76', '300003', '山西省一页介绍.doc', 'f96159b1-e1db-4427-935b-beb3411f70d6.doc', '2017-03-03 11:20:24', '12KB', null);

-- ----------------------------
-- Table structure for t_meeting_base_info
-- ----------------------------
DROP TABLE IF EXISTS `t_meeting_base_info`;
CREATE TABLE `t_meeting_base_info` (
  `meetingId` varchar(7) NOT NULL COMMENT '会议编号',
  `hostId` varchar(40) default NULL COMMENT '编号',
  `meetingName` varchar(60) default NULL,
  `meetingTime` datetime NOT NULL COMMENT '会议时间',
  `meetingPlace` varchar(60) default NULL,
  `meetingNotice` varchar(50) default NULL,
  `meetingStatus` varchar(6) default '200001' COMMENT '会议状态',
  `remark` varchar(50) default NULL COMMENT '备注',
  PRIMARY KEY  (`meetingId`),
  KEY `FK_Reference_33` (`hostId`),
  CONSTRAINT `FK_Reference_33` FOREIGN KEY (`hostId`) REFERENCES `t_user_base_info` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会议基本信息表';

-- ----------------------------
-- Records of t_meeting_base_info
-- ----------------------------
INSERT INTO `t_meeting_base_info` VALUES ('M100001', 'U100005', '项目会议1', '2017-01-23 09:38:01', '太原科技评估中心', null, '200001', '项目会议1');
INSERT INTO `t_meeting_base_info` VALUES ('M100002', 'U100013', '验收会', '2017-03-01 09:36:23', '评估中心一楼会议室', null, '200002', '会议说明');
INSERT INTO `t_meeting_base_info` VALUES ('M100003', 'U100008', '才阿三大法', '2017-03-08 10:12:05', '金刚里西乡子', null, '200002', '阿三大');
INSERT INTO `t_meeting_base_info` VALUES ('M100004', 'U100009', '大项目', '2017-03-23 16:00:45', '评估中心', null, '200003', '化工');

-- ----------------------------
-- Table structure for t_pictures_index
-- ----------------------------
DROP TABLE IF EXISTS `t_pictures_index`;
CREATE TABLE `t_pictures_index` (
  `pictureId` int(11) NOT NULL auto_increment,
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `pictureType` varchar(6) default NULL COMMENT '图片类型',
  `originalName` varchar(50) default NULL COMMENT '图片原始名称',
  `currentName` varchar(50) default NULL,
  `uploadTime` datetime default NULL,
  `pictureSize` varchar(10) default NULL,
  `remark` varchar(50) default NULL COMMENT '备注',
  PRIMARY KEY  (`pictureId`),
  KEY `FK_Reference_26` (`projectId`),
  CONSTRAINT `FK_Reference_26` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片';

-- ----------------------------
-- Records of t_pictures_index
-- ----------------------------
INSERT INTO `t_pictures_index` VALUES ('1', 'asdsadfasdf', '400001', 'IMG_3898.JPG', 'b729e7e2-9e92-4c21-abfc-8f0c534359f3.JPG', '2017-01-23 09:36:49', '2991031', null);
INSERT INTO `t_pictures_index` VALUES ('2', 'asdsadfasdf', '400001', 'IMG_3899.JPG', '8134ab68-5e8f-42fc-a3d5-bb969e32f473.JPG', '2017-01-23 09:36:50', '2716385', null);
INSERT INTO `t_pictures_index` VALUES ('3', 'asdsadfasdf', '400002', 'IMG_3899.JPG', '5a1e7679-217a-44d8-b16b-371e27114fa8.JPG', '2017-01-23 09:36:53', '2716385', null);
INSERT INTO `t_pictures_index` VALUES ('4', '2016-gx-04', '400001', 'IMG_4316.JPG', '23bd2fa4-1155-4b2e-9d30-61e8874fdacc.JPG', '2017-02-27 08:26:10', '54719', null);
INSERT INTO `t_pictures_index` VALUES ('5', '2016-gx-04', '400002', 'IMG_4314.JPG', '5392727c-4770-4c5c-9b8b-7854cade1e5c.JPG', '2017-02-27 08:26:21', '89676', null);
INSERT INTO `t_pictures_index` VALUES ('6', '20170301', '400001', 'city.jpg', '388e85c9-1067-4333-9639-70966e810f71.jpg', '2017-03-01 09:31:33', '8998088', null);
INSERT INTO `t_pictures_index` VALUES ('7', '20170301', '400003', '手机终端交接确认单.jpg', 'c746ab4a-1fc7-4577-bea0-065538d57b58.jpg', '2017-03-01 09:45:01', '629KB', null);
INSERT INTO `t_pictures_index` VALUES ('8', '2016-gx-04', '400003', 'Hydrangeas.jpg', '4585e0e2-8eab-4272-ae17-c195d8cf9065.jpg', '2017-03-01 09:46:36', '595KB', null);
INSERT INTO `t_pictures_index` VALUES ('9', '2016-gx-04', '400003', 'Jellyfish.jpg', 'e1cddaed-1a1b-43c3-940a-ef6d37197322.jpg', '2017-03-01 09:47:05', '775KB', null);
INSERT INTO `t_pictures_index` VALUES ('10', '239589', '400001', 'night.jpg', '75fc4d3a-8ea1-49a8-a6d8-5f9da08d880a.jpg', '2017-03-01 10:11:05', '3283017', null);
INSERT INTO `t_pictures_index` VALUES ('12', '239589', '400003', '手机终端交接确认单.jpg', 'd03f1745-30ca-4d0a-bf6e-7c8ba6be7b2b.jpg', '2017-03-01 10:24:28', '629KB', null);
INSERT INTO `t_pictures_index` VALUES ('13', '1245566', '400003', 'Chrysanthemum.jpg', 'de06465d-13e2-449c-93a9-a7fcecdbf78c.jpg', '2017-03-01 10:25:31', '879KB', null);
INSERT INTO `t_pictures_index` VALUES ('14', '1234523', '400001', 'IMG_0785.JPG', '8db5fc73-5212-4f44-b179-4d1a4d04e48e.JPG', '2017-03-01 16:01:48', '4042405', null);
INSERT INTO `t_pictures_index` VALUES ('15', '1234523', '400002', 'IMG_0788.JPG', '9bb0218a-10b3-4219-964c-29da8ff0e12a.JPG', '2017-03-01 16:02:35', '2998555', null);
INSERT INTO `t_pictures_index` VALUES ('17', '1234523', '400003', '太原市科技评估中心账号信息.jpg', 'f0d31fb3-c157-4879-b8e0-fa7cfe9462a1.jpg', '2017-03-01 16:06:50', '614KB', null);
INSERT INTO `t_pictures_index` VALUES ('18', '123546897', '400003', '001.jpg', 'd9657e11-66af-4a0f-a5ed-8711e2109899.jpg', '2017-03-01 16:08:09', '670KB', null);

-- ----------------------------
-- Table structure for t_project_base_info
-- ----------------------------
DROP TABLE IF EXISTS `t_project_base_info`;
CREATE TABLE `t_project_base_info` (
  `projectId` varchar(40) NOT NULL COMMENT '项目编号',
  `projectName` varchar(100) default NULL,
  `applicant` varchar(50) default NULL,
  `applicationDate` date NOT NULL COMMENT '申请日期',
  `contactPerson` varchar(30) NOT NULL COMMENT '联系人',
  `telephone` varchar(13) NOT NULL COMMENT '联系电话',
  `domain` varchar(16) NOT NULL COMMENT '所属领域',
  `projectFunds` float(7,3) default NULL,
  `status` varchar(6) default '100001' COMMENT '当前状态',
  `certificate` bit(1) NOT NULL default '\0' COMMENT '是否发放证书',
  `remark` varchar(50) default NULL COMMENT '备注',
  `endDate` date default NULL,
  PRIMARY KEY  (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目基本信息表\r\n';

-- ----------------------------
-- Records of t_project_base_info
-- ----------------------------
INSERT INTO `t_project_base_info` VALUES ('1234523', '碳纤维', '煤化所', '2011-03-30', '白', '123455', '化工与轻工技术领域', '500.000', '100009', '\0', null, '2013-09-23');
INSERT INTO `t_project_base_info` VALUES ('123546897', '路桥', '喜跃发', '2015-03-02', '李', '1234567', '化工与轻工技术领域', '100.000', '100008', '\0', null, '2016-03-16');
INSERT INTO `t_project_base_info` VALUES ('1245566', '石墨烯', '煤化所', '2015-03-01', '李', '5693821', '化工与轻工技术领域', '10.000', '100006', '\0', null, '2016-03-14');
INSERT INTO `t_project_base_info` VALUES ('20120405', '太阳能', '景辉能源', '2012-03-15', '杨', '12405829121', '化工与轻工技术领域', '50.000', '100004', '\0', null, '2013-12-31');
INSERT INTO `t_project_base_info` VALUES ('2016-gx-04', '基于阿萨德法师打发斯蒂芬阿斯蒂芬', '太原大意科技有限公司', '2016-11-07', '峰峰', '5621023', '电子信息领域', '100.000', '100006', '\0', null, null);
INSERT INTO `t_project_base_info` VALUES ('2016-gx-05', '阿斯顿发射点', '山西手动阀手动阀有限公司', '2016-11-01', '阿斯顿', '5621023', '电子信息领域', '30.000', '100004', '\0', null, null);
INSERT INTO `t_project_base_info` VALUES ('2016-gx-06', '水电费感受到分公司的分公司', '太原电饭锅电饭锅科技有限公司', '2016-11-01', '水电工', '5621023', '电子信息领域', '20.000', '100004', '\0', null, null);
INSERT INTO `t_project_base_info` VALUES ('2016-gx-07', '阿道夫请问人情味人情味请问', '山西终结者有限公司', '2016-09-29', '情人桥', '5621028', '电子信息领域', '50.000', '100004', '\0', null, null);
INSERT INTO `t_project_base_info` VALUES ('2016-gx-08', '与肉特特体让他与肉俄条约体与', '山西啊手动阀手动阀add的啊有限公司', '2016-08-11', '为人体让', '5621028', '计算机、通讯技术领域', '10.000', '100004', '\0', null, null);
INSERT INTO `t_project_base_info` VALUES ('20170301', '铸造件', '太重股份有限公司', '2014-03-08', '边', '13923452308', '机械装备与制造技术领域', '20.000', '100006', '\0', null, '2015-03-05');
INSERT INTO `t_project_base_info` VALUES ('239589', '肝外系统支持', '健邦景源', '2015-03-10', '王', '5621738', '计算机、通讯技术领域', '10.000', '100006', '\0', null, '2016-03-15');
INSERT INTO `t_project_base_info` VALUES ('asdsadfasdf', 'asdfasdfasdfasdf', '阿萨德发生的发生的发虽千万人', '2016-11-22', '阿斯蒂芬', '5623520', '电子信息领域', '100.000', '100006', '\0', null, null);

-- ----------------------------
-- Table structure for t_role_base_info
-- ----------------------------
DROP TABLE IF EXISTS `t_role_base_info`;
CREATE TABLE `t_role_base_info` (
  `roleId` varchar(40) NOT NULL COMMENT '编号',
  `roleName` varchar(50) default NULL,
  `isUse` bit(1) default '',
  `description` varchar(100) default NULL COMMENT '描述',
  `remark` varchar(50) default NULL,
  PRIMARY KEY  (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户基本信息表';

-- ----------------------------
-- Records of t_role_base_info
-- ----------------------------
INSERT INTO `t_role_base_info` VALUES ('07708e57-4ada-1035-9ef3-9631346f9394', '证书发放', '', '证书发放', '证书发放');
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
  `remark` varchar(50) default NULL,
  PRIMARY KEY  (`templateId`)
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
  `upUnitId` varchar(40) default NULL COMMENT '上级部门编号',
  `description` varchar(100) default NULL COMMENT '描述',
  PRIMARY KEY  (`unitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门信息表';

-- ----------------------------
-- Records of t_unit_base_info
-- ----------------------------
INSERT INTO `t_unit_base_info` VALUES ('10', '科技评估中心', '', '');
INSERT INTO `t_unit_base_info` VALUES ('10001', '主任', '10', '主任');
INSERT INTO `t_unit_base_info` VALUES ('10002', '项目评估部', '10', '项目评估部');
INSERT INTO `t_unit_base_info` VALUES ('10003', '成果评价部', '10', '成果评价部');
INSERT INTO `t_unit_base_info` VALUES ('10004', '副主任', '10', '');
INSERT INTO `t_unit_base_info` VALUES ('10005', '综合管理部', '10', '');

-- ----------------------------
-- Table structure for t_user_account
-- ----------------------------
DROP TABLE IF EXISTS `t_user_account`;
CREATE TABLE `t_user_account` (
  `uaId` varchar(40) NOT NULL,
  `uId` varchar(40) NOT NULL,
  `account` varchar(30) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY  (`uaId`),
  KEY `FK_UC_UID` (`uId`),
  CONSTRAINT `FK_UC_UID` FOREIGN KEY (`uId`) REFERENCES `t_user_base_info` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_account
-- ----------------------------
INSERT INTO `t_user_account` VALUES ('1d62dff4-4f6d-1035-9283-351ef77f9670', 'U100013', 'fmr', '123456');
INSERT INTO `t_user_account` VALUES ('267ae5b6-4ada-1035-9ef3-9631346f9394', 'U100011', 'lixin', '123456');
INSERT INTO `t_user_account` VALUES ('61003947-3fc2-1035-b4b5-ee6636dcaed3', 'U100008', 'wangyun', '123456');
INSERT INTO `t_user_account` VALUES ('738e9ece-89f7-11e6-81ea-208984976338', 'U100002', '项目登记人', '123456');
INSERT INTO `t_user_account` VALUES ('7df4af79-89f7-11e6-81ea-208984976338', 'U100003', '项目负责人', '123456');
INSERT INTO `t_user_account` VALUES ('8487ebdf-89f7-11e6-81ea-208984976338', 'U100004', '会议创建人', '123456');
INSERT INTO `t_user_account` VALUES ('89fad9af-89f7-11e6-81ea-208984976338', 'U100005', '会议主持人', '123456');
INSERT INTO `t_user_account` VALUES ('900d1b02-89f7-11e6-81ea-208984976338', 'U100006', '系统管理员', '123456');
INSERT INTO `t_user_account` VALUES ('9628a231-89f7-11e6-81ea-208984976338', 'U100001', 'root', '123456');
INSERT INTO `t_user_account` VALUES ('aaddadd6-4ad9-1035-9ef3-9631346f9394', 'U100010', 'liangzhi', '123456');
INSERT INTO `t_user_account` VALUES ('c19bea04-3fc2-1035-b4b5-ee6636dcaed3', 'U100012', 'hcw', '123456');
INSERT INTO `t_user_account` VALUES ('f06651e4-01a4-1035-9c45-929d5f03f2b7', 'U100009', '李长有', '123456');

-- ----------------------------
-- Table structure for t_user_base_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_base_info`;
CREATE TABLE `t_user_base_info` (
  `userId` varchar(40) NOT NULL COMMENT '编号',
  `unitId` varchar(40) NOT NULL COMMENT '部门编号',
  `userName` varchar(30) default NULL COMMENT '用户名',
  `name` varchar(30) NOT NULL,
  `sex` varchar(6) NOT NULL COMMENT '性别',
  `password` varchar(16) NOT NULL COMMENT '密码',
  `duty` varchar(10) NOT NULL COMMENT '职位',
  `telephone` varchar(13) NOT NULL,
  PRIMARY KEY  (`userId`),
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
INSERT INTO `t_user_base_info` VALUES ('U100007', '10001', null, '10001', '女', '123456', '主任', '13935142905');
INSERT INTO `t_user_base_info` VALUES ('U100008', '10004', null, '王赟', '男', '123456', '副主任', '13503512028');
INSERT INTO `t_user_base_info` VALUES ('U100009', '10004', null, '李长有', '男', '123456', '副主任', '13934149450');
INSERT INTO `t_user_base_info` VALUES ('U100010', '10003', null, '梁智', '男', '123456', '部长', '15934126104');
INSERT INTO `t_user_base_info` VALUES ('U100011', '10005', null, '李欣', '女', '123456', '部长', '13466834842');
INSERT INTO `t_user_base_info` VALUES ('U100012', '10002', null, '何成文', '男', '123456', '部长', '15103430575');
INSERT INTO `t_user_base_info` VALUES ('U100013', '10001', null, '冯美荣', '女', '123456', '主任', '03515621036');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `userId` varchar(40) NOT NULL COMMENT '编号',
  `roleId` varchar(40) NOT NULL COMMENT '编号',
  PRIMARY KEY  (`userId`,`roleId`),
  KEY `FK_Reference_36` (`roleId`),
  CONSTRAINT `FK_Reference_36` FOREIGN KEY (`roleId`) REFERENCES `t_role_base_info` (`roleId`),
  CONSTRAINT `FK_USER` FOREIGN KEY (`userId`) REFERENCES `t_user_base_info` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('U100011', '07708e57-4ada-1035-9ef3-9631346f9394');
INSERT INTO `user_role` VALUES ('U100005', '09c7eff4-7a93-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100008', '09c7eff4-7a93-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100009', '09c7eff4-7a93-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100013', '09c7eff4-7a93-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100001', '2c604a17-7a93-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100006', '2c604a17-7a93-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100001', 'c49b4a97-7a92-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100002', 'c49b4a97-7a92-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100008', 'c49b4a97-7a92-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100001', 'dd868784-7a92-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100003', 'dd868784-7a92-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100010', 'dd868784-7a92-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100012', 'dd868784-7a92-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100001', 'f3a432bb-7a92-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100004', 'f3a432bb-7a92-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100009', 'f3a432bb-7a92-11e6-a8a9-206a8ab73904');
INSERT INTO `user_role` VALUES ('U100013', 'f3a432bb-7a92-11e6-a8a9-206a8ab73904');

-- ----------------------------
-- View structure for v_complete_material_file
-- ----------------------------
DROP VIEW IF EXISTS `v_complete_material_file`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_complete_material_file` AS select sql_no_cache `complete_material`.`fileId` AS `fileId`,`complete_material`.`completeId` AS `completeId`,`complete_material`.`projectId` AS `projectId`,`t_files_index`.`fileType` AS `fileType`,`t_files_index`.`originalName` AS `originalName`,`t_files_index`.`currentName` AS `currentName`,`t_files_index`.`uploadTime` AS `uploadTime`,`t_files_index`.`fileSize` AS `fileSize`,`t_files_index`.`remark` AS `remark` from (`complete_material` join `t_files_index` on((`complete_material`.`fileId` = `t_files_index`.`fileId`))) ;

-- ----------------------------
-- View structure for v_project_accept_info
-- ----------------------------
DROP VIEW IF EXISTS `v_project_accept_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_project_accept_info` AS select `tpbi`.`projectId` AS `projectId`,`tpbi`.`projectName` AS `projectName`,`tpbi`.`applicant` AS `applicant`,`tpbi`.`applicationDate` AS `applicationDate`,`tpbi`.`contactPerson` AS `contactPerson`,`tpbi`.`telephone` AS `telephone`,`tpbi`.`domain` AS `domain`,`tpbi`.`projectFunds` AS `projectFunds`,`tpbi`.`status` AS `status`,`tpbi`.`certificate` AS `certificate`,`tpbi`.`remark` AS `remark`,`pa`.`recordDate` AS `recordDate`,`pa`.`recordPerson` AS `recordPerson`,`pa`.`chargePerson` AS `chargePerson`,`pa`.`chargeUnit` AS `chargeUnit`,`pa`.`distributionDate` AS `distributionDate`,`pa`.`receiveDate` AS `receiveDate`,`pa`.`receivePerson` AS `receivePerson`,`pa`.`receiveResult` AS `receiveResult`,`pa`.`remark1` AS `remark1`,`pa`.`remark2` AS `remark2`,`pa`.`remark3` AS `remark3`,`pc`.`censorDate` AS `censorDate`,`pc`.`censorPerson` AS `censorPerson`,`pc`.`censorResult` AS `censorResult`,`ei`.`inspectPerson` AS `inspectPerson`,`ei`.`inspectDate` AS `inspectDate`,`ei`.`inspectResult` AS `inspectResult`,`ei`.`enterpriseReceiver` AS `enterpriseReceiver`,`ei`.`isAudit` AS `isAudit`,`ia`.`financeUnit` AS `financeUnit`,`ia`.`auditingPerson` AS `auditingPerson`,`ia`.`auditDate` AS `auditDate`,`ia`.`enterpriseReceiver2` AS `enterpriseReceiver2` from ((((`t_project_base_info` `tpbi` left join `project_accept` `pa` on((`tpbi`.`projectId` = `pa`.`projectId`))) left join `project_censor` `pc` on((`tpbi`.`projectId` = `pc`.`projectId`))) left join `enterprise_inspect` `ei` on((`tpbi`.`projectId` = `ei`.`projectId`))) left join `inspect_audit` `ia` on((`ei`.`inspectId` = `ia`.`inspectId`))) ;

-- ----------------------------
-- View structure for v_project_material_file
-- ----------------------------
DROP VIEW IF EXISTS `v_project_material_file`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_project_material_file` AS select sql_no_cache `project_material`.`fileId` AS `fileId`,`project_material`.`materialId` AS `materialId`,`project_material`.`projectId` AS `projectId`,`t_files_index`.`fileType` AS `fileType`,`t_files_index`.`originalName` AS `originalName`,`t_files_index`.`currentName` AS `currentName`,`t_files_index`.`uploadTime` AS `uploadTime`,`t_files_index`.`fileSize` AS `fileSize`,`t_files_index`.`remark` AS `remark` from (`project_material` join `t_files_index` on((`project_material`.`fileId` = `t_files_index`.`fileId`))) ;

-- ----------------------------
-- View structure for v_project_meeting_notify
-- ----------------------------
DROP VIEW IF EXISTS `v_project_meeting_notify`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_project_meeting_notify` AS select `t_project_base_info`.`projectId` AS `projectId`,`t_project_base_info`.`projectName` AS `projectName`,`t_project_base_info`.`applicant` AS `applicant`,`t_project_base_info`.`applicationDate` AS `applicationDate`,`t_project_base_info`.`contactPerson` AS `contactPerson`,`t_project_base_info`.`telephone` AS `telephone`,`t_project_base_info`.`domain` AS `domain`,`t_project_base_info`.`projectFunds` AS `projectFunds`,`t_project_base_info`.`status` AS `status`,`t_project_base_info`.`certificate` AS `certificate`,`t_project_base_info`.`remark` AS `remark`,`project_meeting`.`meetingId` AS `meetingId`,`project_meeting`.`notifyDate` AS `notifyDate`,`project_meeting`.`notifyMethod` AS `notifyMethod` from (`t_project_base_info` join `project_meeting` on((`t_project_base_info`.`projectId` = `project_meeting`.`projectId`))) ;
