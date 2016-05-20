package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;

public class MainActivity extends Activity implements OnClickListener
{
	ProgressBar bar1,bar2;
	Button button;
	int i=0;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		bar1=(ProgressBar)findViewById(R.id.bar1);
		bar2=(ProgressBar)findViewById(R.id.bar2);
		button=(Button)findViewById(R.id.button);
		button.setOnClickListener(this);
    }
	public void onClick(View v)
	{
		i=i+10;
		bar2.setProgress(i);
		if(i==bar2.getMax())
		{
			bar1.setVisibility(5);
		}
	}
}
