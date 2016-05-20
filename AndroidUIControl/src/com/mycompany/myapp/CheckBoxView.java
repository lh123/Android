package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;

public class CheckBoxView extends Activity
{
	private CheckBox cbYuWen,cbMath,cbChemical,cbPhysics;
	private Button btnSubmit;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.checkbox_view);
		cbChemical=(CheckBox) findViewById(R.id.cbChemical);
		cbYuWen=(CheckBox) findViewById(R.id.cbYuWen);
		cbMath=(CheckBox) findViewById(R.id.cbMath);
		cbPhysics=(CheckBox) findViewById(R.id.cbPhysics);
		btnSubmit=(Button) findViewById(R.id.cbButtonSubmit);
		btnSubmit.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					StringBuffer string=new StringBuffer("你喜欢的科目有:\n");
					if(cbYuWen.isChecked())
					{
						string.append("语文\n");
					}
					if(cbChemical.isChecked())
					{
						string.append("化学\n");
					}
					if(cbMath.isChecked())
					{
						string.append("数学\n");
					}
					if(cbPhysics.isChecked())
					{
						string.append("物理\n");
					}
					System.out.println( string.toString());//debug
					string.delete(string.length()-1,string.length());
					new AlertDialog.Builder(CheckBoxView.this).setTitle("提示").setMessage(string.toString()).setPositiveButton("确定",null).show();
				}
			});
	}
	
}
