package com.kitchensink.sensors;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.hardware.Sensor;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.kitchensink.R;

public class SensorsActivity extends Activity {
	
	protected ListView sensorMonitorsListView;
	protected TextView temperatureTextView;
	protected SensorMonitor[] sensorMonitors = new SensorMonitor[] {
			new SensorMonitor("Light", Sensor.TYPE_LIGHT, new SensorValueMonitor(0, "Intensity")),
			//new SensorMonitor("Pressure", Sensor.TYPE_PRESSURE, new SensorValueMonitor(0, "Intensity")),
			new SensorMonitor("Gravity", Sensor.TYPE_GRAVITY, new SensorValueMonitor(0, "X"), new SensorValueMonitor(1, "Y"), new SensorValueMonitor(2, "Z")),
			new SensorMonitor("Accelerometer", Sensor.TYPE_ACCELEROMETER, new SensorValueMonitor(0, "X"), new SensorValueMonitor(1, "Y"), new SensorValueMonitor(2, "Z")),
			new SensorMonitor("Magnetic field", Sensor.TYPE_MAGNETIC_FIELD),
			//new SensorMonitor("Ambient temperature", Sensor.TYPE_AMBIENT_TEMPERATURE),
			new SensorMonitor("Proximity", Sensor.TYPE_PROXIMITY),
			new SensorMonitor("Gyroscope", Sensor.TYPE_GYROSCOPE),
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensors);
		
		sensorMonitorsListView = (ListView) findViewById(R.id.sensorMonitorsListView);
		

		
		
		for (SensorMonitor monitor : sensorMonitors) {
//			monitor.addSensorMonitorListener(new SensorMonitorListener() {
//				@Override
//				public void onSensorMonitorChanged(SensorMonitor sensorMonitor) {
//					((ArrayAdapter<SensorMonitor>) sensorMonitorsListView.getAdapter()).notifyDataSetChanged();
//				}
//			});
			monitor.start(this);
		}
		
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						
						final ArrayAdapter<SensorMonitor> adapter = new ArrayAdapter<SensorMonitor>(SensorsActivity.this, 
								android.R.layout.simple_list_item_1, sensorMonitors);
						
						sensorMonitorsListView.setAdapter(adapter);
						//((ArrayAdapter<SensorMonitor>) sensorMonitorsListView.getAdapter()).notifyDataSetChanged();
					}
				});
			}
		}, 0, 1000);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.environment_sensors, menu);
		return true;
	}

}
