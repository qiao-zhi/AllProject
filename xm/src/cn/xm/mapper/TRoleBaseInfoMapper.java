package cn.xm.mapper;

import cn.xm.pojo.TRoleBaseInfo;
import cn.xm.pojo.TRoleBaseInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRoleBaseInfoMapper {
    int countByExample(TRoleBaseInfoExample example);

    int deleteByExample(TRoleBaseInfoExample example);

    int deleteByPrimaryKey(String roleid);

    int insert(TRoleBaseInfo record);

    int insertSelective(TRoleBaseInfo record);

    List<TRoleBaseInfo> selectByExample(TRoleBaseInfoExample example);

    TRoleBaseInfo selectByPrimaryKey(String roleid);

    int updateByExampleSelective(@Param("record") TRoleBaseInfo record, @Param("example") TRoleBaseInfoExample example);

    int updateByExample(@Param("record") TRoleBaseInfo record, @Param("example") TRoleBaseInfoExample example);

    int updateByPrimaryKeySelective(TRoleBaseInfo record);

    int updateByPrimaryKey(TRoleBaseInfo record);
}