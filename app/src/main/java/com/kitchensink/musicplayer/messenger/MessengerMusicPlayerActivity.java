package com.kitchensink.musicplayer.messenger;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

import com.kitchensink.musicplayer.AbstractMusicPlayerActivity;

public class MessengerMusicPlayerActivity extends AbstractMusicPlayerActivity {

	protected Messenger messenger = null;
	protected ServiceConnection connection = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		connection = new ServiceConnection() {
			@Override
			public void onServiceDisconnected(ComponentName name) {
				messenger = null;
			}
			@Override
			public void onServiceConnected(ComponentName name, IBinder binder) {
				messenger = new Messenger(binder);
			}
		};
		
		Intent intent = new Intent(this, MessengerMusicPlayerService.class);
		startService(intent);
		bindService(intent, connection, Context.BIND_AUTO_CREATE);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		unbindService(connection);
	}
	
	@Override
	public void play(String song) {
		Message message = new Message();
		message.getData().putString("action", "play");
		message.getData().putString("song", song);
		try { messenger.send(message); }
		catch (Exception ex) { log(ex); }
	}

	@Override
	public void pause() {
		Message message = new Message();
		message.getData().putString("action", "pause");
		try { messenger.send(message); }
		catch (Exception ex) { log(ex); }
	}

	@Override
	public void stop() {
		Message message = new Message();
		message.getData().putString("action", "stop");
		try { messenger.send(message); }
		catch (Exception ex) { log(ex); }		
	}
	
	@Override
	public void showCurrentPosition() {
		Message message = new Message();
		message.getData().putString("action", "getCurrentPosition");
		message.getData().putParcelable("callback", new Messenger(new Handler() {
			@Override
			public void dispatchMessage(Message msg) {
				toast("Current position: " + msg.getData().getInt("currentPosition"));
			}
		}));
		try { messenger.send(message); }		
		catch (Exception ex) { log(ex); }		
	}
	
	@Override
	public int getCurrentPosition() {
		// We don't need to implement this
		// as we've implemented showCurrentPosition()
		return 0;
	}
	
}
