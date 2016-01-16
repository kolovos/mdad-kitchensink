package com.kitchensink.intents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BookmarksActivity extends Activity {
	
	protected String[] bookmarks = new String[]{
			"http://www.google.com", 
			"http://www.facebook.com",
			"http://www.twitter.com/kolovos"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ListView bookmarksList = new ListView(this);
		bookmarksList.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		setContentView(bookmarksList);
		
		bookmarksList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bookmarks));
		
		bookmarksList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(bookmarks[position]));
				startActivity(intent);
			}
		});
	}
	
}
