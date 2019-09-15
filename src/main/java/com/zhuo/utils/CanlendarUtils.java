package com.zhuo.utils;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class CanlendarUtils {

	Calendar calendar = Calendar.getInstance();
	
	@Test
	public void testCanlen() {
		
		
		// 获取年
		int year = calendar.get(Calendar.YEAR);
        // 获取月，这里需要需要月份的范围为0~11，因此获取月份的时候需要+1才是当前月份值
		int month = calendar.get(Calendar.MONTH) + 1;
		// 获取日
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		// 获取时
		int hour = calendar.get(Calendar.HOUR);
		// int hour = calendar.get(Calendar.HOUR_OF_DAY); // 24小时表示
		// 获取分
		int minute = calendar.get(Calendar.MINUTE);
		// 获取秒
		int second = calendar.get(Calendar.SECOND);
		// 星期，英语国家星期从星期日开始计算
		int weekday = calendar.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("现在是：" + year + "年" + month + "月" + day + "日" + hour
		                + "时" + minute + "分" + second + "秒" + "星期" + weekday);
		
		
		
	}
	
	 // 一年后的今天
	@Test
	public void test2() {
		// 同理换成下个月的今天calendar.add(Calendar.MONTH, 1);
		 calendar.add(Calendar.YEAR, 1);
		// 获取年
		int year = calendar.get(Calendar.YEAR);
		// 获取月
		int month = calendar.get(Calendar.MONTH) + 1;
		// 获取日
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("一年后的今天：" + year + "年" + month + "月" + day + "日");
	}
	
	// 设置日期
	@Test
	public void test4() {
		calendar.set(Calendar.YEAR, 2000);
	      System.out.println("现在是" + calendar.get(Calendar.YEAR) + "年");
	       calendar.set(2008, 8, 8);
	       // 获取年
	       int year = calendar.get(Calendar.YEAR);
	       // 获取月
	        int month = calendar.get(Calendar.MONTH);
	        // 获取日
	       int day = calendar.get(Calendar.DAY_OF_MONTH);
	       System.out.println("现在是" + year + "年" + month + "月" + day + "日");
	}
	
	/**
	 * 获取当年的第一天
	 * @param year
	 * @return
	 */
	@Test
	public Date getCurrYearFirst(){
		Calendar currCal=Calendar.getInstance();  
		int currentYear = currCal.get(Calendar.YEAR);
		
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, currentYear);
		Date currYearFirst = calendar.getTime();
		return currYearFirst;
		
	}
	
	/**
	 * 获取某年第一天日期
	 * @param year 年份
	 * @return Date
	 */
	public static Date getYearFirst(int year){
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		Date currYearFirst = calendar.getTime();
		return currYearFirst;
	}

}