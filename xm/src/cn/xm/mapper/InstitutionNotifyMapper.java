package cn.xm.mapper;

import cn.xm.pojo.InstitutionNotify;
import cn.xm.pojo.InstitutionNotifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InstitutionNotifyMapper {
    int countByExample(InstitutionNotifyExample example);

    int deleteByExample(InstitutionNotifyExample example);

    int deleteByPrimaryKey(String notifyid);

    int insert(InstitutionNotify record);

    int insertSelective(InstitutionNotify record);

    List<InstitutionNotify> selectByExample(InstitutionNotifyExample example);

    InstitutionNotify selectByPrimaryKey(String notifyid);

    int updateByExampleSelective(@Param("record") InstitutionNotify record, @Param("example") InstitutionNotifyExample example);

    int updateByExample(@Param("record") InstitutionNotify record, @Param("example") InstitutionNotifyExample example);

    int updateByPrimaryKeySelective(InstitutionNotify record);

    int updateByPrimaryKey(InstitutionNotify record);
}