package com.mycompany.myapp;

import android.app.*;
import android.widget.*;
import android.os.*;

public class MyImageView extends Activity
{
	private ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.image);
		imageView=new ImageView(this);
		setContentView(imageView);
		//imageView=(ImageView) findViewById(R.id.imageImageView);
		//imageView.setImageResource(R.drawable.ic_launcher);
		imageView.setImageURI(getIntent().getData());
		System.out.println(getIntent().getData());
	}
	
}
