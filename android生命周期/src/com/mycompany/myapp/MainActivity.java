package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.util.*;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		Log.i("main","onCreat");
    }

	@Override
	protected void onResume()
	{
		// TODO: Implement this method
		super.onResume();
		Log.i("main","onResume");
	}

	@Override
	protected void onPause()
	{
		// TODO: Implement this method
		super.onPause();
		Log.i("main","onPause");
	}

	@Override
	protected void onRestart()
	{
		// TODO: Implement this method
		super.onRestart();
		Log.i("main","onRestart");
	}

	@Override
	protected void onStop()
	{
		// TODO: Implement this method
		super.onStop();
		Log.i("main","onStop");
	}

	@Override
	protected void onStart()
	{
		// TODO: Implement this method
		super.onStart();
		Log.i("main","onStart");
	}

	@Override
	protected void onDestroy()
	{
		// TODO: Implement this method
		super.onDestroy();
		Log.i("main","onDestroy");
	}
	
}
