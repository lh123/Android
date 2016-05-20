package com.mycompany.myapp;
import android.view.*;
import android.content.*;
import android.graphics.*;
import android.widget.*;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback
{
	SurfaceHolder sfh;
	Paint p;
	Canvas canvas;
	Toast t;


	@Override
	public void surfaceCreated(SurfaceHolder p1)
	{
		// TODO: Implement this method
		int sw=getWidth();
		int sh=getHeight();
		canvas = sfh.lockCanvas();
		canvas.drawRGB(255, 255, 255);
		p.setTextSize(50);
		p.setColor(0xffff0000);
		canvas.drawText("lh123", 0, 50, p);
		Bitmap bmp=BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		canvas.drawBitmap(bmp, (sw - bmp.getWidth()) / 2, sh - bmp.getHeight(), p);
		sfh.unlockCanvasAndPost(canvas);
	}

	@Override
	public void surfaceChanged(SurfaceHolder p1, int p2, int p3, int p4)
	{
		// TODO: Implement this method
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder p1)
	{
		// TODO: Implement this method
	}

	MySurfaceView(Context context)
	{
		super(context);
		sfh = getHolder();
		sfh.addCallback(this);
		p = new Paint();
		t = Toast.makeText(context, "", Toast.LENGTH_SHORT);
	}


	public boolean onTouchEvent(MotionEvent event)
	{
		// TODO: Implement this method
		int xx=(int)event.getX();
		int yy=(int)event.getY();
		t.setText("x坐标:"+xx+",y坐标"+yy);
		t.show();
		canvas=sfh.lockCanvas();
		canvas.drawRGB(225,225,225);
		canvas.drawText("lh123",xx,yy,p);
		sfh.unlockCanvasAndPost(canvas);
		return true;
	}
}
