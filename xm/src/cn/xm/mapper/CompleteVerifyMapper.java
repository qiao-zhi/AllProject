package cn.xm.mapper;

import cn.xm.pojo.CompleteVerifyExample;
import cn.xm.pojo.CompleteVerifyKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompleteVerifyMapper {
    int countByExample(CompleteVerifyExample example);

    int deleteByExample(CompleteVerifyExample example);

    int deleteByPrimaryKey(CompleteVerifyKey key);

    int insert(CompleteVerifyKey record);

    int insertSelective(CompleteVerifyKey record);

    List<CompleteVerifyKey> selectByExample(CompleteVerifyExample example);

    int updateByExampleSelective(@Param("record") CompleteVerifyKey record, @Param("example") CompleteVerifyExample example);

    int updateByExample(@Param("record") CompleteVerifyKey record, @Param("example") CompleteVerifyExample example);
}