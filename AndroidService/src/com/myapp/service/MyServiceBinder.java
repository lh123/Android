package com.myapp.service;

import android.os.*;

public class MyServiceBinder extends Binder
{
	private MyService myservice;

	public MyServiceBinder(MyService myservice)
	{
		this.myservice = myservice;
	}
	public MyService getService()
	{
		return myservice;
	}
}
