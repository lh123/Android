package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;

public class AtyAutoCompleteTextView extends Activity
{
	private AutoCompleteTextView actv;
	private MultiAutoCompleteTextView mactv;
	private ArrayAdapter<String> adapter,madapter;
	private String[] date;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.autocompletetext_view);
		date=new String[]{
			"Android",
			"ios",
			"Windows",
			"Java",
			"c#",
			"JavaScript",
			"PHP",
			"Windows Phone"
		};
		actv=(AutoCompleteTextView) findViewById(R.id.autocompletetextview);
		mactv=(MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
		adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line);
		actv.setAdapter(adapter);
		adapter.addAll(date);
		madapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line);
		madapter.addAll(date);
		mactv.setAdapter(madapter);
		mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
	
	}
}
