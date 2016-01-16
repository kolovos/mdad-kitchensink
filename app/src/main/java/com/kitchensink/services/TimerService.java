package com.kitchensink.services;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.widget.Toast;

public class TimerService extends Service {
	
	public static final String SECONDS = "seconds";
	public static final String PARALLEL = "parallel";
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		Toast.makeText(this, "Created " + this, Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		TimerTask timerTask = new TimerTask() {
			protected void onProgressUpdate(Integer... values) {
				System.out.println("Progress update " + values[0]);
				if (values[0] == timeout) {
					Toast.makeText(TimerService.this, timeout + " seconds elapsed", Toast.LENGTH_SHORT).show();
					//TimerService.this.stopSelf();
				}
			}
		};
		
		int seconds = intent.getIntExtra(TimerService.SECONDS, 5);
		
		if (intent.getBooleanExtra(TimerService.PARALLEL, false)) {
			timerTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, seconds);
		}
		else {
			timerTask.execute(seconds);
		}
		
		return START_NOT_STICKY;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(this, "Destroyed " + this, Toast.LENGTH_SHORT).show();
	}
	
}
