package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.SearchView.*;
import android.content.*;

public class MainActivity extends Activity
{
	private MyBroadcast myBroadcast;
    private Button buttonSendBroadcast,buttonRegBRC,buttonUnregBRC;
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		myBroadcast=new MyBroadcast();
		buttonRegBRC=(Button) findViewById(R.id.buttonRegBRC);
		buttonUnregBRC=(Button) findViewById(R.id.buttonUnregBRC);
		buttonSendBroadcast=(Button) findViewById(R.id.btnSendBroadcast);
		buttonSendBroadcast.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
//					Intent intent=new Intent(MainActivity.this,MyBroadcast.class);
					Intent intent=new Intent(MyBroadcast.ACTION);
					intent.putExtra("data","hello world");
					sendBroadcast(intent);
				}
			});
		buttonRegBRC.setOnClickListener(new OnClickListener(){
				
				@Override
				public void onClick(View p1)
				{
					registerReceiver(myBroadcast,new IntentFilter(MyBroadcast.ACTION));
				}
			});
			
		buttonUnregBRC.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					unregisterReceiver(myBroadcast);
				}
			});
    }
}
