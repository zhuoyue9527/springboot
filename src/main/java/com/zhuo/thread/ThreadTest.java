package com.zhuo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ThreadTest {

//	public static void main(String[] args) throws InterruptedException {
//		// 创建一个固定大小的线程池
//		ExecutorService service = Executors.newFixedThreadPool(3);
//		for (int i = 0; i < 10; i++) {
//			System.out.println("创建线程" + i);
//
//			Runnable run = new Runnable() {
//				public void run() {
//					System.out.println("启动线程" + System.currentTimeMillis());
//				}
//			};
//			// 在未来某个时间执行给定的命令
//			service.execute(run);
//		}
//		// 关闭启动线程
//		service.shutdown();
//		// 等待子线程结束，再继续执行下面的代码
//		service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
//		System.out.println("all thread complete");
//	}

	@Test
	public void fun1() {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				Thread.sleep(index * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			cachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println(index);
				}
			});
		}
	}

	@Test
	public void fun2() {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					try {
						System.out.println(index);
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

//	public static void main(String[] args) {
//		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//		for (int i = 0; i < 10; i++) {
//			final int index = i;
//			fixedThreadPool.execute(new Runnable() {
//				public void run() {
//					try {
//						System.out.println(index);
//						Thread.sleep(10000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			});
//		}
//	}

//	public static void main(String[] args) {
//		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
//		scheduledThreadPool.schedule(new Runnable() {
//			public void run() {
//				System.out.println("delay 3 seconds");
//			}
//		}, 3, TimeUnit.SECONDS);
//	}

//	public static void main(String[] args) {
//		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
//		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
//			public void run() {
//				System.out.println("delay 1 seconds, and excute every 3 seconds");
//			}
//		}, 1, 3, TimeUnit.SECONDS);
//	}

	public static void main(String[] args) {
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			singleThreadExecutor.execute(new Runnable() {
				public void run() {
					try {
						System.out.println(index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	}
}
