package com.kitchensink.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.kitchensink.R;

public class ComposeMessageActivity extends Activity {
	
	protected EditText recipientEditText = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_composemessage);
		
		final EditText messageEditText = (EditText) findViewById(R.id.messageEditText);
		recipientEditText = (EditText) findViewById(R.id.recipientEditText);
		
		Button sendMessage = (Button) findViewById(R.id.sendMessageButton);
		sendMessage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ComposeMessageActivity.this, 
					ViewMessageActivity.class);
				intent.putExtra("to", recipientEditText.getText().toString());
				intent.putExtra("message", messageEditText.getText().toString());
				startActivity(intent);
			}
			
		});
		
		((ImageButton) findViewById(R.id.recipientBrowseButton)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				onRecipientBrowseButtonClick();
			}
		});
		
	}
	
	protected final int PICK_CONTACT_REQUEST = 1;
	
	protected void onRecipientBrowseButtonClick() {
		Intent intent = new Intent(this, ContactsActivity.class);
		startActivityForResult(intent, PICK_CONTACT_REQUEST);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {	
		if (requestCode == PICK_CONTACT_REQUEST && resultCode == Activity.RESULT_OK) {
			recipientEditText.setText(data.getStringExtra("name"));
		}
	}
	
}
