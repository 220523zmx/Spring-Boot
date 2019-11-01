package com.datangedu.cn.Service.CustomerEva;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.order.Allorder;

public interface CustomerEvaServlet {
	public List<Allorder> findhaseva(HttpServletRequest request);
	public List<Allorder> findnoteva(HttpServletRequest request);
	public String findserinstruction(Allorder allorder);
}
