package cn.xm.mapper;

import cn.xm.pojo.TUserBaseInfo;
import cn.xm.pojo.TUserBaseInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserBaseInfoMapper {
    int countByExample(TUserBaseInfoExample example);

    int deleteByExample(TUserBaseInfoExample example);

    int deleteByPrimaryKey(String userid);

    int insert(TUserBaseInfo record);

    int insertSelective(TUserBaseInfo record);

    List<TUserBaseInfo> selectByExample(TUserBaseInfoExample example);

    TUserBaseInfo selectByPrimaryKey(String userid);

    int updateByExampleSelective(@Param("record") TUserBaseInfo record, @Param("example") TUserBaseInfoExample example);

    int updateByExample(@Param("record") TUserBaseInfo record, @Param("example") TUserBaseInfoExample example);

    int updateByPrimaryKeySelective(TUserBaseInfo record);

    int updateByPrimaryKey(TUserBaseInfo record);
}