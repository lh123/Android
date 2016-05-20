package com.lh.remoteservice;

import android.app.*;
import android.os.*;
import android.content.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		Intent i=new Intent();
		i.setClassName("com.lh.remoteservice","com.lh.service.RemoteService");
		//i.addCategory(Intent.CATEGORY_DEFAULT);
		bindService(i,new MyConn(),BIND_AUTO_CREATE);
    }
	
	private class MyConn implements ServiceConnection
	{

		@Override
		public void onServiceConnected(ComponentName p1, IBinder p2)
		{
			// TODO: Implement this method
		}

		@Override
		public void onServiceDisconnected(ComponentName p1)
		{
			// TODO: Implement this method
		}
	}
}
