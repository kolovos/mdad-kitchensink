package com.kitchensink.test.intents;

import com.kitchensink.intents.ComposeMessageActivity;
import com.robotium.solo.Solo;
import android.test.ActivityInstrumentationTestCase2;

public class ComposeMessageActivityTests extends
	ActivityInstrumentationTestCase2<ComposeMessageActivity>{
	
	protected Solo solo;
	
	public ComposeMessageActivityTests() {
		super(ComposeMessageActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp(); 
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testComposeMessage() {
		String messageText = "A message";
		// Set the value of the Message text
		solo.enterText(1, messageText);
		// Click on the recipient button
		solo.clickOnImageButton(0);
		// Select the 2nd contact
		solo.clickInList(1);
		solo.clickOnButton(0); // Click Send
		assertTrue(solo.searchText(messageText));
	}
	
	@Override
	protected void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}
}
