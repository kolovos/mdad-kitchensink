package com.kitchensink.musicplayer.bound;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.kitchensink.musicplayer.MusicPlayer;

public class BoundMusicPlayerService extends Service {
	
	protected MusicPlayer player = null;
	protected LocalBinder binder = new LocalBinder();
	
	public class LocalBinder extends Binder {
		public BoundMusicPlayerService getService() {
			return BoundMusicPlayerService.this;
		}
	}
	
	@Override
	public void onCreate() {
		player = new MusicPlayer(this);
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}
	
	public void play(String song) {
		player.play(song);
	}
	
	public void pause() {
		player.pause();
	}
	
	public void stop() {
		player.stop();
	}
	
	public int getCurrentPosition() {
		return player.getCurrentPosition();
	}
}
