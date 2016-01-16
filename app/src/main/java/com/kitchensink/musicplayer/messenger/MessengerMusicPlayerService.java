package com.kitchensink.musicplayer.messenger;

import com.kitchensink.musicplayer.MusicPlayer;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

public class MessengerMusicPlayerService extends Service {
	
	protected MusicPlayer player;
	protected IBinder binder = new Messenger(new Handler() {
		@Override
		public void dispatchMessage(Message msg) {
			String action = msg.getData().getString("action");
			if ("play".equals(action)) {
				player.play(msg.getData().getString("song"));
			}
			else if ("stop".equals(action)) {
				player.stop();
			}
			else if ("pause".equals(action)) {
				player.pause();
			}
			else if ("getCurrentPosition".equals(action)) {
				Messenger callback = msg.getData().getParcelable("callback");
				Message response = new Message();
				response.getData().putInt("currentPosition", player.getCurrentPosition());
				try { callback.send(response); }
				catch (Exception ex) { ex.printStackTrace(); }
			}
		}
	}).getBinder();
	
	@Override
	public void onCreate() { player = new MusicPlayer(this); }
	
	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}

}
