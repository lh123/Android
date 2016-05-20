package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;

public class AtyGallery extends Activity
{

	private Gallery gallery;
	private ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallery_view);
		gallery=(Gallery) findViewById(R.id.gallery);
		adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
		for(int i=0;i<20;i++)
		{
			adapter.add("item"+i);
		}
		gallery.setAdapter(adapter);
		gallery.setOnItemClickListener(new Gallery.OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
				{
					// TODO: Implement this method
					Toast.makeText(AtyGallery.this,(String)p1.getAdapter().getItem(p3),Toast.LENGTH_SHORT).show();
				}
			});
	}
}
