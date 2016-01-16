package com.kitchensink.gestures;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.TextView;

import com.kitchensink.R;
import com.kitchensink.util.KitchenSinkActivity;
import com.kitchensink.util.LargeTextViewActivity;

public class ScaleDetectorActivity extends LargeTextViewActivity {

	protected ScaleGestureDetector scaleDetector;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		scaleDetector = new ScaleGestureDetector(this, new ScaleGestureDetector.SimpleOnScaleGestureListener() {
			
			// The current zoom level
			protected float zoom = Float.parseFloat(textView.getText().toString());
			
			@Override
			public boolean onScale(ScaleGestureDetector detector) {
				// Calculate the difference between the current span and the one before it
				float difference = (detector.getCurrentSpan() - detector.getPreviousSpan());
				// Add the difference to the zoom
				zoom = zoom + difference;
				// Update the zoom text view
				textView.setText(Math.round(zoom) + "");
				return true;
			}
		});
		
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		scaleDetector.onTouchEvent(event);
		return super.onTouchEvent(event);
	}

}
