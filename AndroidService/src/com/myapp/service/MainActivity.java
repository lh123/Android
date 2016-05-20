package com.myapp.service;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.View.*;
import android.widget.*;
import android.view.*;
import android.view.ContextMenu.*;

public class MainActivity extends Activity implements ServiceConnection// implements OnClickListener
{
	public static Context myService;
	@Override
	public void onServiceConnected(ComponentName p1, IBinder p2)
	{
		System.out.println("Connected");
		myService=((MyServiceBinder)p2).getService();
		buttonGetCurrentNumber.setEnabled(true);
		//buttonGetCurrentNumber.setOnClickListener(new Click(MainActivity.this,myService));
	}

	@Override
	public void onServiceDisconnected(ComponentName p1)
	{
	}

	private Click click;
	private Button buttonStartService,buttonStopService,buttonBindService,buttonUnbindService,buttonGetCurrentNumber;
	private Intent serviceIntent;
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		buttonStartService=(Button) findViewById(R.id.buttonStartService);
		buttonStopService=(Button) findViewById(R.id.buttonStopService);
		buttonUnbindService=(Button) findViewById(R.id.buttonUnbindService);
		buttonBindService=(Button) findViewById(R.id.buttonBindService);
		buttonGetCurrentNumber=(Button) findViewById(R.id.buttonGetCurrentNumber);
		click=new Click(this);
		buttonStartService.setOnClickListener(click);
		buttonStopService.setOnClickListener(click);
		buttonUnbindService.setOnClickListener(click);
		buttonBindService.setOnClickListener(click);
		buttonGetCurrentNumber.setOnClickListener(click);
		buttonGetCurrentNumber.setEnabled(false);
	}
	
	@Override
	protected void onDestroy()
	{
		unbindService(this);
		super.onDestroy();
	}
	
}
