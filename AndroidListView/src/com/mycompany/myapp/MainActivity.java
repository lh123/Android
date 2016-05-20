package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;

public class MainActivity extends Activity
{
	private ListView listview;
	private ArrayAdapter<ListDate> adapter;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		listview=(ListView) this.findViewById(R.id.mainListView);
		adapter=new ArrayAdapter<ListDate>(this,R.layout.listview);
		listview.setAdapter(adapter);
		adapter.add(new ListDate("nn",14,"n"));
		adapter.add(new ListDate("mm",18,"m"));
		listview.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
				{
					// TODO: Implement this method
					ListDate listdate=adapter.getItem(p3);
					Toast.makeText(MainActivity.this,String.format("名字:%s 性别:%s 年龄:%d",listdate.getName(),listdate.getSex(),listdate.getAge()),Toast.LENGTH_SHORT).show();
				}
			});
    }
}
