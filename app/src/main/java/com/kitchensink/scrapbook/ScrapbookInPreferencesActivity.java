package com.kitchensink.scrapbook;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import com.kitchensink.R;

public class ScrapbookInPreferencesActivity extends Activity {

	protected EditText scrapbookEditText;
	protected String scrapbookFilename = "scrapbook.txt";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scrapbook);
		
		scrapbookEditText = (EditText) findViewById(R.id.scrapbookEditText);
		
		SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
		String scrapbookText = preferences.getString("scrapbook", "");
		scrapbookEditText.setText(scrapbookText);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = preferences.edit();
		editor.putString("scrapbook", scrapbookEditText.getText().toString());
		editor.commit();
	}
	
}
