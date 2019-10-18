package com.datangedu.cn.Service.ServiceLogin;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.datangedu.cn.MD5.MD5;
import com.datangedu.cn.dao.mapper.CustomersMapper;
import com.datangedu.cn.dao.mapper.ServiceproviderMapper;
import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.customers.CustomersExample;
import com.datangedu.cn.model.serviceprovider.Serviceprovider;
import com.datangedu.cn.model.serviceprovider.ServiceproviderExample;

@Service
public class ServiceLoginServletIMPL implements ServiceLoginServlet {
	@Resource
	ServiceproviderMapper serviceproviderMapper;

	public String findid(HttpServletRequest request)
	{
		ServiceproviderExample serviceproviderExample = new ServiceproviderExample();
		ServiceproviderExample.Criteria Criteria = serviceproviderExample.createCriteria();
		Criteria.andServProviderPhoneEqualTo(request.getParameter("phone"));
		List<Serviceprovider> List = serviceproviderMapper.selectByExample(serviceproviderExample);
		System.out.println("findid-status" + List);
		int status = List.size();
		if (status == 0) {
			return "idfalse";
		}
		String id= List.get(0).getServProviderId();
		if (id == null) {
			return "idfalse";
		} else {
			return id;
		}
		
	}
	public String findphone(HttpServletRequest request) {
		ServiceproviderExample serviceproviderExample = new ServiceproviderExample();
		ServiceproviderExample.Criteria Criteria = serviceproviderExample.createCriteria();
		Criteria.andServProviderPhoneEqualTo(request.getParameter("phone"));
		List<Serviceprovider> List = serviceproviderMapper.selectByExample(serviceproviderExample);
		System.out.println("findphoone-status" + List);
		int status = List.size();
		if (status == 0) {
			return "phonefalse";
		}
		String phone = List.get(0).getServProviderPhone();
		if (phone == null) {
			return "phonefalse";
		} else {
			return phone;
		}
	}

	public String findpassword(HttpServletRequest request) {
		ServiceproviderExample serviceproviderExample = new ServiceproviderExample();
		ServiceproviderExample.Criteria Criteria = serviceproviderExample.createCriteria();
		Criteria.andServProviderPhoneEqualTo(request.getParameter("phone"));
		List<Serviceprovider> List = serviceproviderMapper.selectByExample(serviceproviderExample);
		System.out.println("findphoone-status" + List);
		String password = List.get(0).getServProviderPassword();
		if (password.equals("")) {
			return "passwordfalse";
		} else {
			return password;
		}
	}

	public boolean upstatus(HttpServletRequest request) {
		Serviceprovider serviceprovider = new Serviceprovider();
		serviceprovider.setServProviderState(1);
		ServiceproviderExample serviceproviderExample = new ServiceproviderExample();
		ServiceproviderExample.Criteria Criteria = serviceproviderExample.createCriteria();
		Criteria.andServProviderPhoneEqualTo(request.getParameter("phone"));
		int status = serviceproviderMapper.updateByExampleSelective(serviceprovider, serviceproviderExample);
		if (status == 1) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public int serviceLogin(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		return 0;
	}

}
