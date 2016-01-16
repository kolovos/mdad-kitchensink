package com.kitchensink.intents;

import com.kitchensink.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class TwitterAccountDisplayActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_twitteraccountdisplay);
		
		TextView twitterUrlTextView = (TextView) findViewById(R.id.twitterUrlTextView);
		twitterUrlTextView.setText(getIntent().getDataString());
		
	}
	
}
