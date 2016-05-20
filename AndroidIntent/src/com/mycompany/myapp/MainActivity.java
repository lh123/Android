package com.mycompany.myapp;

import android.app.*;
import android.content.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.io.*;

public class MainActivity extends Activity
{
    private Button btnStartActivity,btnOpenImage,btnOpenUrl;
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		btnStartActivity=(Button) findViewById(R.id.buttonStartActivity);
		btnOpenImage=(Button) findViewById(R.id.buttonOpenImage);
		btnOpenUrl=(Button) findViewById(R.id.buttonOpenUrl);
		btnStartActivity.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
//					Intent intent=new Intent();
//					intent.setComponent(new ComponentName("com.mycompany.myapp","com.mycompany.myapp.MyActivity"));
					Intent intent=new Intent();
					intent.setAction("com.mycompany.myapp.My");
					startActivity(intent);
				}
			});
		btnOpenImage.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					File f=new File("/storage/sdcard0/mishop/splash.jpg");
					Intent i=new Intent();
					
					i.setAction(Intent.ACTION_VIEW);
					i.setDataAndType(Uri.fromFile(f),"image/*");
					startActivity(i);
				}
			});
		btnOpenUrl.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					Intent i=new Intent();
					//i.setData(Uri.parse("http:"));
					//i.setAction(Intent.ACTION_VIEW);
					i.setComponent(new ComponentName("com.mycompany.myapp","com.mycompany.myapp.MyView"));
					new ComponentName
					startActivity(i);
				}
			});
    }
}
