package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;

public class AtySeekBar extends Activity
{
	private SeekBar seekBar;
	private TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seekbar_view);
		seekBar=(SeekBar) findViewById(R.id.seekbar);
		text=(TextView) findViewById(R.id.seekbarviewTextView);
		seekBar.setMax(100);
		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

				@Override
				public void onProgressChanged(SeekBar p1, int p2, boolean p3)
				{
					text.setText(String.format("当前值:%d",p2)+"%");
				}

				@Override
				public void onStartTrackingTouch(SeekBar p1)
				{
					// TODO: Implement this method
				}

				@Override
				public void onStopTrackingTouch(SeekBar p1)
				{
					// TODO: Implement this method
				}
			});
	}
}
