package com.kitchensink.wishlist;

//import custompackage.*;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

class WishlistDbOpenHelperBase extends SQLiteOpenHelper {
	
	protected final static String databaseName = "wishlist.db";
	protected final static int databaseVersion = 1;
	
	public WishlistDbOpenHelperBase(Context context) {
		super(context, databaseName, null, databaseVersion);		
	}
	
	public static class Wish {
		
		public static final String TABLE_NAME = "Wish";
		public static final String COLUMN_NAME_ID = "_id";
		public static final String COLUMN_NAME_TITLE = "title";
		public static final String COLUMN_NAME_PRICE = "price";
		
		protected long id;
		protected ContentValues _updates = new ContentValues();
		protected String title;
		protected float price;
		
		public Wish() {
		
		}
		
		public Wish(Cursor cursor) {
			this.title = cursor.getString(cursor.getColumnIndex("title"));
			this.price = cursor.getFloat(cursor.getColumnIndex("price"));
		}
		
		public long getId() {
			return id;
		}
		
		public Wish setId(long id) {
			_updates.put("_id", id);
			this.id = id;
			return this;
		}
		
		public String getTitle() {
			return this.title;
		}
		
		public Wish setTitle(String title) {
			_updates.put("title", title);
			this.title = title;
			return this;
		}
		
		public float getPrice() {
			return this.price;
		}
		
		public Wish setPrice(float price) {
			_updates.put("price", price);
			this.price = price;
			return this;
		}
		
		public Wish insert(SQLiteDatabase db) {
			ContentValues values = new ContentValues();
			values.put("title", title);
			values.put("price", price);
			this.id = db.insert("Wish", "null", values);
			return this;
		}
		
		public boolean update(SQLiteDatabase db) {
			return db.update("Wish", _updates,
				"_id = ?", new String[]{String.valueOf(id)} ) > 0;
		}
		
		public boolean delete(SQLiteDatabase db) {
			return db.delete("Wish",
				"_id = ?", new String[]{String.valueOf(id)} ) > 0;
		}
		
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		String[] createTableStatements = new String[]{
				"create table Wish (_id INTEGER PRIMARY KEY, title TEXT, price REAL)"};				
		
		for (String createTableStatement : createTableStatements) {
			db.execSQL(createTableStatement);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
}