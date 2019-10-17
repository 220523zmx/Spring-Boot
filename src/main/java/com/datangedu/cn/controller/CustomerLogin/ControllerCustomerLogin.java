package com.datangedu.cn.controller.CustomerLogin;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datangedu.cn.Service.CustomerLogin.CustomerLoginServlet;
import com.datangedu.cn.Service.CustomerRegister.CustomerRegisterServlet;

@Controller
@RequestMapping("/customer")
public class ControllerCustomerLogin {
	@Resource
	CustomerLoginServlet customerLogin;
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, Object> register(HttpServletRequest request)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
	
		Map<String, Object> map = new HashMap<String, Object>();
		int state = customerLogin.customerLogin(request);
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
		case 23:
			map.put("state", "该电话号未注册~");
			break;
		case 24:
			map.put("state", "账号或密码不正确~");
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
		case 33:
			map.put("state", "账号或密码不正确~");
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
		case 51:
			map.put("state", "登录成功");
			map.put("status",1);
			break;
		case 52:
			map.put("state", "服务忙，请过一段时间在登录");
			break;
		case 1:
			map.put("state", "注册成功");
			break;
		default:
			map.put("state", "注册失败");
			break;
		}
		return map;
	}

}
