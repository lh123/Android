package com.mycompany.myapp;

import android.view.*;
import android.widget.AdapterView.*;
import android.widget.*;
import android.content.*;

public class ClickListener implements OnItemClickListener
{
	private Context context;

	public ClickListener(Context context)
	{
		this.context = context;
	}

	public void setContext(Context context)
	{
		this.context = context;
	}

	public Context getContext()
	{
		return context;
	}
	@Override
	public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
	{
		// TODO: Implement this method
		ListViewData date=(ListViewData) p1.getItemAtPosition(p3);
		Toast.makeText(context,String.format("icoid:%s  name:%s   detail:%s",date.getIconId(),date.getName(),date.getDetail()),Toast.LENGTH_SHORT).show();
	}
}
