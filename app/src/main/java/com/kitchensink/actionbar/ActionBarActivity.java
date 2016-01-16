package com.kitchensink.actionbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.kitchensink.R;
import com.kitchensink.util.KitchenSinkActivity;

public class ActionBarActivity extends KitchenSinkActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_action_bar);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// R.menu.action_bar -> menu/action_bar.xml
		getMenuInflater().inflate(R.menu.action_bar, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// The id of the selected item
		switch (item.getItemId()) {
			case R.id.action_start: toast("Start"); break;
			case R.id.action_stop: toast("Stop"); break;
			case R.id.action_pause: toast("Pause"); break;
			case R.id.action_shuffle: toast("Shuffle"); break;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
