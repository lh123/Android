package com.mycompany.myapp;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import android.widget.Toolbar.*;

public class AtyTouch extends Activity
{
	private LinearLayout layout;
	private ImageView image;
	private float current=0,last=-1;
	private TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.touch_view);
		layout = (LinearLayout) findViewById(R.id.touch_viewLinearLayout);
		image = (ImageView) findViewById(R.id.touch_viewImageView);
		text = (TextView) findViewById(R.id.touchviewTextView);
		layout.setOnTouchListener(new OnTouchListener(){

				@Override
				public boolean onTouch(View p1, MotionEvent p2)
				{
					switch (p2.getAction())
					{
						case MotionEvent.ACTION_MOVE:
							LinearLayout.LayoutParams l=(LinearLayout.LayoutParams) image.getLayoutParams();
							if (p2.getPointerCount() == 1)
							{
								l.leftMargin = (int) p2.getX();
								l.topMargin = (int) p2.getY();
								text.setText(String.format("x:%f y:%f", p2.getX(), p2.getY()));
								image.setLayoutParams(l);
							}
//							text.setText("move");
//							System.out.println("move");

//							
//							System.out.println("count="+p2.getPointerCount());
							float offsetX,offsetY;
							if (p2.getPointerCount() >= 2)
							{
								offsetX = p2.getX(0) - p2.getX(1);
								offsetY = p2.getY(0) - p2.getY(1);
								current = (float) Math.sqrt(offsetX * offsetX + offsetY * offsetY);
								if (last < 0)
								{
									last = current;
								}
								else
								{
									if (current - last > 5)
									{
										text.setText("放大");
										System.out.println("放大");
										l.width = (int)(1.1f * image.getWidth());
										l.height = (int)(1.1f * image.getHeight());
									}
									else if (last - current > 5)
									{
										text.setText("缩小");
										System.out.println("缩小");
										System.out.println(image.getWidth());
										if (image.getWidth() > 15)
										{
											l.width = (int)(0.9f * image.getWidth());
											l.height = (int)(0.9f * image.getHeight());
										}
									}
									last = current;
									image.setLayoutParams(l);
								}
							}
							break;
						case MotionEvent.ACTION_UP:
							text.setText("up");
							System.out.println("up");
							break;
						case MotionEvent.ACTION_DOWN:
							text.setText("down");
							System.out.println("down");
							break;
					}
					return true;
				}
			});
	}
}
