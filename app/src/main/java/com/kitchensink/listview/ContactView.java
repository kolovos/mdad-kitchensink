package com.kitchensink.listview;


import com.kitchensink.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ContactView extends LinearLayout {
	
	protected TextView firstNameTextView;
	protected TextView lastNameTextView;
	
	public ContactView(Context context) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) 
				context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.view_contact, this, true);
		
		firstNameTextView = (TextView) findViewById(R.id.firstNameTextView);
		lastNameTextView = (TextView) findViewById(R.id.lastNameTextView);
	}
	
	public void setContact(Contact contact) {
		firstNameTextView.setText(contact.getFirstName());
		lastNameTextView.setText(contact.getLastName());
	}

}
