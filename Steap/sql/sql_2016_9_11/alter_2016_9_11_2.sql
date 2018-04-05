#在complete_material表中添加字段verifyId,并设置为外键
alter table complete_material add verifyId int not null;
alter table complete_material ADD CONSTRAINT fk_name_verifyId FOREIGN KEY(verifyId) REFERENCES project_verify(verifyId);