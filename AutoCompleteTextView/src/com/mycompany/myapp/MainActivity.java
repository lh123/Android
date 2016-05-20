package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import android.text.*;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		AutoCompleteTextView actv=(AutoCompleteTextView)findViewById(R.id.actv);
		ArrayList<String> list=new ArrayList<String>();
		list.add("qq.com");
		list.add("baidu.com");
		list.add("lhblog.ml");
		ArrayAdapter<String> aa=new ArrayAdapter<String>(this,R.layout.item,list);
		actv.setAdapter(aa);
    }
}
