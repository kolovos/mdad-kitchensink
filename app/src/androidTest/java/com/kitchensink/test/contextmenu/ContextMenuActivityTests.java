package com.kitchensink.test.contextmenu;

import com.kitchensink.contextmenu.ContextMenuActivity;
import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

public class ContextMenuActivityTests extends ActivityInstrumentationTestCase2<ContextMenuActivity>{
	
	protected Solo solo;
	
	public ContextMenuActivityTests() {
		super(ContextMenuActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void testContextMenu() {
		solo.clickLongOnText("Apple");
		assertTrue(solo.searchText("Edit"));
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		// If solo has opened multiple activities
		// comment-out the above and un-comment the
		// line below
		//solo.finishOpenedActivities();
	}
	
}
