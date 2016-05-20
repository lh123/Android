package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.hardware.*;
import java.awt.*;

public class MainActivity extends Activity 
{
	private AlertDialog dialog;
	private Camera camera;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		dialog=new AlertDialog.Builder(this).setTitle("jj").setMessage("hhh").setIcon(R.drawable.ic_launcher).create();
		dialog.show();
		camera= Camera.open();
    }
}
