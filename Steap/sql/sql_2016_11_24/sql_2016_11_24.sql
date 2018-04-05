#specialist_evaluation表中remark字段作为评审状态使用
ALTER TABLE specialist_evaluation
ALTER COLUMN remark SET DEFAULT '0';
UPDATE specialist_evaluation set remark='0';

#evaluation_result表中remark字段作为评估状态使用
ALTER TABLE evaluation_result
ALTER COLUMN remark SET DEFAULT '0';
UPDATE evaluation_result set remark='0';