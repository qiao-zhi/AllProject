package com.thinkPro.steap.db.service.impl.sys.unit;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.thinkPro.steap.bean.sys.unit.TBaseUnitInfo;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.mapper.sys.unit.IUnitMapper;
import com.thinkPro.steap.db.service.sys.unit.UnitService;

@Service("unitService")
public class UnitServiceImpl implements UnitService{

	@Resource
	private IUnitMapper unitMapper;

	/*
	 * 查询处所有的部门，员工信息
	 */
	public List<Map<String, Object>> getAllUsers() throws SQLException {
		return unitMapper.getAllUsers();
	}

	/**
	 * 返回部门结构
	 * 
	 * @return
	 */
	public List<TBaseUnitInfo> getUnitTree() throws SQLException {
		return unitMapper.getUnitTree();
	}

	/**
	 * 查询部门树信息
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getUnitTree2() throws SQLException {

		return unitMapper.getUnitTree2();
	}

	/**
	 * 添加部门
	 * 
	 * @param tBaseUnitInfo
	 * @return
	 * @throws SQLException
	 */
	public boolean addUnit(TBaseUnitInfo baseUnitInfo) throws SQLException {
		if (baseUnitInfo != null) {
			int addUnitResult = unitMapper.addUnit(baseUnitInfo);
			boolean result = addUnitResult > -1 ? true : false;
			return result;
		}
		return false;
	}

	/**
	 * 根据部门id删除部门
	 * 
	 * @param unitId
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteUnit(String unitId) throws SQLException {
		if (unitId != null && !"".equals(unitId)) {
			return unitMapper.deleteUnit(unitId) > 0 ? true : false;
		} else {
			return false;
		}
	}

	/**
	 * 修改部门信息
	 * 
	 * @param baseUnitInfo
	 * @return
	 * @throws SQLException
	 */
	public boolean updateUnit(TBaseUnitInfo baseUnitInfo) throws SQLException {
		if (baseUnitInfo != null) {
			boolean updateResult = false;
			updateResult = unitMapper.updateUnit(baseUnitInfo) > 0 ? true : false;
			return updateResult;
		} else {
			return false;
		}
	}

	/**
	 * 根据unitId查询部门信息
	 * 
	 * @param unitId
	 * @return
	 * @throws SQLException
	 */
	public TBaseUnitInfo getUnitByUnitId(String unitId) throws SQLException {
		if (unitId != null && !"".equals(unitId)) {
			return unitMapper.getUnitByUnitId(unitId);
		}
		return null;
	}

	/**
	 * 根据upUnitId查询部门信息
	 * 
	 * @param upUnitId
	 * @return
	 * @throws SQLException
	 */
	public List<TBaseUnitInfo> getUnitByUpUnitId(String upUnitId)
			throws SQLException {
		if (upUnitId != null && !"".equals(upUnitId)) {
			return unitMapper.getUnitByUpUnitId(upUnitId);
		}
		return null;
	}

	/**
	 * 根据上级部门Id查询下一个要插入的下一级部门Id
	 * 
	 * @param upUnitId
	 * @return
	 * @throws SQLException
	 */
	public String getNextUnitId(String upUnitId) throws SQLException {
		boolean result = ValidateCheck.isNotNull(upUnitId);
		if (result) {
			String nextId = unitMapper.getNextUnitId(upUnitId);
			if (nextId == null) {
				nextId = upUnitId + "001";
			} else {
				nextId = Integer.toString(Integer.parseInt(nextId) + 1);
			}
			return nextId;
		} else {
			return null;
		}
	}

	/**
	 * 按条件查询部门
	 * 
	 * @param unitCon
	 * @return
	 * @throws SQLException
	 */
	public List<TBaseUnitInfo> getUnitByConditon(Map<String, Object> condition)
			throws SQLException {
		if (condition != null && condition.size() > 0) {
			return unitMapper.getUnitByConditon(condition);
		} else {
			return null;
		}
	}
}
