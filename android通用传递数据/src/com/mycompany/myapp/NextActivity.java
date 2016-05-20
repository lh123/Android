package com.mycompany.myapp;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.content.*;

public class NextActivity extends Activity
{
	TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.next);
		text=(TextView)this.findViewById(R.id.nextTextView);
		Intent intent=getIntent();
		int age=intent.getIntExtra("age",1);
		String name=intent.getStringExtra("name");
		String address=intent.getStringExtra("address");
		text.setText("name----->"+name+"\n"+"age-------->"+age+"\n"+"address->"+address);
	}
}
