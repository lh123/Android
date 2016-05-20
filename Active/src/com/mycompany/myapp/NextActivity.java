package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class NextActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nextone);
		TextView text=(TextView)findViewById(R.id.name);
		text.setText("test");
		text.setTextSize(60);
	}
	
}
