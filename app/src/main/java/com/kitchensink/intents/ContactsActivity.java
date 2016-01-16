package com.kitchensink.intents;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kitchensink.R;

public class ContactsActivity extends Activity {
	
	protected Contact[] contacts = new Contact[]{
		new Contact("Enid", "07787443321"),
		new Contact("George", "07787993321"),
		new Contact("Tom", "07787553321")
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phonelist);
		
		ListView contactsView = (ListView) findViewById(R.id.contactList);
		contactsView.setAdapter(new ArrayAdapter<Contact>(ContactsActivity.this, 
			android.R.layout.simple_list_item_1, contacts));
		
		contactsView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
				Intent intent = new Intent();
				intent.putExtra("name", contacts[position].getName());
				setResult(RESULT_OK, intent);
				finish();
			}
		});
		
		
	}
	
}
