#在专家库中添加账户字段
ALTER TABLE `specialist_library`
ADD COLUMN `account`  varchar(30) NULL AFTER `sex`;