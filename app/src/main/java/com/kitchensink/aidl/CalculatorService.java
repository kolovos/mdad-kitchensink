package com.kitchensink.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class CalculatorService extends Service {
	
	@Override
	public IBinder onBind(Intent intent) {
		return new ICalculatorService.Stub() {

			@Override
			public int add(int a, int b) throws RemoteException {
				return a + b;
			}

			@Override
			public double average(double[] doubles) throws RemoteException {
				
				if (doubles.length == 0) return 0;
				
				double sum = 0;
				for (double d : doubles) {
					sum+=d;
				}
				return sum / doubles.length;
			}
		};
	}
	
}
