package com.datangedu.cn.dao.mapper;

import com.datangedu.cn.model.Product_type.ProductType;
import com.datangedu.cn.model.Product_type.ProductTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductTypeMapper {
    long countByExample(ProductTypeExample example);

    int deleteByExample(ProductTypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProductType record);

    int insertSelective(ProductType record);

    List<ProductType> selectByExample(ProductTypeExample example);

    ProductType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProductType record, @Param("example") ProductTypeExample example);

    int updateByExample(@Param("record") ProductType record, @Param("example") ProductTypeExample example);

    int updateByPrimaryKeySelective(ProductType record);

    int updateByPrimaryKey(ProductType record);
}