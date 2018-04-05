package cn.xm.mapper;

import cn.xm.pojo.SpecialistRecommend;
import cn.xm.pojo.SpecialistRecommendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpecialistRecommendMapper {
    int countByExample(SpecialistRecommendExample example);

    int deleteByExample(SpecialistRecommendExample example);

    int deleteByPrimaryKey(String specialistid);

    int insert(SpecialistRecommend record);

    int insertSelective(SpecialistRecommend record);

    List<SpecialistRecommend> selectByExample(SpecialistRecommendExample example);

    SpecialistRecommend selectByPrimaryKey(String specialistid);

    int updateByExampleSelective(@Param("record") SpecialistRecommend record, @Param("example") SpecialistRecommendExample example);

    int updateByExample(@Param("record") SpecialistRecommend record, @Param("example") SpecialistRecommendExample example);

    int updateByPrimaryKeySelective(SpecialistRecommend record);

    int updateByPrimaryKey(SpecialistRecommend record);
}