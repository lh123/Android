package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity
{
	private TextView showView=null;
	private EditText edit=null;
	private Button btn=null;
	private Button btn2=null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		this.showView=(TextView)findViewById(R.id.text);
		this.edit=(EditText)findViewById(R.id.edit);
		this.btn=(Button)findViewById(R.id.btn1);
		this.btn2=(Button)findViewById(R.id.btn2);
		btn.setOnClickListener(new ShowListener());
		btn2.setOnClickListener(new ClearListener());
    }
	private class ShowListener implements OnClickListener
	{
		@Override
		public void onClick(View p1)
		{
			// TODO: Implement this method
			String sum=edit.getText().toString();
			showView.setText(sum);
		}
	}
	private class ClearListener implements OnClickListener
	{

		@Override
		public void onClick(View p1)
		{
			// TODO: Implement this method
			showView.setText(" ? ");
			edit.setText("");
		}

		
	}
}

