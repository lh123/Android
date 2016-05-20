package com.lh.weather;
import android.view.*;
import android.content.*;

public class custom extends ViewGroup
{
	public custom(Context context)
	{
		super(context);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	
	@Override
	protected void onLayout(boolean changed,int left, int top, int right, int bottom)
	{
		int mViewGroupWidth=getMeasuredWidth();
		int mViewX=left;
		int mViewY=top;
		int viewCount=getChildCount();
		
	}
}
