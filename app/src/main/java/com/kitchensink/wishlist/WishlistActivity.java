package com.kitchensink.wishlist;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.SimpleCursorAdapter.ViewBinder;
import android.widget.TextView;

import com.kitchensink.R;

public class WishlistActivity extends Activity {

	protected ListView wishlistListView;
	protected boolean customLayout = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wishlist);

		deleteDatabase("wishlist.db");
		wishlistListView = (ListView) findViewById(R.id.wishlistListView);

		WishlistDbOpenHelper helper = new WishlistDbOpenHelper(this);
		Cursor cursor = helper.getReadableDatabase().rawQuery("select * from wish", new String[] {});
		
		SimpleCursorAdapter adapter = null;
		
		if (customLayout) {
			adapter = new SimpleCursorAdapter(this, R.layout.view_wish, cursor, new String[] { "title", "price" }, new int[] { R.id.titleTextView,
					R.id.priceTextView }, 0);
		}
		else {
			adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, new String[] { "title", "price" }, new int[] { android.R.id.text1,
					android.R.id.text2 }, 0);
		}
		
		adapter.setViewBinder(new ViewBinder() {
			
			@Override
			public boolean setViewValue(View view, Cursor cursor, int columnIndex) {
				if (columnIndex == cursor.getColumnIndex("price")) {
					TextView priceTextView = (TextView) view;
					priceTextView.setText("£" + cursor.getInt(columnIndex));
					return true;
				}
				else return false;
			}
		});
		wishlistListView.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.wishlist, menu);
		return true;
	}

}
