package com.lh.mygame;
import android.content.*;
import android.view.*;
import android.graphics.*;
import android.view.View.*;
import android.content.res.*;

public class GameUi extends SurfaceView implements SurfaceHolder.Callback,OnTouchListener
{
	public static boolean isDraw=true;
	private SurfaceHolder holder;
	private Player player;
	private GamePoint poi;
	private Thread t;
	long start,end;
	float FPS;
	public GameUi(Context context)
	{
		super(context);
		holder = this.getHolder();
		holder.addCallback(this);
		setOnTouchListener(this);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder)
	{
		t = new Thread(new drawRun());
		player=new Player(null,BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher));
		poi= player.creatPoint(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher));
		t.start();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int p2, int p3, int p4)
	{

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder p1)
	{
		//isDraw = false;
	}
	
	
	class drawRun implements Runnable
	{

		@Override
		public void run()
		{
			while (isDraw)
			{
				start=System.currentTimeMillis();
				Canvas canvas= null;
				try
				{
					canvas = holder.lockCanvas();
					if (canvas != null)
					{
						canvas.drawColor(Color.WHITE);
//						Paint p=new Paint();
//						p.setColor(Color.RED);
//						canvas.drawRect(0, 0, 50, 50, p);
						player.draw(canvas);
						
						poi.draw(canvas);
						poi.move();
						end=System.currentTimeMillis();
						FPS=1000.0f/(end-start);
						Paint t=new Paint();
						t.setColor(Color.BLACK);
						canvas.drawText(String.format("%.0f",FPS),500,500,t);
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					if (canvas != null)
						holder.unlockCanvasAndPost(canvas);
				}
			}
		}
	}
	
	@Override
	public boolean onTouch(View p1, MotionEvent event)
	{
		switch(event.getAction())
		{
			case MotionEvent.ACTION_DOWN:
				break;
			case MotionEvent.ACTION_UP:
				break;
			case MotionEvent.ACTION_MOVE:
				break;
		}
		return true;
	}
	
	
}
