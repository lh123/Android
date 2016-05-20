package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;

public class MainActivity extends Activity implements OnClickListener
{
	TextView tv;
	Button btn[]=new Button[5];
	int btnid[]=new int[5];
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		tv=(TextView)findViewById(R.id.tv);
		for(int i=0;i<btnid.length;i++)
		{
			btnid[i]=getResources().getIdentifier("btn"+i,"id",getPackageName());
			btn[i]=(Button)findViewById(btnid[i]);
			btn[i].setOnClickListener(this);
		}
		
    }
	@Override
	public void onClick(View p1)
	{
		// TODO: Implement this method
		Button button=(Button)p1;
		tv.setText(tv.getText().toString()+button.getText().toString());
	}
}
