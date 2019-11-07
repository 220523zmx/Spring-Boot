package com.datangedu.cn.Service.CustomerRegister;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;


public interface CustomerRegisterServlet {

<<<<<<< HEAD
	public int customerRegister(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException ;
	public String customerId();
=======
	public String customerId();
	public boolean findphone(HttpServletRequest request);
	int customerInsert(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException;
>>>>>>> ae91f5c60013d33b5451853a0b57e38e3e7bc4d6
	
}
