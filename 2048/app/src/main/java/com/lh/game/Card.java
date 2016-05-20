package com.lh.game;
import android.app.*;
import android.view.*;
import android.os.*;
import android.widget.*;
import android.content.*;
import android.widget.Toolbar.*;
import android.graphics.*;

public class Card extends FrameLayout
{
	private TextView txt;
	private int num;
	public Card(Context context)
	{
		super(context);
		txt=new TextView(getContext());
		txt.setGravity(Gravity.CENTER);
		txt.setTextSize(32);
		LayoutParams lp=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		lp.setMargins(10,10,10,10);
		addView(txt,lp);
	}

	public void setNum(int num)
	{
		this.num = num;
		txt.setTextColor(Color.WHITE);
		if(num==0)
		{
			txt.setTextColor(Color.BLACK);
			txt.setBackgroundColor(Color.argb(50,238,228,218));
		}
		else if(num==2)
		{
			txt.setTextColor(Color.BLACK);
			txt.setBackgroundResource(R.color.card_2);
		}
		else if(num==4)
		{
			txt.setTextColor(Color.BLACK);
			txt.setBackgroundResource(R.color.card_4);
		}
		else if(num==8)
		{
			txt.setBackgroundResource(R.color.card_8);
		}
		else if(num==16)
		{
			txt.setBackgroundResource(R.color.card_16);
		}
		else if(num==32)
		{
			txt.setBackgroundResource(R.color.card_32);
		}
		else if(num==64)
		{
			txt.setBackgroundResource(R.color.card_64);
		}
		else if(num==128)
		{
			txt.setBackgroundResource(R.color.card_128);
		}
		else if(num==256)
		{
			txt.setBackgroundResource(R.color.card_256);
		}
		else if(num==512)
		{
			txt.setBackgroundResource(R.color.card_512);
		}
		else if(num==1024)
		{
			txt.setBackgroundResource(R.color.card_1024);
		}
		else if(num==2048)
		{
			txt.setBackgroundResource(R.color.card_2048);
		}
		else if(num>2048)
		{
			txt.setBackgroundResource(R.color.card_more);
		}
		if(num==0)
		{
			txt.setText(" ");
		}
		else
		{
			txt.setText(num+"");
		}
	}

	public int getNum()
	{
		return num;
	}

	public boolean equals(Card c)
	{
		if(num==c.getNum())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
