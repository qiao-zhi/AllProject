package com.thinkPro.steap.db.mapper.material;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkPro.steap.bean.material.Picture;

public interface IPictureMapper {

	/**
	 * 添加项目的图片资料
	 * @param picture 图片信息
	 * @return
	 * @throws SQLException
	 */
	public int addPicture(Picture picture)throws SQLException;
	/**
	 * 根据项目Id和图片类型查询项目的图片资料
	 * @param pictureInfo 项目Id 图片类型(Map)
	 * @return 图片信息(List)
	 * @throws SQLException
	 */
	public List<Picture> getPicture(Map<String, Object> pictureInfo)throws SQLException;
	/**
	 * 根据项目Id和图片在数据库中现在的名字进行删除
	 * @param deleteInfo (Map) 项目Id，图片现在的名字
	 * @return 删除的记录数
	 * @throws SQLException
	 */
	public int deletePictureByPidAndCName(Map<String, Object> deleteInfo)throws SQLException;
	
	/**
	 * 根据项目编号和图片类型获取图片信息
	 * @param project_picture 项目编号、图片类型
	 * @return 图片集合
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getPictureSet(Map<String, Object> project_picture) throws SQLException;
	
	/**
	 * 根据项目编号和图片类型查询图片信息 
	 * @param project_picture 项目编号、图片类型
	 * @return 图片信息
	 * @throws SQLException
	 */
	public List<Picture> getPictureByIf(Map<String, Object> project_picture) throws SQLException;
}