package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.content.*;
import java.util.*;
import android.view.*;

public class AtyService extends Service
{
	public static boolean isRun=false;
	private PendingIntent p;
	private Message message;
	private NotificationManager nm;
	private Notification.Builder n;
	private MHindler mHander;
	private class MHindler extends Handler
	{

		@Override
		public void handleMessage(Message msg)
		{
			// TODO: Implement this method
			super.handleMessage(msg);
			int p=msg.obj;
			onprogress.Text(p);
		}
		
	}
	
//	private Handler mHander=new Handler(){
//
//		@Override
//		public void handleMessage(Message msg)
//		{
//			// TODO: Implement this method
//			super.handleMessage(msg);
//			int p=msg.obj;
//			onprogress.Text(p);
//		}
//		
//	};
	
	public interface onProgressListener
	{
		public void Progress(int progress);
		public void Text(int p);
	}
	private onProgressListener onprogress;
	public void setOnProgressListener(onProgressListener progressListener)
	{
		this.onprogress=progressListener;
	}
	private Timer timer=null;
	private TimerTask task=null;
	private int progress=0;
	private MyServiceBinder myServiceBinder=new MyServiceBinder(this);
	public class MyServiceBinder extends Binder
	{
		private AtyService service;

		public MyServiceBinder(AtyService service)
		{
			this.service = service;
		}

		public AtyService getService()
		{
			return service;
		}
	}
	@Override
	public IBinder onBind(Intent p1)
	{
		// TODO: Implement this method
		System.out.println("bind");
		if(progress==100)
		{
			onprogress.Progress(progress);
		}
		return myServiceBinder;
	}
	public void StartTimer()
	{
		System.out.println("startTimer");
		if(timer==null)
		{
			timer=new Timer();
			task = new TimerTask(){

				@Override
				public void run()
				{
					progress++;
					n.setProgress(100,progress,false);
					nm.notify(R.layout.service_view,n.build());
					if(progress>99)
					{
					
						StopTimer();
					}
					onprogress.Progress(progress);
					message=new Message();
					message.obj=progress;
					mHander.sendMessage(message);
				}
			};
			timer.schedule(task,1000,100);
		}
	}

	public void StopTimer()
	{
		System.out.println("stopTimer");
		if(timer!=null)
		{
			timer.cancel();
			task.cancel();
			timer=null;
			task=null;
		}
	}

	@Override
	public void onCreate()
	{
		// TODO: Implement this method
		super.onCreate();
		StartTimer();
		System.out.println("onCreat");
		mHander=new AtyService.MHindler();
		nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		n=new Notification.Builder(this).setContentTitle("正在处理");
		p=PendingIntent.getActivity(this,0,new Intent(this,AtyServiceMyService.class),PendingIntent.FLAG_UPDATE_CURRENT);
		n.setContentIntent(p);
		n.setSmallIcon(R.drawable.ic_launcher);
		n.setWhen(System.currentTimeMillis());
	}

	@Override
	public void onDestroy()
	{
		// TODO: Implement this method
		super.onDestroy();
		StopTimer();
		System.out.println("onDestory");
		isRun=false;
	}

	@Override
	public void onStart(Intent intent, int startId)
	{
		// TODO: Implement this method
		super.onStart(intent, startId);
		System.out.println("onStart");
		isRun=true;
	}

	@Override
	public boolean onUnbind(Intent intent)
	{
		// TODO: Implement this method
		System.out.println("unbind");
		return super.onUnbind(intent);
	}
	
	public int getCurrentProgress()
	{
		return progress;
	}
}
