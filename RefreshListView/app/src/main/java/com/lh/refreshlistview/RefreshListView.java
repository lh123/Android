package com.lh.refreshlistview;
import android.view.*;
import android.view.animation.*;
import android.widget.*;
import java.text.*;
import java.util.*;

public class RefreshListView extends ListView implements AbsListView.OnScrollListener
{
	private int downY;
	private int moveY;
	private int currentItem=-1;
	private int measuredHeight;
	private int paddingTop;
	private int currentState=PULL_DOWN_REFRESH;
	private View view;
	private TextView tvHeadState;
	private TextView tvLastTime;
	private ImageView ivArrow;
	private ProgressBar pbHead;
	private BaseAdapter adapter;
	private RotateAnimation upAnimation;
	private RotateAnimation downAnimation;
	private onRefreshListener listener;
	
	public static final int PULL_DOWN_REFRESH = 0;
	public static final int RELEASE_REFRESH = 1;
	public static final int REFESHING = 2;

	public RefreshListView(android.content.Context context, android.util.AttributeSet attrs) 
	{
		super(context, attrs);
		initAnimation();
		initHeadView();
		setOnScrollListener(this);
	}

	public void setOnRefreshListener(onRefreshListener listener)
	{
		this.listener = listener;
	}

	@Override
	public void setAdapter(BaseAdapter adapter)
	{
		this.adapter=adapter;
		super.setAdapter(adapter);
	}
	
	//2015-7-21 10:29:23
	public void refreshComplete()
	{
		if (currentState == REFESHING)
		{
			final SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if ("main".equals(Thread.currentThread().getName()))
			{
				hideHeadView();
				adapter.notifyDataSetChanged();
				tvLastTime.setText(format.format(new Date()));
			}
			else
			{
				this.post(new Runnable(){

						@Override
						public void run()
						{
							hideHeadView();
							tvLastTime.setText(format.format(new Date()));
						}
					});
			}
			currentState = PULL_DOWN_REFRESH;
		}
	}

	public void refreshFail(final String msg)
	{
		if (currentState == REFESHING)
		{
			if ("main".equals(Thread.currentThread().getName()))
			{
				Toast.makeText(getContext(), msg, 0).show();
				hideHeadView();
			}
			else
			{
				this.post(new Runnable(){

						@Override
						public void run()
						{
							Toast.makeText(getContext(), msg, 0).show();
							hideHeadView();
						}
					});
			}
			currentState = PULL_DOWN_REFRESH;
		}
	}

	private void hideHeadView()
	{
		tvHeadState.setText("下拉刷新");
		ivArrow.setVisibility(View.VISIBLE);
		pbHead.setVisibility(View.INVISIBLE);
		view.setPadding(0, -measuredHeight, 0, 0);
	}
	private void initAnimation()
	{
		upAnimation = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		downAnimation = new RotateAnimation(180, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		upAnimation.setDuration(400);
		upAnimation.setFillAfter(true);
		downAnimation.setDuration(400);
		downAnimation.setFillAfter(true);
	}

	private void initHeadView()
	{
		view = View.inflate(getContext(), R.layout.head_view, null);
		tvHeadState = (TextView) view.findViewById(R.id.head_state);
		tvLastTime = (TextView) view.findViewById(R.id.head_lasttime);
		ivArrow = (ImageView) view.findViewById(R.id.head_arrow);
		pbHead = (ProgressBar) view.findViewById(R.id.head_progressbar);
		view.measure(0, 0);
		measuredHeight = view.getMeasuredHeight();
		view.setPadding(0, -measuredHeight, 0, 0);
		addHeaderView(view);
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev)
	{
		switch (ev.getAction())
		{
			case MotionEvent.ACTION_DOWN:
				downY = (int)ev.getY();
				break;
			case MotionEvent.ACTION_MOVE:
				if (currentState == REFESHING)
					break;
				moveY = (int)ev.getY();
				int offsetY=moveY - downY;
				if (offsetY > 0 && currentItem == 0)
				{
					paddingTop = -measuredHeight + offsetY;
					if (currentState == RELEASE_REFRESH && paddingTop < 0)
					{
						currentState = PULL_DOWN_REFRESH;
						setRefreshState();
						//System.out.println("下拉刷新");
					}
					else if (currentState == PULL_DOWN_REFRESH && paddingTop > 0)
					{
						currentState = RELEASE_REFRESH;
						setRefreshState();
						//System.out.println("释放刷新");
					}
					view.setPadding(0, paddingTop, 0, 0);
					return true;
				}
				break;
			case MotionEvent.ACTION_UP:
				if (currentState == PULL_DOWN_REFRESH)
				{
					hideHeadView();
				}
				else if (currentState == RELEASE_REFRESH)
				{
					currentState = REFESHING;
					view.setPadding(0, 0, 0, 0);
					setRefreshState();
				}
				break;
		}
		return super.onTouchEvent(ev);
	}

	private void setRefreshState()
	{
		switch (currentState)
		{
			case PULL_DOWN_REFRESH:
				tvHeadState.setText("下拉刷新");
				ivArrow.startAnimation(downAnimation);
				pbHead.setVisibility(View.INVISIBLE);
				break;
			case RELEASE_REFRESH:
				tvHeadState.setText("释放刷新");
				ivArrow.startAnimation(upAnimation);
				pbHead.setVisibility(View.INVISIBLE);
				break;
			case REFESHING:
				tvHeadState.setText("正在刷新");
				ivArrow.clearAnimation();
				ivArrow.setVisibility(View.INVISIBLE);
				pbHead.setVisibility(View.VISIBLE);
				if (listener != null)
					listener.onRefresh();
				else
					refreshComplete();
				break;
		}
	}

	@Override
	public void onScrollStateChanged(AbsListView p1, int p2)
	{}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
	{
		currentItem = firstVisibleItem;
	}

	public interface onRefreshListener
	{
		public void onRefresh();
	}
}
