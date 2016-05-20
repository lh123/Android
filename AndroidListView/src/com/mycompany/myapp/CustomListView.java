package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.graphics.drawable.*;

public class CustomListView extends Activity
{
	ListView listview;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_listview);
		listview = (ListView) this.findViewById(R.id.custom_listviewListView);
		listview.setAdapter(new CustomAdapter(this));
	}
}
