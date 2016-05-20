package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;

public class MainActivity extends Activity 
{
	private ListView listview;
	private ListBaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		adapter=new ListBaseAdapter(this);
		listview=(ListView) this.findViewById(R.id.mainListView);
		
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new ClickListener(this));
    }

	public static long current;
	@Override
	public void onBackPressed()
	{
		// TODO: Implement this method
		//super.onBackPressed();
		if(System.currentTimeMillis()-current>2000)
		{
			current=System.currentTimeMillis();
			Toast.makeText(this,"再按一次退出",Toast.LENGTH_SHORT).show();
		}
		else
		{
			finish();
		}
	}
	
}
