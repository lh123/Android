package com.lh.socket;
import android.os.*;
import java.io.*;
import java.net.*;

public class SocketClient
{
	private Handler handler;
	private Socket socket;
	private BufferedReader br;
	private OutputStream os;
	private Thread thread=new Thread(new Runnable(){

			@Override
			public void run()
			{
				String content;
				try
				{
					while(true)
					{
						content=br.readLine();
						if(content==null)
							break;
						handler.sendMessage(handler.obtainMessage(1,content));
					}
					br.close();
					os.close();
				}
				catch (IOException e)
				{}
			}
		});

		
	public void initSocket(final String ip)
	{
		new Thread(new Runnable(){

				@Override
				public void run()
				{
					try
					{
						System.out.println(ip);
						socket = new Socket(ip, 8089);
						socket.setKeepAlive(true);
						br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						os=socket.getOutputStream();
						thread.start();
					}
					catch (IOException e)
					{}
				}
			}).start();
	}
	
	
	
	public void sendMessage(String message)
	{
		try
		{
			if(socket==null)
			{
				return;
			}
			os.write((message+"\n").getBytes("utf-8"));
			os.flush();
		}
		catch (IOException e)
		{}
	}
	public SocketClient(Handler handler)
	{
		this.handler = handler;
	}
}
