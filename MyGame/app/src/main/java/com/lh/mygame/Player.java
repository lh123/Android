package com.lh.mygame;

import android.graphics.*;

public class Player extends GameObj
{
	public Player(Point point, Bitmap bitmap)
	{
		super(point,bitmap);
	}
	
	public GamePoint creatPoint(Bitmap bit)
	{
		return new GamePoint(new Point(point.x+30,point.y+30),bit);
	}
}
