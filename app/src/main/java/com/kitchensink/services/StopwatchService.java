package com.kitchensink.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class StopwatchService extends Service {
	
	@Override
	public IBinder onBind(Intent intent) {
		return new LocalBinder();
	}
	
	@Override
	public void onCreate() {
		Toast.makeText(this, "Created " + this, Toast.LENGTH_SHORT).show();
		super.onCreate();
	}
	
	@Override
	public void onDestroy() {
		Toast.makeText(this, "Destroyed " + this, Toast.LENGTH_SHORT).show();
		super.onDestroy();
	}
	
	public class LocalBinder extends Binder {
		
		public StopwatchService getService() {
			return StopwatchService.this;
		}
		
	}
	
}
