package com.lh.game;

import android.app.*;
import android.os.*;
import com.lh.*;
import android.widget.*;

public class MainActivity extends Activity 
{
	private TextView tvScore;
	private Grid grid;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		tvScore=(TextView) findViewById(R.id.tv_score);
		grid=(Grid) findViewById(R.id.grid);
		grid.setOnScoreChangeListener(new Grid.onScoreChangeListener(){

				@Override
				public void score(int score)
				{
					tvScore.setText("分数:"+score);
				}
			});
    }
}
