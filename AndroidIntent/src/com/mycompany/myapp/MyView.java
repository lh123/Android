package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.webkit.*;
import android.content.*;

public class MyView extends Activity
{
	private WebView webview;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web);
		webview=(WebView) findViewById(R.id.webWebView);
		//Intent i= getIntent();
		webview.loadUrl("http://www.baidu.com");
		
	}
	
}
