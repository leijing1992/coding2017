package com.coding.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
//		 Set<String> anchorWhiteList4Coupon = new HashSet<String>();
//		 //anchorWhiteList4Coupon.add("123");
//		 String[] array = {"123","456","345"};
//		 for (int i = 0; i < array.length; i++) {
//			if(!anchorWhiteList4Coupon.contains(array[i])){
//				System.out.println(array[i]);
//			}
//		}
		SimpleDateFormat format =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		String d1 = "2017-01-04 18:02:47";
		try {
			long date1 = format.parse(d1).getTime();
			System.out.println(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
