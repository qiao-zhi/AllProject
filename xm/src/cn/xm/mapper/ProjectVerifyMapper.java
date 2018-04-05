package cn.xm.mapper;

import cn.xm.pojo.ProjectVerify;
import cn.xm.pojo.ProjectVerifyExample;
import cn.xm.pojo.ProjectVerifyWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectVerifyMapper {
    int countByExample(ProjectVerifyExample example);

    int deleteByExample(ProjectVerifyExample example);

    int deleteByPrimaryKey(Integer verifyid);

    int insert(ProjectVerifyWithBLOBs record);

    int insertSelective(ProjectVerifyWithBLOBs record);

    List<ProjectVerifyWithBLOBs> selectByExampleWithBLOBs(ProjectVerifyExample example);

    List<ProjectVerify> selectByExample(ProjectVerifyExample example);

    ProjectVerifyWithBLOBs selectByPrimaryKey(Integer verifyid);

    int updateByExampleSelective(@Param("record") ProjectVerifyWithBLOBs record, @Param("example") ProjectVerifyExample example);

    int updateByExampleWithBLOBs(@Param("record") ProjectVerifyWithBLOBs record, @Param("example") ProjectVerifyExample example);

    int updateByExample(@Param("record") ProjectVerify record, @Param("example") ProjectVerifyExample example);

    int updateByPrimaryKeySelective(ProjectVerifyWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProjectVerifyWithBLOBs record);

    int updateByPrimaryKey(ProjectVerify record);
}