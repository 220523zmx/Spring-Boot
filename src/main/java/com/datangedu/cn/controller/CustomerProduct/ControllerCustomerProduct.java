package com.datangedu.cn.controller.CustomerProduct;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datangedu.cn.Random.ServletRandom;
import com.datangedu.cn.Service.CustomerRegister.CustomerRegisterServlet;

@Controller
@RequestMapping("/customer")
public class ControllerCustomerProduct {
	@Resource
	CustomerRegisterServlet customerRegister;
	ServletRandom servletRandom;
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/register", method = RequestMethod.POST) public
	 */
}
