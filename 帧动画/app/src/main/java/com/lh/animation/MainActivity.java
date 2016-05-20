package com.lh.animation;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.graphics.drawable.*;

public class MainActivity extends Activity 
{
	private ImageView imageView;
	private AnimationDrawable ad;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		ad=(AnimationDrawable) getResources().getDrawable(R.drawable.girl);
		imageView=(ImageView) findViewById(R.id.mainImageView);
		imageView.setBackgroundDrawable(ad);
		ad.start();
    }
}
