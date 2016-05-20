package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;

public class AtyEditText extends Activity
{
	private EditText edit;
	private Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edittext_view);
		edit=(EditText) findViewById(R.id.edittext);
		btn=(Button) findViewById(R.id.btnEdittext);
		btn.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					if(edit.getText().length()==0)
					{
						Toast.makeText(AtyEditText.this,"文本为空",Toast.LENGTH_SHORT).show();
					}
					else
					{
						Toast.makeText(AtyEditText.this,edit.getText().toString(),Toast.LENGTH_SHORT).show();
					}
				}
			});
	}
}
