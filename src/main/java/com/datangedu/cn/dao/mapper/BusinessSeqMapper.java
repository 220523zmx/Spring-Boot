package com.datangedu.cn.dao.mapper;

import com.datangedu.cn.model.Business_seq.BusinessSeq;
import com.datangedu.cn.model.Business_seq.BusinessSeqExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessSeqMapper {
    long countByExample(BusinessSeqExample example);

    int deleteByExample(BusinessSeqExample example);

    int deleteByPrimaryKey(String id);

    int insert(BusinessSeq record);

    int insertSelective(BusinessSeq record);

    List<BusinessSeq> selectByExample(BusinessSeqExample example);

    BusinessSeq selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BusinessSeq record, @Param("example") BusinessSeqExample example);

    int updateByExample(@Param("record") BusinessSeq record, @Param("example") BusinessSeqExample example);

    int updateByPrimaryKeySelective(BusinessSeq record);

    int updateByPrimaryKey(BusinessSeq record);
}