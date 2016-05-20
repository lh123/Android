package com.myapp.service;

import java.util.*;

public class Task extends TimerTask
{
	private int i=0;

	public int getI()
	{
		return i;
	}
	
	@Override
	public void run()
	{
		i++;
		System.out.println(i);
	}
}
