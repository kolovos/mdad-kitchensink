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
import android.support.v4.content.LocalBroadcastManager;
import android.telephony.SmsManager;
import android.view.Menu;

public class IncomingSmsLoggerActivity extends Activity {

	protected IncomingSmsLogger logger = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_incoming_sms_logger);
		
		logger = new IncomingSmsLogger();
		// Register the receiver
		registerReceiver(logger, 
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

}
