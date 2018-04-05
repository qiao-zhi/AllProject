#修改表project_verify中的verifyPerson，verifyDate，verifyResult字段允许为空
alter table project_verify modify verifyPerson varchar(30) null;
alter table project_verify modify verifyDate date null;
alter table project_verify modify verifyResult longtext null;