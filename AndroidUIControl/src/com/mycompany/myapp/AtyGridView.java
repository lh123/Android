package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;

public class AtyGridView extends Activity
{
	private GridView gridView;
	private ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridview_view);
		adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
		gridView=(GridView) findViewById(R.id.gridview);
		gridView.setAdapter(adapter);
		for(int i=0;i<60;i++)
		{
			adapter.add("test item "+i);
		}
		gridView.setOnItemClickListener(new GridView.OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
				{
					// TODO: Implement this method
					Toast.makeText(AtyGridView.this,(String)p1.getAdapter().getItem(p3),Toast.LENGTH_SHORT).show();
				}
			});
	}
	
}
