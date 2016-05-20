package com.myapp.service;

import android.app.*;
import android.content.*;
import android.os.*;
import android.util.*;
import java.util.*;

public class MyService extends Service
{
	private Timer timer=null;
	private Task task=null;
	
	public void startTimer()
	{
		if(timer==null)
		{
			timer=new Timer();
			task=new Task();
			timer.schedule(task,1000,1000);
		}
	}
	
	public void stopTimer()
	{
		if(timer!=null)
		{
			task.cancel();
			timer.cancel();
			timer=null;
			task=null;
		}
	}
	
	public int getCurrent()
	{
		return task.getI();
	}
	
	@Override
	public IBinder onBind(Intent p1)
	{
		System.out.println("Binder");
		return myServiceBinder;
	}

	private MyServiceBinder myServiceBinder=new MyServiceBinder(MyService.this);
	@Override
	public void onCreate()
	{
		Log.i("Service","onCreate");
		super.onCreate();
		startTimer();
	}
	
	@Override
	public void onDestroy()
	{
		Log.i("Service","onDestory");
		super.onDestroy();
		stopTimer();
	}
	
}
