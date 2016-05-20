package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// TODO: Implement this method
		menu.add(1,1,1,"关于");
		menu.add(2,2,2,"退出");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// TODO: Implement this method
		if(item.getItemId()==1)
		{
			Toast.makeText(MainActivity.this,"lh123",Toast.LENGTH_SHORT).show();
		}
		else if(item.getItemId()==2)
		{
			finish();
			android.os.Process.killProcess(android.os.Process.myPid());
		}
		return false;
	}
}
