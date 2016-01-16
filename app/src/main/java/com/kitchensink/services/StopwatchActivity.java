package com.kitchensink.services;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Button;
import android.widget.TextView;

import com.kitchensink.R;
import com.kitchensink.services.StopwatchService.LocalBinder;

public class StopwatchActivity extends Activity {

	protected TextView stopwatchTextView;
	protected Button startButton;
	protected Button stopButton;
	protected StopwatchService stopwatchService;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stopwatch);
		
		startButton = (Button) findViewById(R.id.startButton);
		stopButton = (Button) findViewById(R.id.stopButton);
		stopwatchTextView = (TextView) findViewById(R.id.stopwatchTextView);
		
		
		ServiceConnection connection = new ServiceConnection() {
			
			@Override
			public void onServiceDisconnected(ComponentName name) {
				stopwatchService = null;
			}
			
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				stopwatchService = ((LocalBinder) service).getService();
			}
		};
		
		Intent intent = new Intent(this, StopwatchService.class);
		bindService(intent, connection, Context.BIND_AUTO_CREATE);
		unbindService(connection);
	}
	
}
