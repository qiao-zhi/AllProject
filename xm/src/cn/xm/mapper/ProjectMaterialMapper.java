package cn.xm.mapper;

import cn.xm.pojo.ProjectMaterial;
import cn.xm.pojo.ProjectMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectMaterialMapper {
    int countByExample(ProjectMaterialExample example);

    int deleteByExample(ProjectMaterialExample example);

    int deleteByPrimaryKey(String materialid);

    int insert(ProjectMaterial record);

    int insertSelective(ProjectMaterial record);

    List<ProjectMaterial> selectByExample(ProjectMaterialExample example);

    ProjectMaterial selectByPrimaryKey(String materialid);

    int updateByExampleSelective(@Param("record") ProjectMaterial record, @Param("example") ProjectMaterialExample example);

    int updateByExample(@Param("record") ProjectMaterial record, @Param("example") ProjectMaterialExample example);

    int updateByPrimaryKeySelective(ProjectMaterial record);

    int updateByPrimaryKey(ProjectMaterial record);
}