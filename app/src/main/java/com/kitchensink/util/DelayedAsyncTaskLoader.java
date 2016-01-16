package com.kitchensink.util;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

public class DelayedAsyncTaskLoader<T> extends AsyncTaskLoader<T> {

	protected T t;
	protected int delay = 0;
	
	public DelayedAsyncTaskLoader(Context context, T t, int delay) {
		super(context);
		this.t = t;
		this.delay = delay;
	}
	
	@Override
	protected void onStartLoading() {
		forceLoad();
	}
	
	@Override
	public T loadInBackground() {
		try { Thread.sleep(delay); }
		catch (Exception ex) {}
		return t;
	}

}
