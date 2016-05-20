package com.mycompany.myapp;
import android.view.*;
import android.content.*;
import org.xml.sax.*;
import android.util.*;
import android.graphics.*;

public class MyView extends View
{
	public MyView(Context context,AttributeSet attr)
	{
		super(context,attr);
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		// TODO: Implement this method
		Paint paint=new Paint();
		paint.setColor(Color.RED);
		RectF rectf=new RectF(100,150,400,250);
		canvas.drawOval(rectf,paint);
		super.onDraw(canvas);
	}
}
