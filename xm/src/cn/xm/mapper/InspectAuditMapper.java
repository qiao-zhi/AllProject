package cn.xm.mapper;

import cn.xm.pojo.InspectAudit;
import cn.xm.pojo.InspectAuditExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InspectAuditMapper {
    int countByExample(InspectAuditExample example);

    int deleteByExample(InspectAuditExample example);

    int deleteByPrimaryKey(String auditid);

    int insert(InspectAudit record);

    int insertSelective(InspectAudit record);

    List<InspectAudit> selectByExample(InspectAuditExample example);

    InspectAudit selectByPrimaryKey(String auditid);

    int updateByExampleSelective(@Param("record") InspectAudit record, @Param("example") InspectAuditExample example);

    int updateByExample(@Param("record") InspectAudit record, @Param("example") InspectAuditExample example);

    int updateByPrimaryKeySelective(InspectAudit record);

    int updateByPrimaryKey(InspectAudit record);
}