package com.kitchensink.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public abstract class InflateableView extends LinearLayout {
	
	public InflateableView(Context context) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) 
				context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(getLayout(), this, true);
		findViews();
	}
	
	protected abstract int getLayout();
	
	protected abstract void findViews();
}
