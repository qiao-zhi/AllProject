package cn.xm.mapper;

import cn.xm.pojo.ProjectCensor;
import cn.xm.pojo.ProjectCensorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectCensorMapper {
    int countByExample(ProjectCensorExample example);

    int deleteByExample(ProjectCensorExample example);

    int deleteByPrimaryKey(String censorid);

    int insert(ProjectCensor record);

    int insertSelective(ProjectCensor record);

    List<ProjectCensor> selectByExampleWithBLOBs(ProjectCensorExample example);

    List<ProjectCensor> selectByExample(ProjectCensorExample example);

    ProjectCensor selectByPrimaryKey(String censorid);

    int updateByExampleSelective(@Param("record") ProjectCensor record, @Param("example") ProjectCensorExample example);

    int updateByExampleWithBLOBs(@Param("record") ProjectCensor record, @Param("example") ProjectCensorExample example);

    int updateByExample(@Param("record") ProjectCensor record, @Param("example") ProjectCensorExample example);

    int updateByPrimaryKeySelective(ProjectCensor record);

    int updateByPrimaryKeyWithBLOBs(ProjectCensor record);

    int updateByPrimaryKey(ProjectCensor record);
}