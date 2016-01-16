package com.kitchensink.musicplayer;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.Log;

public class MusicPlayer {
	
protected MediaPlayer player = null;
	
	protected Context context;

	public MusicPlayer(Context context) {
		this.context = context;
	}

	public void play(String song) {
		try {
			AssetFileDescriptor afd = context.getAssets().
				openFd(song);
		    if (player != null) player.stop();
		    player = new MediaPlayer(); // Create the player
		    player.setDataSource(afd.getFileDescriptor(), 
		    	afd.getStartOffset(), afd.getLength());
		    player.prepare();
			player.start(); // Start the player
		}
		catch(Exception ex) {
			Log.e(MusicPlayer.class.
				getSimpleName(), ex.getMessage(), ex);
		}	
	}
	
	public void stop() {
		if (player != null) player.stop();
	}
	
	public void pause() {
		if (player != null) {
			if (player.isPlaying()) player.pause();
			else player.start();
		}
	}
	
	public int getCurrentPosition() {
		if (player != null) return player.getCurrentPosition();
		else return -1;
	}
}
