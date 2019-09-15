package com.zhuo.test;

public class MyThread extends Thread{

	public String name ;
	
	public MyThread(String name) {
		this.name = name;
	}

	public void run() {
		for(int i=1 ;i<10000;i++) {
			 if(i%100 == 0 ) {
				 System.out.println(name+":"+i);
			 }
		 }
	}
	public static void main(String[] args) {
		new MyThread("99").start();
		new MyThread("888").start();
	}

}
