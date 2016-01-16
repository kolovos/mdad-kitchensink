package com.kitchensink.aidl;

import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.Menu;
import android.view.View;

import com.kitchensink.R;
import com.kitchensink.util.KitchenSinkActivity;

public class CalculatorAidlServiceActivity extends KitchenSinkActivity {
	
	protected ICalculatorService calculatorService = null;
	protected ServiceConnection calculatorServiceConnection = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator_aidl_service);
	}
	
	public void bind(View view) {
		
		toast("Binding...");
		
		calculatorServiceConnection = new ServiceConnection() {
			
			@Override
			public void onServiceDisconnected(ComponentName name) {
				calculatorService = null;
				toast("Disconnected");
				
			}
			
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				calculatorService = ICalculatorService.Stub.asInterface(service);
				toast("Bound");
			}
		};
		
		bindService(new Intent(CalculatorAidlServiceActivity.this, CalculatorService.class), calculatorServiceConnection, BIND_AUTO_CREATE);
		
	}
	
	public void unbind(View view) {
		unbindService(calculatorServiceConnection);
		calculatorService = null;
		toast("Unbound");
	}
	
	public void add(View view) {
		try {
			toast("5+3=" + calculatorService.add(5, 3));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void average(View view) {
		try {
			toast("avg(1,2,4)=" + calculatorService.average(new double[]{1,2,4}));
		} catch (RemoteException e) {
			e.printStackTrace();
		}		
	}
	
}
