package com.mycompany.myapp2;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity
{
	ListView lv;
	String[] str=new String[] {"1","2","3","4"};
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		lv=(ListView)findViewById(R.id.list);
		ArrayAdapter<String> aa=new ArrayAdapter<String>(
			this,android.R.layout.simple_list_item_1,str
		);
		lv.setAdapter(aa);
    }
}
