package cn.xm.mapper;

import cn.xm.pojo.TProjectBaseInfo;
import cn.xm.pojo.TProjectBaseInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProjectBaseInfoMapper {
    int countByExample(TProjectBaseInfoExample example);

    int deleteByExample(TProjectBaseInfoExample example);

    int deleteByPrimaryKey(String projectid);

    int insert(TProjectBaseInfo record);

    int insertSelective(TProjectBaseInfo record);

    List<TProjectBaseInfo> selectByExample(TProjectBaseInfoExample example);

    TProjectBaseInfo selectByPrimaryKey(String projectid);

    int updateByExampleSelective(@Param("record") TProjectBaseInfo record, @Param("example") TProjectBaseInfoExample example);

    int updateByExample(@Param("record") TProjectBaseInfo record, @Param("example") TProjectBaseInfoExample example);

    int updateByPrimaryKeySelective(TProjectBaseInfo record);

    int updateByPrimaryKey(TProjectBaseInfo record);
}