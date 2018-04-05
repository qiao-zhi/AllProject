#修改t_pictures_index图片信息表的结构，删除sortNo字段，并修改主键pictureId的类型为int，自增
#先清除表中数据
delete from t_pictures_index;

alter table t_pictures_index drop column sortNo;
alter table t_pictures_index change pictureId pictureId int(11) not null AUTO_INCREMENT;