package com.datangedu.cn.dao.mapper;

import com.datangedu.cn.model.Provider_business.ProviderBusiness;
import com.datangedu.cn.model.Provider_business.ProviderBusinessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProviderBusinessMapper {
    long countByExample(ProviderBusinessExample example);

    int deleteByExample(ProviderBusinessExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProviderBusiness record);

    int insertSelective(ProviderBusiness record);

    List<ProviderBusiness> selectByExample(ProviderBusinessExample example);

    ProviderBusiness selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProviderBusiness record, @Param("example") ProviderBusinessExample example);

    int updateByExample(@Param("record") ProviderBusiness record, @Param("example") ProviderBusinessExample example);

    int updateByPrimaryKeySelective(ProviderBusiness record);

    int updateByPrimaryKey(ProviderBusiness record);
}