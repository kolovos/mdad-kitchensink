package com.kitchensink.newslist;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

import com.kitchensink.R;
import com.kitchensink.R.layout;
import com.kitchensink.R.menu;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class NewsListActivity extends Activity {

	protected List<NewsItem> newsItems = new ArrayList<NewsItem>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news_list);
		
		new AsyncTask<String, Document, Void>() {
			@Override
			protected Void doInBackground(String... params) {
				try {
					SAXBuilder builder = new SAXBuilder();
					//Document document = builder.build(getAssets().open("bbcrss.xml"));
					Document document = builder.build(new URL(params[0]).openStream());
					publishProgress(document);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
				return null;
			}
			
			protected void onProgressUpdate(Document... values) {
				Document document = values[0];
				Namespace mediaNamespace = document.getRootElement().getNamespace("media");
				
				for (Element itemElement : document.getRootElement().getChild("channel").getChildren("item")) {
					NewsItem newsItem = new NewsItem();
					newsItem.setTitle(itemElement.getChildText("title"));
					newsItem.setDescription(itemElement.getChildText("description"));
					//newsItem.setThumbnail(itemElement.getChild("thumbnail", mediaNamespace).getAttributeValue("url"));
					newsItem.setUrl(itemElement.getChildText("guid"/*"link"*/));
					newsItems.add(newsItem);
				}
				
				ListView newsListView = (ListView) findViewById(R.id.newsListView);
				newsListView.setAdapter(new ArrayAdapter<NewsItem>(NewsListActivity.this, android.R.layout.simple_list_item_1, newsItems.toArray(new NewsItem[]{})) {
					@Override
					public View getView(int position, View convertView, ViewGroup parent) {
						NewsItemView newsItemView = null;
						if (convertView == null) {
							newsItemView = new NewsItemView(NewsListActivity.this);
						}
						else {
							newsItemView = (NewsItemView) convertView;
						}
						newsItemView.setNewsItem(newsItems.get(position));
						return newsItemView;
					}
				});
				newsListView.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
						Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(newsItems.get(position).getUrl()));
						startActivity(intent);
					}
				});
			};
			
		}.execute("http://www.enet.gr/rss?i=news.el.article"/*"http://feeds.bbci.co.uk/news/rss.xml"*/);
		
		/*
		try {
			SAXBuilder builder = new SAXBuilder();
			//Document document = builder.build(getAssets().open("bbcrss.xml"));
			Document document = builder.build(new URL("http://feeds.bbci.co.uk/news/rss.xml").openStream());
			Namespace mediaNamespace = document.getRootElement().getNamespace("media");
			
			for (Element itemElement : document.getRootElement().getChild("channel").getChildren("item")) {
				NewsItem newsItem = new NewsItem();
				newsItem.setTitle(itemElement.getChildText("title"));
				newsItem.setDescription(itemElement.getChildText("description"));
				newsItem.setThumbnail(itemElement.getChild("thumbnail", mediaNamespace).getAttributeValue("url"));
				newsItems.add(newsItem);
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}*/
		
		
		
	}
	
}
