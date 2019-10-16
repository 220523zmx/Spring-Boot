package com.datangedu.cn.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.datangedu.cn.model.serviceprovider.Serviceprovider;
import com.datangedu.cn.model.serviceprovider.ServiceproviderExample;
@Mapper
public interface ServiceproviderMapper {
    long countByExample(ServiceproviderExample example);

    int deleteByExample(ServiceproviderExample example);

    int insert(Serviceprovider record);

    int insertSelective(Serviceprovider record);

    List<Serviceprovider> selectByExample(ServiceproviderExample example);

    int updateByExampleSelective(@Param("record") Serviceprovider record, @Param("example") ServiceproviderExample example);

    int updateByExample(@Param("record") Serviceprovider record, @Param("example") ServiceproviderExample example);
}