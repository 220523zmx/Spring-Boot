package com.datangedu.cn.controller.CustomerRegister;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class ControllerCustomerRegister {
	
	@ResponseBody
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public Map<String,Object> customerRegister()
	{
		Map<String,Object> map = new HashMap<String,Object>();
		int state=0 ;
		map.put("custregister",state);
		return map;
	}

}
