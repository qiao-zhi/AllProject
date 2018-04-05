/*
	@author Zychaowill
	@date 2017/04/26
	@description 修改专家联系方式字段长度 & 增加专家专业字段
*/
ALTER TABLE specialist_library MODIFY telephone VARCHAR(50);
ALTER TABLE specialist_library ADD COLUMN major VARCHAR(200);