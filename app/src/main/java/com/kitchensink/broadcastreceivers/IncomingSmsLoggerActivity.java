package com.kitchensink.broadcastreceivers;

import com.kitchensink.R;
import com.kitchensink.R.layout;
import com.kitchensink.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.view.Menu;
import android.widget.TextView;

public class IncomingSmsLoggerActivity extends Activity {

	protected IncomingSmsLogger logger = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_incoming_sms_logger);

		// Register the receiver
		registerReceiver(new LocalSmsLogger(new Handler()),
				new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(logger);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.incoming_sms_logger_registration, menu);
		return true;
	}

	class LocalSmsLogger extends BroadcastReceiver {

		Handler handler = null;

		public LocalSmsLogger(Handler handler) {
			this.handler = handler;
		}

		@Override
		public void onReceive(Context context, Intent intent) {
			handler.post(new Runnable() {
				@Override
				public void run() {
					TextView v = (TextView) IncomingSmsLoggerActivity.this.findViewById(R.id.smsNumberTextView);
					v.setText("Message received!");
				}
			});
		}
	}

}
