package com.datangedu.cn.Service.CustomerRegister;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.datangedu.cn.Random.ServletRandom;
import com.datangedu.cn.Random.ServletRandomIMPL;
import com.datangedu.cn.dao.mapper.CustomersMapper;
import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.customers.CustomersExample;
@Service
public class CustomerRegisterServeltIMPL implements CustomerRegisterServlet {
	@Resource
	CustomersMapper customersMapper;
	ServletRandom servletRandom;

	
	@Override
	public int customerRegister(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.getAttribute("vimg");
		String vimg = (String)session.getAttribute("code");
		String code = request.getParameter("code");
		System.out.println(code);
		System.out.println(vimg);
		System.out.println(code.equals(vimg));
		String id = customeId();
		//System.out.println(id);
		if(request.getParameter("phone").length()==0)
		{return 20; }//未填写电话
		else if (request.getParameter("password").length()==0)
		{return 30;}//未填写密码
		else if(request.getParameter("code").length()==0)
		{return 10;}//未输入验证码
		else if(request.getParameter("provice")=="-1")
		{return 41;}//未输入省
		else if(request.getParameter("city")=="-1")
		{return 42;}//未输入市
		else if(request.getParameter("area")=="-1")
		{return 43;}//未输入区县
		else {
			if(code.equals(vimg) == true)
			{
				if(request.getParameter("password").length()<6)
				{return 31;}//密码小于6位
				else if(request.getParameter("password").length()>20)
				{return 32;}//密码大于20位
				else if(request.getParameter("phone").length()!=11)
				{return 21;}//电话非11位
				else if(findphone(request) == false)
				{return 22;}//电话号已注册
				else//信息正确非空
				{
					Customers customers  = new Customers();
					customers.setCustPhone(request.getParameter("phone"));
					customers.setCustPassword(request.getParameter("password"));
					customers.setCustRegion(request.getParameter("area"));
					customers.setCustId(id);
					return customersMapper.insert(customers);
				}
			}
			else 
			{
				return 11;//验证码错误
			}
		}
		
		
	}
	
	
	public String customeId() {
		CustomersExample customersExample = new CustomersExample();
		CustomersExample.Criteria  criteria =  customersExample.createCriteria();
		boolean i = true;
		do
		{
			ServletRandomIMPL sRandom = new ServletRandomIMPL();
			String id = sRandom.getRandomCode(11);
			criteria.andCustIdEqualTo(id);
			Long findid = customersMapper.countByExample(customersExample);
			System.out.println("customeId-findid"+findid);
			if(findid == 0)
			{
				i=false;
				return id.toString();
			}
			else
			{
				i=true;
			}
		}while(i==false);
		return "false";
	}
	public boolean findphone(HttpServletRequest request)
	{
		CustomersExample customersExample = new CustomersExample();
		CustomersExample.Criteria  criteria =  customersExample.createCriteria();
		criteria.andCustPhoneEqualTo(request.getParameter("phone"));
		Long status = customersMapper.countByExample(customersExample);
		System.out.println("findphoone-status"+status);
		if(status == 0)
		{
			return true;
		}
		else 
		{
		return false;
		}
	}
}
