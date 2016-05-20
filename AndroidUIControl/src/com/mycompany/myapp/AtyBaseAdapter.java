package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class AtyBaseAdapter extends Activity implements OnClickListener
{

	@Override
	public void onClick(View p1)
	{
		switch(p1.getId())
		{
			case R.id.mainButtonAdd:
				adapter.add("item "+adapter.getCount());
				break;
			case R.id.mainButtonRemove:
				adapter.removeLast();
				break;
		}
	}

	private Button btnAdd,btnRemove;
	private ListView list;
    private MyBaseAdapter<String> adapter;
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);

        setContentView(R.layout.baseadapter_view);
		list=(ListView) findViewById(R.id.mainListView);
		btnAdd=(Button) findViewById(R.id.mainButtonAdd);
		btnRemove=(Button) findViewById(R.id.mainButtonRemove);
		btnAdd.setOnClickListener(this);
		btnRemove.setOnClickListener(this);
		adapter = new MyBaseAdapter<String>(this,android.R.layout.simple_list_item_1){

			@Override
			protected void initAdapter(int p1, View p2, ViewGroup p3)
			{
				((TextView)p2).setText(getItem(p1));
			}
		};
		for(int i=0;i<10;i++)
		{
			adapter.add("item "+i);
		}
		list.setAdapter(adapter);
    }
}
