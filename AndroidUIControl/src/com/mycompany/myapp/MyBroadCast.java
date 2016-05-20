package com.mycompany.myapp;
import android.content.*;
import android.widget.*;

public class MyBroadCast extends BroadcastReceiver
{

	public static boolean isReg=false;
	public static final String ACTION="MyBroadCast";
	@Override
	public void onReceive(Context p1, Intent p2)
	{
		Toast.makeText(p1,p2.getStringExtra("message"),Toast.LENGTH_SHORT).show();
	}
	
}
