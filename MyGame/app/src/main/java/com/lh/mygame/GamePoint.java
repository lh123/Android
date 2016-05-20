package com.lh.mygame;

import android.graphics.*;

public class GamePoint extends GameObj
{
	public GamePoint(Point point, Bitmap bitmap)
	{
		super(point,bitmap);
	}
	
	public void move()
	{
		point.x=point.x+5;
		point.y+=5;
	}
}
