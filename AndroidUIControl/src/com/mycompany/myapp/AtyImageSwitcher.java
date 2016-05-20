package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import android.view.animation.*;
import android.animation.*;

public class AtyImageSwitcher extends Activity
{
	private boolean imageShow=true;
	private ImageSwitcher imageSwitcher;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imageswitcher_view);
		imageSwitcher=(ImageSwitcher) findViewById(R.id.imageSwitcher);
		imageSwitcher.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					imageShow=!imageShow;
					showImage();
				}
			});
		imageSwitcher.setFactory(new ImageSwitcher.ViewFactory(){

				@Override
				public View makeView()
				{
					return new ImageView(AtyImageSwitcher.this);
				}
			});
		imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(AtyImageSwitcher.this,android.R.anim.slide_in_left));
		imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(AtyImageSwitcher.this,android.R.anim.slide_out_right));
		showImage();
	}
	public void showImage()
	{
		if(imageShow)
		{
			imageSwitcher.setImageResource(R.drawable.img1);
		}
		else
		{
			imageSwitcher.setImageResource(R.drawable.img2);
		}
	}
}
