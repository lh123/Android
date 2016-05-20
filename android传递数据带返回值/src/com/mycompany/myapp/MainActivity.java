package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;
import android.content.*;

public class MainActivity extends Activity
{
	private int RESULT_CODE=1;
	private EditText one,two,result;
	private Button button;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		one=(EditText)this.findViewById(R.id.mainEditText1);
		two=(EditText)this.findViewById(R.id.mainEditText2);
		result=(EditText)this.findViewById(R.id.mainEditTextResult);
		button=(Button)this.findViewById(R.id.mainButton);
		button.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					int oned,twod;
					// TODO: Implement this method
					try
					{
						oned=Integer.parseInt(one.getText().toString());
						twod=Integer.parseInt(two.getText().toString());
					}
					catch (NumberFormatException e)
					{
						oned=0;
						twod=0;
						one.setText("0");
						two.setText("0");
						Toast.makeText(MainActivity.this,"数字默认为0",1).show();
					}
					Intent intent=new Intent(MainActivity.this, OtherActivity.class);
					intent.putExtra("one",oned);
					intent.putExtra("two",twod);
					startActivityForResult(intent,RESULT_CODE);
				}
			});
    }
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		// TODO: Implement this method
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==2)
		{
			if(requestCode==RESULT_CODE)
			{
				int three=data.getIntExtra("three",0);
				result.setText(String.valueOf(three));
			}
		}
	}
	
}
