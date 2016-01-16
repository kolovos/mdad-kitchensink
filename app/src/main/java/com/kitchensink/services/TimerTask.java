package com.kitchensink.services;

import android.os.AsyncTask;

public class TimerTask extends AsyncTask<Integer, Integer, Void>{
	
	protected int timeout = 0;
	
	@Override
	protected Void doInBackground(Integer... params) {
		timeout = params[0];
		for (int i = 1; i<=timeout; i++) {
			try {
				Thread.sleep(1000);
			}
			catch (Exception ex) {}
			publishProgress(i);
		}
		return null;
	}
	
	public int getTimeout() {
		return timeout;
	}
	
}
