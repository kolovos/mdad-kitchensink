package com.kitchensink.intents;

import com.kitchensink.R;
import com.kitchensink.R.id;
import com.kitchensink.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewMessageActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_viewmessage);
		TextView messageTextView = (TextView) findViewById(R.id.messageTextView);
		messageTextView.setText(getIntent().getStringExtra("message"));
	
	}
	
}
