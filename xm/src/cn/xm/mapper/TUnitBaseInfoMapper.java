package cn.xm.mapper;

import cn.xm.pojo.TUnitBaseInfo;
import cn.xm.pojo.TUnitBaseInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUnitBaseInfoMapper {
    int countByExample(TUnitBaseInfoExample example);

    int deleteByExample(TUnitBaseInfoExample example);

    int deleteByPrimaryKey(String unitid);

    int insert(TUnitBaseInfo record);

    int insertSelective(TUnitBaseInfo record);

    List<TUnitBaseInfo> selectByExample(TUnitBaseInfoExample example);

    TUnitBaseInfo selectByPrimaryKey(String unitid);

    int updateByExampleSelective(@Param("record") TUnitBaseInfo record, @Param("example") TUnitBaseInfoExample example);

    int updateByExample(@Param("record") TUnitBaseInfo record, @Param("example") TUnitBaseInfoExample example);

    int updateByPrimaryKeySelective(TUnitBaseInfo record);

    int updateByPrimaryKey(TUnitBaseInfo record);
}