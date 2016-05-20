package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;
import android.content.*;

public class MainActivity extends Activity
{
	private Button button;
	private Myapp myapp;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		button=(Button)this.findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					myapp=(Myapp)getApplication();
					myapp.setName("jack");
					Intent intent=new Intent(MainActivity.this,Other.class);
					startActivity(intent);
				}
		});
    }
}
