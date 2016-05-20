package com.mycompany.myapp;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;

public class AtyToast extends Activity implements OnClickListener
{
	private Button btnShort,btnLong,btnImage;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.toast_view);
		btnShort=(Button) findViewById(R.id.btnToastShort);
		btnLong=(Button) findViewById(R.id.btnToastLong);
		btnImage=(Button) findViewById(R.id.btnToastImage);
		btnShort.setOnClickListener(this);
		btnLong.setOnClickListener(this);
		btnImage.setOnClickListener(this);
	}

	@Override
	public void onClick(View p1)
	{
		switch(p1.getId())
		{
			case R.id.btnToastShort:
				Toast tc=Toast.makeText(AtyToast.this,"hello world!",Toast.LENGTH_SHORT);
				tc.setGravity(Gravity.CENTER,0,0);
				tc.show();
				break;
			case R.id.btnToastLong:
				Toast tcl=Toast.makeText(AtyToast.this,"hello world!",Toast.LENGTH_LONG);
				tcl.setGravity(Gravity.TOP,0,0);
				tcl.show();
				break;
			case R.id.btnToastImage:
				LayoutInflater l=LayoutInflater.from(AtyToast.this);
				View v=l.inflate(R.layout.custom_toast_view,null);
				TextView text=(TextView) v.findViewById(R.id.customToastTextView);
				text.setText("hello world!\n这是一个自定义View");
				Toast tvl=new Toast(AtyToast.this);
				tvl.setDuration(Toast.LENGTH_LONG);
				tvl.setView(v);
				tvl.show();
				break;
		}
	}

	
}
