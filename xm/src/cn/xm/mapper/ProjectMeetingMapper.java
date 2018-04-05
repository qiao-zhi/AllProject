package cn.xm.mapper;

import cn.xm.pojo.ProjectMeeting;
import cn.xm.pojo.ProjectMeetingExample;
import cn.xm.pojo.ProjectMeetingKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectMeetingMapper {
    int countByExample(ProjectMeetingExample example);

    int deleteByExample(ProjectMeetingExample example);

    int deleteByPrimaryKey(ProjectMeetingKey key);

    int insert(ProjectMeeting record);

    int insertSelective(ProjectMeeting record);

    List<ProjectMeeting> selectByExample(ProjectMeetingExample example);

    ProjectMeeting selectByPrimaryKey(ProjectMeetingKey key);

    int updateByExampleSelective(@Param("record") ProjectMeeting record, @Param("example") ProjectMeetingExample example);

    int updateByExample(@Param("record") ProjectMeeting record, @Param("example") ProjectMeetingExample example);

    int updateByPrimaryKeySelective(ProjectMeeting record);

    int updateByPrimaryKey(ProjectMeeting record);
}