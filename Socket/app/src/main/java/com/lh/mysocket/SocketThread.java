package com.lh.mysocket;
import java.net.*;
import java.io.*;
import java.util.*;

public class SocketThread extends Thread
{
	private Socket socket;
	private BufferedReader br;
	private OutputStream os;
	public SocketThread(Socket socket) throws IOException
	{
		this.socket=socket;
		br=new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
		os=socket.getOutputStream();
		os.write("欢迎进入聊天室\n".getBytes());
		os.flush();
		this.start();
	}

	@Override
	public void run()
	{
		String content;
		while(true)
		{
			try
			{
				content= br.readLine();
				if(content==null)
				{
					os.close();
					MySocketService.socketArray.remove(socket);
					for(int i=0;i<MySocketService.socketArray.size();i++)
					{
						OutputStream os= MySocketService.socketArray.get(i).getOutputStream();
						os.write("有人离开聊天室\n".getBytes("utf-8"));
						os.flush();
					}
					break;
				}
				for(int i=0;i<MySocketService.socketArray.size();i++)
				{
					OutputStream os= MySocketService.socketArray.get(i).getOutputStream();
					if(MySocketService.socketArray.get(i).equals(this.socket))
					{
						os.write(("自己说："+content+"\n").getBytes("utf-8"));
					}
					else
					{
						os.write(("别人说："+content+"\n").getBytes("utf-8"));
					}
					os.flush();
				}
			}
			catch (IOException e)
			{
				MySocketService.socketArray.remove(this.socket);
			}
		}
	}
	
}
