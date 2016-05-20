package com.lh.lightsensor;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.hardware.*;
import android.content.*;

public class MainActivity extends Activity 
{
	private TextView textView;
	private SensorManager manager;
	private MyListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		textView=(TextView) findViewById(R.id.mainTextView);
		manager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
		Sensor sensor = manager.getDefaultSensor(Sensor.TYPE_LIGHT);
		listener=new MyListener();
		manager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
	private class MyListener implements SensorEventListener
	{

		@Override
		public void onSensorChanged(SensorEvent event)
		{
			textView.setText(Float.toString(event.values[0]));
		}

		@Override
		public void onAccuracyChanged(Sensor sensor, int p2)
		{
			
		}
	}

	@Override
	protected void onDestroy()
	{
		manager.unregisterListener(listener);
		super.onDestroy();
	}
	
}
