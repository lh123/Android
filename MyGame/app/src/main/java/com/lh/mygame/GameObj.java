package com.lh.mygame;
import android.graphics.*;

public abstract class GameObj
{
	protected Point point;
	protected Bitmap bitmap;

	public GameObj(Point point, Bitmap bitmap)
	{
		this.point = point;
		this.bitmap = bitmap;
		if(point==null)
		{
			this.point=new Point(0,0);
		}
	}
	
	public void draw(Canvas canvas)
	{
		canvas.drawBitmap(bitmap,point.x,point.y,null);
	}
}
