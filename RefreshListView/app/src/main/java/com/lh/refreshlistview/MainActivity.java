package com.lh.refreshlistview;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import java.util.*;
import com.lh.refreshlistview.MainActivity.*;

public class MainActivity extends Activity 
{
	private RefreshListView listView;
	private ArrayList<String> listData;
	private MainActivity.MyAdapter myAdapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		listView=(RefreshListView) findViewById(R.id.mainRefreshListView);
		initListData();
		listView.setOnRefreshListener(new RefreshListView.onRefreshListener(){

				@Override
				public void onRefresh()
				{
					listView.postDelayed(new Runnable(){

							@Override
							public void run()
							{
								listData.add(0,"我是新数据 哈哈😄");
								listView.refreshComplete();
							}
						}, 2000);
				}
			});
    }

	private void initListData()
	{
		listData=new ArrayList<String>();
		for(int i=0;i<25;i++)
		{
			listData.add("测试数据"+i);
		}
		myAdapter = new MyAdapter();
		listView.setAdapter(myAdapter);
	}
	
	
	private class MyAdapter extends BaseAdapter
	{
		@Override
		public int getCount()
		{
			return listData.size();
		}

		@Override
		public String getItem(int p1)
		{
			return listData.get(p1);
		}

		@Override
		public long getItemId(int p1)
		{
			return p1;
		}

		@Override
		public View getView(int index, View convertView, ViewGroup p3)
		{
			TextView view=null;
			if(convertView==null)
			{
				view=new TextView(MainActivity.this);
			}
			else
			{
				view=(TextView) convertView;
			}
			view.setTextSize(25);
			view.setText(getItem(index));
			return view;
		}
		
	}
}
