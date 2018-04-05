package cn.xm.mapper;

import cn.xm.pojo.TMeetingBaseInfo;
import cn.xm.pojo.TMeetingBaseInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMeetingBaseInfoMapper {
    int countByExample(TMeetingBaseInfoExample example);

    int deleteByExample(TMeetingBaseInfoExample example);

    int deleteByPrimaryKey(String meetingid);

    int insert(TMeetingBaseInfo record);

    int insertSelective(TMeetingBaseInfo record);

    List<TMeetingBaseInfo> selectByExample(TMeetingBaseInfoExample example);

    TMeetingBaseInfo selectByPrimaryKey(String meetingid);

    int updateByExampleSelective(@Param("record") TMeetingBaseInfo record, @Param("example") TMeetingBaseInfoExample example);

    int updateByExample(@Param("record") TMeetingBaseInfo record, @Param("example") TMeetingBaseInfoExample example);

    int updateByPrimaryKeySelective(TMeetingBaseInfo record);

    int updateByPrimaryKey(TMeetingBaseInfo record);
}