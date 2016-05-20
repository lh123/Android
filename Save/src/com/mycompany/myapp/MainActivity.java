package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.view.View.*;

public class MainActivity extends Activity
{
	SharedPreferences sp;
	EditText et;
	Button btn;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		et=(EditText)findViewById(R.id.et);
		btn=(Button)findViewById(R.id.btn);
		sp=getSharedPreferences("save",MODE_PRIVATE);
		String str=sp.getString("etstr","");
		et.setText(str);
		btn.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					sp.edit().putString("etstr",et.getText().toString()).commit();
				}

			
		});
    }
	long current=0;
	@Override
	public void onBackPressed()
	{
		// TODO: Implement this method
		if(System.currentTimeMillis()-current>2000)
		{
			current=System.currentTimeMillis();
			Toast.makeText(this,"再按一次退出",0).show();
		}
		else
		{
			finish();
			System.exit(0);
		}
	}
}
