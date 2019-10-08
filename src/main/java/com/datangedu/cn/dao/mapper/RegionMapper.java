package com.datangedu.cn.dao.mapper;

import com.datangedu.cn.model.Region.Region;
import com.datangedu.cn.model.Region.RegionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RegionMapper {
    long countByExample(RegionExample example);

    int deleteByExample(RegionExample example);

    int deleteByPrimaryKey(String id);

    int insert(Region record);

    int insertSelective(Region record);

    List<Region> selectByExample(RegionExample example);

    Region selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Region record, @Param("example") RegionExample example);

    int updateByExample(@Param("record") Region record, @Param("example") RegionExample example);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);
}