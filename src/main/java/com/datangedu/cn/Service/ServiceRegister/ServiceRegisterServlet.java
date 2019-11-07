package com.datangedu.cn.Service.ServiceRegister;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

public interface ServiceRegisterServlet {
	public int serviceRegister(HttpServletRequest request)
			throws NoSuchAlgorithmException, UnsupportedEncodingException ;
	public String serviceId();
<<<<<<< HEAD
=======
	public boolean findphone(HttpServletRequest request);
>>>>>>> ae91f5c60013d33b5451853a0b57e38e3e7bc4d6
}
