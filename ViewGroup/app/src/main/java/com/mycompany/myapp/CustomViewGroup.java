package com.mycompany.myapp;
import android.view.*;
import android.content.*;
import android.util.*;
import android.view.ViewGroup.*;

public class CustomViewGroup extends ViewGroup
{
	private Context context;
	public CustomViewGroup(android.content.Context context)
	{
		super(context);
	}

    public CustomViewGroup(android.content.Context context, android.util.AttributeSet attrs)
	{
		super(context, attrs);
	}

    public CustomViewGroup(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
	}

    public CustomViewGroup(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes)
	{
		super(context, attrs, defStyleAttr, defStyleRes);
	}

	@Override
	public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs)
	{
		return new MarginLayoutParams(getContext(),attrs);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		int widthMode=MeasureSpec.getMode(widthMeasureSpec);
		int heightMode=MeasureSpec.getMode(heightMeasureSpec);
		int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
		int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
		measureChildren(widthMeasureSpec, heightMeasureSpec);
		int width=0,height=0;
		int count=getChildCount();
		int cwidth=0,cheight=0;
		MarginLayoutParams cParams=null;
		int lheight=0;
		int rheight=0;
		int twidth=0;
		int bwidth=0;
		for (int i=0;i < count;i++)
		{
			View childView=getChildAt(i);
			cwidth = childView.getMeasuredWidth();
			cheight = childView.getMeasuredHeight();
			cParams = (ViewGroup.MarginLayoutParams) childView.getLayoutParams();
			if (i == 0 || i == 1)
			{
				twidth = twidth + cwidth + cParams.leftMargin + cParams.rightMargin;
			}
			if (i == 2 || i == 3)
			{
				bwidth = bwidth + cwidth + cParams.leftMargin + cParams.rightMargin;
			}
			if (i == 0 || i == 2)
			{
				lheight = lheight + cheight + cParams.topMargin + cParams.bottomMargin;
			}
			if (i == 1 || i == 3)
			{
				rheight = rheight + cheight + cParams.topMargin + cParams.bottomMargin;
			}
			width = Math.max(twidth, bwidth);
			height = Math.max(lheight, rheight);
			setMeasuredDimension((widthMode == MeasureSpec.EXACTLY) ? sizeWidth: width, (heightMode == MeasureSpec.EXACTLY) ?sizeHeight: height);
		}
	}


	@Override
	protected void onLayout(boolean p1, int p2, int p3, int p4, int p5)
	{
		int cCount=getChildCount();
		int cWidth=0,cHeight=0;
		MarginLayoutParams cParams;
		for (int i=0;i < cCount;i++)
		{
			View childView=getChildAt(i);
			cWidth = childView.getMeasuredWidth();
			cHeight = childView.getMeasuredHeight();
			cParams = (ViewGroup.MarginLayoutParams) childView.getLayoutParams();
			int cl = 0, ct = 0, cr = 0, cb = 0;

			switch (i)
			{
				case 0:
					cl = cParams.leftMargin;
					ct = cParams.topMargin;
					break;
				case 1:
					cl = getWidth() - cWidth - cParams.leftMargin
						- cParams.rightMargin;
					ct = cParams.topMargin;

					break;
				case 2:
					cl = cParams.leftMargin;
					ct = getHeight() - cHeight - cParams.bottomMargin;
					break;
				case 3:
					cl = getWidth() - cWidth - cParams.leftMargin
						- cParams.rightMargin;
					ct = getHeight() - cHeight - cParams.bottomMargin;
					break;

			}
			cr = cl + cWidth;
			cb = cHeight + ct;
			childView.layout(cl, ct, cr, cb);
		}
	}
}
