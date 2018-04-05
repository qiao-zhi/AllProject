#账户管理表
CREATE TABLE t_user_account(
	uaId varchar(40) PRIMARY KEY,
	uId VARCHAR(40) not NULL,
	account VARCHAR(30) not NULL,	
	password varchar(16)not NULL
)