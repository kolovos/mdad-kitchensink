package com.kitchensink.newslist;

import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kitchensink.R;

public class NewsItemView extends LinearLayout {
	
	protected NewsItem newsItem = null;
	protected TextView titleTextView = null;
	protected TextView descriptionTextView = null;
	protected ImageView thumbnailImageView = null;
	
	public NewsItemView(Context context) {
		super(context);
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.view_newsitem, this, true);
		
		titleTextView = (TextView) findViewById(R.id.titleTextView);
		descriptionTextView = (TextView) findViewById(R.id.descriptionTextView);
		thumbnailImageView = (ImageView) findViewById(R.id.thumbnailImageView);
		
	}
	
	public void setNewsItem(NewsItem newsItem) {
		this.newsItem = newsItem;
		titleTextView.setText(newsItem.getTitle());
		descriptionTextView.setText(newsItem.getDescription());
		if (newsItem.getThumbnail() != null)
		new LoadImageViewFromURLTask(thumbnailImageView, newsItem.getThumbnail()).execute();
	}
	
}
