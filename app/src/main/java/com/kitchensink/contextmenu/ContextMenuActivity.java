package com.kitchensink.contextmenu;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.AdapterContextMenuInfo;

import com.kitchensink.R;
import com.kitchensink.util.KitchenSinkActivity;

public class ContextMenuActivity extends KitchenSinkActivity {
	
	protected String[] fruits = new String[]{"Apple", "Orange", "Pear"};
	protected ListView fruitsListView;
	protected ArrayAdapter<String> fruitsListViewAdapter = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_context_menu);
		
		fruitsListView = (ListView) findViewById(R.id.listView);
		fruitsListViewAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_list_item_1, fruits);
		fruitsListView.setAdapter(fruitsListViewAdapter);
		registerForContextMenu(fruitsListView);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
	    MenuInflater inflater = getMenuInflater();
	    // R.menu.context_menu -> menu/context_menu.xml
	    inflater.inflate(R.menu.context_menu, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		String action = "";
		switch (item.getItemId()) {
			case R.id.action_duplicate: action = "Duplicate"; break;
			case R.id.action_edit: action = "Edit"; break;
			case R.id.action_delete: action = "Delete"; break;
			default: action = "Unknown action on";
		}
		
		// Get the selected fruit using the item's menu info
		// Note: fruitListView.getSelectedItem() will return null here
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
		String selectedFruit = (String) fruitsListView.getItemAtPosition((int) info.position);

		toast(action + " " + selectedFruit);
		return super.onContextItemSelected(item);
	}
	
}
