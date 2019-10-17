package com.datangedu.cn.Service.CustomerLogin;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.datangedu.cn.MD5.MD5;
import com.datangedu.cn.Service.ServiceRegister.ServiceRegisterServlet;
import com.datangedu.cn.dao.mapper.CustomersMapper;
import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.customers.CustomersExample;
import com.datangedu.cn.model.serviceprovider.Serviceprovider;
import com.datangedu.cn.model.serviceprovider.ServiceproviderExample;

@Service
public class CustomerLoginServletIMPL implements CustomerLoginServlet {

	@Resource
	CustomersMapper customersMapper;

	public int customerLogin(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
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
		else if (request.getParameter("password").length() == 0) {
			return 30;
		} // 未填写密码
		else if (request.getParameter("code").length() == 0) {
			return 10;
		} // 未输入验证码
		else {
			if (code.equals(vimg) == true) {
				if (request.getParameter("password").length() < 6) {
					return 31;
				} // 密码小于6位
				else if (request.getParameter("password").length() > 20) {
					return 32;
				} // 密码大于20位
				else if (request.getParameter("phone").length() != 11) {
					return 21;
				} // 电话非11位
				else if (findphone(request).equals("phonefalse")) {
					return 23;
				} // 电话号未注册
				else// 信息正确非空
				{
					if (findphone(request).equals(request.getParameter("phone")) == false) {
						return 24;// 电话号不匹配
					} else if (findpassword(request)
							.equals(md5.EncoderByMd5(request.getParameter("password"))) == false) {
						return 33;// 密码不匹配
					} else {
						if (upstatus(request) == true) {
							return 51;
						} else {
							return 52;
						}
					}

				}
			} else {
				return 11;// 验证码错误
			}

		}
	}

	public String findphone(HttpServletRequest request) {
		CustomersExample customersExample = new CustomersExample();
		CustomersExample.Criteria Criteria = customersExample.createCriteria();
		Criteria.andCustPhoneEqualTo(request.getParameter("phone"));
		List<Customers> List = customersMapper.selectByExample(customersExample);
		System.out.println("findphoone-status" + List);
		int status = List.size();
		if(status==0)
		{
			return "phonefalse";
		}
		String phone = List.get(0).getCustPhone();
		if (phone == null) {
			return "phonefalse";
		} else {
			return phone;
		}
	}

	public String findpassword(HttpServletRequest request) {
		CustomersExample customersExample = new CustomersExample();
		CustomersExample.Criteria Criteria = customersExample.createCriteria();
		Criteria.andCustPhoneEqualTo(request.getParameter("phone"));
		List<Customers> List = customersMapper.selectByExample(customersExample);
		System.out.println("findphoone-status" + List);
		String password = List.get(0).getCustPassword();
		if (password.equals("")) {
			return "passwordfalse";
		} else {
			return password;
		}
	}

	public boolean upstatus(HttpServletRequest request) {
		Customers customers = new Customers();
		customers.setCustState(1);
		CustomersExample customersExample = new CustomersExample();
		CustomersExample.Criteria Criteria = customersExample.createCriteria();
		Criteria.andCustPhoneEqualTo(request.getParameter("phone"));
		int status = customersMapper.updateByExampleSelective(customers, customersExample);
		if (status == 1) {
			return true;
		} else {
			return false;
		}

	}

}
