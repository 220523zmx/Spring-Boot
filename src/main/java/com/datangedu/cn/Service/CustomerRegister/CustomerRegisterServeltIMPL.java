package com.datangedu.cn.Service.CustomerRegister;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;


import com.datangedu.cn.dao.mapper.CustomersMapper;
import com.datangedu.cn.model.customers.Customers;
@Service
public class CustomerRegisterServeltIMPL implements CustomerRegisterServlet {
	@Resource
	CustomersMapper customersMapper;
	
	@Override
	public int customerRegister(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.getAttribute("vimg");
		String vimg = (String)session.getAttribute("code");
		String code = request.getParameter("code");
		
		System.out.println(code);
		System.out.println(vimg);
		System.out.println(code.equals(vimg));
		
		if(request.getParameter("phone").length()==0)
		{return 20; }//未填写电话
		else if (request.getParameter("password").length()==0)
		{return 30;}//未填写密码
		else if(request.getParameter("code").length()==0)
		{return 10;}//未输入验证码
		else if(request.getParameter("provice")=="-1")
		{
			return 41;
		}
		else if(request.getParameter("city")=="-1")
		{
			return 42;
		}
		else if(request.getParameter("area")=="-1")
		{
			return 43;
		}
		else {
			if(code.equals(vimg) == true)
			{
				if(request.getParameter("password").length()<6)
				{
					return 31;//密码小于6位
				}
				else if(request.getParameter("password").length()>20)
				{
					return 32;//密码大于20位
				}
				else if(request.getParameter("phone").length()!=11)
				{
					return 21;//电话非11位
				}
				else//信息正确非空
				{
					Customers customers  = new Customers();
					customers.setCustPhone(request.getParameter("phone"));
					customers.setCustPassword(request.getParameter("password"));
					customers.setCustRegion(request.getParameter("area"));
					return customersMapper.insert(customers);
				}
			}
			else 
			{
				return 11;//验证码错误
			}
		}
		
		
	}
	
 
}
