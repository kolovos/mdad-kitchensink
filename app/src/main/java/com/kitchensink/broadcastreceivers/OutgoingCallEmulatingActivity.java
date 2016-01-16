package com.kitchensink.broadcastreceivers;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;

import com.kitchensink.R;
import com.kitchensink.util.KitchenSinkActivity;

public class OutgoingCallEmulatingActivity extends KitchenSinkActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_outgoing_call_emulating);
		Intent intent = new Intent(Intent.ACTION_NEW_OUTGOING_CALL);
        intent.putExtra(Intent.EXTRA_PHONE_NUMBER, "01234567890");
        LocalBroadcastManager.getInstance(this).registerReceiver(new LastOutgoingCallMonitor(), new IntentFilter(Intent.ACTION_NEW_OUTGOING_CALL));
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
	}
	
}
