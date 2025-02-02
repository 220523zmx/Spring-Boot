package com.datangedu.cn.controller.CustomerPay;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datangedu.cn.Service.CustomerPay.CustomerPayServlet;
import com.datangedu.cn.Service.CustomerPay.CustomerPayServletIMPL;

@Controller
@RequestMapping("/customer")
public class ControllerCustomerPay {
	@Resource
	CustomerPayServlet customerPay;
	@ResponseBody
	@RequestMapping(value = "/paylist", method = RequestMethod.POST)
	public Map<String, Object> customerpay(HttpServletRequest request)
	{
		Map<String, Object> map = new HashMap<String, Object>();	
		map.put("paylist", customerPay.findorder(request));
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/payway", method = RequestMethod.POST)
	public Map<String, Object> orderpayway(HttpServletRequest request)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		int a = customerPay.updatepayway(request);
		System.out.println(a);
		if(a!=0)
		{
			int b= customerPay.updatestate(request);
			if(b!=0)
			{
				map.put("status", "支付成功");
			}
			else
			{
				map.put("status","支付失败，请重试");
			}
		}else
		{
			map.put("status","支付失败，请重试");
		}
		return map;
	}

}
