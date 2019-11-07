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

<<<<<<< HEAD
=======
    int deleteByPrimaryKey(String servProductid);

>>>>>>> ae91f5c60013d33b5451853a0b57e38e3e7bc4d6
    int insert(Serviceproduct record);

    int insertSelective(Serviceproduct record);

<<<<<<< HEAD
    List<Serviceproduct> selectByExample(ServiceproductExample example);

    int updateByExampleSelective(@Param("record") Serviceproduct record, @Param("example") ServiceproductExample example);

    int updateByExample(@Param("record") Serviceproduct record, @Param("example") ServiceproductExample example);
=======
    List<Serviceproduct> selectByExampleWithBLOBs(ServiceproductExample example);

    List<Serviceproduct> selectByExample(ServiceproductExample example);

    Serviceproduct selectByPrimaryKey(String servProductid);

    int updateByExampleSelective(@Param("record") Serviceproduct record, @Param("example") ServiceproductExample example);

    int updateByExampleWithBLOBs(@Param("record") Serviceproduct record, @Param("example") ServiceproductExample example);

    int updateByExample(@Param("record") Serviceproduct record, @Param("example") ServiceproductExample example);

    int updateByPrimaryKeySelective(Serviceproduct record);

    int updateByPrimaryKeyWithBLOBs(Serviceproduct record);

    int updateByPrimaryKey(Serviceproduct record);
    
    List<Serviceproduct> selectBypcname(String str);
    
    List<Serviceproduct> selectBypvname(String str);
>>>>>>> ae91f5c60013d33b5451853a0b57e38e3e7bc4d6
}