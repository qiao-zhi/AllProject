package cn.xm.mapper;

import cn.xm.pojo.TBaseDefinedUrl;
import cn.xm.pojo.TBaseDefinedUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBaseDefinedUrlMapper {
    int countByExample(TBaseDefinedUrlExample example);

    int deleteByExample(TBaseDefinedUrlExample example);

    int deleteByPrimaryKey(String id);

    int insert(TBaseDefinedUrl record);

    int insertSelective(TBaseDefinedUrl record);

    List<TBaseDefinedUrl> selectByExample(TBaseDefinedUrlExample example);

    TBaseDefinedUrl selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TBaseDefinedUrl record, @Param("example") TBaseDefinedUrlExample example);

    int updateByExample(@Param("record") TBaseDefinedUrl record, @Param("example") TBaseDefinedUrlExample example);

    int updateByPrimaryKeySelective(TBaseDefinedUrl record);

    int updateByPrimaryKey(TBaseDefinedUrl record);
}