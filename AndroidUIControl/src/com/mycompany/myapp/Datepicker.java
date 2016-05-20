package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;

public class Datepicker extends Activity
{
	private Button btnSelectTime;
	private int year=1995,month=0,day=1;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.datepicker_view);
		btnSelectTime=(Button) findViewById(R.id.btnSelectTime);
		btnSelectTime.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					new DatePickerDialog(Datepicker.this, new DatePickerDialog.OnDateSetListener(){

							@Override
							public void onDateSet(DatePicker p1, int p2, int p3, int p4)
							{
								year=p2;
								month=p3;
								day=p4;
								btnSelectTime.setText(String.format("%d-%d-%d",year,month+1,day));
							}
						}, year, month, day).show();
				}
			});
	}
}
