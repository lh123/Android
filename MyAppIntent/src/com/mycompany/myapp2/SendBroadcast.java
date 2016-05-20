package com.mycompany.myapp2;

import android.content.*;

public class SendBroadcast extends BroadcastReceiver
{
	private Intent intent;
	public static String ACTION="com.mycompany.myapp2.intent.action.BRC";
	@Override
	public void onReceive(Context p1, Intent p2)
	{
		System.out.println("onReceive");
		intent=new Intent(p1,NextActivity.class);
		String data=p2.getStringExtra("data");
		intent.putExtra("data",data);
		intent.putExtra("tag",2);
		p1.startActivity(intent);
		
	}
}
