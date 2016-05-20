package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.widget.AdapterView.*;
import android.view.*;

public class MainActivity extends Activity implements OnItemClickListener
{
    private ListView listView;
	private ArrayAdapter arrayAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		listView=(ListView) findViewById(R.id.mainListView);
		arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1);
		for(int i=0;i<100;i++)
		{
			arrayAdapter.add(String.format("item %d",i));
		}
		listView.setAdapter(arrayAdapter);
		listView.setOnItemClickListener(this);
    }

	@Override
	public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
	{
		ArrayAdapter a=(ArrayAdapter) p1.getAdapter();
		String data=(String) p1.getItemAtPosition(p3);
		System.out.println(data);
	}
}
