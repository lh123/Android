package com.mycompany.myapp2;

import android.app.*;
import android.os.*;
import android.view.View.*;
import android.widget.*;
import android.view.*;
import android.content.*;

public class MainActivity extends Activity implements OnClickListener
{
	private Button sendBRC,regBRC,unregBRC;
	private MyBRC myBRC;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		sendBRC=(Button) findViewById(R.id.buttonSendBroadcast);
		regBRC=(Button) findViewById(R.id.buttonReg);
		unregBRC=(Button) findViewById(R.id.buttonUnreg);
		myBRC=new MyBRC();
		sendBRC.setOnClickListener(this);
		regBRC.setOnClickListener(this);
		unregBRC.setOnClickListener(this);
    }

	@Override
	public void onClick(View p1)
	{
		if(p1.getId()==R.id.buttonReg)
		{
			registerReceiver(myBRC,new IntentFilter(MyBRC.ACTION));
		}
		if(p1.getId()==R.id.buttonSendBroadcast)
		{
			Intent intent=new Intent(MyBRC.ACTION);
			intent.putExtra("hg","hgg");
			sendBroadcast(intent);
		}
	}

}
