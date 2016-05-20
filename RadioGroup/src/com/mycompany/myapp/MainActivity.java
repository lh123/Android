package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.RadioGroup.*;

public class MainActivity extends Activity
{
	RadioGroup rg;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		rg=(RadioGroup)findViewById(R.id.mainRadioGroup);
		rg.setOnCheckedChangeListener(new Listener());
    }
	class Listener implements OnCheckedChangeListener
	{

		@Override
		public void onCheckedChanged(RadioGroup p1, int p2)
		{
			// TODO: Implement this method
			String str=null;
			if(p2==R.id.mainRadioButton1)
				str="你选择了剪刀";
			else if(p2==R.id.mainRadioButton2)
				str="你选择了石头";
			else
				str="你选择了布";
			Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
		}

		
	}
}
