package cn.xm.mapper;

import cn.xm.pojo.SpecialistLibrary;
import cn.xm.pojo.SpecialistLibraryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpecialistLibraryMapper {
    int countByExample(SpecialistLibraryExample example);

    int deleteByExample(SpecialistLibraryExample example);

    int deleteByPrimaryKey(String specialistid);

    int insert(SpecialistLibrary record);

    int insertSelective(SpecialistLibrary record);

    List<SpecialistLibrary> selectByExample(SpecialistLibraryExample example);

    SpecialistLibrary selectByPrimaryKey(String specialistid);

    int updateByExampleSelective(@Param("record") SpecialistLibrary record, @Param("example") SpecialistLibraryExample example);

    int updateByExample(@Param("record") SpecialistLibrary record, @Param("example") SpecialistLibraryExample example);

    int updateByPrimaryKeySelective(SpecialistLibrary record);

    int updateByPrimaryKey(SpecialistLibrary record);
}