package com.mycompany.myapp;
import android.app.*;

public class Myapp extends Application
{
	private String name;

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	@Override
	public void onCreate()
	{
		// TODO: Implement this method
		super.onCreate();
		setName("张三");
	}
	
}
