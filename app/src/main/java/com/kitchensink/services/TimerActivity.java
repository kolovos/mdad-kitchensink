package com.kitchensink.services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;

import com.kitchensink.R;

public class TimerActivity extends Activity {
	
	protected SeekBar timeoutSeekBar = null;
	protected CheckBox parallelCheckBox = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timer);
		timeoutSeekBar = (SeekBar) findViewById(R.id.timeoutSeekBar);
		parallelCheckBox = (CheckBox) findViewById(R.id.parallelCheckBox);
	}

	public void startButtonOnClick(View v) {
		Intent intent = new Intent(this, TimerService.class);
		intent.putExtra(TimerService.SECONDS, timeoutSeekBar.getProgress());
		intent.putExtra(TimerService.PARALLEL, parallelCheckBox.isChecked());
		startService(intent);
	}
	
	public void stopButtonOnClick(View v) {
		Intent intent = new Intent(this, TimerService.class);
		stopService(intent);
	}
	
}
