package com.kitchensink.contentproviders;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.RawContacts;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.kitchensink.R;

public class PhoneListViewActivity extends Activity {

	protected ListView contactList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phonelist);
		
		contactList = (ListView) findViewById(R.id.contactList);		
		
		Cursor cursor = getContentResolver().query(
				Phone.CONTENT_URI,
				new String[]{Contacts._ID, Phone.DISPLAY_NAME, Phone.NUMBER},
				Phone.DISPLAY_NAME + " like ?",
				new String[]{"%"},
				Phone.DISPLAY_NAME + " asc");
		
		contactList.setAdapter(
				new SimpleCursorAdapter(
						this, 
						android.R.layout.simple_list_item_2, 
						cursor, 
						new String[]{Phone.DISPLAY_NAME, Phone.NUMBER}, 
						new int[]{android.R.id.text1, android.R.id.text2}, 
				0));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.phone_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.addSampleContact) {
			addSampleContact();
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void addSampleContact() {
		ContentValues rawContactValues = new ContentValues();
		rawContactValues.putNull(RawContacts.ACCOUNT_TYPE);
		rawContactValues.putNull(RawContacts.ACCOUNT_TYPE);
		Uri uri = getContentResolver().insert(RawContacts.CONTENT_URI, rawContactValues);
		// Result is in the form of content://com.android.contacts/raw_contacts/<new-contact-id>
		int rawContactId = Integer.parseInt(uri.getLastPathSegment());
		
		ContentValues phoneValues = new ContentValues();
		phoneValues.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
		phoneValues.put(Contacts.Data.MIMETYPE, Phone.CONTENT_ITEM_TYPE);
		phoneValues.put(Phone.NUMBER, "07700000001");
		getContentResolver().insert(ContactsContract.Data.CONTENT_URI, phoneValues);
		
		ContentValues nameValues = new ContentValues();
		nameValues.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
		nameValues.put(ContactsContract.Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
		nameValues.put(StructuredName.DISPLAY_NAME, "Joe Doe");
		getContentResolver().insert(ContactsContract.Data.CONTENT_URI, nameValues);
		
		Toast.makeText(this, "Added sample contact", Toast.LENGTH_LONG).show();
	}
}
