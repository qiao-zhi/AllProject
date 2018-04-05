package cn.xm.mapper;

import cn.xm.pojo.TUserAccount;
import cn.xm.pojo.TUserAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserAccountMapper {
    int countByExample(TUserAccountExample example);

    int deleteByExample(TUserAccountExample example);

    int deleteByPrimaryKey(String uaid);

    int insert(TUserAccount record);

    int insertSelective(TUserAccount record);

    List<TUserAccount> selectByExample(TUserAccountExample example);

    TUserAccount selectByPrimaryKey(String uaid);

    int updateByExampleSelective(@Param("record") TUserAccount record, @Param("example") TUserAccountExample example);

    int updateByExample(@Param("record") TUserAccount record, @Param("example") TUserAccountExample example);

    int updateByPrimaryKeySelective(TUserAccount record);

    int updateByPrimaryKey(TUserAccount record);
}