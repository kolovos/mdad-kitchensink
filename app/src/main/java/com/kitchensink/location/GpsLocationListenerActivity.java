package com.kitchensink.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import com.kitchensink.R;
import com.kitchensink.util.KitchenSinkActivity;

public class GpsLocationListenerActivity extends KitchenSinkActivity {

	protected TextView gpsLocationTextView;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_location_listener);
	gpsLocationTextView = findTextViewById(R.id.gpsLocationTextView);
	
	LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
	LocationListener locationListener = new LocationListener() {
					
		public void onLocationChanged(Location location) {
			gpsLocationTextView.setText("GPS location: " + 
					location.getLatitude() + " / " + 
					location.getLongitude() + " / " + 
					location.getAltitude() +  " @ " + location.getAccuracy());
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {}
		public void onProviderEnabled(String provider) {}
		public void onProviderDisabled(String provider) {}
	};
	
	if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
		gpsLocationTextView.setText("Waiting for GPS location...");
	}
	else { gpsLocationTextView.setText("GPS location unavailable"); }

}

}
