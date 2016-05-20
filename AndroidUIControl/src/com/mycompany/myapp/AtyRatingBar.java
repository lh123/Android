package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;

public class AtyRatingBar extends Activity
{

	private RatingBar ratingBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ratingbar_view);
		ratingBar=(RatingBar) findViewById(R.id.ratingbar);
		ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){

				@Override
				public void onRatingChanged(RatingBar p1, float p2, boolean p3)
				{
					Toast.makeText(AtyRatingBar.this,"评分:"+p2,Toast.LENGTH_SHORT).show();
				}
			});
	}
}
