package cn.xm.mapper;

import cn.xm.pojo.EvaluationResult;
import cn.xm.pojo.EvaluationResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EvaluationResultMapper {
    int countByExample(EvaluationResultExample example);

    int deleteByExample(EvaluationResultExample example);

    int deleteByPrimaryKey(String evaluateresultid);

    int insert(EvaluationResult record);

    int insertSelective(EvaluationResult record);

    List<EvaluationResult> selectByExampleWithBLOBs(EvaluationResultExample example);

    List<EvaluationResult> selectByExample(EvaluationResultExample example);

    EvaluationResult selectByPrimaryKey(String evaluateresultid);

    int updateByExampleSelective(@Param("record") EvaluationResult record, @Param("example") EvaluationResultExample example);

    int updateByExampleWithBLOBs(@Param("record") EvaluationResult record, @Param("example") EvaluationResultExample example);

    int updateByExample(@Param("record") EvaluationResult record, @Param("example") EvaluationResultExample example);

    int updateByPrimaryKeySelective(EvaluationResult record);

    int updateByPrimaryKeyWithBLOBs(EvaluationResult record);

    int updateByPrimaryKey(EvaluationResult record);
}