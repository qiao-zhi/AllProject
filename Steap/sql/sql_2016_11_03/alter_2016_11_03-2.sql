#删除项目时，级联删除
ALTER TABLE `project_accept` DROP FOREIGN KEY `FK_Reference_5`;

ALTER TABLE `project_accept` ADD CONSTRAINT `FK_Reference_5` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `project_censor` DROP FOREIGN KEY `FK_Reference_2`;

ALTER TABLE `project_censor` ADD CONSTRAINT `FK_Reference_2` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `enterprise_inspect` DROP FOREIGN KEY `FK_Reference_3`;

ALTER TABLE `enterprise_inspect` ADD CONSTRAINT `FK_Reference_3` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `inspect_audit` DROP FOREIGN KEY `FK_Reference_16`;

ALTER TABLE `inspect_audit` ADD CONSTRAINT `FK_Reference_16` FOREIGN KEY (`inspectId`) REFERENCES `enterprise_inspect` (`inspectId`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `t_pictures_index` DROP FOREIGN KEY `FK_Reference_26`;

ALTER TABLE `t_pictures_index` ADD CONSTRAINT `FK_Reference_26` FOREIGN KEY (`projectId`) REFERENCES `t_project_base_info` (`projectId`) ON DELETE CASCADE ON UPDATE CASCADE;

