package com.kitchensink.intents;

import com.kitchensink.R;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract.Contacts;
import android.widget.TextView;

public class ComposeMessageWithRealRecipientActivity extends ComposeMessageActivity {
	
	@Override
	protected void onRecipientBrowseButtonClick() {
		Intent intent = new Intent(Intent.ACTION_PICK, Contacts.CONTENT_URI);
		startActivityForResult(intent, PICK_CONTACT_REQUEST);		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == PICK_CONTACT_REQUEST && resultCode == Activity.RESULT_OK) {
			Cursor cursor = getContentResolver().query(data.getData(),
	        new String[] {Contacts.DISPLAY_NAME}, null, null, null);
	        if (cursor.moveToFirst()) { // True if the cursor is not empty
	            int columnIndex = cursor.getColumnIndex(Contacts.DISPLAY_NAME);
	            String name = cursor.getString(columnIndex);
	           ((TextView)findViewById(R.id.recipientEditText)).setText(name);
	        }
		}		
	}
	
}
