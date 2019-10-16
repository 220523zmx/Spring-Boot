package com.datangedu.cn.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.datangedu.cn.model.serviceproduct.Serviceproduct;
import com.datangedu.cn.model.serviceproduct.ServiceproductExample;
@Mapper
public interface ServiceproductMapper {
    long countByExample(ServiceproductExample example);

    int deleteByExample(ServiceproductExample example);

    int insert(Serviceproduct record);

    int insertSelective(Serviceproduct record);

    List<Serviceproduct> selectByExample(ServiceproductExample example);

    int updateByExampleSelective(@Param("record") Serviceproduct record, @Param("example") ServiceproductExample example);

    int updateByExample(@Param("record") Serviceproduct record, @Param("example") ServiceproductExample example);
}