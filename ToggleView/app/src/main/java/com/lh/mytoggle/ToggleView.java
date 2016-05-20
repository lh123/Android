package com.lh.mytoggle;

import android.view.*;
import android.graphics.*;

public class ToggleView extends View
{
	private Bitmap slideBackground;
	private Bitmap toggleBackground;
	private int currentX=0;
	private boolean status=false,preStatus;
	private boolean isTouch=false;
	private int toggleWidth,slideWidth;
	private OnToggleStatusChangeListener listener;

	public ToggleView(android.content.Context context)
	{
		super(context);
	}

    public ToggleView(android.content.Context context, android.util.AttributeSet attrs)
	{
		super(context, attrs);
		String name="http://schemas.android.com/apk/res/com.lh.mytoggle";
		setStatus(attrs.getAttributeBooleanValue(name,"status",false));
		setBackgroundID(attrs.getAttributeResourceValue(name,"switch_background",R.drawable.ic_launcher));
		setSlideBackgroundID(attrs.getAttributeResourceValue(name,"slider_background",R.drawable.ic_launcher));
	}

	public void setStatus(boolean status)
	{
		this.status = status;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		setMeasuredDimension(toggleWidth, toggleBackground.getHeight());
		toggleWidth=toggleBackground.getWidth();
		slideWidth=slideBackground.getWidth();
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		canvas.drawBitmap(toggleBackground, 0, 0, null);
		if (isTouch)
		{
			currentX=currentX-slideWidth/2;
			if(currentX>toggleWidth-slideWidth)
			{
				currentX=toggleWidth-slideWidth;
				canvas.drawBitmap(slideBackground,currentX,0,null);
			}
			else if(currentX<0)
			{
				currentX=0;
				canvas.drawBitmap(slideBackground,currentX,0,null);
			}
			else
			{
				canvas.drawBitmap(slideBackground,currentX,0,null);
			}
		}
		else
		{
			if (!status)
			{
				canvas.drawBitmap(slideBackground, 0, 0, null);
			}
			else
			{
				canvas.drawBitmap(slideBackground, toggleWidth - slideWidth, 0, null);
			}
		}
	}

	public void setOnToggleStatusChangeListener(OnToggleStatusChangeListener listener)
	{
		this.listener=listener;
	}
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		switch (event.getAction())
		{
			case MotionEvent.ACTION_DOWN:
				currentX = (int)event.getX();
				isTouch=true;
				break;
			case MotionEvent.ACTION_MOVE:
				currentX = (int)event.getX();
				break;
			case MotionEvent.ACTION_UP:
				isTouch=false;
				currentX=(int) event.getX();
				int temp=currentX-slideWidth/2;
				preStatus=status;
				if(temp>(toggleWidth-slideWidth)/2)
					status=true;
				else
					status=false;
				if(listener!=null&&preStatus!=status)
					//System.out.println(status);
					listener.statusChange(status);
				break;
		}
		invalidate();
		return true;
	}

	public void setSlideBackgroundID(int slide_button_background)
	{
		slideBackground = BitmapFactory.decodeResource(getResources(), slide_button_background);
	}

	public void setBackgroundID(int switch_background)
	{
		toggleBackground = BitmapFactory.decodeResource(getResources(), switch_background);
	}
	
	public interface OnToggleStatusChangeListener
	{
		public void statusChange(boolean status);
	}
}
