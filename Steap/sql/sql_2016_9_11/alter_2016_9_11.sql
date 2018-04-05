#修改verifyId的类型为int，自增
alter table project_verify change verifyId verifyId int(11) not null AUTO_INCREMENT;