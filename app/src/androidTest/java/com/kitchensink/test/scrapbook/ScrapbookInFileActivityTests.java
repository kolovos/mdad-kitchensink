package com.kitchensink.test.scrapbook;

import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.widget.EditText;

import com.kitchensink.R;
import com.kitchensink.scrapbook.ScrapbookInFileActivity;
import com.kitchensink.test.StringUtils;

public class ScrapbookInFileActivityTests extends ActivityInstrumentationTestCase2<ScrapbookInFileActivity> {

	protected EditText editText = null;
	
	public ScrapbookInFileActivityTests() {
		super(ScrapbookInFileActivity.class);
	}
	
	public void testPauseState() throws Exception {

		final String text = StringUtils.getRandomString(10);
		// Spawn the activity
		ScrapbookInFileActivity activity = getActivity();
		editText = (EditText) activity.findViewById(R.id.scrapbookEditText);
		// Set the value of the edit text to something random
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				editText.setText(text);
			}
		});
		getInstrumentation().waitForIdleSync();

		// Destroy the activity
		activity.finish();
		setActivity(null);

		// Re-spawn the activity
		activity = getActivity();

		// Ensure that the text is still there
		editText = (EditText) activity.findViewById(R.id.scrapbookEditText);

		assertEquals(text, editText.getText().toString());
	}
	
	
}
