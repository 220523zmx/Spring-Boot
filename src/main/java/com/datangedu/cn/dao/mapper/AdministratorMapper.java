package com.datangedu.cn.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.datangedu.cn.model.administrator.Administrator;
import com.datangedu.cn.model.administrator.AdministratorExample;
<<<<<<< HEAD


=======
>>>>>>> ae91f5c60013d33b5451853a0b57e38e3e7bc4d6
@Mapper
public interface AdministratorMapper {
    long countByExample(AdministratorExample example);

    int deleteByExample(AdministratorExample example);

<<<<<<< HEAD
=======
    int deleteByPrimaryKey(String admiId);

>>>>>>> ae91f5c60013d33b5451853a0b57e38e3e7bc4d6
    int insert(Administrator record);

    int insertSelective(Administrator record);

<<<<<<< HEAD
    List<Administrator> selectByExample(AdministratorExample example);
    
    List<Administrator> selectBylike(AdministratorExample example);
    
    Administrator selectByPrimaryKey(String admiId);
    
    int updateByExampleSelective(@Param("record") Administrator record, @Param("example") AdministratorExample example);

    int updateByExample(@Param("record") Administrator record, @Param("example") AdministratorExample example);
=======
    List<Administrator> selectByExampleWithBLOBs(AdministratorExample example);

    List<Administrator> selectByExample(AdministratorExample example);

    Administrator selectByPrimaryKey(String admiId);

    int updateByExampleSelective(@Param("record") Administrator record, @Param("example") AdministratorExample example);

    int updateByExampleWithBLOBs(@Param("record") Administrator record, @Param("example") AdministratorExample example);

    int updateByExample(@Param("record") Administrator record, @Param("example") AdministratorExample example);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKeyWithBLOBs(Administrator record);

    int updateByPrimaryKey(Administrator record);
>>>>>>> ae91f5c60013d33b5451853a0b57e38e3e7bc4d6
}