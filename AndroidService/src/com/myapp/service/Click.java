package com.myapp.service;

import android.app.*;
import android.view.View.*;
import android.view.*;
import android.content.*;
import android.widget.*;
import android.util.*;

public class Click implements OnClickListener
{
	private Context context;
	//private Context serviceContext;
	private Intent serviceIntent;

	public Click(Context context)
	{
		this.context = context;
	}

//	public Click(Context context, Context serviceContext)
//	{
//		this.context = context;
//		this.serviceContext = serviceContext;
//	}

	@Override
	public void onClick(View p1)
	{
		serviceIntent=new Intent(context,MyService.class);
		switch(p1.getId())
		{
			case R.id.buttonStartService:
				context.startService(serviceIntent);		
				break;
			case R.id.buttonStopService:
				context.stopService(serviceIntent);
				break;
			case R.id.buttonBindService:
				context.bindService(serviceIntent,(ServiceConnection)context,Context.BIND_AUTO_CREATE);
				break;
			case R.id.buttonUnbindService:
				context.unbindService((ServiceConnection)context);
				break;
			case R.id.buttonGetCurrentNumber:
				if(MainActivity.myService!=null)
				{
				System.out.println("当前的数字"+((MyService)MainActivity.myService).getCurrent());
				}
				else
				{
					System.out.println("null");
				}
				break;
		}
	}
	
	
}
