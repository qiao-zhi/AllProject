package cn.xm.mapper;

import cn.xm.pojo.TTempleateBaseInfo;
import cn.xm.pojo.TTempleateBaseInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTempleateBaseInfoMapper {
    int countByExample(TTempleateBaseInfoExample example);

    int deleteByExample(TTempleateBaseInfoExample example);

    int deleteByPrimaryKey(String templateid);

    int insert(TTempleateBaseInfo record);

    int insertSelective(TTempleateBaseInfo record);

    List<TTempleateBaseInfo> selectByExampleWithBLOBs(TTempleateBaseInfoExample example);

    List<TTempleateBaseInfo> selectByExample(TTempleateBaseInfoExample example);

    TTempleateBaseInfo selectByPrimaryKey(String templateid);

    int updateByExampleSelective(@Param("record") TTempleateBaseInfo record, @Param("example") TTempleateBaseInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") TTempleateBaseInfo record, @Param("example") TTempleateBaseInfoExample example);

    int updateByExample(@Param("record") TTempleateBaseInfo record, @Param("example") TTempleateBaseInfoExample example);

    int updateByPrimaryKeySelective(TTempleateBaseInfo record);

    int updateByPrimaryKeyWithBLOBs(TTempleateBaseInfo record);

    int updateByPrimaryKey(TTempleateBaseInfo record);
}