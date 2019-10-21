package com.datangedu.cn.Service.CustomerProduct;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datangedu.cn.Random.ServletRandom;
import com.datangedu.cn.dao.mapper.CustomersMapper;

@Service
public class CustomerProductServeltIMPL implements CustomerProductServelt {
	@Resource
	CustomersMapper customersMapper;
	ServletRandom servletRandom;

}
