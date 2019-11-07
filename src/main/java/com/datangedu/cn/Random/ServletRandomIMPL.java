package com.datangedu.cn.Random;

import java.util.Random;

public class ServletRandomIMPL implements ServletRandom {

	/*
	 * public static void main(String[] args) {
	 * System.out.println(getRandomCode(11,9)); }
	 */
	public static String getRandomCode(int length)	
	{
		String str = "1234567890abcdefghijklmnopqrstuywxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuffer sb =new StringBuffer();
		for(int i=0;i<length;i++)
		{
			int number = random.nextInt(62);
			sb.append(str.charAt(number));		
		}
		System.out.println("函数生成的id"+sb.toString());
		return sb.toString();
	}
	
}
