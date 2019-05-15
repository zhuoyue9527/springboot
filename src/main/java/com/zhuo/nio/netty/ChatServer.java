//package com.zhuo.nio.netty;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelOption;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import io.netty.handler.codec.http.HttpServerCodec;
//
//public class ChatServer {
//
//	private int port = 80;
//	
//	public void start() {
//		//boss线程
//		EventLoopGroup bossGroup = new NioEventLoopGroup();
//		//worker线程
//		EventLoopGroup workerGroup = new NioEventLoopGroup();
//	
//		try {
//			//启动引擎
//			ServerBootstrap b  = new ServerBootstrap();
//			b.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
//			.option(ChannelOption.SO_BACKLOG, 1024)
//			.childHandler(new ChannelInitializer<SocketChannel>() {
//
//				@Override
//				protected void initChannel(SocketChannel ch) throws Exception {
//					//所有自定义的业务从这开始
//					
//					/* 解码和编码都能做*/
//					ch.pipeline().addLast(new HttpServerCodec());
//					
//					//拦截http协议的
//					ch.pipeline().addLast(new HttpHandle());
//				}
//			});
//			//等待客户连接
//			ChannelFuture f = b.bind(this.port).sync();
//			System.out.println("服务已经启动，舰艇端口"+ this.port);
//			f.channel().closeFuture().sync();
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally {
//			bossGroup.shutdownGracefully();
//			workerGroup.shutdownGracefully();
//		}
//	
//	}
//	
//	public static void main(String[] args) {
//		start();
//	}
//}
