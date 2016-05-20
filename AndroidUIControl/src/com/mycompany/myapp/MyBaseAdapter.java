package com.mycompany.myapp;

import android.content.*;
import android.view.*;
import android.widget.*;
import java.util.*;

public abstract class MyBaseAdapter<T> extends BaseAdapter
{

	private ArrayList<T> myList;
	private Context context;
	private int resId=0;
	private View view;

	public MyBaseAdapter(Context context, int resId)
	{
		this.context = context;
		this.resId = resId;
		myList=new ArrayList<T>();
	}

	public void add(T obj)
	{
		myList.add(obj);
		notifyDataSetChanged();
	}
	public void removeId(int id)
	{
		if(id>=0)
		{
			myList.remove(id);
			notifyDataSetChanged();
		}
	}
	public void removeLast()
	{
		removeId(getCount()-1);
	}
	public Context getContext()
	{
		return context;
	}
	@Override
	public int getCount()
	{
		// TODO: Implement this method
		return myList.size();
	}

	@Override
	public T getItem(int p1)
	{
		// TODO: Implement this method
		return myList.get(p1);
	}

	@Override
	public long getItemId(int p1)
	{
		// TODO: Implement this method
		return p1;
	}

	@Override
	public View getView(int p1, View p2, ViewGroup p3)
	{
		if(p2==null)
		{
			view=LayoutInflater.from(context).inflate(resId,null);
			System.out.println("creat view "+p1);
		}
		else
		{
			view=p2;
		}
		initAdapter(p1,view,p3);
		return view;
	}
	protected abstract void initAdapter(int p1, View p2, ViewGroup p3);

}
