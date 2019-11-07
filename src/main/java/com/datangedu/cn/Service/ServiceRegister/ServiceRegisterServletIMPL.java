package com.datangedu.cn.Service.ServiceRegister;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.datangedu.cn.MD5.MD5;
import com.datangedu.cn.Random.ServletRandom;
import com.datangedu.cn.Random.ServletRandomIMPL;
import com.datangedu.cn.dao.mapper.CustomersMapper;
import com.datangedu.cn.dao.mapper.ServiceproviderMapper;
import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.customers.CustomersExample;
import com.datangedu.cn.model.serviceprovider.Serviceprovider;
import com.datangedu.cn.model.serviceprovider.ServiceproviderExample;
@Service
public class ServiceRegisterServletIMPL implements ServiceRegisterServlet {
	@Resource
	ServiceproviderMapper serviceproviderMapper;
	ServletRandom servletRandom;

	public int serviceRegister(HttpServletRequest request)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MD5 md5 = new MD5();
<<<<<<< HEAD
		HttpSession session = request.getSession();
		session.getAttribute("vimg");
		String vimg = (String) session.getAttribute("code");
		String code = request.getParameter("code");
		System.out.println("输入验证码" + code);
		System.out.println("图片验证码" + vimg);
		System.out.println("验证码是否：" + code.equals(vimg));
		String id = serviceId();
		System.out.println("服务商id：" + id);
		if (request.getParameter("phone").length() == 0) {
			return 20;
		} // 未填写电话
		else if (request.getParameter("password").length() == 0) {
			return 30;
		} // 未填写密码
		else if (request.getParameter("code").length() == 0) {
			return 10;
		} // 未输入验证码
		else if (request.getParameter("provice") == "-1") {
			return 41;
		} // 未输入省
		else if (request.getParameter("city") == "-1") {
			return 42;
		} // 未输入市
		else if (request.getParameter("area") == "-1") {
			return 43;
		} // 未输入区县
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
				else if (findphone(request) == false) {
					return 22;
				} // 电话号已注册
				else// 信息正确非空
				{
					Serviceprovider serviceprovider= new Serviceprovider();
					serviceprovider.setServProviderPhone(request.getParameter("phone"));
					serviceprovider.setServProviderPassword(md5.EncoderByMd5(request.getParameter("password")));
					serviceprovider.setServProviderRegion(request.getParameter("area"));
					serviceprovider.setServProviderId(id);
					return serviceproviderMapper.insert(serviceprovider);
				}
			} else {
				return 11;// 验证码错误
			}
		}
=======
		java.sql.Date now = new java.sql.Date(System.currentTimeMillis());
		String id = serviceId();
		System.out.println("服务商id：" + id);
		Serviceprovider serviceprovider= new Serviceprovider();
		serviceprovider.setServProviderPhone(request.getParameter("phone"));
		serviceprovider.setServProviderPassword(md5.EncoderByMd5(request.getParameter("password")));
		serviceprovider.setServProviderRegion(request.getParameter("area"));
		serviceprovider.setServProviderId(id);
		serviceprovider.setServProviderStarttime(now);
		return serviceproviderMapper.insert(serviceprovider);
>>>>>>> ae91f5c60013d33b5451853a0b57e38e3e7bc4d6
	}

	public String serviceId() {
		ServiceproviderExample serviceproviderExample = new ServiceproviderExample();
		ServiceproviderExample.Criteria criteria = serviceproviderExample.createCriteria();
		boolean i = true;
		do {
			ServletRandomIMPL sRandom = new ServletRandomIMPL();
			String id = sRandom.getRandomCode(11);
			criteria.andServProviderIdEqualTo(id);
			Long findid = serviceproviderMapper.countByExample(serviceproviderExample);
			System.out.println("customeId-findid" + findid);
			if (findid == 0) {
				i = false;
				return id.toString();
			} else {
				i = true;
			}
		} while (i == false);
		return "false";
	}

	public boolean findphone(HttpServletRequest request) {
		ServiceproviderExample serviceproviderExample = new ServiceproviderExample();
		ServiceproviderExample.Criteria criteria = serviceproviderExample.createCriteria();
		criteria.andServProviderPhoneEqualTo(request.getParameter("phone"));
		Long status = serviceproviderMapper.countByExample(serviceproviderExample);
		System.out.println("findphoone-status" + status);
		if (status == 0) {
			return true;
		} else {
			return false;
		}
	}
}
