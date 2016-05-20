package com.lh.mysocket;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class MainActivity extends Activity 
{
	private Handler handler=new Handler(){

		@Override
		public void handleMessage(Message msg)
		{
			if(msg.what==1)
			{
				tvMessage.append((String)msg.obj+"\n\r");
			}
		}
	};
	private SocketClient socketClient;
	private MySocketService mySocketService;
	private EditText edIp,edContent;
	private Button btnCon,btnSend;
	private TextView tvMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		edIp=(EditText) findViewById(R.id.scoket_ip);
		edContent=(EditText) findViewById(R.id.message);
		tvMessage=(TextView) findViewById(R.id.tv_content);
		btnCon=(Button) findViewById(R.id.btn_connect);
		btnSend=(Button) findViewById(R.id.btn_send);
		socketClient=new SocketClient(handler);
		
		edIp.setText("127.0.0.1");
		btnCon.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					socketClient.initSocket(edIp.getText().toString());
				}
			});
		btnSend.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					
					socketClient.sendMessage(edContent.getText().toString());
					edContent.setText("");
				}
			});
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		menu.add("启动服务");
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item)
	{
		mySocketService=MySocketService.getService();
		mySocketService.startService();
		Toast.makeText(MainActivity.this,"启动服务器",Toast.LENGTH_SHORT).show();
		return true;
	}
	
}
