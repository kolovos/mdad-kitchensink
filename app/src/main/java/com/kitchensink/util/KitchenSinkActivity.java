package com.kitchensink.util;

import android.app.Activity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class KitchenSinkActivity extends Activity {
	
	public void toast(String s) {
		Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
	}
	
	public Button findButtonById(int id) {
		return (Button) findViewById(id);
	}
	
	public TextView findTextViewById(int id) {
		return (TextView) findViewById(id);
	}
	
	public EditText findEditTextById(int id) {
		return (EditText) findViewById(id);
	}
	
	public ListView findListViewById(int id) {
		return (ListView) findViewById(id);
	}
	
	public void log(Exception ex) {
		Log.e(getClass().getCanonicalName(), ex.getMessage(), ex);
	}
	
	public void debug(Object o) {
		Log.d("DBG", o + "");
	}
	
}
