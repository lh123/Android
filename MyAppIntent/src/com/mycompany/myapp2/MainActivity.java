package com.mycompany.myapp2;

import android.app.*;
import android.os.*;
import android.view.View.*;
import android.widget.*;
import android.view.*;
import android.renderscript.*;
import java.io.*;
import android.util.*;
import android.content.*;

public class MainActivity extends Activity implements OnClickListener
{
	private Button button,buttonBRC,buttonReg,buttonUnreg;
	private Mydata data;
	private String datastring = null;
	private Intent intent;
	private SendBroadcast myBRC;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		button = (Button) findViewById(R.id.mainButton);
		buttonBRC = (Button) findViewById(R.id.mainButton1);
		buttonReg=(Button) findViewById(R.id.regBRC);
		buttonUnreg=(Button) findViewById(R.id.unregBRC);
		myBRC=new SendBroadcast();
		button.setTag("intent");
		buttonBRC.setTag("BRC");
		buttonReg.setTag("Reg");
		buttonUnreg.setTag("Unreg");
		data = new Mydata("lh123", "detail");
		button.setOnClickListener(this);
		buttonReg.setOnClickListener(this);
		buttonBRC.setOnClickListener(this);
		buttonUnreg.setOnClickListener(this);
		
		try
		{
			ByteArrayOutputStream bytearray=new ByteArrayOutputStream();
			ObjectOutputStream object=new ObjectOutputStream(bytearray);
			object.writeObject(data);
			datastring = Base64.encodeToString(bytearray.toByteArray(), Base64.DEFAULT);
		}
		catch (Exception e)
		{
		}
		intent=new Intent(MainActivity.this, NextActivity.class);

    }

	@Override
	public void onClick(View p1)
	{
		System.out.println("error");
		System.out.println(datastring);
		if (p1.getTag() == "intent")
		{
			intent.putExtra("data", datastring);
			intent.putExtra("tag",1);
			System.out.println(datastring);
			startActivity(intent);
		}
		else if(p1.getTag()=="BRC")
		{
			System.out.println("Brc");
			Intent intentBRC=new Intent(SendBroadcast.ACTION);
			intentBRC.putExtra("data",datastring);
			sendBroadcast(intentBRC);
		}
		else if(p1.getTag()=="Reg")
		{
			System.out.println("reg");
			registerReceiver(myBRC,new IntentFilter(SendBroadcast.ACTION));
		}
		else if(p1.getTag()=="Unreg")
		{
			unregisterReceiver(myBRC);
		}
	}

}
