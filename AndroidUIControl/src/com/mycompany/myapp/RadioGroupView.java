package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.widget.ExpandableListView.*;
import android.view.*;

public class RadioGroupView extends Activity
{
	private RadioButton radiobtnRight;
	private Button btnRight;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.radio_group_view);
		radiobtnRight=(RadioButton) findViewById(R.id.radioButtonRight);
		btnRight=(Button) findViewById(R.id.radiobtnSubmit);
		btnRight.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					if(radiobtnRight.isChecked())
					{
						new AlertDialog.Builder(RadioGroupView.this).setTitle("提示").setMessage("判断正确").setPositiveButton("确定",null).show();
					}
					else
					{
						new AlertDialog.Builder(RadioGroupView.this).setTitle("提示").setMessage("判断错误").setPositiveButton("确定",null).show();
					}
				}
			});
	}
}
