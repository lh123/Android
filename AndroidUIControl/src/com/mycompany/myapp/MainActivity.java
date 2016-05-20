package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;

public class MainActivity extends ListActivity
{
	private ArrayAdapter<ListData> adapter;
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		adapter=new ArrayAdapter<ListData>(this,android.R.layout.simple_list_item_1);
		setListAdapter(adapter);
		adapter.add(new ListData("RadioGroup",this,new Intent(MainActivity.this,RadioGroupView.class)));
		adapter.add(new ListData("CheckBox",this,new Intent(MainActivity.this,CheckBoxView.class)));
		adapter.add(new ListData("DatePicker",this,new Intent(MainActivity.this,Datepicker.class)));
		adapter.add(new ListData("TimePicker",this,new Intent(MainActivity.this,Timepicker.class)));
		adapter.add(new ListData("Spinner",this,new Intent(MainActivity.this,AtySpinner.class)));
		adapter.add(new ListData("ProgressBar",this,new Intent(MainActivity.this,AtyProgressBar.class)));
		adapter.add(new ListData("AutoCompleteText",this,new Intent(MainActivity.this,AtyAutoCompleteTextView.class)));
		adapter.add(new ListData("SeekBar",this,new Intent(MainActivity.this,AtySeekBar.class)));
		adapter.add(new ListData("GridView",this,new Intent(MainActivity.this,AtyGridView.class)));
		adapter.add(new ListData("ProgressDialog",this,new Intent(MainActivity.this,AtyProgressDialog.class)));
		adapter.add(new ListData("Notification(old api)",this,new Intent(MainActivity.this,AtyNotification.class)));
		adapter.add(new ListData("Notification(new api)",this,new Intent(MainActivity.this,AtyNotificationNew.class)));
		adapter.add(new ListData("ScrollView",this,new Intent(MainActivity.this,AtyScrollView.class)));
		adapter.add(new ListData("Service",this,new Intent(MainActivity.this,AtyServiceMyService.class)));
		adapter.add(new ListData("RatingBar",this,new Intent(MainActivity.this,AtyRatingBar.class)));
		adapter.add(new ListData("ImageSwitcher",this,new Intent(MainActivity.this,AtyImageSwitcher.class)));
		adapter.add(new ListData("Gallery",this,new Intent(MainActivity.this,AtyGallery.class)));
		adapter.add(new ListData("EditText",this,new Intent(MainActivity.this,AtyEditText.class)));
		adapter.add(new ListData("BaseAdapter",this,new Intent(MainActivity.this,AtyBaseAdapter.class)));
		adapter.add(new ListData("BroadCast",this,new Intent(MainActivity.this,AtyBroadCast.class)));
		adapter.add(new ListData("Toast",this,new Intent(MainActivity.this,AtyToast.class)));
		adapter.add(new ListData("CustomView",this,new Intent(MainActivity.this,AtyCustomView.class)));
		adapter.add(new ListData("TouchEvent",this,new Intent(MainActivity.this,AtyTouch.class)));
    }

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id)
	{
		// TODO: Implement this method
		ListData data=(ListData) l.getAdapter().getItem(position);
		data.startActivity();
		super.onListItemClick(l, v, position, id);
	}
	
}
