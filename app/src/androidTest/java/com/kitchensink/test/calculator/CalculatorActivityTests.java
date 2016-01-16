package com.kitchensink.test.calculator;

import com.kitchensink.R;
import com.kitchensink.calculator.CalculatorActivity;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.view.KeyEvent;

public class CalculatorActivityTests extends ActivityInstrumentationTestCase2<CalculatorActivity>{

	public CalculatorActivityTests() {
		super(CalculatorActivity.class);
	}
	
	@UiThreadTest
	public void testEqualsButton2() {
		
		CalculatorActivity activity = getActivity();
		activity.findEditTextById(R.id.firstNumberEditText).setText("10");
		activity.findEditTextById(R.id.secondNumberEditText).setText("5");
		activity.findButtonById(R.id.equalsButton).performClick();
		assertEquals(activity.findEditTextById(R.id.resultEditText).getText().toString(), "15");
		
	}
	
	public void testEqualsButton() {
		try {
			runTestOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					CalculatorActivity activity = getActivity();
					activity.findEditTextById(R.id.firstNumberEditText).setText("10");
					activity.findEditTextById(R.id.secondNumberEditText).setText("5");
					activity.findButtonById(R.id.equalsButton).performClick();
					assertEquals(activity.findEditTextById(R.id.resultEditText).getText().toString(), "15");
				}
			});
		} catch (Throwable e) {
			fail(e.getMessage());
		}
	}

}
