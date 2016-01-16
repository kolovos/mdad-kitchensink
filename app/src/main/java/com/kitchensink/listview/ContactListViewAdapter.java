package com.kitchensink.listview;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ContactListViewAdapter extends ArrayAdapter<Contact> {

		public ContactListViewAdapter(Context context, List<Contact> objects) {
			super(context, android.R.layout.simple_list_item_1, objects);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ContactView view = new ContactView(getContext());
			view.setContact(getItem(position));
			return view;
		}
		
	}