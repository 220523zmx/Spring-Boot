package com.datangedu.cn.Service.CustomerOrder;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.order.Allorder;

public interface CustomerOrderServelt {

	/* public String findPvLine(String ordeProvidername); */

	public List<String> findOrderNo(String cuid);

	public List<Allorder> findOrderByOrderNo(String orid);

	public int removeorderline(HttpServletRequest request);
}
