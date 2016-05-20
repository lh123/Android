package com.mycompany.myapp2;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.content.*;
import java.io.*;
import android.util.*;

public class NextActivity extends Activity
{
	private byte bytedata[];
	private SendBroadcast myBRC;
	private ObjectInputStream object;
	private ByteArrayInputStream bytearray;
	private TextView textview;
	private int tag;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.next);
		textview = (TextView) findViewById(R.id.nextActivityTextView);
		Intent intent=getIntent();
		tag = intent.getIntExtra("tag", 0);
		String datastring=intent.getStringExtra("data");
		bytedata = Base64.decode(datastring, Base64.DEFAULT);
		bytearray = new ByteArrayInputStream(bytedata);
		myBRC=new SendBroadcast();
		try
		{
			object = new ObjectInputStream(bytearray);
			Mydata data=(Mydata) object.readObject();
			if (tag == 1)
			{
				textview.setText(data.toString() + " from Intent");
			}
			else if (tag == 2)
			{
				System.out.println("tag=2");
				textview.setText(data.toString() + " from Broadcast");
			}
		}
		catch (Exception e)
		{}
	}	
}
