#删除complete_material中的verifyId字段
ALTER TABLE complete_material DROP FOREIGN KEY fk_name_verifyId;
ALTER TABLE complete_material DROP column verifyId;