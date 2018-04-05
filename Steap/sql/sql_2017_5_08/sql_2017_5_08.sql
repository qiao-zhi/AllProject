/*
	@author Zychaowill
	@date 2017/05/08
	@description 增加专家学位degree、从事专业ZJZY字段
*/
ALTER TABLE specialist_library ADD COLUMN degree VARCHAR(100);
ALTER TABLE specialist_library ADD COLUMN ZJZY VARCHAR(100);