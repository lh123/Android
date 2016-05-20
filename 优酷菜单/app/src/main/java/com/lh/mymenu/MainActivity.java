package com.lh.mymenu;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import com.lh.Utils.*;

public class MainActivity extends Activity implements OnClickListener
{
	private RelativeLayout level1,level2,level3;
	private boolean isShow1=true,isShow2=true,isShow3=true;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		level1=(RelativeLayout) findViewById(R.id.level1);
		level2=(RelativeLayout) findViewById(R.id.level2);
		level3=(RelativeLayout) findViewById(R.id.level3);
		findViewById(R.id.icon_home).setOnClickListener(this);
		findViewById(R.id.icon_menu).setOnClickListener(this);
    }

	@Override
	public void onClick(View view)
	{
		long startOffset =0;
		switch(view.getId())
		{
			case R.id.icon_home:
				if(isShow2)
				{
					if(isShow3)
					{
						MyUtils.setOutAnimation(level3,startOffset);
						isShow3=false;
						startOffset+=200;
					}
					MyUtils.setOutAnimation(level2,startOffset);
					isShow2=false;
				}
				else
				{
					MyUtils.setInAnimation(level2,0);
					MyUtils.setInAnimation(level3,200);
					isShow2=true;
					isShow3=true;
				}
				break;
			case R.id.icon_menu:
				if(isShow3)
				{
					MyUtils.setOutAnimation(level3,0);
					isShow3=false;
				}
				else
				{
					MyUtils.setInAnimation(level3,0);
					isShow3=true;
				}
				break;
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if(event.getKeyCode()==KeyEvent.KEYCODE_MENU)
		{
			long startOffset = 0;
			if(isShow1)
			{
				if(isShow2)
				{
					if(isShow3)
					{
						MyUtils.setOutAnimation(level3, startOffset);
						isShow3 = false;
						startOffset+=200;
					}
					MyUtils.setOutAnimation(level2,startOffset);
					isShow2=false;
					startOffset+=200;
				}
				MyUtils.setOutAnimation(level1,startOffset);
				isShow1=false;
			}
			else
			{
				MyUtils.setInAnimation(level1,0);
				MyUtils.setInAnimation(level2,200);
				MyUtils.setInAnimation(level3,400);
				isShow1=true;
				isShow2=true;
				isShow3=true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	
}
