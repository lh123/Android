package com.mycompany.myapp;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.content.*;
import java.io.*;
import android.util.*;

public class OtherActivity extends Activity
{
	TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);
		text=(TextView)this.findViewById(R.id.otherTextView);
		ClipboardManager clip=(ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
		String string="";
		string=clip.getText().toString();
		byte[] bytedate=Base64.decode(string,Base64.DEFAULT);
		ByteArrayInputStream byteinput=new ByteArrayInputStream(bytedate);
		try
		{		
			ObjectInputStream objectinput=new ObjectInputStream(byteinput);
			MyClass mydate=(MyClass)objectinput.readObject();
			text.setText(mydate.toString());
		}
		catch (Exception e)
		{}
	}
}
