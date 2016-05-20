package com.lh.service;
import android.app.*;
import android.content.*;
import android.os.*;

public class RemoteService extends Service
{
	@Override
	public IBinder onBind(Intent p1)
	{
		System.out.println("onBind");
		return new MyBinder();
	}

	@Override
	public void onCreate()
	{
		System.out.println("onCreat"+android.os.Process.myPid());
		super.onCreate();
	}
	
	private class MyBinder extends Iservice.Stub
	{
		@Override
		public void showMessage() throws RemoteException
		{
			System.out.println("我是远程服务");
		}
	}
}
