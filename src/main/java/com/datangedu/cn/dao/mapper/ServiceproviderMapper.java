package com.datangedu.cn.dao.mapper;

import com.datangedu.cn.model.serviceprovider.Serviceprovider;
import com.datangedu.cn.model.serviceprovider.ServiceproviderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceproviderMapper {
    long countByExample(ServiceproviderExample example);

    int deleteByExample(ServiceproviderExample example);

    int insert(Serviceprovider record);

    int insertSelective(Serviceprovider record);

    List<Serviceprovider> selectByExample(ServiceproviderExample example);

    int updateByExampleSelective(@Param("record") Serviceprovider record, @Param("example") ServiceproviderExample example);

    int updateByExample(@Param("record") Serviceprovider record, @Param("example") ServiceproviderExample example);
}