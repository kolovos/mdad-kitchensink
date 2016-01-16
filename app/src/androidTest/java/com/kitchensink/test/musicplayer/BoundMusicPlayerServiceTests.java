package com.kitchensink.test.musicplayer;

import org.junit.Test;

import android.content.Intent;
import android.test.MoreAsserts;
import android.test.ServiceTestCase;
import android.test.ViewAsserts;

import com.kitchensink.musicplayer.bound.BoundMusicPlayerService;
import com.kitchensink.musicplayer.bound.BoundMusicPlayerService.LocalBinder;

public class BoundMusicPlayerServiceTests extends ServiceTestCase<BoundMusicPlayerService>{

	public BoundMusicPlayerServiceTests() {
		super(BoundMusicPlayerService.class);
	}
	
	@Override
	protected void setUp() throws Exception {

	}
	
	@Test
	public void testCurrentPosition() {
		Intent intent = new Intent(); // No need to specify the target service
		LocalBinder binder = (LocalBinder) bindService(intent);
		BoundMusicPlayerService service = binder.getService();
		service.play("guitar.mp3");
		try { Thread.sleep(2000); } catch (Exception ex) {}
		int currentPosition = service.getCurrentPosition();
		// Pefrorm tests
		assertTrue("More than 1.5 seconds have elapsed", currentPosition > 1500);
		assertTrue("Less than 2.5 seconds have elapsed", currentPosition < 2500);
		// Shut down the service
		shutdownService();
	}
	
	@Override
	protected void tearDown() throws Exception {

	}
	
}
