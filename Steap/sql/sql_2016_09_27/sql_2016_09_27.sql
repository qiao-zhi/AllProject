#给t_user_account表中用户编号uId添加外键约束
alter table t_user_account add CONSTRAINT FK_UC_UID FOREIGN KEY(uId) REFERENCES t_user_base_info(userId);