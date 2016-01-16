package com.kitchensink.listview;

import java.util.ArrayList;
import java.util.List;

import com.kitchensink.R;
import com.kitchensink.R.layout;
import com.kitchensink.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ContactListViewActivity extends Activity {
	
	protected List<Contact> contacts;
	protected ListView contactsListView;
	protected ArrayAdapter<Contact> contactsListViewAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_list_view);
		
		contactsListView = (ListView) findViewById(R.id.contactsListView);
		
		contacts = new ArrayList<Contact>();
		contacts.add(new Contact("Joe", "Doe"));
		contacts.add(new Contact("Jane", "Doe"));
		
		contactsListViewAdapter = new ContactListViewAdapter(this, contacts);
		contactsListView.setAdapter(contactsListViewAdapter);
		
	}
	
}
