package com.mycompany.myapp5;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.text.*;
import com.baidu.cyberplayer.sdk.*;
import android.view.View.*;
import android.view.*;
import android.content.*;
import android.net.*;

public class FileDetailActivity extends Activity
{
	private TextView textName,textSize,textMD,textDown;
	private FileInfo file;
	private BEngineManager bmr;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.file);
		BCyberPlayerFactory.init(this);
		bmr=BCyberPlayerFactory.createEngineManager();
		if(!bmr.EngineInstalled())
		{
			bmr.installAsync(new BEngineManager.OnEngineListener(){

					@Override
					public boolean onPrepare()
					{
						// TODO: Implement this method
						return true;
					}

					@Override
					public int onDownload(int p1, int p2)
					{
						// TODO: Implement this method
						return 0;
					}

					@Override
					public int onPreInstall()
					{
						// TODO: Implement this method
						return 0;
					}

					@Override
					public void onInstalled(int p1)
					{
						// TODO: Implement this method
					}
				});
		}
		findViewById(R.id.fileButton).setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					Intent i=new Intent();
					i.setAction(Intent.ACTION_VIEW);
					i.putExtra("isHW",true);
					Uri uri=Uri.parse(file.down);
					i.setClassName("com.baidu.cyberplayer.engine", "com.baidu.cyberplayer.engine.PlayingActivity");
					i.setData(uri);
					startActivity(i);
				}
			});
		textName=(TextView) findViewById(R.id.fileTextViewName);
	//	textTime=(TextView) findViewById(R.id.fileTextViewTime);
		textSize=(TextView) findViewById(R.id.fileTextViewSize);
		textMD=(TextView) findViewById(R.id.fileTextViewMDFive);
		textDown=(TextView) findViewById(R.id.fileTextViewDown);
		file=(FileInfo) getIntent().getSerializableExtra("file");
		textSize.setText(file.size);
		textName.setText(file.name);
		textMD.setText(file.MD);
		if(file.down!=null)
		{
			textDown.setText(file.down);
		}
	//	textTime.setText(file.Time);
	}
}
