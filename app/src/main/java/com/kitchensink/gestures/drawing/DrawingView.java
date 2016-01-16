package com.kitchensink.gestures.drawing;

import java.util.ArrayList;
import java.util.List;

import android.R.color;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class DrawingView extends View {

	protected List<Path> paths = new ArrayList<Path>();
	
	public DrawingView(Context context, AttributeSet attributeSet) {
		super(context, attributeSet);
	}
	
	public void draw(List<Path> paths) {
		this.paths = paths;
		invalidate();
	}
	
	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		
		Paint paint = new Paint();
		paint.setColor(0xFFFF0000);
		paint.setAntiAlias(true);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeJoin(Paint.Join.ROUND);
		paint.setStrokeCap(Paint.Cap.ROUND);
		paint.setStrokeWidth(12);
        
		for (Path path : paths) {
			canvas.drawPath(path, paint);
		}
	}
	
}
