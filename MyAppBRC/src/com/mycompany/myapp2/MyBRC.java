package com.mycompany.myapp2;

import android.content.*;

public class MyBRC extends BroadcastReceiver
{
	public static final String ACTION="com.mycompany.myapp2.intent.action";
	@Override
	public void onReceive(Context p1, Intent p2)
	{
		System.out.println("onReceive");
	}
}
