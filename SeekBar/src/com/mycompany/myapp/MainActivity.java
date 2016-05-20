package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.SeekBar.*;

public class MainActivity extends Activity
{
	TextView tv;
	SeekBar sb;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		tv=(TextView)findViewById(R.id.tv);
		sb=(SeekBar)findViewById(R.id.sb);
		sb.setMax(200);
		sb.setOnSeekBarChangeListener(new Listener());
    }
	class Listener implements OnSeekBarChangeListener
	{

		@Override
		public void onProgressChanged(SeekBar p1, int p2, boolean p3)
		{
			// TODO: Implement this method
			tv.setText("拖动的值为："+p2);
			sb.setSecondaryProgress(p1.getProgress()+40);
			tv.setText(tv.getText()+"进度条的第二进度为："+(p2+40));
		}

		@Override
		public void onStartTrackingTouch(SeekBar p1)
		{
			// TODO: Implement this method
			tv.setText("用户开始拖动");
		}

		@Override
		public void onStopTrackingTouch(SeekBar p1)
		{
			// TODO: Implement this method
			tv.setText(tv.getText()+"用户停止拖动");
		}

		
	}
}
