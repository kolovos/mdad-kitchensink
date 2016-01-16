package com.kitchensink.network;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import com.kitchensink.R;
import com.kitchensink.R.layout;
import com.kitchensink.R.menu;
import com.kitchensink.util.KitchenSinkActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class AdcActivity extends KitchenSinkActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adc);
		
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				try {
					URL url = new URL("http://www-module.cs.york.ac.uk/soar/public/adc/");
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("PUT");
					OutputStream os = conn.getOutputStream();
					os.write("<note title=\"Some title\" description=\"Some description\"/>".getBytes());
					os.close();
					final String response = new java.util.Scanner(conn.getInputStream()).useDelimiter("\\A").next();
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							Toast.makeText(AdcActivity.this, response, Toast.LENGTH_SHORT).show();
						}
					});
					
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}, 0);
		
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.adc, menu);
		return true;
	}

}
