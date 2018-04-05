package cn.xm.mapper;

import cn.xm.pojo.SpecialistArrangement;
import cn.xm.pojo.SpecialistArrangementExample;
import cn.xm.pojo.SpecialistArrangementKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpecialistArrangementMapper {
    int countByExample(SpecialistArrangementExample example);

    int deleteByExample(SpecialistArrangementExample example);

    int deleteByPrimaryKey(SpecialistArrangementKey key);

    int insert(SpecialistArrangement record);

    int insertSelective(SpecialistArrangement record);

    List<SpecialistArrangement> selectByExample(SpecialistArrangementExample example);

    SpecialistArrangement selectByPrimaryKey(SpecialistArrangementKey key);

    int updateByExampleSelective(@Param("record") SpecialistArrangement record, @Param("example") SpecialistArrangementExample example);

    int updateByExample(@Param("record") SpecialistArrangement record, @Param("example") SpecialistArrangementExample example);

    int updateByPrimaryKeySelective(SpecialistArrangement record);

    int updateByPrimaryKey(SpecialistArrangement record);
}