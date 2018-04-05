package cn.xm.mapper;

import cn.xm.pojo.TFilesIndex;
import cn.xm.pojo.TFilesIndexExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TFilesIndexMapper {
    int countByExample(TFilesIndexExample example);

    int deleteByExample(TFilesIndexExample example);

    int deleteByPrimaryKey(Integer fileid);

    int insert(TFilesIndex record);

    int insertSelective(TFilesIndex record);

    List<TFilesIndex> selectByExampleWithBLOBs(TFilesIndexExample example);

    List<TFilesIndex> selectByExample(TFilesIndexExample example);

    TFilesIndex selectByPrimaryKey(Integer fileid);

    int updateByExampleSelective(@Param("record") TFilesIndex record, @Param("example") TFilesIndexExample example);

    int updateByExampleWithBLOBs(@Param("record") TFilesIndex record, @Param("example") TFilesIndexExample example);

    int updateByExample(@Param("record") TFilesIndex record, @Param("example") TFilesIndexExample example);

    int updateByPrimaryKeySelective(TFilesIndex record);

    int updateByPrimaryKeyWithBLOBs(TFilesIndex record);

    int updateByPrimaryKey(TFilesIndex record);
}