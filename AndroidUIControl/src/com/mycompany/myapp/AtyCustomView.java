package com.mycompany.myapp;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.text.*;
import android.view.View.*;
import android.view.*;
import android.widget.Toolbar.*;

public class AtyCustomView extends Activity implements OnClickListener
{

	@Override
	public void onClick(View p1)
	{
		layout.removeView(p1);
	}
	
	private int count=0;
	private Button btnAdd;
	private LinearLayout layout;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.customview_view);
		btnAdd=(Button) findViewById(R.id.customviewbtnAdd);
		layout=(LinearLayout) findViewById(R.id.customviewLayout);
		btnAdd.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					Button btn=new Button(AtyCustomView.this);
					btn.setText("new button "+count);
					count++;
					btn.setOnClickListener(AtyCustomView.this);
					layout.addView(btn,LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
				}
			});
	}
}
