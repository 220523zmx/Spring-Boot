package com.datangedu.cn.Service.ServiceLogin;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

public interface ServiceLoginServlet {
	public int serviceLogin(HttpServletRequest request)
	throws NoSuchAlgorithmException, UnsupportedEncodingException ;
	public String findphone(HttpServletRequest request);
	public String findpassword(HttpServletRequest request);
	public boolean upstatus(HttpServletRequest request);
	public String findid(HttpServletRequest request);

}
