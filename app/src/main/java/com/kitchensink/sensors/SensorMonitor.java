package com.kitchensink.sensors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SensorMonitor implements SensorEventListener {
	
	protected String name;
	protected ArrayList<SensorValueMonitor> valueMonitors = new ArrayList<SensorValueMonitor>();
	protected int sensorType;
	protected ArrayList<SensorMonitorListener> sensorMonitorListeners = new ArrayList<SensorMonitorListener>();
	protected Sensor sensor = null;
	protected String str = "";
	//private float[] values = new float[]{0.0f, 0.0f, 0.0f};
	
	public SensorMonitor(String name, int sensorType, SensorValueMonitor... valueMonitors) {
		this.name = name;
		this.sensorType = sensorType;
		//this.valueMonitors.addAll(Arrays.asList(valueMonitors));
	}
	
	public String getName() {
		return name;
	}
	
	public int getSensorType() {
		return sensorType;
	}
	
	public ArrayList<SensorValueMonitor> getValueDescriptors() {
		return valueMonitors;
	}
	
	public void start(Context context) {
		SensorManager sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
		
		sensor = sensorManager.getDefaultSensor(sensorType);
		
		if (sensor != null) {
			sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
		}
		
	}
	
	protected SensorValueMonitor getSensorValueMonitor(int index) {
		for (SensorValueMonitor monitor : valueMonitors) {
			if (monitor.getIndex() == index) {
				return monitor;
			}
		}
		return null;
	}
	
	public void stop(Context context) {
		if (sensor != null) {
			SensorManager sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
			sensorManager.unregisterListener(this);
		}
	}
	
	public void addSensorMonitorListener(SensorMonitorListener listener) {
		sensorMonitorListeners.add(listener);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		
	}

	public void setValues(float[] values) {
		//if (name.equalsIgnoreCase("Light"))
		//System.out.println("Setting " + name + " values to " + Arrays.toString(values));
		//this.values = values;
		str = name + "\n";
		for (int i=0;i<values.length;i++) {
			str += "  " + values[i];
			if (i<values.length-1) {
				str += "\n";
			}
		}
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		if (event.sensor.getType() == this.sensorType) {
			//System.out.println("Values for " + name + " " + Arrays.toString(event.values));
			setValues(event.values);
		}
		/*
		for (int i=0;i<values.length;i++) {
			SensorValueMonitor monitor = getSensorValueMonitor(i);
			if (monitor != null) {
				monitor.setValue(values[i]);
			}
		}*/
		//for (SensorMonitorListener listener : sensorMonitorListeners) {
		//	listener.onSensorMonitorChanged(SensorMonitor.this);
		//}
	}
	
	public String getValueMonitorsAsString() {
		String str = "";
		ListIterator<SensorValueMonitor> li = valueMonitors.listIterator();
		while (li.hasNext()) {
			str += li.next().toString();
			if (li.hasNext()) str = str + "\n";
		}
		return str;
	}
	
	@Override
	public String toString() {
		
		if (sensor == null) {
			return name + " sensor not supported";
		}
		else {
			
			return str;
		}
	}
	
}
