package com.thinkPro.steap.db.service.impl.sys.dic;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.thinkPro.steap.bean.sys.dic.SystemDictionary;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.mapper.sys.dic.IDictionaryMapper;
import com.thinkPro.steap.db.service.sys.dic.DictionaryService;

@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {

	@Resource
	private IDictionaryMapper dictionaryMapper;

	/**
	 * 添加字典信息
	 * @param dictionary
	 * @return
	 * @throws SQLException
	 */
	public boolean addDictionary(SystemDictionary dictionary)
			throws SQLException {

		if (dictionary != null) {
			int addDictionaryResult = dictionaryMapper.addDictionary(dictionary);

			boolean result = addDictionaryResult > -1 ? true : false;

			return result;

		}
		return false;
	}

	/**
	 * 根据字典Id删除字典信息
	 * 
	 * @param dictionaryOptionId
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteDictionary(String dictionaryOptionId)
			throws SQLException {
		if (dictionaryOptionId != null && !"".equals(dictionaryOptionId)) {
			return dictionaryMapper.deleteDictionary(dictionaryOptionId) > 0 ? true
					: false;
		} else {
			return false;
		}
	}

	/**
	 * 根据字典编码查询字典信息
	 * 
	 * @param dictionaryOptionId
	 * @return
	 * @throws SQLException
	 */
	public SystemDictionary getDictionaryById(String dictionaryOptionId)
			throws SQLException {
		if (dictionaryOptionId != null && !"".equals(dictionaryOptionId)) {
			return dictionaryMapper.getDictionaryById(dictionaryOptionId);
		}
		return null;
	}

	/* ----------START BY HaoShaSha -------------- */

	/**
	 * 根据条件查询字典信息(字典编号，字典名称， 起始记录数，每页的记录数)
	 * 
	 * @param condition
	 *            (dictionaryOptionId 字典编号,dictionaryOptionName 字典名称, pageBegin
	 *            起始记录数,pageSize 每页的记录数,dictionaryOptionId 上级字典编号)
	 * @return
	 * @throws SQLException
	 */
	public List<SystemDictionary> getDictionaryByConditon(
			Map<String, Object> condition) throws SQLException {

		if (condition != null) {

			return dictionaryMapper.getDictionaryByConditon(condition);
		}

		return null;
	}

	/**
	 * 根据条件查询字典的总的记录数(字典编号，字典名称)
	 * 
	 * @param condition
	 *            (dictionaryOptionId 字典编号,dictionaryOptionName 字典名称)
	 * @return
	 * @throws SQLException
	 */
	public int getDicCountByConditon(Map<String, Object> condition)
			throws SQLException {

		if (condition != null) {

			return dictionaryMapper.getDicCountByConditon(condition);

		}
		return 0;
	}

	/**
	 * 修改字典信息
	 * 
	 * @param dictionary
	 * @return
	 * @throws SQLException
	 */
	public boolean updateDictionary(SystemDictionary dictionary)
			throws SQLException {

		if (dictionary != null) {

			boolean updateResult = false;

			System.out.println(dictionary);

			updateResult = dictionaryMapper.updateDictionary(dictionary) >= 0 ? true
					: false;

			// 此处待完善，对性能有很大的影响

			if (updateResult && dictionary.isUse() != true) {

				updateResult = dictionaryMapper.updateChildNotUse(dictionary
						.getDictionaryOptionId()) >= 0 ? true : false;
			}

			return updateResult;

		} else {

			return false;
		}
	}

	/**
	 * 根据上级字典编号查询字典信息
	 * 
	 * @param upDictionaryOptionId
	 *            (上级字典编号)、pageBegin(起始记录数)、pageSize(返回的记录数)
	 * @return List<SystemDictionary> (下级字典列表)
	 * @throws SQLException
	 */
	public List<SystemDictionary> getDictionaryByUpDicId(
			Map<String, Object> dicCondition) throws SQLException {

		if (dicCondition != null) {

			return dictionaryMapper.getDictionaryByUpDicId(dicCondition);

		} else {

			return null;
		}

	}

	/**
	 * 查询全部字典列表
	 * 
	 * @return List<SystemDictionary> (全部字典列表)
	 * @throws SQLException
	 */
	public List<SystemDictionary> getAllDictionary() throws SQLException {

		return dictionaryMapper.getAllDictionary();
	}

	/**
	 * 查询字典树信息
	 * 
	 * @return List<Map<String,Object>>
	 *         返回的map包括(dictionaryOptionId,dictionaryOptionName
	 *         ,upDictionaryOptionId) (字典编号，字典名称，上级字典编号)
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getDictionaryTree() throws SQLException {

		return dictionaryMapper.getDictionaryTree();
	}

	/**
	 * 根据上级字典Id查询下一个要插入的下一级字典的编号
	 * 
	 * @param upDictionaryOptionId
	 *            上级字典Id
	 * @return
	 * @throws SQLException
	 */
	public String getNextDictionaryId(String upDictionaryOptionId)
			throws SQLException {

		boolean result = ValidateCheck.isNotNull(upDictionaryOptionId);

		if (result) {

			String nextId = dictionaryMapper
					.getMaxDictionaryId(upDictionaryOptionId);

			if (nextId == null) {

				nextId = upDictionaryOptionId + "001";

			} else if (Integer.parseInt(nextId) / 100 < 1000) {

				nextId = Integer.toString(Integer.parseInt(nextId) + 100);

			} else {

				nextId = Integer.toString(Integer.parseInt(nextId) + 1);
			}

			return nextId;

		} else {

			return null;
		}

	}

	/**
	 * 根据上级字典Id查询最新的一个下级字典信息
	 * 
	 * @param upDictionaryOptionId
	 *            上级字典Id
	 * @return 最新的一个下级字典信息
	 * @throws SQLException
	 */
	public SystemDictionary getNewDictionary(String upDictionaryOptionId)
			throws SQLException {

		boolean result = ValidateCheck.isNotNull(upDictionaryOptionId);

		if (result) {

			return dictionaryMapper.getNewDictionary(upDictionaryOptionId);

		} else {

			return null;
		}

	}

	/**
	 * 得到领域
	 * 
	 * @param dictionaryOptionName
	 *            ("领域")
	 * @return 领域列表
	 * @throws SQLException
	 */
	public List<String> getDomain(String dictionaryOptionName)
			throws SQLException {

		if(ValidateCheck.isNotNull(dictionaryOptionName)) {
			return dictionaryMapper.getDomain(dictionaryOptionName);
		}
		return null;
	}

	/* ----------END BY HaoShaSha -------------- */
	/**
	 * 根据字典名称查询字典编码
	 * 
	 * @param dictionaryName
	 *            字典名称
	 * @return 字典编码
	 * @throws SQLException
	 */
	public String getCodeByName(String dictionaryName) throws SQLException {
		if(ValidateCheck.isNotNull(dictionaryName)) {
			return dictionaryMapper.getCodeByName(dictionaryName);
		}
		return null;
	}

	public List<String> getInstitutionList(Map<String, Object> institutionCon)
			throws SQLException {
		if(institutionCon != null && institutionCon.size() > 0) {
			return dictionaryMapper.getInstitutionList(institutionCon);
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> getDicNameByUpDicId(String upDictionaryOptionId) throws SQLException {
		if (ValidateCheck.isNotNull(upDictionaryOptionId)) {
			return dictionaryMapper.getDicNameByUpDicId(upDictionaryOptionId);
		}
		return null;
	}
}
