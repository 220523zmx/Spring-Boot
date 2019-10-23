package com.datangedu.cn.dao.mapper;

import com.datangedu.cn.model.serviceprovider.Serviceprovider;
import com.datangedu.cn.model.serviceprovider.ServiceproviderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceproviderMapper {
    long countByExample(ServiceproviderExample example);

    int deleteByExample(ServiceproviderExample example);

    int deleteByPrimaryKey(String servProviderId);

    int insert(Serviceprovider record);

    int insertSelective(Serviceprovider record);

    List<Serviceprovider> selectByExampleWithBLOBs(ServiceproviderExample example);

    List<Serviceprovider> selectByExample(ServiceproviderExample example);

    Serviceprovider selectByPrimaryKey(String servProviderId);

    int updateByExampleSelective(@Param("record") Serviceprovider record, @Param("example") ServiceproviderExample example);

    int updateByExampleWithBLOBs(@Param("record") Serviceprovider record, @Param("example") ServiceproviderExample example);

    int updateByExample(@Param("record") Serviceprovider record, @Param("example") ServiceproviderExample example);

    int updateByPrimaryKeySelective(Serviceprovider record);

    int updateByPrimaryKeyWithBLOBs(Serviceprovider record);

    int updateByPrimaryKey(Serviceprovider record);
}