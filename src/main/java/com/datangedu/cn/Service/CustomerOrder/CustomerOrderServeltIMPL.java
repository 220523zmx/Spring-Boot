package com.datangedu.cn.Service.CustomerOrder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.AllorderMapper;
import com.datangedu.cn.dao.mapper.ServiceproductMapper;
import com.datangedu.cn.model.order.Allorder;
import com.datangedu.cn.model.order.AllorderExample;
import com.datangedu.cn.model.serviceproduct.Serviceproduct;
import com.datangedu.cn.model.serviceproduct.ServiceproductExample;

@Service
public class CustomerOrderServeltIMPL implements CustomerOrderServelt {
	@Resource
	AllorderMapper allorderMapper;
	@Resource
	ServiceproductMapper serviceproduct;
	

	
	/*public String findPvLine(String pvid)
	{
		ServiceproductExample  serviceproductExample  = new ServiceproductExample();
		ServiceproductExample.Criteria criteria = serviceproductExample.createCriteria();
		criteria.andServProductnameEqualTo(pvid);
		List<Serviceproduct> list = serviceproduct.selectByExample(serviceproductExample);
		return list.get(0).getServProvidername();
	}*/
	
	public List<String> findOrderNo(String cuid)
	{
		List<String> lists = new ArrayList<String>();
		List<Allorder> lista = new ArrayList<Allorder>();
		Set<String> set = new HashSet<String>();
		AllorderExample allorderExample =new AllorderExample();
		AllorderExample.Criteria criteria = allorderExample.createCriteria();
		criteria.andOrdeCustomeridEqualTo(cuid);
		lista = allorderMapper.selectByExample(allorderExample);
		for(int i = 0;i<lista.size();i++)
		{
			set.add(lista.get(i).getOrdeId());
		}
		lists.addAll(set);
		return lists;
	}
	public List<Allorder> findOrderByOrderNo(String orid)
	{
		
		AllorderExample allorderExample =new AllorderExample();
		AllorderExample.Criteria criteria = allorderExample.createCriteria();
		criteria.andOrdeIdEqualTo(orid);
		return allorderMapper.selectByExample(allorderExample);
		
		
	}
	public int removeorderline(HttpServletRequest request)
	{
		System.out.println(request.getParameter("orderid"));
		System.out.println(request.getParameter("pcname"));
		AllorderExample allorderExample =new AllorderExample();
		AllorderExample.Criteria criteria = allorderExample.createCriteria();
		criteria.andOrdeIdEqualTo(request.getParameter("orderid"));
		criteria.andOrdeProductEqualTo(request.getParameter("pcname"));
		return allorderMapper.deleteByExample(allorderExample);
		
	}
	

}
