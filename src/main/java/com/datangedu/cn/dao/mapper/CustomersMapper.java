package com.datangedu.cn.dao.mapper;

import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.customers.CustomersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomersMapper {
    long countByExample(CustomersExample example);

    int deleteByExample(CustomersExample example);

    int deleteByPrimaryKey(String custPhone);

    int insert(Customers record);

    int insertSelective(Customers record);

    List<Customers> selectByExample(CustomersExample example);

    Customers selectByPrimaryKey(String custPhone);

    int updateByExampleSelective(@Param("record") Customers record, @Param("example") CustomersExample example);

    int updateByExample(@Param("record") Customers record, @Param("example") CustomersExample example);

    int updateByPrimaryKeySelective(Customers record);

    int updateByPrimaryKey(Customers record);
}