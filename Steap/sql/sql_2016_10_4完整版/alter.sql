#在字典表里添加图片类型“审计报告”
INSERT INTO `dic_system_dictionary` VALUES ('400004', '审计报告', '400', '', '审计报告图片', '0', '0', null, '字符型', null, null);
#删除字典表中重复的字段(机构)
delete from dic_system_dictionary where dictionaryOptionId = '700';
delete from dic_system_dictionary where dictionaryOptionId = '700001';
delete from dic_system_dictionary where dictionaryOptionId = '700001';