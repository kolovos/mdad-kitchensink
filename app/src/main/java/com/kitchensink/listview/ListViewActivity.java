package com.kitchensink.listview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.kitchensink.R;

public class ListViewActivity extends Activity {
	
	protected List<String> fruits = null;
	protected ListView fruitsListView;
	protected ArrayAdapter<String> fruitsListViewAdapter = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);
		
		fruitsListView = (ListView) findViewById(R.id.fruitsListView);
		fruits = new ArrayList<String>();
		fruits.add("Apple");
		fruits.add("Orange");
		fruits.add("Pear");
		
		fruitsListViewAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_list_item_1, fruits);
		fruitsListView.setAdapter(fruitsListViewAdapter);
		
	}
	
	public void addFruitButtonOnClick(View view) {
		
		fruits.add("Banana");
		fruitsListViewAdapter.notifyDataSetChanged();
		
	}

}
