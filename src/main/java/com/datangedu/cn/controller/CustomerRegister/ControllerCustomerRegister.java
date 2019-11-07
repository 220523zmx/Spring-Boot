package com.datangedu.cn.controller.CustomerRegister;

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

import com.datangedu.cn.Service.CustomerRegister.CustomerRegisterServlet;

@Controller
@RequestMapping("/customer")
public class ControllerCustomerRegister {
	@Resource
	CustomerRegisterServlet customerRegister;

	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Map<String, Object> register(HttpServletRequest request)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<String, Object>();
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
		return map;
	}
}
