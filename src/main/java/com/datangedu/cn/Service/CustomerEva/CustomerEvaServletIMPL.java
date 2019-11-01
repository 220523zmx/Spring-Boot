package com.datangedu.cn.Service.CustomerEva;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.AllorderMapper;
import com.datangedu.cn.dao.mapper.ServiceproductMapper;
import com.datangedu.cn.model.order.Allorder;
import com.datangedu.cn.model.order.AllorderExample;
import com.datangedu.cn.model.serviceproduct.ServiceproductExample;

@Service
public class CustomerEvaServletIMPL implements CustomerEvaServlet {
	@Resource
	AllorderMapper allorderMapper;
	@Resource
	ServiceproductMapper serviceproductMapper;
	public List<Allorder> findhaseva(HttpServletRequest request)
	{
		AllorderExample allorderExample = new AllorderExample();
		AllorderExample.Criteria Criteria =  allorderExample.createCriteria();
		Criteria.andOrdeEvaluationstatusEqualTo(1);
		Criteria.andOrdeCustomeridEqualTo(request.getParameter("id"));
		return allorderMapper.selectByExample(allorderExample); 
	}
	
	
	public List<Allorder> findnoteva(HttpServletRequest request)
	{
		AllorderExample allorderExample = new AllorderExample();
		AllorderExample.Criteria Criteria =  allorderExample.createCriteria();
		Criteria.andOrdeEvaluationstatusEqualTo(0);
		Criteria.andOrdeCustomeridEqualTo(request.getParameter("id"));
		return allorderMapper.selectByExample(allorderExample); 
	}
	public String findserinstruction(Allorder allorder)
	{
		ServiceproductExample serviceproductExample = new ServiceproductExample();
		ServiceproductExample.Criteria criteria= serviceproductExample.createCriteria();
		criteria.andServProductnameEqualTo(allorder.getOrdeProduct());
		criteria.andServProvidernameEqualTo(allorder.getOrdeProvidername());
		return serviceproductMapper.selectByExample(serviceproductExample).get(0).getServInstructions();
	}

}
