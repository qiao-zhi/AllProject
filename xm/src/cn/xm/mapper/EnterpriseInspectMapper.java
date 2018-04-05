package cn.xm.mapper;

import cn.xm.pojo.EnterpriseInspect;
import cn.xm.pojo.EnterpriseInspectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnterpriseInspectMapper {
    int countByExample(EnterpriseInspectExample example);

    int deleteByExample(EnterpriseInspectExample example);

    int deleteByPrimaryKey(String inspectid);

    int insert(EnterpriseInspect record);

    int insertSelective(EnterpriseInspect record);

    List<EnterpriseInspect> selectByExampleWithBLOBs(EnterpriseInspectExample example);

    List<EnterpriseInspect> selectByExample(EnterpriseInspectExample example);

    EnterpriseInspect selectByPrimaryKey(String inspectid);

    int updateByExampleSelective(@Param("record") EnterpriseInspect record, @Param("example") EnterpriseInspectExample example);

    int updateByExampleWithBLOBs(@Param("record") EnterpriseInspect record, @Param("example") EnterpriseInspectExample example);

    int updateByExample(@Param("record") EnterpriseInspect record, @Param("example") EnterpriseInspectExample example);

    int updateByPrimaryKeySelective(EnterpriseInspect record);

    int updateByPrimaryKeyWithBLOBs(EnterpriseInspect record);

    int updateByPrimaryKey(EnterpriseInspect record);
}