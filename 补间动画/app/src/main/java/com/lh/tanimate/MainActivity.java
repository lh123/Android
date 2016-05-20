package com.lh.tanimate;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.animation.*;

public class MainActivity extends Activity 
{
	private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		imageView=(ImageView) findViewById(R.id.mainImageView);
    }
	
	public void alpha(View v)
	{
		AlphaAnimation alphaAnimation=new AlphaAnimation(0,1.0f);
		alphaAnimation.setDuration(2000);
		//alphaAnimation.setStartTime(System.currentTimeMillis()+1000);
		imageView.startAnimation(alphaAnimation);
		//imageView.setAnimation(alphaAnimation);
	}
	public void trans(View v)
	{
		TranslateAnimation translateAnimation=new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0.5f);
		translateAnimation.setDuration(2000);
		imageView.startAnimation(translateAnimation);
	}
	public void scale(View v)
	{
		ScaleAnimation scaleAnimation=new ScaleAnimation(0, 2.0f, 0, 2.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		scaleAnimation.setDuration(2000);
		imageView.startAnimation(scaleAnimation);
	}
	public void rotate(View v)
	{
		RotateAnimation rotateAnimation=new RotateAnimation(0,360,imageView.getWidth()/2,imageView.getHeight()/2);
		rotateAnimation.setDuration(2000);
		imageView.startAnimation(rotateAnimation);
	}
	
	public void set(View v)
	{
		TranslateAnimation translateAnimation=new TranslateAnimation(Animation.RELATIVE_TO_PARENT, -0.5f, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, -0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
		translateAnimation.setDuration(2000);
		translateAnimation.setRepeatCount(2);
		RotateAnimation rotateAnimation=new RotateAnimation(0, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		rotateAnimation.setDuration(2000);
		rotateAnimation.setRepeatCount(2);
		ScaleAnimation scaleAnimation=new ScaleAnimation(0, 2.0f, 0, 2.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		scaleAnimation.setDuration(2000);
		scaleAnimation.setRepeatCount(2);
		AnimationSet animationSet=new AnimationSet(false);
		animationSet.addAnimation(rotateAnimation);
		animationSet.addAnimation(scaleAnimation);
		animationSet.addAnimation(translateAnimation);
		animationSet.setRepeatMode(Animation.REVERSE);
		imageView.startAnimation(animationSet);
	}
}
