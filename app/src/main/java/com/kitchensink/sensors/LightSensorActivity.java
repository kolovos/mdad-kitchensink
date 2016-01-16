package com.kitchensink.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import com.kitchensink.util.LargeTextViewActivity;

public class LightSensorActivity extends LargeTextViewActivity 
	implements SensorEventListener{
	
	protected SensorManager sensorManager;
	protected Sensor lightSensor = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		sensorManager = (SensorManager) 
			getSystemService(Context.SENSOR_SERVICE);
		lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
		textView.setText("");
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {}

	@Override
	public void onSensorChanged(SensorEvent event) {
		float lux = event.values[0];
		textView.setText(lux + "");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		sensorManager.registerListener(this, lightSensor, 
				SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		sensorManager.unregisterListener(this);		
	}
}
