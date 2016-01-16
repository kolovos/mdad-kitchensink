package com.kitchensink.sensors;

public class SensorValueMonitor {
	
	protected int index;
	protected String title;
	protected float value;
	
	public SensorValueMonitor(int index, String title) {
		super();
		this.index = index;
		this.title = title;
	}

	public int getIndex() {
		return index;
	}
	
	public String getTitle() {
		return title;
	}
	
	public float getValue() {
		return value;
	}
	
	public void setValue(float value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return title + ": " + value;
	}
}
