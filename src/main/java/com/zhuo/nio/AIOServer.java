package com.zhuo.nio;

import java.io.IOException;
import java.nio.channels.AsynchronousServerSocketChannel;

public class AIOServer {

	private int port =8080;
	public AIOServer(int port) {
		this.port =port;
	}
	
	public void listen() {
		try {
			AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new AIOServer(8080).listen();
	}
}
