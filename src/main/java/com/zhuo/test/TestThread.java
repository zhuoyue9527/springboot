package com.zhuo.test;

public class TestThread {

	public static void main(String[] args) {
		MyThread thread1 = new MyThread("线程1");
		MyThread thread2 = new MyThread("线程2");
		MyThread thread3 = new MyThread("线程3");
		MyThread thread4 = new MyThread("线程4");
		thread1.run();
		thread2.run();
		thread3.run();
		thread4.run();
		
	}
}
