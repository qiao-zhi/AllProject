/*
	@author Zychaowill
	@date 2017/03/22
	@description 在t_files_index表中新增保存验收意见初稿内容的字段
*/
alter table t_files_index add column opinionContent longtext;


/*
	@author Zychaowill
	@description 替换v_project_material_file视图
*/
CREATE OR REPLACE VIEW v_project_material_file
AS
SELECT
	`project_material`.`fileId` AS `fileId`,
	`project_material`.`materialId` AS `materialId`,
	`project_material`.`projectId` AS `projectId`,
	`t_files_index`.`fileType` AS `fileType`,
	`t_files_index`.`originalName` AS `originalName`,
	`t_files_index`.`currentName` AS `currentName`,
	`t_files_index`.`uploadTime` AS `uploadTime`,
	`t_files_index`.`fileSize` AS `fileSize`,
	`t_files_index`.`remark` AS `remark`,
	`t_files_index`.`opinionContent` AS `opinionContent`
FROM
	(
		`project_material`
		JOIN `t_files_index` ON(
			(
				`project_material`.`fileId` = `t_files_index`.`fileId`
			)
		)
	)