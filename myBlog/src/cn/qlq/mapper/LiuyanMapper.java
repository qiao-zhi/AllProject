package cn.qlq.mapper;

import cn.qlq.bean.Liuyan;
import cn.qlq.bean.LiuyanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LiuyanMapper {
    int countByExample(LiuyanExample example);

    int deleteByExample(LiuyanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Liuyan record);

    int insertSelective(Liuyan record);

    List<Liuyan> selectByExample(LiuyanExample example);

    Liuyan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Liuyan record, @Param("example") LiuyanExample example);

    int updateByExample(@Param("record") Liuyan record, @Param("example") LiuyanExample example);

    int updateByPrimaryKeySelective(Liuyan record);

    int updateByPrimaryKey(Liuyan record);
}