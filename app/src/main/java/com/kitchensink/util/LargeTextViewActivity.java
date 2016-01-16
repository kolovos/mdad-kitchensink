package com.kitchensink.util;

import android.os.Bundle;
import android.widget.TextView;

import com.kitchensink.R;

public class LargeTextViewActivity extends KitchenSinkActivity {
	
	protected TextView textView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_large_text_view);
		textView = findTextViewById(R.id.textView);
	}
}
