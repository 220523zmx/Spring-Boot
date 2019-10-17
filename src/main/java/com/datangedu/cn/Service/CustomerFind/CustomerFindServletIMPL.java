package com.datangedu.cn.Service.CustomerFind;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.datangedu.cn.MD5.MD5;
import com.datangedu.cn.dao.mapper.CustomersMapper;
import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.customers.CustomersExample;
@Service
public class CustomerFindServletIMPL implements CustomerFindServlet {
	@Resource
	CustomersMapper customersMapper;

	@Override
	public int customerFind(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MD5 md5 = new MD5();
		HttpSession session = request.getSession();
		session.getAttribute("vimg");
		String vimg = (String) session.getAttribute("code");
		String code = request.getParameter("code");
		System.out.println("输入验证码" + code);
		System.out.println("图片验证码" + vimg);
		System.out.println("验证码是否：" + code.equals(vimg));
		if (request.getParameter("phone").length() == 0) {
			return 20;
		} // 未填写电话
		else if (request.getParameter("newpassword").length() == 0||request.getParameter("againpassword").length() == 0) {
			return 30;
		} // 未填写密码并再次确认
		else if (request.getParameter("code").length() == 0) {
			return 10;
		} // 未输入验证码
		else {
			if (code.equals(vimg) == true) {
				if (request.getParameter("newpassword").length() < 6) {
					return 31;
				} // 密码小于6位
				else if (request.getParameter("newpassword").length() > 20) {
					return 32;
				} // 密码大于20位
				else if (request.getParameter("phone").length() != 11) {
					return 21;
				} // 电话非11位
				else// 信息正确非空
				{
					if (findphone(request) == true) {
						if(request.getParameter("newpassword").equals(request.getParameter("againpassword")))
						{
							Customers customers = new Customers();
							customers.setCustPassword(request.getParameter("newpassword"));
							CustomersExample customersExample = new CustomersExample();
							CustomersExample.Criteria criteria  = customersExample.createCriteria();
							criteria.andCustPhoneEqualTo(request.getParameter("phone"));
							return customersMapper.updateByExampleSelective(customers, customersExample);
							}
						else
						{
							return 35;//两次输入的密码不同
						}
					} 
					else
					{
						return 23;//改该用户不存在
					}
				}
			} else {
				return 11;// 验证码错误
			}
			
		}
		}
	public boolean findphone(HttpServletRequest request) {
		CustomersExample customersExample = new CustomersExample();
		CustomersExample.Criteria criteria = customersExample.createCriteria();
		criteria.andCustPhoneEqualTo(request.getParameter("phone"));
		Long status = customersMapper.countByExample(customersExample);
		System.out.println("findphoone-status" + status);
		if (status != 0) {
			return true;
		} else {
			return false;
		}
	}
}

