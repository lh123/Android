package com.lh.mydropmenu;

import android.app.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.util.*;

public class MainActivity extends Activity implements OnClickListener
{
	private EditText editText;
	private ImageButton imageButton;
	private List<String> myData;
	private ListView listView;
	private PopupWindow popup;
	private MyAdapter adapter;
	private boolean popuIsShow=false;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		editText=(EditText) findViewById(R.id.ed_text);
		imageButton=(ImageButton) findViewById(R.id.btn_drop);
		//initListView();
		//initPopupWindows();
		imageButton.setOnClickListener(this);
    }
	public void initListView()
	{
		listView=new ListView(this);
		myData=new ArrayList<String>();
		for(int i=0;i<15;i++)
		{
			myData.add("test+"+(i+1));
		}
		adapter=new MyAdapter();
		listView.setDivider(null);
		listView.setBackgroundColor(Color.RED);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new ListView.OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
				{
					editText.setText(myData.get(p3));
					popup.dismiss();
					popuIsShow=false;
				}
			});
	}

	@Override
	public void onClick(View p1)
	{
		if(!popuIsShow)
		{
			initPopupWindows();
			popuIsShow=true;
		}
		else
		{
			popuIsShow=false;
			popup.dismiss();
		}
	}
	
	public void initPopupWindows()
	{
		initListView();
		popup=new PopupWindow();
		popup.setContentView(listView);
		popup.setWidth(editText.getWidth());
		popup.setHeight(200);
		popup.setBackgroundDrawable(new BitmapDrawable());
		popup.setOutsideTouchable(true);
		popup.showAsDropDown(editText,0,0);
	}
	private class MyAdapter extends BaseAdapter
	{
		@Override
		public int getCount()
		{
			return myData.size();
		}

		@Override
		public String getItem(int p1)
		{
			return myData.get(p1);
		}

		@Override
		public long getItemId(int p1)
		{
			return p1;
		}

		@Override
		public View getView( final int p1, View p2, ViewGroup p3)
		{
			View view=null;
			if(p2==null)
			{
				view=View.inflate(MainActivity.this,R.layout.item,null);
			}
			else
				view=p2;
			TextView t=(TextView) view.findViewById(R.id.itemTextView);
			view.findViewById(R.id.itemImageButton).setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View view)
					{
						myData.remove(p1);
						adapter.notifyDataSetChanged();
						if(myData.size()==0)
							popup.dismiss();
							popuIsShow=false;
					}
				});
			t.setText(getItem(p1));
			return view;
		}
	}
}
