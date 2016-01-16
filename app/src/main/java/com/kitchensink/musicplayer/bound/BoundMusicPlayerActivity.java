package com.kitchensink.musicplayer.bound;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

import com.kitchensink.musicplayer.AbstractMusicPlayerActivity;
import com.kitchensink.musicplayer.bound.BoundMusicPlayerService.LocalBinder;

public class BoundMusicPlayerActivity extends AbstractMusicPlayerActivity {
	
	protected BoundMusicPlayerService service = null;
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
				service = ((LocalBinder) binder).getService();
			}
		};
		
		Intent intent = createIntent();
		startService(intent);
		bindService(intent, connection, Context.BIND_AUTO_CREATE);
		
	}
	
	protected void onDestroy() {
		super.onDestroy();
		unbindService(connection);
	};
	
	public Intent createIntent() {
		return new Intent(this, BoundMusicPlayerService.class);
	}
	
	@Override
	public void play(String song) {
		service.play(song);
	}

	@Override
	public void pause() {
		service.pause();
	}

	@Override
	public void stop() {
		service.stop();
	}

	@Override
	public int getCurrentPosition() {
		return service.getCurrentPosition();
	}

}
