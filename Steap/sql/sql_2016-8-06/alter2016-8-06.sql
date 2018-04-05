/**
 * 修改用户表和用户角色表的级联删除
 */
ALTER TABLE user_role  DROP FOREIGN KEY FK_Reference_25;

ALTER TABLE user_role ADD (CONSTRAINT FK_USER FOREIGN KEY (userId) 
REFERENCES t_user_base_info(userId) ON DELETE CASCADE ON UPDATE CASCADE);

