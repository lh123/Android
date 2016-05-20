package com.mycompany.myapp;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import android.content.*;

public class AtyBroadCast extends Activity implements OnClickListener
{
	private Button btnRegBRC,btnUnRegBRC,btnSendBRC;
	private MyBroadCast broadCast;
	private EditText editMessage;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.broadcast_view);
		btnRegBRC = (Button) findViewById(R.id.btnRegBRC);
		btnUnRegBRC = (Button) findViewById(R.id.btnUnRegBRC);
		btnSendBRC = (Button) findViewById(R.id.btnSendBRC);
		editMessage=(EditText) findViewById(R.id.editMessage);
		btnRegBRC.setOnClickListener(this);
		btnUnRegBRC.setOnClickListener(this);
		btnSendBRC.setOnClickListener(this);
		broadCast = new MyBroadCast();
		if(MyBroadCast.isReg==false)
		{
			btnRegBRC.setClickable(true);
			btnUnRegBRC.setClickable(false);
		}
	}

	@Override
	public void onClick(View p1)
	{
		switch (p1.getId())
		{
			case R.id.btnRegBRC:
				regBRC();
				break;
			case R.id.btnUnRegBRC:
				unRegBRC();
				break;
			case R.id.btnSendBRC:
				Intent intent=new Intent();
				intent.putExtra("message",editMessage.getText().toString());
				intent.setAction(MyBroadCast.ACTION);
				sendBroadcast(intent);
				break;
		}
	}

	@Override
	protected void onDestroy()
	{
		// TODO: Implement this method
		super.onDestroy();
		unRegBRC();
	}
	public void regBRC()
	{
		if(MyBroadCast.isReg==false)
		{
		IntentFilter i=new IntentFilter();
		i.addAction(MyBroadCast.ACTION);
		registerReceiver(broadCast,i);
		broadCast.isReg=true;
		btnRegBRC.setClickable(false);
		btnUnRegBRC.setClickable(true);
		}
	}
	public void unRegBRC()
	{
		if(MyBroadCast.isReg==true)
		{
			unregisterReceiver(broadCast);
			MyBroadCast.isReg=false;
			btnRegBRC.setClickable(true);
			btnUnRegBRC.setClickable(false);
		}
	}
	
}
