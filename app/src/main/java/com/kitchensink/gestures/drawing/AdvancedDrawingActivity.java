package com.kitchensink.gestures.drawing;

import android.graphics.Path;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class AdvancedDrawingActivity extends DrawingActivity {

	@Override
	protected OnTouchListener createOnTouchListener() {
		return new OnTouchListener() {

			protected boolean doubleTouch = false;
			protected boolean singleTouch = false;

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int action = MotionEventCompat.getActionMasked(event);
				int pointers = event.getPointerCount();
				// We don't care about events with more than 2 pointers
				if (pointers > 2) return false;

				if (action == MotionEvent.ACTION_UP && pointers == 1 && doubleTouch) {
					if (paths.size() > 0)
						paths.remove(paths.size() - 1);
					drawingView.draw(paths);
					doubleTouch = false;
					singleTouch = false;
				} else if (action == MotionEvent.ACTION_MOVE && pointers == 1 && singleTouch) {
					currentPath.lineTo(event.getX(), event.getY());
					drawingView.draw(paths);
				} else if (action == MotionEvent.ACTION_DOWN && pointers == 1) {
					singleTouch = true;
					currentPath = new Path();
					currentPath.moveTo(event.getX(), event.getY());
					paths.add(currentPath);
				} else if (action == MotionEvent.ACTION_POINTER_DOWN) {
					if (paths.size() > 0)
						paths.remove(paths.size() - 1);
					drawingView.draw(paths);
					singleTouch = false;
					doubleTouch = true;
				}

				return true;
			}
		};
	}

}
