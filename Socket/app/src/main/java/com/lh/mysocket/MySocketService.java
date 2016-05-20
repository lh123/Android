package com.lh.mysocket;
import java.net.*;
import java.io.*;
import java.util.*;

public class MySocketService extends Thread
{
	public static ArrayList<Socket> socketArray;
	private MySocketService(){};
	private static final MySocketService mySocketService=new MySocketService();
	public static MySocketService getService()
	{
		socketArray=new ArrayList<Socket>();
		return mySocketService;
	}

	public void startService()
	{
		if(this.isAlive())
			return;
		this.start();
	}
	@Override
	public void run()
	{
		try
		{
			ServerSocket serverSocket=new ServerSocket(8089);
			System.out.println("服务启动");
			while(true)
			{
				System.out.println("正在等待连接");
				Socket socket=serverSocket.accept();
				System.out.println("有客户端连接");
				socketArray.add(socket);
				new SocketThread(socket);
			}
		}
		catch (IOException e)
		{}
	}
	
}
