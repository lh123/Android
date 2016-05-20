package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;

public class SecondActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
		Intent intent=getIntent();
		int a,b,result;
		TextView text=(TextView)findViewById(R.id.tv);
		try
		{
			a = Integer.parseInt(intent.getStringExtra("edita"));
			b = Integer.parseInt(intent.getStringExtra("editb"));
			result = a + b;
			text.setText(result + "");
		}
		catch (NumberFormatException e)
		{
			text.setText("必须填入数字");
		}
    }
}
