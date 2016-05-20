package com.mycompany.myapp;
import android.widget.*;
import android.view.*;
import android.content.*;

public class CustomAdapter extends BaseAdapter
{
	private Context context=null;
	Customlistdate[] data=new  Customlistdate[]{
		new Customlistdate("img1", "describe img1", R.drawable.img1),
		new Customlistdate("img2", "describe img2", R.drawable.img2),
		new Customlistdate("img3", "describe img3", R.drawable.img3)
	};

	public CustomAdapter(Context context)
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
	public Customlistdate getItem(int p1)
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
		LinearLayout ll=null;
		if (p2 == null)
		{
			ll = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.listwithimg, null);
			System.out.println("creat");
		}
		else
		{
			ll = (LinearLayout) p2;
		}
		Customlistdate data=getItem(p1);
		ImageView icon=(ImageView) ll.findViewById(R.id.listwithimgImageView);
		TextView name=(TextView) ll.findViewById(R.id.name);
		TextView des=(TextView) ll.findViewById(R.id.describe);
		icon.setImageResource(data.iconId);
		name.setText(data.name);
		des.setText(data.describe);
		return ll;
	}
}
