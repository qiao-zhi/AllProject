package com.thinkPro.steap.db.service.impl.material;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.thinkPro.steap.bean.material.Picture;
import com.thinkPro.steap.db.mapper.material.IPictureMapper;
import com.thinkPro.steap.db.mapper.sys.dic.IDictionaryMapper;
import com.thinkPro.steap.db.service.material.PictureService;

@Service("pictureService")
public class PictureServiceImpl implements PictureService{
	
	@Resource
	private IPictureMapper pictureMapper;
	@Resource
	private IDictionaryMapper dictionaryMapper;
	

	/**
	 * 添加项目的图片资料
	 * @param picture 图片信息
	 * @return
	 * @throws SQLException
	 */
	public boolean addPicture(Picture picture)throws SQLException{
		if(picture!=null){
			String code = dictionaryMapper.getCodeByName(picture.getPictureType());
			picture.setPictureType(code);
			boolean result = pictureMapper.addPicture(picture)>-1?true:false;
			return result;
		}
		return false;
	}
	
	/**
	 * 根据项目Id和图片类型查询项目的图片资料
	 * @param pictureInfo 项目Id 图片类型(Map)
	 * @return 图片信息(List)
	 * @throws SQLException
	 */
	public List<Picture> getPicture(Map<String, Object> pictureInfo)throws SQLException{
		if(pictureInfo.size()>0){
			return pictureMapper.getPicture(pictureInfo);
		}
		return null;
	}
	
	/**
	 * 根据项目Id和图片在数据库中现在的名字进行删除
	 * @param deleteInfo (Map) 项目Id，图片现在的名字
	 * @return 删除的记录数
	 * @throws SQLException
	 */
	public int deletePictureByPidAndCName(Map<String, Object> deleteInfo)
			throws SQLException {
		return pictureMapper.deletePictureByPidAndCName(deleteInfo);
	}
	
	/**
	 * 根据项目编号和图片类型获取图片信息
	 * @param project_picture 项目编号、图片类型
	 * @return 图片集合
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getPictureSet(Map<String, Object> project_picture) throws SQLException {
		if(project_picture.size() != 0) {
			return pictureMapper.getPictureSet(project_picture);
		}
		return null;
	}
	
	/**
	 * 根据项目编号和图片类型查询图片信息 
	 * @param project_picture 项目编号、图片类型
	 * @return 图片信息
	 * @throws SQLException
	 */
	public List<Picture> getPictureByIf(Map<String, Object> project_picture) throws SQLException {
		if(project_picture.size() != 0 ) {
			return pictureMapper.getPictureByIf(project_picture);
		}
		return null;
	}
}
