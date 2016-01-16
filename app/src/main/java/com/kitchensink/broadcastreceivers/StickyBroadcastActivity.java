package com.kitchensink.broadcastreceivers;

import java.util.Calendar;

import com.kitchensink.R;
import com.kitchensink.R.layout;
import com.kitchensink.R.menu;
import com.kitchensink.util.KitchenSinkActivity;
import com.kitchensink.util.Worker;

import android.os.BatteryManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;

public class StickyBroadcastActivity extends KitchenSinkActivity {
	
	public static final String CUSTOM_EVENT = "com.kitchensink.CustomEvent1";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sticky_broadcast);
	}
	
	public void sendStickyBroadcast(View view) {
		Intent intent = new Intent(CUSTOM_EVENT);
		intent.putExtra("now", Calendar.getInstance().getTime() + "");
		sendStickyBroadcast(intent);
		
		final BroadcastReceiver receiver = new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				toast(intent.getExtras().getString("now"));
				unregisterReceiver(this);
			}
		};
		// At this point the broadcast still sticks around
		// and will be dispatched to the receiver
		registerReceiver(receiver, new IntentFilter(CUSTOM_EVENT));
	}
	
	public void sendRegularBroadcast(View view) {
		
		Intent intent = new Intent(CUSTOM_EVENT);
		intent.putExtra("now", Calendar.getInstance().getTime() + "");
		sendBroadcast(intent);
		
		final BroadcastReceiver receiver = new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				toast(intent.getExtras().getString("now"));
				unregisterReceiver(this);
			}
		};
		// At this point the broadcast has been dispatched and lost
		registerReceiver(receiver, new IntentFilter(CUSTOM_EVENT));
	}
	
}
