package com.my.view;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;

public class MainActivity extends Activity
{
    private Button btn;
	private LinearLayout layout;

	private View.OnClickListener clickHandle=new OnClickListener(){

		@Override
		public void onClick(View p1)
		{
//			LinearLayout ll=(LinearLayout) p1.getParent();
//			ll.removeView(p1);
			layout.removeView(p1);
		}
	};
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		layout=(LinearLayout) findViewById(R.id.mainLinearLayout);
		for(int i=0;i<5;i++)
		{
			btn=new Button(this);
			layout.addView(btn,LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
			btn.setText("Click me To Remove "+i);
			btn.setOnClickListener(clickHandle);
		}
    }
}
