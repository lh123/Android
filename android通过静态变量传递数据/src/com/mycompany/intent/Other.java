package com.mycompany.intent;
import android.app.*;
import android.os.*;
import android.widget.*;

public class Other extends Activity
{
	private TextView textview;
	public static String name;
	public static int age;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);
		textview=(TextView)this.findViewById(R.id.otherTextView);
		textview.setText("name:"+name+"\n"+"age:"+age);
	}
}

