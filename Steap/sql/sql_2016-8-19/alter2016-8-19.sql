/**
 * alter by HaoShaSha
 * 修改文件当前名称的长度(40->50)
 */
ALTER TABLE t_files_index MODIFY COLUMN currentName varchar(50);

/**
 * alter by HaoShaSha
 * 为项目添加一个状态
 */

INSERT INTO `dic_system_dictionary` VALUES ('100009', '已通过审核', '100', '', '已通过审核', '0', '0', '', 'varchar(6)', '', '');