package com.kitchensink.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LastOutgoingCallMonitor extends BroadcastReceiver {
	
	protected String lastNumber;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// Keep the number called in the lastNumber field
		lastNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
	}

	public String getLastNumber() {
		return lastNumber;
	}
	
}
