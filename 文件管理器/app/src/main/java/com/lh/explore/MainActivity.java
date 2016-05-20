package com.lh.explore;

import android.app.*;
import android.os.*;
import java.io.*;
import android.widget.*;
import java.util.*;

public class MainActivity extends Activity 
{
	private ListView listv;
	ArrayAdapter<File> adapter;
	long startTime,endTime;
	private Handler handler=new Handler(){

		@Override
		public void handleMessage(Message msg)
		{
			switch (msg.what)
			{
				case 1:
					adapter.add((File)msg.obj);
					adapter.notifyDataSetChanged();
					listv.setSelection(adapter.getCount()-1);
					break;
				case 2:
					Toast.makeText(getApplicationContext(), adapter.getCount() + "个,花费:"+(endTime-startTime), Toast.LENGTH_SHORT).show();
					break;
				case 3:
					adapter.addAll((ArrayList<File>)msg.obj);
					adapter.notifyDataSetChanged();
					break;
			}
		}

	};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		listv = (ListView) findViewById(R.id.mainListView);
		adapter = new ArrayAdapter<File>(getApplicationContext(), android.R.layout.simple_list_item_1);
		listv.setAdapter(adapter);
		Toast.makeText(getApplicationContext(), "正在加载", Toast.LENGTH_LONG).show();
		new Thread(new Runnable(){

				@Override
				public void run()
				{
					startTime=System.currentTimeMillis();
					//getFile("/storage/emulated/0/.aide");
					//getFileNo("/storage/emulated/0/.aide");
					getFileSearch("/storage/emulated/0/AppProjects","WAN口连接信息");
					endTime=System.currentTimeMillis();
					
					handler.sendEmptyMessage(2);
				}
			}).start();
    }

	public void getFile(String dir) //使用递归
	{
		File file=new File(dir);
		File[] list = file.listFiles();

		for (int i = 0;i < list.length;i++)
		{
			if (list[i].isDirectory())
			{
				getFile(list[i].getPath());
			}
			else
			{
				handler.sendMessage(handler.obtainMessage(1, list[i]));
			}
		}
	}
	
	public void getFileSearch(String dir,String key) //不使用递归
	{
		File file=new File(dir);
		File[] list=file.listFiles();
		ArrayList<File> fileArray=new ArrayList<File>();
		ArrayList<File> dirArray=new ArrayList<File>();
		for(int i=0;i<list.length;i++)
		{
			if(list[i].isDirectory())
				dirArray.add(list[i]);
			else
			{
				try
				{
					FileInputStream fi=new FileInputStream(list[i]);
					InputStreamReader isr=new InputStreamReader(fi);
					String tempkey;
					int raw=0;
					BufferedReader br=new BufferedReader(isr);
					while((tempkey=br.readLine())!=null)
					{
						raw++;
						int index=0;
						if((index=tempkey.indexOf(key))>=0)
						{
							System.out.println("路径:"+list[i].getPath()+"第"+raw+"行,位置:"+index);
							fileArray.add(list[i]);
						}
					}
				}
				catch (Exception e)
				{}
				
			}
		}
		for(int i=0;i<dirArray.size();i++)
		{
			File[] temp;
			if(dirArray.get(i).isDirectory())
			{
				temp=dirArray.get(i).listFiles();
				for(int j=0;j<temp.length;j++)
				{
					if(temp[j].isDirectory())
						dirArray.add(temp[j]);
					else
					{
						try
						{
							FileInputStream fi=new FileInputStream(temp[j]);
							InputStreamReader isr=new InputStreamReader(fi);
							String tempkey;
							BufferedReader br=new BufferedReader(isr);
							int raw=0;
							while((tempkey=br.readLine())!=null)
							{
								int index=0;
								raw++;
								if((index=tempkey.indexOf(key))>=0)
								{

									System.out.println("路径:"+temp[j].getPath()+"第"+raw+"行,位置:"+index);
									fileArray.add(temp[j]);
								}
							}
						}
						catch (Exception e)
						{}
						
					}
				}
			}
		}
		handler.sendMessage(handler.obtainMessage(3,fileArray));
	}
	
	public void getFileNo(String dir) //不使用递归
	{
		File file=new File(dir);
		File[] list=file.listFiles();
		ArrayList<File> fileArray=new ArrayList<File>();
		ArrayList<File> dirArray=new ArrayList<File>();
		for(int i=0;i<list.length;i++)
		{
			if(list[i].isDirectory())
				dirArray.add(list[i]);
			else
				fileArray.add(list[i]);
		}
		for(int i=0;i<dirArray.size();i++)
		{
			File[] temp;
			if(dirArray.get(i).isDirectory())
			{
				temp=dirArray.get(i).listFiles();
				for(int j=0;j<temp.length;j++)
				{
					if(temp[j].isDirectory())
						dirArray.add(temp[j]);
					else
						fileArray.add(temp[j]);
				}
			}
		}
		handler.sendMessage(handler.obtainMessage(3,fileArray));
	}
}
