package com.zhuo.controller;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhuo.annoation.NotThreadSafe;

@NotThreadSafe
public class ConcurrencyTest {

	private static Logger logger = LoggerFactory.getLogger(ConcurrencyTest.class);
	//请求总数
	public static int clientTotal =5000;
	//同时并发执行的线程数
	private static int threadTotal = 200;
	
	private static int count = 0 ;
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(threadTotal);
		final CountDownLatch countDownLacth = new CountDownLatch(clientTotal);
		for(int i=0 ; i<clientTotal ;i++) {
			executorService.execute(()->{
				try {
					semaphore.acquire();
					add();
					semaphore.release();
				} catch (InterruptedException e) {
					logger.error("InterruptedException+:::::",e);
				}
				countDownLacth.countDown();
				
			});
			
		}
		countDownLacth.await();
		executorService.shutdown();
		logger.info("count:{}",count);
	}
	
	private static void add() {
		count++;
	}
}
