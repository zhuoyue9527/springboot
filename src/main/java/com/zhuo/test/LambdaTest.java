package com.zhuo.test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LambdaTest {
	
	static Logger logger = LoggerFactory.getLogger(LambdaTest.class);
	
	public static void main(String[] args) {
		String[] atp = {"Rafael Nadal", "Novak Djokovic",  
		       "Stanislas Wawrinka",  
		       "David Ferrer","Roger Federer",  
		       "Andy Murray","Tomas Berdych",  
		       "Juan Martin Del Potro"};  
		List<String> players =  Arrays.asList(atp);  
		  
		// 以前的循环方式  
		logger.info("以前的循环方式=--- ");
		for (String player : players) {  
		     System.out.print(player + "; ");  
		}  
		  
		// 使用 lambda 表达式以及函数操作(functional operation) 
		logger.info("lambda------ ");
		players.forEach((player) -> System.out.print(player + "; "));  
		players.forEach((player) -> System.out.println(player));
		// 在 Java 8 中使用双冒号操作符(double colon operator) 
		logger.info("双冒号操作符 ");
		players.forEach(System.out::println);
	}
	
	@Test
	public void testString() {
		String ss = String.format("获取字典%s", "aa");
		System.out.println(ss);
	}
	
	@Test
	public void testSub() {
		String s = "你好txt_s00_dmfm15" ;
		System.out.println(s.toUpperCase());
	}
	
	
}
