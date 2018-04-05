#创建关联完善文件编号和审核编号的表结构
DROP TABLE IF EXISTS `complete_verify`;
CREATE TABLE `complete_verify` (
  `verifyId` int(11) NOT NULL COMMENT '项目审核编号',
  `completeId` varchar(40) NOT NULL,
  PRIMARY KEY (`verifyId`,`completeId`),
  KEY `FK_Reference_verifyId` (`verifyId`),
  KEY `FK_Reference_materialId` (`completeId`),
  CONSTRAINT `FK_Reference_verifyId` FOREIGN KEY (`verifyId`) REFERENCES `project_verify` (`verifyId`),
  CONSTRAINT `FK_Reference_completeId` FOREIGN KEY (`completeId`) REFERENCES `complete_material` (`completeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='审核完善资料表';