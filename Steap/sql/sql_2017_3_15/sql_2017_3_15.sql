/*
	@date 2017/03/15
	@author Zychaowill
	@description 新增项目状态 “已发放证书”
*/
insert into dic_system_dictionary
values('100010', '已发放证书', '100', 1, '已发放证书', 0, 0, 'issue_certificate', '字符型', null, null);

/*
	@author Zychaowill
	@description 新增证书发放人角色
*/
insert into t_role_base_info
values('f3a432bb-7a92-11e6-a8a9-206a8ab739e7', '证书发放人', 1, '证书发放人', '证书发放人');

insert into role_module
values('f3a432bb-7a92-11e6-a8a9-206a8ab739e7', '14003');

/*
	@author Zychaowill
	@description 在evaluation_result表中新增录入项目评审结果的专家编号
*/
alter table evaluation_result add column specialistId varchar(8) after projectId;
alter table evaluation_result add constraint FOREIGN KEY(specialistId) REFERENCES specialist_library(specialistId);

/*	
	@author Zychaowill
	@description 录入会议主持人路由
*/
update t_base_defined_url set moduleURL='admin/host/host_meeting.jsp', moduleName='会议主持首页', memo1='会议主持' where moduleId='13002';
insert into t_base_defined_url values(uuid(), '13003', '召开会议', 'admin/host/conveneMeeting.jsp', '召开会议', null, 1, 0, 2, 0);
insert into t_base_defined_url values(uuid(), '13004', '待主持会议', 'admin/host/hostedMeeting.jsp', '待主持会议', null, 1, 0, 2, 0);
insert into t_base_defined_url values(uuid(), '13005', '已主持会议', 'admin/host/pastMeeting.jsp', '已主持会议', null, 1, 0, 2, 0);