package com.mycompany.myapp;
import android.app.*;
import android.os.*;
import android.widget.*;

public class Other extends Activity
{
	private Myapp myapp;
	private TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);
		text=(TextView)findViewById(R.id.text);
		myapp=(Myapp)getApplication();
		text.setText("---->"+myapp.getName());
	}
}
