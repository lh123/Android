package com.mycompany.myapp5;
import android.widget.*;
import android.view.*;
import com.baidu.pcs.*;
import android.content.*;

public class MyAdapter extends BaseAdapter
{

	private BaiduPCSActionInfo.PCSListInfoResponse p;
	private Context context;

	public MyAdapter(Context context)
	{
		this.context = context;
	}
	public void setFile(BaiduPCSActionInfo.PCSListInfoResponse p)
	{
		this.p = p;
	}
	@Override
	public int getCount()
	{
		// TODO: Implement this method
		return p.list.size();
	}

	@Override
	public BaiduPCSActionInfo.PCSCommonFileInfo getItem(int p1)
	{
		// TODO: Implement this method
		return p.list.get(p1);
	}

	@Override
	public long getItemId(int p1)
	{
		// TODO: Implement this method
		return p1;
	}

	@Override
	public View getView(int p1, View p2, ViewGroup p3)
	{
		if (p2 == null)
		{
			p2 = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, null);
		}
		((TextView)p2).setText(getFileName(getItem(p1)));
		
		return p2;
	}
	public static String getFileName(BaiduPCSActionInfo.PCSCommonFileInfo fileinfo)
	{
		String path=fileinfo.path;
		int last=path.lastIndexOf("/");
		return path.substring(last + 1, path.length());
	}
}
