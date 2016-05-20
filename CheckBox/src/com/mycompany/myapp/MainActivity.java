package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.widget.CompoundButton.*;

public class MainActivity extends Activity
{
	CheckBox cb1,cb2,cb3;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		cb1=(CheckBox)findViewById(R.id.mainCheckBox1);
		cb2=(CheckBox)findViewById(R.id.mainCheckBox2);
		cb3=(CheckBox)findViewById(R.id.mainCheckBox3);
		cb3.setOnCheckedChangeListener(new Listener());
    }
	class Listener implements OnCheckedChangeListener
	{

		@Override
		public void onCheckedChanged(CompoundButton p1, boolean p2)
		{
			// TODO: Implement this method
			cb1.setChecked(p2);
			cb2.setChecked(p2);
		}

		
	}
}
