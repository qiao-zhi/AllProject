/*
	@author Zychaowill
	@date 2017/3/16
	@description 修改institution_notify表中notify_method字段长度
*/
alter table institution_notify modify notifyMethod varchar(50);

/*
	@author Zychaowill
	@date 2017/3/16
	@description 通过t_files_index表中的字段remark作为记录是否该材料已审核
*/
alter table t_files_index modify remark bit default 0;
# 更新该字段值，避免修改字段类型出现异常
update t_files_index set remark=0;