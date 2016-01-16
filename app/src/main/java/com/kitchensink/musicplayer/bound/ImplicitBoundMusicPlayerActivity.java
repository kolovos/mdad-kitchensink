package com.kitchensink.musicplayer.bound;

import android.content.Intent;

public class ImplicitBoundMusicPlayerActivity extends BoundMusicPlayerActivity {
	
	@Override
	public Intent createIntent() {
		return new Intent("com.kitchensink.musicplayer.bound.BoundMusicPlayerService");
	}
	
}
