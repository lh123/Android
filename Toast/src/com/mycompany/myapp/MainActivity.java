package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;

public class MainActivity extends Activity
{
	Button btn=null;
	EditText text1=null;
	EditText text2=null;
	int a,b,c;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		btn=(Button)findViewById(R.id.btn);
		text1=(EditText)findViewById(R.id.text1);
		text2=(EditText)findViewById(R.id.text2);
		btn.setOnClickListener(new ButtonClick());
    }
	class ButtonClick implements OnClickListener
	{

		@Override
		public void onClick(View p1)
		{
			// TODO: Implement this method
			try
			{
				a = Integer.parseInt(text1.getText().toString());
				b = Integer.parseInt(text2.getText().toString());
				c = a + b;
				Toast.makeText(MainActivity.this, "result=" + c, Toast.LENGTH_SHORT).show();
			}
			catch (NumberFormatException e)
			{
				Toast.makeText(MainActivity.this,"必须输入数字",Toast.LENGTH_SHORT).show();
				Toast.makeText(MainActivity.this,e.getMessage().toString(),Toast.LENGTH_SHORT).show();
			}
		}
	}
}
