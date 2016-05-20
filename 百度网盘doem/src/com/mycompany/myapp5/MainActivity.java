package com.mycompany.myapp5;

import android.app.*;
import android.content.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.widget.AdapterView.*;
import com.baidu.oauth.*;
import com.baidu.pcs.*;
import java.io.*;
import org.json.*;

import android.view.View.OnClickListener;

public class MainActivity extends Activity
{
	private final String mbApiKey = "L6g70tBRRIXLsY0Z3HwKqlRE";//请替换申请客户端应用时获取的Api Key串
	private final String mbRootPath =  "/apps/pcstest_oauth"; //用户测试的根目录
	private String mbOauth=null;
	private ListView ls;
	private String currentPath="/apps/pcstest_oauth";
	private Myhandle handle=new Myhandle();
	final BaiduPCSClient client=new BaiduPCSClient();
	private MyAdapter adapter=new MyAdapter(MainActivity.this);
	private ProgressBar pb;

    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		checkLogn();
		findViewById(R.id.mainButtonUpLoad).setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
					intent.setType("*/*");// 文件类型	 

					//i.addCategory(Intent.CATEGORY_OPENABLE);
					startActivityForResult(intent, 1);
				}
			});
		findViewById(R.id.mainButtonBack).setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					if (!currentPath.equals(mbRootPath))
					{
						int last=currentPath.lastIndexOf("/");

						final String lastPath=currentPath.substring(0, last);
						new Thread(){
							public void run()
							{
								openDir(lastPath);
							}
						}.start();
					}
				}
			});
		findViewById(R.id.mainButtonCreatDir).setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					final View v=LayoutInflater.from(getApplicationContext()).inflate(R.layout.edit, null);
					new AlertDialog.Builder(MainActivity.this).setTitle("新建文件夹").setView(v).setPositiveButton("确定", new DialogInterface.OnClickListener(){

							@Override
							public void onClick(DialogInterface p1, int p2)
							{
								String name=((EditText)v).getText().toString();
								final String path=currentPath + "/" + name;
								new Thread(){
									public void run()
									{
										client.makeDir(path);
										openDir(currentPath);
									}
								}.start();
							}
						}).setNegativeButton("取消", null).show();

				}
			});
		ls = (ListView) findViewById(R.id.mainListView1);
		ls.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
				{
					MyAdapter adapter=(MyAdapter) p1.getAdapter();
					BaiduPCSActionInfo.PCSCommonFileInfo info= adapter.getItem(p3);
					if (info.isDir)
					{
						final String tempPath=info.path;
						new Thread(){
							public void run()
							{
								openDir(tempPath);
							}
						}.start();
						//adapter.notifyDataSetChanged();
					}
					else
					{
						Intent i=new Intent();
						FileInfo singlefile=new FileInfo();
						singlefile.name = MyAdapter.getFileName(info);
						singlefile.down = null;
						singlefile.size = Long.toString(info.size);
						singlefile.MD = info.blockList;
						if(getGeS(info.path).equals("mp4"))
						{
							BaiduPCSActionInfo.PCSStreamingURLResponse p= client.getStreamingURL(info.path,BaiduPCSClient.Type_Media_MP4_480P);
							if(p.status.errorCode==0)
							{
								singlefile.down=p.url;
							}
						}
						i.putExtra("file", singlefile);
						i.setClass(MainActivity.this, FileDetailActivity.class);
						startActivity(i);
					}
				}
			});
		ls.setOnItemLongClickListener(new OnItemLongClickListener(){

				@Override
				public boolean onItemLongClick(AdapterView<?> p1, View p2, final int p3, long p4)
				{
					new AlertDialog.Builder(MainActivity.this).setTitle("确定删除").setMessage(MyAdapter.getFileName(adapter.getItem(p3))).setNegativeButton("取消", null).setPositiveButton("确定", new DialogInterface.OnClickListener(){

							@Override
							public void onClick(DialogInterface p1, int p2)
							{
								new Thread(){
									public void run()
									{
										if (client.deleteFile(adapter.getItem(p3).path).errorCode == 0)
										{
											handle.sendEmptyMessage(0);
										}
										openDir(adapter.getItem(p3).path.replace(MyAdapter.getFileName(adapter.getItem(p3)), ""));
										handle.sendEmptyMessage(2);
									}
								}.start();
							}
						}).show();
					return true;
				}
			});
		pb = (ProgressBar) findViewById(R.id.mainProgressBar);
		findViewById(R.id.mainButtonlogn).setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					BaiduOAuth oauthClient=new BaiduOAuth();
					oauthClient.startOAuth(MainActivity.this, mbApiKey, new String[]{"basic", "netdisk"}, new BaiduOAuth.OAuthListener(){

							@Override
							public void onComplete(BaiduOAuth.BaiduOAuthResponse p1)
							{
								if (p1 != null)
								{
									mbOauth = p1.getAccessToken();
									System.out.println(mbOauth);
									client.setAccessToken(mbOauth);
									File file=new File("/storage/emulated/0/text.txt");
									try
									{
										FileWriter fw=new FileWriter(file);
										JSONObject jo=new JSONObject();
										try
										{
											jo.put("oauth", mbOauth);
											fw.write(jo.toString());
											fw.close();
										}
										catch (JSONException e)
										{}

									}
									catch (IOException e)
									{}
								}
							}

							@Override
							public void onException(String p1)
							{
								// TODO: Implement this method
							}

							@Override
							public void onCancel()
							{
								Toast.makeText(getApplicationContext(), "Login cancelled", Toast.LENGTH_SHORT).show();
							}
						});
				}
			});
		findViewById(R.id.mainButton).setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					if (mbOauth != null)
					{
						final BaiduPCSClient client=new BaiduPCSClient();
						client.setAccessToken(mbOauth);
						Thread thread=new Thread(){
							@Override
							public void run()
							{
								BaiduPCSActionInfo.PCSQuotaResponse quotainfo= client.quota();
								long total=quotainfo.total;
								long used=quotainfo.used;
								int percent= (int)(used * 100 / total);
								pb.setProgress(percent);
								System.out.println(total);
							}
						};
						thread.start();
					}
				}
			});
		findViewById(R.id.mainButtonList).setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					new Thread(){
						public void run()
						{
							openDir(mbRootPath);
							//adapter.notifyDataSetChanged();
						}
					}.start();
				}
			});
	}
	public void checkLogn()
	{
		File file=new File("/storage/emulated/0/text.txt");
		try
		{
			FileInputStream fis=new FileInputStream(file);
			InputStreamReader ir=new InputStreamReader(fis);
			BufferedReader br=new BufferedReader(ir);
			JSONObject jobj=new JSONObject(br.readLine());
			if (!jobj.isNull("oauth"))
			{
				mbOauth = jobj.getString("oauth");
				client.setAccessToken(mbOauth);
				System.out.println(mbOauth);
			}
			br.close();
			ir.close();
			fis.close();
		}
		catch (JSONException e)
		{}
		catch (IOException e)
		{}
	}
	public class Myhandle extends Handler
	{

		@Override
		public void handleMessage(Message msg)
		{

			if (msg.what == 1)
			{
				ls.setAdapter((MyAdapter)msg.obj);
				adapter.notifyDataSetChanged();
			}
			else if (msg.what == 2)
			{
				adapter.notifyDataSetChanged();
			}
			else if (msg.what == 0)
			{
				Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
			}
			else if (msg.what == 3)
			{
				uploadFile((String)msg.obj);
			}
			else if (msg.what == 4)
			{
				Toast.makeText(MainActivity.this, "上传成功", Toast.LENGTH_SHORT).show();
			}
			else if(msg.what==5)
			{
				Toast.makeText(MainActivity.this,"读取成功",Toast.LENGTH_SHORT).show();
			}
			super.handleMessage(msg);
		}

	}
	public void openDir(final String path)
	{
		BaiduPCSActionInfo.PCSListInfoResponse listinfo=client.list(path, "time", "asc");
		//List<FileInfo> listr=new List<FileInfo>();
		//ArrayAdapter<FileInfo> adapter=new ArrayAdapter<FileInfo>(MainActivity.this,android.R.layout.simple_list_item_1);
		if(listinfo.status.errorCode==0)
		{
			handle.sendEmptyMessage(5);
			adapter.setFile(listinfo);
			currentPath = path;
			handle.sendMessage(handle.obtainMessage(1, adapter));
		}
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		if (requestCode == 1 && resultCode == -1)
		{
			Uri url=data.getData();
			String path=url.getPath();
			//uploadFile(path);
			handle.sendMessage(handle.obtainMessage(3, path));
		}

		super.onActivityResult(requestCode, resultCode, data);
	}

	public void uploadFile(final String path)
	{
		Thread thread=new Thread(){
			public void run()
			{
				BaiduPCSActionInfo.PCSFileInfoResponse p= client.uploadFile(path, currentPath + "/" + getFileName(path), new BaiduPCSStatusListener(){

						@Override
						public void onProgress(long byteq, long total)
						{
							System.out.println(byteq * 100 / total);
						}
					});
				if (p.status.errorCode == 0)
				{
					handle.sendEmptyMessage(4);
				}
				else
				{
					System.out.println(p.status.message);
				}
				openDir(currentPath);
			}
		};
		thread.start();
	}
	public String getFileName(String path)
	{
		int last=path.lastIndexOf("/");
		return path.substring(last + 1, path.length());
	}
	public String getGeS(String path)
	{
		int last=path.lastIndexOf(".");
		String temp=path.substring(last+1,path.length());
		temp=temp.toLowerCase();
		return temp;
	}

}
