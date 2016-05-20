package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.View.*;
import android.view.*;
import android.content.*;

public class AtyNotificationNew extends Activity
{
	private NotificationManager nm;
	private Notification n;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification_view);
		nm=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		nm.cancel(R.layout.notification_view);
		findViewById(R.id.btnShowNotification).setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					n=new Notification.Builder(AtyNotificationNew.this).setSmallIcon(R.drawable.ic_launcher).setWhen(System.currentTimeMillis()).setContentText("new api").setContentTitle("Title").setContentIntent(PendingIntent.getActivity(AtyNotificationNew.this,1,getIntent(),0)).build();
					nm.notify(R.layout.notification_view,n);
				}
			});
	}
}
