#修改enterprise_inspect中的inspectPerson字段长度为100
ALTER TABLE `enterprise_inspect`
MODIFY COLUMN `inspectPerson`  varchar(100) NOT NULL;