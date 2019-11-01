package com.datangedu.cn.controller.CusstomerEva;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datangedu.cn.Service.CustomerEva.CustomerEvaServlet;
import com.datangedu.cn.model.order.Allorder;

@Controller
@RequestMapping("/customer")
public class ControllerCustomerEva {
	@Resource
	CustomerEvaServlet customerEvaServlet;
	@ResponseBody
	@RequestMapping(value= "hasevaluate",method = RequestMethod.POST)
	public Map<String,Object> findhaseva(HttpServletRequest request)
	{
		Map<String,Object> map = new HashMap<String,Object> ();
		List<Allorder> list = customerEvaServlet.findhaseva(request);
		System.out.println(list);
		if(list.size() != 0) {
			for(int i = 0;i<list.size();i++)
			{
				String str = customerEvaServlet.findserinstruction(list.get(i));
				map.put(list.get(i).getOrdeProduct(), str);
			}
			map.put("list", list);
		}
		else{
			map.put("state","您还没有评价过哦");
		}
		return map;
	}
	@ResponseBody
	@RequestMapping(value= "notevaluate",method = RequestMethod.POST)
	public Map<String,Object> findnoteva(HttpServletRequest request)
	{
		Map<String,Object> map = new HashMap<String,Object> ();
		List<Allorder> list = customerEvaServlet.findnoteva(request);
		System.out.println(list);
		if(list.size() != 0) {
			for(int i = 0;i<list.size();i++)
			{
				String str =customerEvaServlet.findserinstruction(list.get(i));
				map.put(list.get(i).getOrdeProduct(), str);
			}
			map.put("list", list);
		
		}
		else{
			map.put("state","您都评价完了哦");
		}
		
		return map;
	}

}
