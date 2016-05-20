package com.mycompany.myapp;
import android.content.*;

public class ListData
{
	private String controlName;
	private Context context;
	private Intent intent;

	public ListData(String controlName, Context context, Intent intent)
	{
		this.controlName = controlName;
		this.context = context;
		this.intent = intent;
	}

	public String getControlName()
	{
		return controlName;
	}

	public Context getContext()
	{
		return context;
	}

	public Intent getIntent()
	{
		return intent;
	}
	
	public void startActivity()
	{
		getContext().startActivity(intent);
	}

	@Override
	public String toString()
	{
		// TODO: Implement this method
		return getControlName();
	}
}
