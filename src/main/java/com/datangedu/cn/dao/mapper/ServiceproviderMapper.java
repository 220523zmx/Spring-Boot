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

<<<<<<< HEAD
=======
    int deleteByPrimaryKey(String servProviderId);

>>>>>>> ae91f5c60013d33b5451853a0b57e38e3e7bc4d6
    int insert(Serviceprovider record);

    int insertSelective(Serviceprovider record);

<<<<<<< HEAD
    List<Serviceprovider> selectByExample(ServiceproviderExample example);

    int updateByExampleSelective(@Param("record") Serviceprovider record, @Param("example") ServiceproviderExample example);

    int updateByExample(@Param("record") Serviceprovider record, @Param("example") ServiceproviderExample example);
=======
    List<Serviceprovider> selectByExampleWithBLOBs(ServiceproviderExample example);

    List<Serviceprovider> selectByExample(ServiceproviderExample example);

    Serviceprovider selectByPrimaryKey(String servProviderId);

    int updateByExampleSelective(@Param("record") Serviceprovider record, @Param("example") ServiceproviderExample example);

    int updateByExampleWithBLOBs(@Param("record") Serviceprovider record, @Param("example") ServiceproviderExample example);

    int updateByExample(@Param("record") Serviceprovider record, @Param("example") ServiceproviderExample example);

    int updateByPrimaryKeySelective(Serviceprovider record);

    int updateByPrimaryKeyWithBLOBs(Serviceprovider record);

    int updateByPrimaryKey(Serviceprovider record);
>>>>>>> ae91f5c60013d33b5451853a0b57e38e3e7bc4d6
}