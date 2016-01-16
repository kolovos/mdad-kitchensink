package com.kitchensink.layouts;

import com.kitchensink.R;
import com.kitchensink.R.layout;
import com.kitchensink.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class LayoutsActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_layouts_linear_horizontal);
		//setContentView(R.layout.activity_layouts_linear_vertical);
		setContentView(R.layout.activity_layouts_relative);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.layouts, menu);
		return true;
	}

}
