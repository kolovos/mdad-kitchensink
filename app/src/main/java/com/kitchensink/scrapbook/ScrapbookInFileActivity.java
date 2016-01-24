package com.kitchensink.scrapbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

import android.os.Bundle;
import android.widget.EditText;

import com.kitchensink.R;
import com.kitchensink.util.KitchenSinkActivity;

public class ScrapbookInFileActivity extends KitchenSinkActivity {

	protected EditText scrapbookEditText;
	protected String scrapbookFilename = "scrapbook.txt";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scrapbook);
		
		scrapbookEditText = (EditText) findViewById(R.id.scrapbookEditText);
		File scrapbookFile = getFileStreamPath(scrapbookFilename);
		if (scrapbookFile.exists()) {
			try {
				String text = new Scanner(scrapbookFile).useDelimiter("\\Z").next();
				scrapbookEditText.setText(text);
			}
			catch (Exception ex) {
				toast("Could not read from file");
			}
		}
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		try {
			FileOutputStream fos =
					openFileOutput(scrapbookFilename, MODE_PRIVATE);
			fos.write(scrapbookEditText.getText().toString().getBytes());
			fos.close();
		}
		catch (Exception ex) {
			toast("Could not write to file");
		}
	}

	
}
