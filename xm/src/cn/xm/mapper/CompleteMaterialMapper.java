package cn.xm.mapper;

import cn.xm.pojo.CompleteMaterial;
import cn.xm.pojo.CompleteMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompleteMaterialMapper {
    int countByExample(CompleteMaterialExample example);

    int deleteByExample(CompleteMaterialExample example);

    int deleteByPrimaryKey(String completeid);

    int insert(CompleteMaterial record);

    int insertSelective(CompleteMaterial record);

    List<CompleteMaterial> selectByExample(CompleteMaterialExample example);

    CompleteMaterial selectByPrimaryKey(String completeid);

    int updateByExampleSelective(@Param("record") CompleteMaterial record, @Param("example") CompleteMaterialExample example);

    int updateByExample(@Param("record") CompleteMaterial record, @Param("example") CompleteMaterialExample example);

    int updateByPrimaryKeySelective(CompleteMaterial record);

    int updateByPrimaryKey(CompleteMaterial record);
}