package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity 
{
	private CustomView v;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		v=(CustomView) findViewById(R.id.customView);
		v.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					System.out.println("点击");
				}
			});
    }
}
