package com.datangedu.cn.controller.CustomerFind;

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

import com.datangedu.cn.Service.CustomerFind.CustomerFindServlet;

@Controller
@RequestMapping("/customer")
public class ControllerCustomerFind {
	@Resource
	CustomerFindServlet customerFind;
	@ResponseBody
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public Map<String, Object> register(HttpServletRequest request)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<String, Object>();
		int state = customerFind.customerFind(request);
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
			map.put("state", "该用户未注册~");
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
		case 35:
			map.put("state", "两次输入的密码不同~");
			break;
		case 1:
			map.put("state", "更改密码成功，请登录·");
			break;
		default:
			map.put("state", "更改密码成功");
			break;
		}
		return map;
		}
}
