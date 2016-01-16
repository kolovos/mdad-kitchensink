package com.kitchensink.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.kitchensink.R;
import com.kitchensink.util.KitchenSinkActivity;

public class CalculatorActivity extends KitchenSinkActivity {
	
	protected EditText firstNumberEditText;
	protected EditText secondNumberEditText;
	protected EditText resultEditText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		
		firstNumberEditText = findEditTextById(R.id.firstNumberEditText);
		secondNumberEditText = findEditTextById(R.id.secondNumberEditText);
		resultEditText = findEditTextById(R.id.resultEditText);
		
	}
	
	// Called when the = button is pressed
	public void add(View view) {
		int result = Integer.parseInt(firstNumberEditText.getText().toString()) +
			Integer.parseInt(secondNumberEditText.getText().toString());
		resultEditText.setText(result + "");
	}
	
}
