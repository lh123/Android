package com.lh.mytoggle;

import android.app.*;
import android.os.*;
import android.widget.*;

public class MainActivity extends Activity 
{
	private ToggleView toggleView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		toggleView=(ToggleView) findViewById(R.id.toggleView);
		//toggleView.setBackgroundID(R.drawable.switch_background);
		//toggleView.setSlideBackgroundID(R.drawable.slide_button_background);
		//toggleView.setStatus(true);
		toggleView.setOnToggleStatusChangeListener(new ToggleView.OnToggleStatusChangeListener(){

				@Override
				public void statusChange(boolean status)
				{
					Toast.makeText(MainActivity.this,""+status,0).show();
				}
			});
		}
}
