package com.lh.camera;

import android.app.*;
import android.os.*;
import android.view.*;
import java.io.*;
import android.content.*;
import android.provider.*;
import android.net.*;
import android.widget.*;

public class MainActivity extends Activity
{
	private File file;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
	
	public void click(View view)
	{
		Intent intent=new Intent();
		intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
		file=new File(Environment.getExternalStorageDirectory(),"hh.jpg");
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
		startActivityForResult(intent,0);
	}

	public void clickV(View view)
	{
		Intent intent=new Intent();
		intent.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
		file=new File(Environment.getExternalStorageDirectory(),"hh.mp4");
		intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
		startActivityForResult(intent,1);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		Toast.makeText(this,file.getAbsolutePath(),0).show();
		super.onActivityResult(requestCode, resultCode, data);
	}
}
