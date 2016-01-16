package com.kitchensink.messenger;

import com.kitchensink.R;
import com.kitchensink.R.layout;
import com.kitchensink.R.menu;
import com.kitchensink.util.KitchenSinkActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MessengerActivity extends KitchenSinkActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_messenger);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.messenger, menu);
		return true;
	}
	
	public void start(View view) {
		
		Messenger messenger = new Messenger(new Handler() {
			@Override
			public void handleMessage(Message msg) {
				toast("Started at " + msg.getData().getString("when"));
				
				Messenger ackMessenger = msg.getData().getParcelable("ackMessenger");
				try {ackMessenger.send(new Message());}
				catch (Exception ex) { ex.printStackTrace(); }
			}
		});
		
		Intent intent = new Intent(this, MessengerService.class);
		intent.putExtra("messenger", messenger);
		startService(intent);
		
	}
	
}
