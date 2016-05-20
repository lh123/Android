package com.mycompany.myapp;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.View.*;
import android.widget.*;
import android.view.*;

public class AtyServiceMyService extends Activity implements ServiceConnection,OnClickListener
{

	@Override
	public void onClick(View p1)
	{
		switch (p1.getId())
		{
			case R.id.btnStartService:
				startService(intent);
				bindService(intent, AtyServiceMyService.this, BIND_AUTO_CREATE);break;
			case R.id.btnStopService:
				if (myService != null)
				{
					unbindService(AtyServiceMyService.this);

				}
				stopService(intent);
				myService = null;
				textGetCurrent.setText("服务已停止");
				break;
			case R.id.btnProgress:
				if (myService == null)
				{
					textGetCurrent.setText("服务未启动");
				}
				else
				{
					textGetCurrent.setText(percentFormat(myService.getCurrentProgress()));
				}break;
		}
	}


	@Override
	public void onServiceConnected(ComponentName p1, IBinder p2)
	{
		System.out.println("onConnect");
		myService = ((AtyService.MyServiceBinder)p2).getService();
		if (myService != null)
		{
			textGetCurrent.setText("服务已经启动");
		}

		if(myService.getCurrentProgress()==100)
		{
			progressBar.setProgress(100);
			textView.setText(percentFormat(100));
		}
		myService.setOnProgressListener(new AtyService.onProgressListener(){

				@Override
				public void Text(int p)
				{
					if (p == 100)
					{
						Toast.makeText(AtyServiceMyService.this,"已完成",Toast.LENGTH_SHORT).show();
					}
					textView.setText(percentFormat(p));
				}


				@Override
				public void Progress(int progress)
				{
					progressBar.setProgress(progress);
				}
			});
	}

	public String percentFormat(int p)
	{
		return p + "%";
	}
	@Override
	public void onServiceDisconnected(ComponentName p1)
	{
		// TODO: Implement this method
	}

	private Button btnStart,btnStop,btnProgress;
	private ProgressBar progressBar;
	private TextView textView,textGetCurrent;
	private Intent intent=new Intent();
	private AtyService myService=null;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service_view);
		btnStart = (Button) findViewById(R.id.btnStartService);
		btnStop = (Button) findViewById(R.id.btnStopService);
		btnProgress = (Button) findViewById(R.id.btnProgress);
		progressBar = (ProgressBar) findViewById(R.id.serviceProgressBar);
		textGetCurrent = (TextView) findViewById(R.id.textViewGetCurrent);
		textView = (TextView) findViewById(R.id.serviceviewTextView);
		btnStart.setOnClickListener(this);
		btnStop.setOnClickListener(this);
		btnProgress.setOnClickListener(this);
		intent.setClass(this, AtyService.class);
		if(AtyService.isRun==true)
		{
			bindService(intent, AtyServiceMyService.this, BIND_AUTO_CREATE);
		}

	}

	@Override
	protected void onDestroy()
	{
		// TODO: Implement this method
		super.onDestroy();
		if (myService != null)
			unbindService(this);
	}

}
