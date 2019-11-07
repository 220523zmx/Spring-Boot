package com.datangedu.cn.Random;

import java.util.Random;

<<<<<<< HEAD
public class ServletRandomIMPL implements ServletRandom {

	/*
	 * public static void main(String[] args) {
	 * System.out.println(getRandomCode(11,9)); }
	 */
=======
import org.springframework.stereotype.Service;
@Service
public class ServletRandomIMPL implements ServletRandom {

	
	/*
	 * public static void main(String[] args) {
	 * System.out.println(getRandomNum(11)); }
	 */
	 
>>>>>>> ae91f5c60013d33b5451853a0b57e38e3e7bc4d6
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
<<<<<<< HEAD
=======
	public static String getRandomNo(int length)	
	{
		String str = "1234567890";
		Random random = new Random();
		StringBuffer sb =new StringBuffer();
		for(int i=0;i<length;i++)
		{
			int number = random.nextInt(9);
			sb.append(str.charAt(number));		
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
>>>>>>> ae91f5c60013d33b5451853a0b57e38e3e7bc4d6
	
}
