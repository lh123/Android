package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;
import android.content.*;

public class MainActivity extends Activity
{
	Button btn=null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		btn=(Button)findViewById(R.id.btn);
		btn.setOnClickListener(new ClickListener());
    }
	private class ClickListener implements OnClickListener
	{

		@Override
		public void onClick(View p1)
		{
			// TODO: Implement this method
			Intent intent=new Intent();
			intent.setClass(MainActivity.this,SecondActivity.class);
			startActivity(intent);
			MainActivity.this.finish();
		}
	}
}
