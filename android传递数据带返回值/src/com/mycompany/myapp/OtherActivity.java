package com.mycompany.myapp;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import android.content.*;

public class OtherActivity extends Activity
{
	TextView textview;
	EditText edittext;
	Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);
		textview=(TextView)this.findViewById(R.id.otherTextView);
		button=(Button)this.findViewById(R.id.otherButton);
		edittext=(EditText)this.findViewById(R.id.otherEditText3);
		Intent intent=getIntent();
		int one=intent.getIntExtra("one",0);
		int two=intent.getIntExtra("two",0);
		textview.setText(one+" + "+two+" = ?");
		button.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method;
					Intent intent=new Intent();
					int three;
					try
					{
						three=Integer.parseInt(edittext.getText().toString());
					}
					catch (NumberFormatException e)
					{
						three=0;
					}
					intent.putExtra("three", three);
					setResult(2,intent);
					finish();
				}
			});
	}
}
