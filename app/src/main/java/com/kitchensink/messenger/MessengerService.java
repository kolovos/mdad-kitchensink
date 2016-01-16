package com.kitchensink.messenger;

import java.util.Date;

import com.kitchensink.util.Worker;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

public class MessengerService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		// Work for two seconds
		Worker.work(2);
		
		Messenger messenger = (Messenger) intent.getParcelableExtra("messenger");
		Message message = new Message();
		Bundle data = new Bundle();
		data.putString("when", new Date().toString());
		Messenger ackMessenger = new Messenger(new Handler() {
			@Override
			public void handleMessage(Message msg) {
				System.out.println("Ack received");
			}
		});
		data.putParcelable("ackMessenger", ackMessenger);
		message.setData(data);
		
		try {
			messenger.send(message);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
		
		return START_NOT_STICKY;
	}

}
