#修改部门信息表中的部门信息，以及在字典表中添加创建会议时需要通知的机构
SET FOREIGN_KEY_CHECKS=0;

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

INSERT INTO `dic_system_dictionary` VALUES ('700', '机构', '1', '', '会议需要通知的相关人员', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('700001', '专项管理机构业务处室', '700', '', '专项管理机构业务处室', '0', '0', null, '字符型', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('700002', '局纪检监察领导', '700', '', '局纪检监察领导', '0', '0', null, '字符型', null, null);
