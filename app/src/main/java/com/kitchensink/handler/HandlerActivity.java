package com.kitchensink.handler;

import com.kitchensink.R;
import com.kitchensink.R.id;
import com.kitchensink.R.layout;
import com.kitchensink.R.menu;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class HandlerActivity extends Activity {
	
	protected Handler handler;
	protected TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_handler);
		handler = new Handler();
		textView = (TextView) findViewById(R.id.textView);
	}
	
	public void longRunningTask(View view) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				}
				catch (Exception ex) {}
				
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						textView.setText("The result is 42");
					}
				});
			}
		}).start();		
	}
	
	/*
	public void longRunningTask(View view) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				}
				catch (Exception ex) {}
				
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						textView.setText("The result is 42");
					}
				});
			}
		}).start();
	}*/
	
}
