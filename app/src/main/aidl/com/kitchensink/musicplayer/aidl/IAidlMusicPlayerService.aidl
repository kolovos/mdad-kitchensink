package com.kitchensink.musicplayer.aidl;

interface IAidlMusicPlayerService {
	
	void play(String song);
	
	void stop();
	
	void pause();
	
	int getCurrentPosition();
	
}