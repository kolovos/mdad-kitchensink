package com.kitchensink.musicplayer.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

import com.kitchensink.musicplayer.AbstractMusicPlayerActivity;

public class AidlMusicPlayerActivity extends AbstractMusicPlayerActivity {

	protected IAidlMusicPlayerService service = null;
	protected ServiceConnection connection = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		connection = new ServiceConnection() {
			@Override
			public void onServiceDisconnected(ComponentName name) {
				service = null;
			}
			@Override
			public void onServiceConnected(ComponentName name, IBinder binder) {
				service = ((IAidlMusicPlayerService) binder);
			}
		};
		
		Intent intent = createIntent();
		startService(intent);
		bindService(intent, connection, Context.BIND_AUTO_CREATE);
		
	}
	
	public Intent createIntent() {
		return new Intent(this, AidlMusicPlayerService.class);
	}
	
	@Override
	public void play(String song) {
		try { service.play(song); }
		catch (Exception ex) { log(ex); }
	}

	@Override
	public void pause() {
		try { service.pause(); }
		catch (Exception ex) { log(ex); }
	}

	@Override
	public void stop() {
		try { service.stop(); }
		catch (Exception ex) { log(ex); }
	}

	@Override
	public int getCurrentPosition() {
		try { return service.getCurrentPosition(); }
		catch (Exception ex) {
			log(ex);
			return -1;
		}
	}

}
