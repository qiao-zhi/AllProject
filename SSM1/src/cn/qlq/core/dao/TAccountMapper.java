package cn.qlq.core.dao;

import cn.qlq.pojo.TAccount;
import cn.qlq.pojo.TAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAccountMapper {
    int countByExample(TAccountExample example);

    int deleteByExample(TAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TAccount record);

    int insertSelective(TAccount record);

    List<TAccount> selectByExample(TAccountExample example);

    TAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TAccount record, @Param("example") TAccountExample example);

    int updateByExample(@Param("record") TAccount record, @Param("example") TAccountExample example);

    int updateByPrimaryKeySelective(TAccount record);

    int updateByPrimaryKey(TAccount record);
}