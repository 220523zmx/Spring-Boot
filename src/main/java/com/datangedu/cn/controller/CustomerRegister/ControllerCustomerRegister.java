package com.datangedu.cn.controller.CustomerRegister;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
<<<<<<< HEAD
=======
import javax.servlet.http.HttpSession;
>>>>>>> ae91f5c60013d33b5451853a0b57e38e3e7bc4d6

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

<<<<<<< HEAD
=======
import com.datangedu.cn.MD5.MD5;
import com.datangedu.cn.Random.ServletRandom;
>>>>>>> ae91f5c60013d33b5451853a0b57e38e3e7bc4d6
import com.datangedu.cn.Service.CustomerRegister.CustomerRegisterServlet;

@Controller
@RequestMapping("/customer")
public class ControllerCustomerRegister {
	@Resource
	CustomerRegisterServlet customerRegister;
<<<<<<< HEAD
=======
	ServletRandom servletRandom;
>>>>>>> ae91f5c60013d33b5451853a0b57e38e3e7bc4d6

	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Map<String, Object> register(HttpServletRequest request)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<String, Object>();
<<<<<<< HEAD
		int state = customerRegister.customerRegister(request);
		switch (state) {
		case 10:
			map.put("state", "请输入验证码");
			break;
		case 11:
			map.put("state", "验证码错误");
			break;
		case 20:
			map.put("state", "请输入11位的移动端电话号码~");
			break;
		case 21:
			map.put("state", "请输入11位的移动端电话号码~");
			break;
		case 22:
			map.put("state", "该电话号已注册~");
			break;
		case 30:
			map.put("state", "请输入6-20位不包含中文字符的密码~");
			break;
		case 31:
			map.put("state", "密码长度小于6位，请输入6-20位不包含中文字符的密码~");
			break;
		case 32:
			map.put("state", "密码长度大于20位，请输入6-20位不包含中文字符的密码~");
			break;
		case 41:
			map.put("state", "请选择正确地址~");
			break;
		case 42:
			map.put("state", "请选择正确地址~");
			break;
		case 43:
			map.put("state", "请选择正确地址~");
			break;
		case 1:
			map.put("state", "注册成功");
			break;
		default:
			map.put("state", "注册失败");
			break;
		}
=======
		
		HttpSession session = request.getSession();
		session.getAttribute("vimg");
		String vimg = (String) session.getAttribute("code");
		String code = request.getParameter("code");
		System.out.println("输入验证码" + code);
		System.out.println("图片验证码" + vimg);
		System.out.println("验证码是否：" + code.equals(vimg));
		
		if (request.getParameter("phone").length() == 0) {
			map.put("state","请输入11位的移动端电话号码~");
		} // 未填写电话
		else if (request.getParameter("password").length() == 0) {
			map.put("state", "请输入6-20位不包含中文字符的密码~");
		} // 未填写密码
		else if (request.getParameter("code").length() == 0) {
			map.put("state","请输入验证码");
		} // 未输入验证码
		else if (request.getParameter("provice") == "-1") {
			map.put("state","请选择正确地址~");
		} // 未输入省
		else if (request.getParameter("city") == "-1") {
			map.put("state","请选择正确地址~");
		} // 未输入市
		else if (request.getParameter("area") == "-1") {
			map.put("state","请选择正确地址~");
		} // 未输入区县
		else {
			if (code.equals(vimg) == true) {
				if (request.getParameter("password").length() < 6) {
					map.put("state","密码长度小于6位，请输入6-20位不包含中文字符的密码~");
				} // 密码小于6位
				else if (request.getParameter("password").length() > 20) {
					map.put("state","密码长度大于20位，请输入6-20位不包含中文字符的密码~");
				} // 密码大于20位
				else if (request.getParameter("phone").length() != 11) {
					map.put("state","请输入11位的移动端电话号码~");
				} // 电话非11位
				else if (customerRegister.findphone(request) == false) {
					map.put("state","该电话号已注册~");
				} // 电话号已注册
				else// 信息正确非空
				{
					int status = customerRegister.customerInsert(request);
					if(status ==1)
					{
						map.put("state","注册成功~");
					}
					else
					{
						map.put("state","注册失败~");
					}	
				}
			} else {
				map.put("state","验证码错误");// 验证码错误
			}
				}
>>>>>>> ae91f5c60013d33b5451853a0b57e38e3e7bc4d6
		return map;
	}
}
