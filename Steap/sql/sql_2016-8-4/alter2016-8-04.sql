delete from dic_system_dictionary where dictionaryOptionId='100005';
delete from dic_system_dictionary where dictionaryOptionId='100006';
INSERT INTO `dic_system_dictionary` VALUES ('100005', '已现场考察', '100', '', '已企业现场考场', '0', '0', '', 'varchar(6)', '', null);
INSERT INTO `dic_system_dictionary` VALUES ('100006', '已创建项目会议', '100', '', '已创建项目会议', '0', '0', '', 'varchar(6)', '', null);
INSERT INTO `dic_system_dictionary` VALUES ('100007', '已评审', '100', '', '已评审', '0', '0', null, 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('100008', '已评估', '100', '', '已评估', '0', '0', null, 'varchar(6)', null, null);
alter table enterprise_inspect add inspectStatus varchar(10) comment '考察状态';
update enterprise_inspect set inspectStatus='已提交';