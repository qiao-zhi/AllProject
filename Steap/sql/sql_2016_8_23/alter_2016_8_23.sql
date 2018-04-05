/*
* 更改role_module的外键约束，能使用级联删除；
*/
alter table role_module drop foreign key FK_MODULE;

ALTER TABLE role_module ADD (CONSTRAINT FK_MODULE FOREIGN KEY (moduleId) 
REFERENCES t_base_defined_url(moduleId) ON DELETE CASCADE ON UPDATE CASCADE);