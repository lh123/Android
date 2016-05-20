package com.lh.sensor;

import android.app.*;
import android.os.*;
import android.content.*;
import android.hardware.*;
import java.util.*;
import android.widget.*;

public class MainActivity extends Activity 
{
	private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		textView=(TextView) findViewById(R.id.mainTextView);
		SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		List<Sensor> list= sensorManager.getSensorList(Sensor.TYPE_ALL);
		for(Sensor s:list)
		{
			textView.append("Name:"+s.getName()+"  Vendor:"+s.getVendor()+"  Power:"+s.getPower()+"mA\n");
			//System.out.println();
		}
		
    }
}
