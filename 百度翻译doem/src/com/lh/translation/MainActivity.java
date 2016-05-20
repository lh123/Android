package com.lh.translation;

import android.app.*;
import android.os.*;
import android.widget.*;
import java.net.*;
import android.view.*;
import java.io.*;
import org.json.*;
import android.widget.AdapterView.*;

public class MainActivity extends Activity
{
	public final String apiToken="tUVihLR9Y7aHxoMtgwICzdc6";
	public class Language
	{
		public int index;
		public String name;
		public String content;

		public Language(int index, String name, String content)
		{
			this.index = index;
			this.name = name;
			this.content = content;
		}
		@Override
		public String toString()
		{
			return this.name;
		}
	}
    private TextView tv;
	private Spinner sY,sA;
	private EditText edit;
	private String stringY="",stringA="";
	private URL url;
	private Thread thread;
	private HttpURLConnection connect;
	private JSONObject jsobj;
	private ArrayAdapter<Language> adapter;
	private String[] s;
	private Handler hand=new Handler(){

		@Override
		public void handleMessage(Message msg)
		{
			if(msg.what==1)
			{
			tv.setText(((StringBuffer)msg.obj).toString());
			super.handleMessage(msg);
			}
			else if(msg.what==2)
			{
				tv.setText("正在连接");
			}
			else if(msg.what==3)
			{
				tv.setText("连接超时");
			}
		}

	};
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		sY = (Spinner) findViewById(R.id.mainSpinnerYuan);
		sA = (Spinner) findViewById(R.id.mainSpinnerAim);
		tv = (TextView) findViewById(R.id.mainTextView);
		edit = (EditText) findViewById(R.id.mainEditText);
		adapter = new ArrayAdapter<Language>(this, android.R.layout.simple_spinner_dropdown_item);
		adapter.add(new Language(0, "自动", "auto"));
		adapter.add(new Language(1, "英语", "en"));
		adapter.add(new Language(2, "中文", "zh"));
		adapter.add(new Language(3, "日语", "jp"));
		adapter.add(new Language(4, "韩语", "kor"));
		adapter.add(new Language(5, "法语", "fra"));
		adapter.add(new Language(6, "文言文", "wyw"));
		adapter.add(new Language(7, "粤语", "yue"));
		adapter.add(new Language(8, "意大利语", "it"));
		adapter.add(new Language(9, "西班牙语", "spa"));
		adapter.add(new Language(10, "泰语", "th"));
		adapter.add(new Language(11, "荷兰语", "nl"));
		adapter.add(new Language(12, "希腊语", "el"));
		adapter.add(new Language(13, "葡萄牙语", "pt"));
		adapter.add(new Language(14, "阿拉伯语", "ara"));

		sA.setAdapter(adapter);
		sY.setAdapter(adapter);
		findViewById(R.id.btnGet).setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					thread = new Thread(){
						@Override
						public void run()
						{
							try
							{
								url = new URL("http://openapi.baidu.com/public/2.0/bmt/translate");
								connect = (HttpURLConnection) url.openConnection();
								connect.setRequestMethod("POST");
								connect.setDoInput(true);
								connect.setDoOutput(true);
								connect.setConnectTimeout(3000);
								//Message me=hand.obtainMessage(2,"正在连接");
								hand.sendEmptyMessage(2);
								OutputStreamWriter osw=new OutputStreamWriter(connect.getOutputStream(), "utf-8");
								osw.write(generateUrl(apiToken, edit, stringY, stringA));
								System.out.println(generateUrl(apiToken, edit, stringY, stringA));
								osw.flush();
								InputStream is=connect.getInputStream();
								InputStreamReader isr=new InputStreamReader(is, "utf-8");
								BufferedReader br=new BufferedReader(isr);
								String line="";
								StringBuffer data=new StringBuffer();
								StringBuffer datai=new StringBuffer();
								while ((line = br.readLine()) != null)
								{
									System.out.println(line);
									data.append(line);
								}
								try
								{
									jsobj = new JSONObject(data.toString());
									if (jsobj.isNull("error_code"))
									{
										JSONArray array=jsobj.getJSONArray("trans_result");
										for (int i=0;i < array.length();i++)
										{
											System.out.println("原文=" + ((JSONObject)array.get(i)).getString("src"));
											System.out.println("译文=" + ((JSONObject)array.get(i)).getString("dst"));
											datai.append(((JSONObject)array.get(i)).getString("dst"));
										}
									}
									else
									{
										int errorCode=jsobj.getInt("error_code");
										String errorMsg=jsobj.getString("error_msg");
										datai.append("错误码:"+errorCode+"\n");
										datai.append("错误信息:"+errorMsg);
									}
									Message m=hand.obtainMessage(1, datai);
									hand.sendMessage(m);

								}
								catch (JSONException e)
								{
									
								}

							}
							catch (IOException e)
							{
								System.out.println(e.getMessage());
								hand.sendEmptyMessage(3);
							}
						}
					};
					thread.start();
				}
			});
		sY.setOnItemSelectedListener(new OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
				{
					stringY = adapter.getItem(p3).content;
				}

				@Override
				public void onNothingSelected(AdapterView<?> p1)
				{
					// TODO: Implement this method
				}
			});
		sA.setOnItemSelectedListener(new OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
				{
					stringA = adapter.getItem(p3).content;
				}

				@Override
				public void onNothingSelected(AdapterView<?> p1)
				{
					// TODO: Implement this method
				}
			});
    }
	public String generateUrl(String apiToken, EditText edit, String y, String a)
	{
		return "client_id=" + apiToken + "&q=" + URLEncoder.encode(edit.getText().toString()) + "&from=" + y + "&to=" + a;
	}
}
