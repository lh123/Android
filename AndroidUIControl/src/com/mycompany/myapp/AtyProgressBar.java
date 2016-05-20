package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import java.util.*;

public class AtyProgressBar extends Activity
{
	private ProgressBar pb;
	private TextView text;
	private int progress=0;
	private Timer timer=null;
	private TimerTask task=null;
	private Handler mHander=new Handler(){

		@Override
		public void handleMessage(Message msg)
		{
			// TODO: Implement this method
			super.handleMessage(msg);
			text.setText(String.format("%d",msg.obj));
		}
		
	};
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progressbar_view);
		pb=(ProgressBar) findViewById(R.id.progressBar);
		text=(TextView) findViewById(R.id.progressbarText);
		
		pb.setMax(100);
		
	}

	private void StartTimer()
	{
		if(timer==null)
		{
			timer=new Timer();
			task = new TimerTask(){

				@Override
				public void run()
				{
					// TODO: Implement this method
					progress++;
					
					pb.setProgress(progress);
					Message m=new Message();
					m.obj=progress;
					mHander.sendMessage(m);
					if(progress>99)
					{
						StopTimer();
					}
				}
			};
			timer.schedule(task,1000,100);
		}
	}
	private void StopTimer()
	{
		if(timer!=null)
		{
			timer.cancel();
			task.cancel();
			timer=null;
			task=null;
			
		}
	}
	@Override
	protected void onResume()
	{
		// TODO: Implement this method
		super.onResume();
		StartTimer();
	}

	@Override
	protected void onPause()
	{
		// TODO: Implement this method
		super.onPause();
		StopTimer();
	}
	
}
