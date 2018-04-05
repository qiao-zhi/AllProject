package cn.xm.mapper;

import cn.xm.pojo.IssueCertificate;
import cn.xm.pojo.IssueCertificateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IssueCertificateMapper {
    int countByExample(IssueCertificateExample example);

    int deleteByExample(IssueCertificateExample example);

    int deleteByPrimaryKey(String issueid);

    int insert(IssueCertificate record);

    int insertSelective(IssueCertificate record);

    List<IssueCertificate> selectByExample(IssueCertificateExample example);

    IssueCertificate selectByPrimaryKey(String issueid);

    int updateByExampleSelective(@Param("record") IssueCertificate record, @Param("example") IssueCertificateExample example);

    int updateByExample(@Param("record") IssueCertificate record, @Param("example") IssueCertificateExample example);

    int updateByPrimaryKeySelective(IssueCertificate record);

    int updateByPrimaryKey(IssueCertificate record);
}