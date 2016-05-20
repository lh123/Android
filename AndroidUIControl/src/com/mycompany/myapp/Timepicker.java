package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Timepicker extends Activity
{
	private Button btnSelectTimer;
	private int hour=0,minute=0;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timepicker_view);
		btnSelectTimer = (Button) findViewById(R.id.btnSelectTimer);
		btnSelectTimer.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					new TimePickerDialog(Timepicker.this, new TimePickerDialog.OnTimeSetListener(){

							@Override
							public void onTimeSet(TimePicker p1, int p2, int p3)
							{
								// TODO: Implement this method
								hour=p2;
								minute=p3;
								btnSelectTimer.setText(String.format("%s:%s",TimeFormat(p2),TimeFormat(p3)));
							}
						}

						, hour, minute, true).show();
				}
			});
	}
	private String TimeFormat(int value)
	{
		if (value >= 10)
			return "" + value;
		else
			return "0" + value;
	}
}
