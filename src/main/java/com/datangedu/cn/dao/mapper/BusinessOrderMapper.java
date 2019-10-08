package com.datangedu.cn.dao.mapper;

import com.datangedu.cn.model.Business_order.BusinessOrder;
import com.datangedu.cn.model.Business_order.BusinessOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessOrderMapper {
    long countByExample(BusinessOrderExample example);

    int deleteByExample(BusinessOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(BusinessOrder record);

    int insertSelective(BusinessOrder record);

    List<BusinessOrder> selectByExample(BusinessOrderExample example);

    BusinessOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BusinessOrder record, @Param("example") BusinessOrderExample example);

    int updateByExample(@Param("record") BusinessOrder record, @Param("example") BusinessOrderExample example);

    int updateByPrimaryKeySelective(BusinessOrder record);

    int updateByPrimaryKey(BusinessOrder record);
}