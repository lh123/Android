package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;

public class AtyProgressDialog extends Activity
{
	private ProgressDialog progressDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progressdialog_view);
		findViewById(R.id.btnShowProgressDialog).setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					progressDialog= new ProgressDialog(AtyProgressDialog.this);
					progressDialog.setTitle("请稍后");
					progressDialog.setMessage("正在处理");
					progressDialog.show();
					new Thread(){
						public void run()
						{
							
							try
							{
								Thread.sleep(3000);
								progressDialog.dismiss();
								
							}
							catch (InterruptedException e)
							{}
						}
					}.start();
				}
			});
	}
}
