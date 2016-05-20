package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.SearchView.*;
import android.content.*;

public class MainActivity extends Activity
{
	EditText edit1,edit2;
	Button button;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		edit1=(EditText)findViewById(R.id.edit1);
		edit2=(EditText)findViewById(R.id.edit2);
		button=(Button)findViewById(R.id.button);
		button.setOnClickListener(new ButtonListener());
    }
	class ButtonListener implements OnClickListener
	{

		@Override
		public void onClick(View p1)
		{
			// TODO: Implement this method
			Intent intent=new Intent();
			intent.putExtra("edita",edit1.getText().toString());
			intent.putExtra("editb",edit2.getText().toString());
			intent.setClass(MainActivity.this,SecondActivity.class);
			startActivity(intent);
		}

		
	}
}
