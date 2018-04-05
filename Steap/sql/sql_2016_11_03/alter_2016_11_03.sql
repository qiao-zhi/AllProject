#修改email的长度为100 修改projectName的长度为100
alter table t_project_base_info modify column projectName varchar(100) ;
alter table specialist_recommend modify column email varchar(100) ;
alter table specialist_library modify column email varchar(100) ;