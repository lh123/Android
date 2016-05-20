package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;
import android.content.*;
import android.util.*;
import java.io.*;
import org.apache.http.entity.*;

public class MainActivity extends Activity
{
	Button btn;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		btn=(Button)this.findViewById(R.id.mainButton);
		btn.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					ClipboardManager clip=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
//					String name="jack";
//					clip.setText(name);
					MyClass mydaate=new MyClass("jack",25);
					ByteArrayOutputStream bytearray=new ByteArrayOutputStream();
					String base64_str="";
					try
					{
						ObjectOutputStream objectoutput=new ObjectOutputStream(bytearray);
						objectoutput.writeObject(mydaate);
						base64_str=Base64.encodeToString(bytearray.toByteArray(),Base64.DEFAULT);
						objectoutput.close();
					}
					catch (IOException e)
					{
					}
					clip.setText(base64_str);
					Intent intent=new Intent(MainActivity.this, OtherActivity.class);
					startActivity(intent);
				}
			});
    }
}
