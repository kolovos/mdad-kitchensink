package com.kitchensink.newslist;

import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class LoadImageViewFromURLTask extends AsyncTask<Void, Void, Void>{

	protected ImageView imageView;
	protected String url;
	protected Bitmap bitmap;
	
	public LoadImageViewFromURLTask(ImageView imageView, String url) {
		super();
		this.imageView = imageView;
		this.url = url;
	}

	@Override
	protected Void doInBackground(Void... params) {
		try {
			bitmap = BitmapFactory.decodeStream(new URL(url).openConnection().getInputStream()); 
			publishProgress();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	protected void onProgressUpdate(Void... values) {
		imageView.setImageBitmap(bitmap);
	}

}
