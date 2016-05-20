package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;

public class AtySpinner extends Activity
{
	private Spinner spinner;
	private TextView text;
	private ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinner_view);
		adapter=new ArrayAdapter<String>(AtySpinner.this,android.R.layout.simple_list_item_1);
		spinner=(Spinner) findViewById(R.id.spinner);
		text=(TextView) findViewById(R.id.spinnerText);
		spinner.setAdapter(adapter);
		adapter.add("test item1");
		adapter.add("test item2");
		adapter.add("test item3");
		spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
				{
					ArrayAdapter<String> date=(ArrayAdapter<String>) p1.getAdapter();
					text.setText(String.format("你选择了\n序号:%d\n内容:%s",p3,date.getItem(p3)));
				}

				@Override
				public void onNothingSelected(AdapterView<?> p1)
				{
					// TODO: Implement this method
				}
			});
	}
}
