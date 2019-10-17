package com.datangedu.cn.Service.CustomerLogin;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

public interface CustomerLoginServlet {
	public int customerLogin(HttpServletRequest request)
			throws NoSuchAlgorithmException, UnsupportedEncodingException ;
}
