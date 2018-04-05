/*
   @modifier yachao
   @time 2017/02/02
   @description 向issue_certificate表中添加新字段
   @holder 证书领取人
   @holderPhone 领取人联系电话
   @holdDate 领取日期
*/
ALTER TABLE issue_certificate ADD holder varchar(30), ADD holderPhone varchar(16), ADD holdDate date;

#添加一字段 endDate
ALTER TABLE t_project_base_info ADD endDate date;

#修改视图 v_project_accept_info
CREATE OR REPLACE view v_project_accept_info as
select `tpbi`.`projectId` AS `projectId`,`tpbi`.`projectName` AS `projectName`,
`tpbi`.`applicant` AS `applicant`,`tpbi`.`applicationDate` AS `applicationDate`,
`tpbi`.`contactPerson` AS `contactPerson`,`tpbi`.`telephone` AS `telephone`,
`tpbi`.`domain` AS `domain`,`tpbi`.`projectFunds` AS `projectFunds`,`tpbi`.`status` AS `status`,
`tpbi`.`certificate` AS `certificate`,`tpbi`.`remark` AS `remark`,`pa`.`recordDate` AS `recordDate`,
`pa`.`recordPerson` AS `recordPerson`,`pa`.`chargePerson` AS `chargePerson`,
`pa`.`chargeUnit` AS `chargeUnit`,`pa`.`distributionDate` AS `distributionDate`,
`pa`.`receiveDate` AS `receiveDate`,`pa`.`receivePerson` AS `receivePerson`,
`pa`.`receiveResult` AS `receiveResult`,`pa`.`remark1` AS `remark1`,`pa`.`remark2` AS `remark2`,
`pa`.`remark3` AS `remark3`,`pc`.`censorDate` AS `censorDate`,`pc`.`censorPerson` AS `censorPerson`,
`pc`.`censorResult` AS `censorResult`,`ei`.`inspectPerson` AS `inspectPerson`,
`ei`.`inspectDate` AS `inspectDate`,`ei`.`inspectResult` AS `inspectResult`,
`ei`.`enterpriseReceiver` AS `enterpriseReceiver`,`ei`.`isAudit` AS `isAudit`,
`ia`.`financeUnit` AS `financeUnit`,`ia`.`auditingPerson` AS `auditingPerson`,
`ia`.`auditDate` AS `auditDate`,`ia`.`enterpriseReceiver2` AS `enterpriseReceiver2` 
from ((((`t_project_base_info` `tpbi` left join `project_accept` `pa` 
on((`tpbi`.`projectId` = `pa`.`projectId`))) left join `project_censor` `pc` 
on((`tpbi`.`projectId` = `pc`.`projectId`))) left join `enterprise_inspect` `ei` 
on((`tpbi`.`projectId` = `ei`.`projectId`))) left join `inspect_audit` `ia` 
on((`ei`.`inspectId` = `ia`.`inspectId`)))


/*
	@modifier yachao
	@description 向t_base_defined_url添加一条路由记录
*/
INSERT INTO 
t_base_defined_url(id, moduleId, moduleName, moduleURL, memo1, momo2, inUse, sortNo, menuClass, flag)
VALUES(uuid(), 15007, '评审意见管理', 'admin/sys/opinion/evaluationOpinion.jsp', '评审意见管理', null, 1, 0, 2, 0);