package com.kitchensink.musicplayer.started;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.kitchensink.musicplayer.MusicPlayer;

public class StartedMusicPlayerService extends Service {
	
	protected MusicPlayer player = null;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		player = new MusicPlayer(this);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if ("play".equals(intent.getAction())) {
			player.play(intent.getExtras().getString("song"));
		}
		else if ("pause".equals(intent.getAction())) {
			player.pause();
		}
		else if ("stop".equals(intent.getAction())) {
			player.stop();
		}
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		player.stop();
	}
}
