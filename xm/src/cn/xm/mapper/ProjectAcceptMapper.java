package cn.xm.mapper;

import cn.xm.pojo.ProjectAccept;
import cn.xm.pojo.ProjectAcceptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectAcceptMapper {
    int countByExample(ProjectAcceptExample example);

    int deleteByExample(ProjectAcceptExample example);

    int deleteByPrimaryKey(String acceptid);

    int insert(ProjectAccept record);

    int insertSelective(ProjectAccept record);

    List<ProjectAccept> selectByExampleWithBLOBs(ProjectAcceptExample example);

    List<ProjectAccept> selectByExample(ProjectAcceptExample example);

    ProjectAccept selectByPrimaryKey(String acceptid);

    int updateByExampleSelective(@Param("record") ProjectAccept record, @Param("example") ProjectAcceptExample example);

    int updateByExampleWithBLOBs(@Param("record") ProjectAccept record, @Param("example") ProjectAcceptExample example);

    int updateByExample(@Param("record") ProjectAccept record, @Param("example") ProjectAcceptExample example);

    int updateByPrimaryKeySelective(ProjectAccept record);

    int updateByPrimaryKeyWithBLOBs(ProjectAccept record);

    int updateByPrimaryKey(ProjectAccept record);
}