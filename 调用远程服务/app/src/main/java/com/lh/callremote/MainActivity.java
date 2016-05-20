package com.lh.callremote;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import com.lh.service.*;

public class MainActivity extends Activity 
{
	private Iservice is;
	private MyConn myConn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
	
	public void bind(View v)
	{
		Intent i=new Intent();
		i.setClassName("com.lh.remoteservice","com.lh.service.RemoteService");
		myConn=new MyConn();
		startService(i);
		bindService(i,myConn,BIND_AUTO_CREATE);
	}
	
	public void call(View v) throws RemoteException
	{
		if(is!=null)
			is.showMessage();
	}
	private class MyConn implements ServiceConnection
	{

		@Override
		public void onServiceConnected(ComponentName p1, IBinder p2)
		{
			is= Iservice.Stub.asInterface(p2);
		}

		@Override
		public void onServiceDisconnected(ComponentName p1)
		{
			// TODO: Implement this method
		}
		
		
	}
}
