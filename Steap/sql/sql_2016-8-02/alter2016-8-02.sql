/**
 * 修改字典的数据
 */
delete from  dic_system_dictionary where dictionaryOptionId = '100005';
insert INSERT INTO `dic_system_dictionary` VALUES ('100005', '考察中', '100', '', '项目企业现场考察中', '0', '0', 'inspecting', 'varchar(6)', null, null);
INSERT INTO `dic_system_dictionary` VALUES ('100006', '已提交', '100', '', '企业现场考察结束', '0', '0', 'inspected', 'varchar(6)', null, null);