package com.mycompany.myapp;

import android.view.*;
import android.graphics.*;
import android.view.View.*;
import android.widget.ExpandableListView.*;

public class CustomView extends View
{
	private Paint paint;
	private int vWidth=100,vHeight=100;
	public CustomView(android.content.Context context)
	{
		super(context);
		init();
	}

    public CustomView(android.content.Context context, android.util.AttributeSet attrs)
	{
		super(context, attrs);
		init();
	}

    public CustomView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
		init();
	}

    public CustomView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes)
	{
		super(context, attrs, defStyleAttr, defStyleRes);
		init();
	}

	protected void init()
	{
		paint=new Paint();
		paint.setAntiAlias(true);
		paint.setColor(Color.BLUE);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		int widthMode=MeasureSpec.getMode(widthMeasureSpec);
		int heightMode=MeasureSpec.getMode(heightMeasureSpec);
		int width=0,height=0;
		if(widthMode==MeasureSpec.EXACTLY)
		{
			width=MeasureSpec.getSize(widthMeasureSpec);
			height=MeasureSpec.getSize(heightMeasureSpec);
		}
		else
		{
			width=getPaddingLeft()+getPaddingRight()+vWidth;
			height=getPaddingTop()+getPaddingBottom()+vHeight;
			if(widthMode==MeasureSpec.AT_MOST)
			{
				width=Math.min(MeasureSpec.getSize(widthMeasureSpec),width);
				height=Math.min(MeasureSpec.getSize(heightMeasureSpec),height);
			}
		}
		setMeasuredDimension(width,height);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		float x,y;
		float viewX,viewY;
		viewX=getMeasuredWidth()/2;
		viewY=getMeasuredHeight()/2;
		switch(event.getAction())
		{
			case MotionEvent.ACTION_DOWN:
				x= event.getX();
				y= event.getY();
				float offsetX=x-viewX;
				float offsetY=y-viewY;
				if(offsetX*offsetX+offsetY*offsetY>viewX*viewX)
				{
					return false;
				}
				else
				{
					if(l!=null)
					{
						l.onClick(this);
					}
					return true;
				}
			case MotionEvent.ACTION_MOVE:
				break;
		}
		return false;
	}

	private OnClickListener l;
	
	@Override
	public void setOnClickListener(OnClickListener l)
	{
		this.l=l;
	}
	
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		canvas.drawOval(0,0,getMeasuredWidth(),getMeasuredHeight(),paint);
	}
	
}
