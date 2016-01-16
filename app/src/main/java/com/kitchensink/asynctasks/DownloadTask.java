package com.kitchensink.asynctasks;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;

public class DownloadTask 
	extends AsyncTask<String, Integer, Long>{
	
	protected List<DownloadProgressListener> listeners = 
			new ArrayList<DownloadProgressListener>();
	
	public void addListener(DownloadProgressListener listener) {
		listeners.add(listener);
	}
	
	public boolean removeListener(DownloadProgressListener listener) {
		return listeners.remove(listener);
	}
	
	@Override
	protected void onProgressUpdate(Integer... values) {
		super.onProgressUpdate(values);
		for (DownloadProgressListener listener : listeners) {
			listener.downloaded(values[0]);
		}
	}
	
	@Override
	protected Long doInBackground(String... params) {
		long downloaded = 0;
		for (String url : params) {
			if (isCancelled()) {
				System.out.println("Stopping");
				break;
			}
			try {
				download(url);
				downloaded ++;
			}
			catch (Exception ex) {}
			publishProgress((int) (100 * downloaded/params.length));
		}
		return downloaded;
	}
	
	protected long download(String url) {
		
		long now = System.currentTimeMillis();
		while (System.currentTimeMillis() - now < 5000) {
			System.out.print("");
		}
		
		/*
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		return url.length();
	}
}
