package com.mycompany.myapp;
import android.widget.*;
import android.view.*;
import android.content.*;
import java.util.zip.*;
import android.media.*;

public class ListBaseAdapter extends BaseAdapter
{
	
	private Context context=null;
	private ListViewData[] data=new ListViewData[]{
		new ListViewData("item1", "item detail", R.drawable.ic_launcher),
		new ListViewData("item2", "item detail", R.drawable.ic_launcher),
		new ListViewData("item3", "item detail", R.drawable.ic_launcher)
	};

	public ListBaseAdapter(Context context)
	{
		this.context = context;
	}

	public void setContext(Context context)
	{
		this.context = context;
	}

	public Context getContext()
	{
		return context;
	}
	@Override
	public int getCount()
	{
		// TODO: Implement this method
		return data.length;
	}

	@Override
	public ListViewData getItem(int p1)
	{
		// TODO: Implement this method
		return data[p1];
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
		ImageView icon;
		TextView name;
		TextView detail;
		LinearLayout ll;
		if (p2 == null)
		{
			ll=(LinearLayout) LinearLayout.inflate(context,R.layout.list,null);
//			LayoutInflater layout=LayoutInflater.from(context);
//			ll = (LinearLayout) layout.inflate(R.layout.list,null);
		}
		else
		{
			ll = (LinearLayout) p2;
		}
		
		name=(TextView) ll.findViewById(R.id.name);
		detail=(TextView) ll.findViewById(R.id.detail);
		icon=(ImageView) ll.findViewById(R.id.listImageView);
		icon.setImageResource(getItem(p1).getIconId());
		name.setText(getItem(p1).getName());
		detail.setText(getItem(p1).getDetail());
//		detail.setText("hello");
		return ll;
	}
}

