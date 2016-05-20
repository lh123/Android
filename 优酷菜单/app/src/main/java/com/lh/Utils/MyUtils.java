package com.lh.Utils;

import android.view.*;
import android.view.animation.*;
import android.view.animation.Animation.*;
import android.widget.*;

public class MyUtils
{
	private static RotateAnimation rotateAnimation;
	private static boolean isPlay;
	private static MyAnimation myAnimation=new MyAnimation();
	public static void setOutAnimation(RelativeLayout view,long startOffset)
	{
		if(isPlay)
			return;
		int count=view.getChildCount();
		for(int i=0;i<count;i++)
		{
			view.getChildAt(i).setEnabled(false);
		}
		rotateAnimation=new RotateAnimation(0, -180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1.0f);
		rotateAnimation.setDuration(400);
		rotateAnimation.setFillAfter(true);
		rotateAnimation.setStartOffset(startOffset);
		rotateAnimation.setAnimationListener(myAnimation);
		view.startAnimation(rotateAnimation);
	}
	public static void setInAnimation(RelativeLayout view,long startOffset)
	{
		if(isPlay)
			return;
		int count=view.getChildCount();
		for(int i=0;i<count;i++)
		{
			view.getChildAt(i).setEnabled(true);
		}
		rotateAnimation=new RotateAnimation(-180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1.0f);
		rotateAnimation.setDuration(400);
		rotateAnimation.setFillAfter(true);
		rotateAnimation.setStartOffset(startOffset);
		rotateAnimation.setAnimationListener(myAnimation);
		view.startAnimation(rotateAnimation);
	}
	
	public static class MyAnimation implements Animation.AnimationListener
	{
		@Override
		public void onAnimationStart(Animation p1)
		{
			isPlay=true;
		}

		@Override
		public void onAnimationEnd(Animation p1)
		{
			isPlay=false;
		}

		@Override
		public void onAnimationRepeat(Animation p1)
		{
			// TODO: Implement this method
		}
	}
}
