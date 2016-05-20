package com.mycompany.myapp;

import android.content.*;
import android.widget.*;

public class MyBroadcast extends BroadcastReceiver
{
	public static final String ACTION="com.mycompany.myapp.intent.action.MyBC";
	@Override
	public void onReceive(Context p1, Intent p2)
	{
		System.out.println("onReceive"+"  date:"+p2.getStringExtra("data"));
		Toast.makeText(p1,"onReceive"+"  date:"+p2.getStringExtra("data"),Toast.LENGTH_SHORT).show();
	}

}
