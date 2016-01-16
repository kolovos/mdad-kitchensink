package com.kitchensink.network;

import java.util.Date;

import com.kitchensink.R;

import android.net.ConnectivityManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.ChannelListener;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class NetworkActivity extends Activity {

	protected TextView networkInfoTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_network);
		networkInfoTextView = (TextView) findViewById(R.id.networkInfoTextView);
		refresh();
	}

	public void refresh() {

		ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		networkInfoTextView.setText(connectivity.getActiveNetworkInfo().getTypeName() + 
				" " + connectivity.getActiveNetworkInfo().getExtraInfo() + " " + 
				connectivity.getActiveNetworkInfo().getSubtypeName() +
				new Date()) ;
		/*
		WifiP2pManager manager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
		manager.initialize(this, getMainLooper(), new ChannelListener() {
			
			@Override
			public void onChannelDisconnected() {
				networkInfoTextView.setText("Disconnected...");
			}
		});*/
		//)
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.action_refresh) {
			refresh();
		}
		return true;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.network, menu);
		return true;
	}

}
