package com.kitchensink.gestures;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

import com.kitchensink.R;
import com.kitchensink.util.KitchenSinkActivity;

public class GestureDetectorActivity extends KitchenSinkActivity {

	protected GestureDetectorCompat gestureDetector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gesture_detector);
		
		gestureDetector = new GestureDetectorCompat(this, new GestureDetector.SimpleOnGestureListener(){
			
			@Override
			public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
				toast("Fling: " + velocityX + " / " + velocityY);
				return super.onFling(e1, e2, velocityX, velocityY);
			}
			
			@Override
			public boolean onDoubleTap(MotionEvent e) {
				toast("Double tap");
				return super.onDoubleTap(e);
			}
			
			@Override
			public void onShowPress(MotionEvent e) {
				toast("Show press");
				super.onShowPress(e);
			}
			
		});
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		boolean handled = gestureDetector.onTouchEvent(event);
		if (handled) return true;
		else return super.onTouchEvent(event);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.fling, menu);
		return true;
	}

}
