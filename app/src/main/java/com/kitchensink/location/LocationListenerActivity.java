package com.kitchensink.location;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.kitchensink.R;
import com.kitchensink.R.layout;
import com.kitchensink.R.menu;
import com.kitchensink.util.KitchenSinkActivity;

import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.TextView;

public class LocationListenerActivity extends KitchenSinkActivity {

	//protected TextView gpsLocationTextView;
	//protected TextView networkLocationTextView;
	//protected TextView passiveLocationTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location_listener);
		
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		new LocationMonitor("GPS", LocationManager.GPS_PROVIDER, findTextViewById(R.id.gpsLocationTextView)) {
			@Override
			public void onLocationChanged(final Location location) {
				super.onLocationChanged(location);
				Geocoder geocoder = new Geocoder(LocationListenerActivity.this);
				try {
					List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
					if (!addresses.isEmpty()) {
						Address address = addresses.get(0);
						findTextViewById(R.id.addressTextView).setText(address.toString());
					}
					else {
						findTextViewById(R.id.addressTextView).setText("No address found for this location");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		new LocationMonitor("Network", LocationManager.NETWORK_PROVIDER, findTextViewById(R.id.networkLocationTextView));
		new LocationMonitor("Passive", LocationManager.PASSIVE_PROVIDER, findTextViewById(R.id.passiveLocationTextView));
		
		Criteria criteria = new Criteria();
		criteria.setAltitudeRequired(false);
		criteria.setCostAllowed(false);
		criteria.setPowerRequirement(Criteria.POWER_MEDIUM);
		String bestProvider = locationManager.getBestProvider(criteria, true);
		new LocationMonitor(bestProvider, bestProvider, findTextViewById(R.id.bestProviderLocationTextView));
		
		if (locationManager.isProviderEnabled("Test")) {
			locationManager.removeTestProvider("Test");
		}
		locationManager.addTestProvider("Test", false, false, false,
				false, false, false, false, 
				Criteria.POWER_LOW, Criteria.ACCURACY_FINE);
		new LocationMonitor("Test", "Test", findTextViewById(R.id.testProviderLocationTextView));
		locationManager.setTestProviderEnabled("Test", true);
		Location location = new Location("Test");
		location.setLatitude(10.0);
		location.setLongitude(20.0);
		location.setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos());
		location.setTime(System.currentTimeMillis());
		location.setAccuracy(10f);
		locationManager.setTestProviderLocation("Test", location);
		
		
		
	}
	
	class LocationMonitor implements LocationListener{
		
		protected String label;
		protected String provider;
		protected TextView textView;
		
		public LocationMonitor(final String label, final String provider, final TextView textView) {
			
			this.label = label;
			this.provider = provider;
			this.textView = textView;
			monitor();
		}
		
		public void monitor() {
			LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
			if (locationManager.isProviderEnabled(provider)) {
				locationManager.requestLocationUpdates(provider, 0, 0, this);
				textView.setText("Waiting for " + label + " location...");
			}		
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {}
		
		@Override
		public void onProviderEnabled(String provider) {}
		
		@Override
		public void onProviderDisabled(String provider) {}
		
		@Override
		public void onLocationChanged(Location location) {
			textView.setText(label + " location: " + 
					location.getLatitude() + " / " + 
					location.getLongitude() + " / " + 
					location.getAltitude() +  " / " + 
					location.getSpeed() + " / " +
					location.getBearing() + " / " + 
					location.getAccuracy());
		}
		
	}
	
}
