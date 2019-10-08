package com.datangedu.cn.dao.mapper;

import com.datangedu.cn.model.Product_detail.ProductDetail;
import com.datangedu.cn.model.Product_detail.ProductDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductDetailMapper {
    long countByExample(ProductDetailExample example);

    int deleteByExample(ProductDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProductDetail record);

    int insertSelective(ProductDetail record);

    List<ProductDetail> selectByExample(ProductDetailExample example);

    ProductDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProductDetail record, @Param("example") ProductDetailExample example);

    int updateByExample(@Param("record") ProductDetail record, @Param("example") ProductDetailExample example);

    int updateByPrimaryKeySelective(ProductDetail record);

    int updateByPrimaryKey(ProductDetail record);
}