package com.kitchensink.wishlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class WishlistDbOpenHelper extends WishlistDbOpenHelperBase {
	
	public WishlistDbOpenHelper(Context context) {
		super(context);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		super.onCreate(db);
		
		// Insert dummy contents
		createWish(db, "Spider-Man Action Figure", 40);
		createWish(db, "Google Nexus 7", 199);
		//createWish(db, "Action-Man Action Figure", 23);
		//createWish(db, "GI-JOE Action Figure", 26.5f);
	}
	
	public Wish createWish(SQLiteDatabase db, String title, float price) {
		return new Wish().setPrice(price).setTitle(title).insert(db);
	}
	
	public void updateWish(SQLiteDatabase db, int wishId, float newPrice) {
		ContentValues values = new ContentValues();
		values.put("price", newPrice);
		db.update("wish", // The table to update
				values, // The new values
				"_id = ?", // The update condition
				new String[]{String.valueOf(wishId)} // The values of ?s
		);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (oldVersion == 1 && newVersion == 2) {
			db.execSQL("alter table wish add lastUpdated TEXT");
		}
	}
}
