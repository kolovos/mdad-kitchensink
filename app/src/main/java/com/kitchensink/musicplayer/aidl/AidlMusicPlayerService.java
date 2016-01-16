package com.kitchensink.musicplayer.aidl;

import com.kitchensink.musicplayer.MusicPlayer;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class AidlMusicPlayerService extends Service {
	
	protected MusicPlayer player;
	protected IBinder binder = new IAidlMusicPlayerService.Stub() {
		
		@Override
		public void stop() throws RemoteException {
			player.stop();
		}
		
		@Override
		public void play(String song) throws RemoteException {
			player.play(song);
		}
		
		@Override
		public void pause() throws RemoteException {
			player.pause();
		}
		
		@Override
		public int getCurrentPosition() throws RemoteException {
			return player.getCurrentPosition();
		}
	};
	
	@Override
	public void onCreate() {
		super.onCreate();
		player = new MusicPlayer(this);
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}
	
}
