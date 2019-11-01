package com.datangedu.cn.controller.CustomerOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datangedu.cn.Service.CustomerOrder.CustomerOrderServelt;

@Controller
@RequestMapping("/customer")
public class ControllerCustomerOrder {
	@Resource
	CustomerOrderServelt customerOrder;

	@ResponseBody
	@RequestMapping(value = "/order" , method = RequestMethod.POST)
	public Map<String, Object> customerOrder(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> lists = new ArrayList<String>();
		lists = customerOrder.findOrderNo(request.getParameter("id"));
		map.put("orderid",lists);//订单id集
		for(int i = 0;i <lists.size();i++)
		{
			map.put(lists.get(i), customerOrder.findOrderByOrderNo(lists.get(i)));
			
		}
		
		return map;
		}
		@ResponseBody
		@RequestMapping(value = "/deletepc", method = RequestMethod.POST)
		public Map<String,Object> removeorderline(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String, Object>();
		int a = customerOrder.removeorderline(request);
		System.out.println(a);
		if(a!=0)
		{
			map.put("status", "删除成功");
		}else
		{
			map.put("status", "删除失败");
		}
		
		return map;
		
		}
}
