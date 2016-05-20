package com.lh.game;
import android.content.*;
import android.util.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;
import java.util.*;

public class Grid extends GridLayout
{
	private int cardWidth,cardHeight,num;
	private boolean isfull=true;
	private Card[][] card=new Card[4][4];
	private int count=0;
	private boolean isMoved=false;
	private int score=0;
	private onScoreChangeListener os;
	interface onScoreChangeListener
	{
		public void score(int score);
	}

	public void setOnScoreChangeListener(onScoreChangeListener os)
	{
		this.os=os;
	}
    public Grid(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		setBackgroundColor(Color.parseColor("#bbada0"));
		initGame();
	}

	public void randAddCard()
	{
		Random rand=new Random(System.currentTimeMillis());
		while (!isFull())
		{
			int x=rand.nextInt(4);
			int y=rand.nextInt(4);
			if (card[x][y].getNum() == 0)
			{
				if (rand.nextFloat() < 0.1)
				{
					card[x][y].setNum(4);
				}
				else
				{
					card[x][y].setNum(2);
				}
				break;
			}
		}
	}
	
	public void afterMoveAdd()
	{
		if(isMoved)
		{
			randAddCard();
			isMoved=false;
			if(os!=null)
			{
				os.score(score);
			}
		}
	}

	public void addCard()
	{
		for (int i=0;i < 4;i++)
		{
			for (int j=0;j < 4;j++)
			{
				Card c=new Card(getContext());
				c.setNum(0);
				addView(c, new ViewGroup.LayoutParams(num, num));
				card[i][j] = c;
			}
		}
		randAddCard();
		randAddCard();
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh)
	{
		super.onSizeChanged(w, h, oldw, oldh);
		cardWidth = w / 4;
		cardHeight = h / 4;
		num = Math.min(cardHeight, cardWidth);
		addCard();
	}

	public void swipLeft()
	{
		for (int i=0;i < 4;i++)
		{
			for (int j=0;j < 3;j++)
			{
				if (card[i][j + 1].getNum() != 0)
				{
					for (int x=j + 1;x > 0;x--)
					{
						if (card[i][x - 1].getNum() == 0)
						{
							card[i][x - 1].setNum(card[i][x].getNum());
							card[i][x].setNum(0);
							isMoved=true;
						}
					}
				}
			}
		}

		for (int i=0;i < 4;i++)
		{
			for (int j=0;j < 3;j++)
			{
				if (card[i][j].getNum() != 0)
				{
					if (card[i][j].equals(card[i][j + 1]))
					{
						card[i][j].setNum(card[i][j].getNum() * 2);
						card[i][j + 1].setNum(0);
						score=score+card[i][j].getNum();
						isMoved=true;
					}
				}
			}
		}

		for (int i=0;i < 4;i++)
		{
			for (int j=0;j < 3;j++)
			{
				if (card[i][j + 1].getNum() != 0)
				{
					for (int x=j + 1;x > 0;x--)
					{
						if (card[i][x - 1].getNum() == 0)
						{
							card[i][x - 1].setNum(card[i][x].getNum());
							card[i][x].setNum(0);
							isMoved=true;
						}
					}
				}
			}
		}
		afterMoveAdd();
		System.out.println(count);
	}

	public void swipRight()
	{
		for (int i=0;i < 4;i++)
		{
			for (int j=3;j > 0;j--)
			{
				if (card[i][j - 1].getNum() != 0)
				{
					for (int x=j - 1;x < 3;x++)
					{
						if (card[i][x + 1].getNum() == 0)
						{
							card[i][x + 1].setNum(card[i][x].getNum());
							card[i][x].setNum(0);
							isMoved=true;
						}
					}
				}
			}
		}

		for (int i=0;i < 4;i++)
		{
			for (int j=3;j > 0;j--)
			{
				if (card[i][j].getNum() != 0)
				{
					if (card[i][j].equals(card[i][j - 1]))
					{
						card[i][j].setNum(card[i][j].getNum() * 2);
						card[i][j - 1].setNum(0);
						score=score+card[i][j].getNum();
						isMoved=true;
					}
				}
			}
		}
		for (int i=0;i < 4;i++)
		{
			for (int j=3;j > 0;j--)
			{
				if (card[i][j - 1].getNum() != 0)
				{
					for (int x=j - 1;x < 3;x++)
					{
						if (card[i][x + 1].getNum() == 0)
						{
							card[i][x + 1].setNum(card[i][x].getNum());
							card[i][x].setNum(0);
							isMoved=true;
						}
					}
				}
			}
		}
		afterMoveAdd();
	}

	public boolean isFull()
	{
		isfull = true;
		for (int i=0;i < 4;i++)
		{
			for (int j=0;j < 4;j++)
			{
				if (card[i][j].getNum() == 0)
				{
					isfull = false;
					return isfull;
				}
			}
		}
		return isfull;

	}

	public void swipUp()
	{
		for (int i=0;i < 3;i++)
		{
			for (int j=0;j < 4;j++)
			{
				if (card[i + 1][j].getNum() != 0)
				{
					for (int y=i + 1;y > 0;y--)
					{
						if (card[y-1][j].getNum() == 0)
						{
							card[y - 1][j].setNum(card[y][j].getNum());
							card[y][j].setNum(0);
							isMoved=true;
						}
					}
				}
			}
		}

		for (int i=0;i < 3;i++)
		{
			for (int j=0;j < 4;j++)
			{
				if (card[i][j].getNum() != 0)
				{
					if (card[i][j].equals(card[i + 1][j]))
					{
						card[i][j].setNum(card[i][j].getNum() * 2);
						card[i + 1][j].setNum(0);
						score=score+card[i][j].getNum();
						isMoved=true;
					}
				}
			}
		}
		for (int i=0;i < 3;i++)
		{
			for (int j=0;j < 4;j++)
			{
				if (card[i + 1][j].getNum() != 0)
				{
					for (int y=i + 1;y > 0;y--)
					{
						if (card[y-1][j].getNum() == 0)
						{
							card[y - 1][j].setNum(card[y][j].getNum());
							card[y][j].setNum(0);
							isMoved=true;
						}
					}
				}
			}
		}
		afterMoveAdd();
	}

	public void swipDown()
	{
		for (int i=3;i > 0;i--)
		{
			for (int j=0;j < 4;j++)
			{
				if (card[i - 1][j].getNum() != 0)
				{
					for (int y=i - 1;y <3;y++)
					{
						if (card[y+1][j].getNum() == 0)
						{
							card[y+1][j].setNum(card[y][j].getNum());
							card[y][j].setNum(0);
							isMoved=true;
						}
					}
				}
			}
		}

		for (int i=3;i >0;i--)
		{
			for (int j=0;j < 4;j++)
			{
				if (card[i][j].getNum() != 0)
				{
					if (card[i][j].equals(card[i - 1][j]))
					{
						card[i][j].setNum(card[i][j].getNum() * 2);
						card[i - 1][j].setNum(0);
						score=score+card[i][j].getNum();
						isMoved=true;
					}
				}
			}
		}
		for (int i=3;i > 0;i--)
		{
			for (int j=0;j < 4;j++)
			{
				if (card[i - 1][j].getNum() != 0)
				{
					for (int y=i - 1;y <3;y++)
					{
						if (card[y+1][j].getNum() == 0)
						{
							card[y+1][j].setNum(card[y][j].getNum());
							card[y][j].setNum(0);
							isMoved=true;
						}
					}
				}
			}
		}
		afterMoveAdd();
	}

	public void initGame()
	{
		setColumnCount(4);
		setOnTouchListener(new OnTouchListener(){
				float currentX = 0,currentY = 0,offsetX=0,offsetY=0;
				@Override
				public boolean onTouch(View p1, MotionEvent event)
				{
					switch (event.getAction())
					{
						case MotionEvent.ACTION_DOWN:
							currentX = event.getX();
							currentY = event.getY();
							break;
						case MotionEvent.ACTION_UP:
							offsetX = event.getX() - currentX;
							offsetY = event.getY() - currentY;
							if (Math.abs(offsetX) > Math.abs(offsetY))
							{
								if (offsetX < -5)
								{
									System.out.println("左");
									swipLeft();
								}
								else if (offsetX > 5)
								{
									System.out.println("右");
									swipRight();
								}
							}
							else
							{
								if (offsetY < -5)
								{
									System.out.println("上");
									swipUp();
								}
								else if (offsetY > 5)
								{
									System.out.println("下");
									swipDown();
								}
							}
							break;
					}
					return true;
				}
			});
	}

}
