package com.kitchensink.gridview;

import java.util.ArrayList;
import java.util.List;

import com.kitchensink.R;
import com.kitchensink.R.layout;
import com.kitchensink.R.menu;
import com.kitchensink.listview.Contact;
import com.kitchensink.listview.ContactListViewAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

public class ContactGridViewActivity extends Activity {
	
	protected GridView contactGridView;
	protected ArrayAdapter<Contact> contactsListViewAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_grid_view);
		
		contactGridView = (GridView) findViewById(R.id.contactGridView);
		contactsListViewAdapter = new ContactListViewAdapter(this, Contact.getSampleContacts());
		contactGridView.setAdapter(contactsListViewAdapter);

	}

}
