package com.thinkPro.steap.db.base.sys.unit;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thinkPro.steap.bean.sys.unit.TBaseUnitInfo;
import com.thinkPro.steap.db.mapper.sys.unit.IUnitMapper;

public class UnitBase implements IUnitMapper{

	
	private ApplicationContext applicationContext;
	private IUnitMapper unitMapper;
	
	
	public UnitBase() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		unitMapper = (IUnitMapper) applicationContext.getBean("IUnitMapper");
	}

	/*
	 * 查询处所有的部门，员工信息
	 **/
	public List<Map<String, Object>> getAllUsers() throws SQLException{
		return unitMapper.getAllUsers();
	}
	/**
	 * 返回部门结构
	 * @return
	 */
	public List<TBaseUnitInfo> getUnitTree() throws SQLException {
		return unitMapper.getUnitTree();
	}
	
	
	/**
	 * 查询部门树信息
	 * @return
	 */
	public List<Map<String, Object>> getUnitTree2() {
		return unitMapper.getUnitTree2();
	}
	
	
	/**
	 * 添加部门
	 * @param tBaseUnitInfo
	 * @return
	 * @throws SQLException
	 */
	public int addUnit(TBaseUnitInfo baseUnitInfo) throws SQLException {
		return unitMapper.addUnit(baseUnitInfo);
	}

	
	/**
	 * 根据部门id删除部门
	 * @param unitId
	 * @return
	 * @throws SQLException
	 */
	public int deleteUnit(String unitId) throws SQLException {
		return unitMapper.deleteUnit(unitId);
	}

	
	/**
	 * 修改部门信息 
	 * @param tBaseUnitInfo
	 * @return
	 * @throws SQLException
	 */
	public int updateUnit(TBaseUnitInfo baseUnitInfo) throws SQLException {
		return unitMapper.updateUnit(baseUnitInfo);
	}

	
	/**
	 * 根据unitId查询部门信息
	 * @param unitId
	 * @return
	 * @throws SQLException
	 */
	public TBaseUnitInfo getUnitByUnitId(String unitId) throws SQLException {
		return unitMapper.getUnitByUnitId(unitId);
	}
	
	
	/**
	 * 根据upUnitId查询部门信息
	 * @param upUnitId
	 * @return
	 * @throws SQLException
	 */
	public List<TBaseUnitInfo> getUnitByUpUnitId(String upUnitId) throws SQLException {
		return unitMapper.getUnitByUpUnitId(upUnitId);
	}

	
	/**
	 * 根据上级部门Id查询下一个要插入的下一级部门的编号 
	 * @param upUnitId
	 * @return
	 * @throws SQLException
	 */
	public String getNextUnitId(String upUnitId) throws SQLException {
		return unitMapper.getNextUnitId(upUnitId);
	}

	
	/**
	 * 按条件查询部门 
	 * @param unitCon
	 * @return
	 * @throws SQLException
	 */
	public List<TBaseUnitInfo> getUnitByConditon(Map<String, Object> condition)
			throws SQLException {
		return unitMapper.getUnitByConditon(condition);
				
	}
}