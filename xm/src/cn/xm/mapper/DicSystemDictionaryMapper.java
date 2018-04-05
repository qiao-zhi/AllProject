package cn.xm.mapper;

import cn.xm.pojo.DicSystemDictionary;
import cn.xm.pojo.DicSystemDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DicSystemDictionaryMapper {
    int countByExample(DicSystemDictionaryExample example);

    int deleteByExample(DicSystemDictionaryExample example);

    int deleteByPrimaryKey(String dictionaryoptionid);

    int insert(DicSystemDictionary record);

    int insertSelective(DicSystemDictionary record);

    List<DicSystemDictionary> selectByExample(DicSystemDictionaryExample example);

    DicSystemDictionary selectByPrimaryKey(String dictionaryoptionid);

    int updateByExampleSelective(@Param("record") DicSystemDictionary record, @Param("example") DicSystemDictionaryExample example);

    int updateByExample(@Param("record") DicSystemDictionary record, @Param("example") DicSystemDictionaryExample example);

    int updateByPrimaryKeySelective(DicSystemDictionary record);

    int updateByPrimaryKey(DicSystemDictionary record);
}