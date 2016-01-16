package com.kitchensink.gestures.drawing;

import java.util.ArrayList;

import android.graphics.Path;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import com.kitchensink.R;
import com.kitchensink.util.KitchenSinkActivity;

public class DrawingActivity extends KitchenSinkActivity {
	
	protected DrawingView drawingView = null;
	protected ArrayList<Path> paths = new ArrayList<Path>();
	protected Path currentPath = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drawing);
		drawingView = (DrawingView) findViewById(R.id.drawingView);
		drawingView.setOnTouchListener(createOnTouchListener());
	}
	
	protected OnTouchListener createOnTouchListener() {
		return new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int action = MotionEventCompat.getActionMasked(event);
				
				if (event.getPointerCount() != 1) return false;
				
				if (action == MotionEvent.ACTION_DOWN) {
					currentPath = new Path();
					currentPath.moveTo(event.getX(), event.getY());
					paths.add(currentPath);
				}
				else if (action == MotionEvent.ACTION_MOVE) {
					currentPath.lineTo(event.getX(), event.getY());
					drawingView.draw(paths);
				}
				
				return true;
			}
		};
	}
	
}
