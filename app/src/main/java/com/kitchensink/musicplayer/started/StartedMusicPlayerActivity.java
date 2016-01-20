package com.kitchensink.musicplayer.started;

import android.content.Intent;

import com.kitchensink.musicplayer.AbstractMusicPlayerActivity;

public class StartedMusicPlayerActivity extends AbstractMusicPlayerActivity {

	@Override
	public void play(String song) {
		Intent intent = createIntent("play");
		intent.putExtra("song", song);
		startService(intent);
	}

	@Override
	public void pause() {
		startService(createIntent("pause"));
	}

	@Override
	public void stop() {
		startService(createIntent("stop"));

		// stopService(createIntent(""));
	}

	@Override
	public int getCurrentPosition() {
		return 0; // The service cannot return data
	}
	
	protected Intent createIntent(String action) {
		Intent intent = new Intent(this, StartedMusicPlayerService.class);
		intent.setAction(action);
		return intent;
	}

}
