package com.kitchensink.util;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;

public abstract class DelayedLoaderCallbacks<T> implements LoaderCallbacks<T>{
	
	protected T t;
	protected int delay;
	protected Context context;
	
	public DelayedLoaderCallbacks(Context context, T t, int delay) {
		this.context = context;
		this.t = t;
		this.delay = delay;
	}
	
	@Override
	public Loader<T> onCreateLoader(int arg0, Bundle arg1) {
		return new DelayedAsyncTaskLoader<T>(context, t, delay);
	}

	@Override
	public abstract void onLoadFinished(Loader<T> loader, T t);

	@Override
	public void onLoaderReset(Loader<T> arg0) {}

}
