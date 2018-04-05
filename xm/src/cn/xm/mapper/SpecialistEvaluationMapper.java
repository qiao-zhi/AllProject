package cn.xm.mapper;

import cn.xm.pojo.SpecialistEvaluation;
import cn.xm.pojo.SpecialistEvaluationExample;
import cn.xm.pojo.SpecialistEvaluationKey;
import cn.xm.pojo.SpecialistEvaluationWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpecialistEvaluationMapper {
    int countByExample(SpecialistEvaluationExample example);

    int deleteByExample(SpecialistEvaluationExample example);

    int deleteByPrimaryKey(SpecialistEvaluationKey key);

    int insert(SpecialistEvaluationWithBLOBs record);

    int insertSelective(SpecialistEvaluationWithBLOBs record);

    List<SpecialistEvaluationWithBLOBs> selectByExampleWithBLOBs(SpecialistEvaluationExample example);

    List<SpecialistEvaluation> selectByExample(SpecialistEvaluationExample example);

    SpecialistEvaluationWithBLOBs selectByPrimaryKey(SpecialistEvaluationKey key);

    int updateByExampleSelective(@Param("record") SpecialistEvaluationWithBLOBs record, @Param("example") SpecialistEvaluationExample example);

    int updateByExampleWithBLOBs(@Param("record") SpecialistEvaluationWithBLOBs record, @Param("example") SpecialistEvaluationExample example);

    int updateByExample(@Param("record") SpecialistEvaluation record, @Param("example") SpecialistEvaluationExample example);

    int updateByPrimaryKeySelective(SpecialistEvaluationWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SpecialistEvaluationWithBLOBs record);

    int updateByPrimaryKey(SpecialistEvaluation record);
}