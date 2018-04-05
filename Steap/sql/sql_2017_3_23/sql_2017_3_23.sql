/*
	@author ding
	@date 2017/03/23
	@description 修改complete_verify的外键，级联删除
*/
ALTER TABLE complete_verify DROP FOREIGN KEY FK_Reference_completeId;

ALTER TABLE complete_verify ADD CONSTRAINT FK_Reference_completeId FOREIGN KEY (completeId) ;
REFERENCES complete_material (completeId) ON DELETE CASCADE ON UPDATE RESTRICT;