package com.kitchensink.ksoap2;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kitchensink.R;

public class KSOAP2Activity extends Activity {
	
	protected EditText stockEditText = null;
	protected TextView currentTextView = null;
	protected TextView minTextView = null;
	protected TextView maxTextView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ksoap2);
		
		stockEditText = (EditText) findViewById(R.id.stockEditText);
		currentTextView = (TextView) findViewById(R.id.currentTextView);
		minTextView = (TextView) findViewById(R.id.minTextView);
		maxTextView = (TextView) findViewById(R.id.maxTextView);
		
		Button fetchButton = (Button) findViewById(R.id.fetchButton);
		fetchButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				final String stock = stockEditText.getText().toString();
				
				// We are going to invoke a web service over the network
				// We can't access the network in the UI thread so we need
				// to start a new thread for this
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							fetchStockData(stock);
						}
						catch (Exception ex) {
							Toast.makeText(KSOAP2Activity.this, 
								"Unable to retrieve stock data.", Toast.LENGTH_SHORT)
								.show();
						}
					}
				}).start();
			}
		});
		
	}
	
	public void fetchStockData(String stock) throws Exception {
		// The WSDL for this web service is located under
		// http://www-module.cs.york.ac.uk/soar/public/ws/stocks/stocks.wsdl
		// First parameter is the namespace of the web service in the WSDL:
		//   <xsd:schema targetNamespace="http://stockexchange.ws.soar">
		// Second parameter is the name of the service operation we wish to invoke
		//   <operation name="getStockPrice">
		SoapObject request = new SoapObject("http://stockexchange.ws.soar", "getStockPrice");
	    request.addProperty("stock", stock);
	    
	    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	    envelope.setOutputSoapObject(request);
	    
	    // The parameter is the URL of the web service
	    HttpTransportSE transport = new HttpTransportSE(
	    		"http://www-module.cs.york.ac.uk/soar/public/ws/stocks/");
	    // Call the web service
	    transport.call("", envelope);
	
	    final SoapObject obj = (SoapObject) envelope.getResponse();
	    
	    // We now need to update the UI
	    // We need to do this through the UI thread
	    runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				currentTextView.setText("Current: " + obj.getProperty("current"));
				minTextView.setText("Min: " + obj.getProperty("min"));
				maxTextView.setText("Max: " + obj.getProperty("max"));
			}
		});
	}
	
}
