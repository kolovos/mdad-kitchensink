package com.kitchensink.timertask;

import java.util.Timer;
import java.util.TimerTask;

import com.kitchensink.R;
import com.kitchensink.R.id;
import com.kitchensink.R.layout;
import com.kitchensink.util.KitchenSinkActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class TimerTaskActivity extends KitchenSinkActivity {
	
	protected int counter;
	protected TextView textView;
	protected Timer timer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timer_task);
		
		textView = findTextViewById(R.id.textView);
		final Handler handler = new Handler() {
			@Override
			public void dispatchMessage(Message msg) {
				textView.setText(msg.getData().getInt("counter") + "");
			}
		};
		
		timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				Message message = new Message();
				counter ++;
				message.getData().putInt("counter", counter);
				handler.sendMessage(message);
			}
		}, 0, 1000);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		timer.cancel();
	}

}
