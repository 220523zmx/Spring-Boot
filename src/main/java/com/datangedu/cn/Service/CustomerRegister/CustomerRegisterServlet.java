package com.datangedu.cn.Service.CustomerRegister;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;


public interface CustomerRegisterServlet {

	public int customerRegister(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException ;
	public String customerId();
	
}
