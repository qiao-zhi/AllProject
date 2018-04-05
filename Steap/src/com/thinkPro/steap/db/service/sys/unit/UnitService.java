package com.thinkPro.steap.db.service.sys.unit;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkPro.steap.bean.sys.unit.TBaseUnitInfo;

public interface UnitService {

	/*
	 * 查询处所有的部门，员工信息
	 **/
	public List<Map<String, Object>> getAllUsers() throws SQLException;
	
	/**
	 * 返回部门结构
	 * @return
	 */
	public List<TBaseUnitInfo> getUnitTree() throws SQLException ;
	
	
	/**
	 * 查询部门树信息
	 * @return
	 */
	public List<Map<String,Object>> getUnitTree2() throws SQLException;

	
	/**
	 * 添加部门
	 * @param tBaseUnitInfo
	 * @return
	 * @throws SQLException
	 */
	public boolean addUnit(TBaseUnitInfo baseUnitInfo) throws SQLException ;

	
	/**
	 * 根据部门id删除部门
	 * @param unitId
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteUnit(String unitId) throws SQLException ;

	
	/**
	 * 修改部门信息 
	 * @param baseUnitInfo
	 * @return
	 * @throws SQLException
	 */
	public boolean updateUnit(TBaseUnitInfo baseUnitInfo) throws SQLException ;

	
	/**
	 * 根据unitId查询部门信息
	 * @param unitId
	 * @return
	 * @throws SQLException
	 */
	public TBaseUnitInfo getUnitByUnitId(String unitId) throws SQLException ;
	
	
	/**
	 * 根据upUnitId查询部门信息
	 * @param upUnitId
	 * @return
	 * @throws SQLException
	 */
	public List<TBaseUnitInfo> getUnitByUpUnitId(String upUnitId) throws SQLException ;
	
	
	/**
	 * 根据上级部门Id查询下一个要插入的下一级部门Id
	 * @param upUnitId
	 * @return
	 * @throws SQLException
	 */
	public String getNextUnitId(String upUnitId) throws SQLException ;
	
	
	/**
	 * 按条件查询部门 
	 * @param unitCon
	 * @return
	 * @throws SQLException
	 */
	public List<TBaseUnitInfo> getUnitByConditon(Map<String,Object> condition) throws SQLException;
}