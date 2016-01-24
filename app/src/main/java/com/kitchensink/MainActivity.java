package com.kitchensink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.kitchensink.actionbar.ActionBarActivity;
import com.kitchensink.aidl.CalculatorAidlServiceActivity;
import com.kitchensink.asynctasks.DownloadActivity;
import com.kitchensink.broadcastreceivers.IncomingSmsLogger;
import com.kitchensink.broadcastreceivers.IncomingSmsLoggerActivity;
import com.kitchensink.broadcastreceivers.OutgoingCallEmulatingActivity;
import com.kitchensink.broadcastreceivers.StickyBroadcastActivity;
import com.kitchensink.calculator.CalculatorActivity;
import com.kitchensink.contentproviders.PhoneListViewActivity;
import com.kitchensink.contextmenu.ContextMenuActivity;
import com.kitchensink.gestures.GestureDetectorActivity;
import com.kitchensink.gestures.GesturesListActivity;
import com.kitchensink.gestures.ScaleDetectorActivity;
import com.kitchensink.gestures.drawing.AdvancedDrawingActivity;
import com.kitchensink.gestures.drawing.DrawingActivity;
import com.kitchensink.gridview.ContactGridViewActivity;
import com.kitchensink.handler.HandlerActivity;
import com.kitchensink.i18n.MultilingualActivity;
import com.kitchensink.intents.BookmarksActivity;
import com.kitchensink.intents.ComposeMessageActivity;
import com.kitchensink.intents.ComposeMessageWithRealRecipientActivity;
import com.kitchensink.intents.ContactsActivity;
import com.kitchensink.ksoap2.KSOAP2Activity;
import com.kitchensink.layouts.LayoutsActivity;
import com.kitchensink.listview.ContactListViewActivity;
import com.kitchensink.listview.ListViewActivity;
import com.kitchensink.location.GpsLocationListenerActivity;
import com.kitchensink.location.LocationListenerActivity;
import com.kitchensink.messenger.MessengerActivity;
import com.kitchensink.mondial.CountriesActivity;
import com.kitchensink.mondial.fragments.CountryListActivity;
import com.kitchensink.multidevice.MultideviceActivity;
import com.kitchensink.musicplayer.aidl.AidlMusicPlayerActivity;
import com.kitchensink.musicplayer.started.StartedMusicPlayerActivity;
import com.kitchensink.network.AdcActivity;
import com.kitchensink.network.NetworkActivity;
import com.kitchensink.newslist.NewsListActivity;
import com.kitchensink.notifications.NotificationsActivity;
import com.kitchensink.notifications.ToastsActivity;
import com.kitchensink.scrapbook.ScrapbookInFileActivity;
import com.kitchensink.scrapbook.ScrapbookInPreferencesActivity;
import com.kitchensink.sensors.LightSensorActivity;
import com.kitchensink.sensors.SensorsActivity;
import com.kitchensink.services.StopwatchActivity;
import com.kitchensink.services.TimerActivity;
import com.kitchensink.viewpager.ViewPagerActivity;
import com.kitchensink.webview.WebViewActivity;
import com.kitchensink.wishlist.WishlistActivity;

import java.util.Arrays;
import java.util.Comparator;

public class MainActivity extends Activity {
	
	protected ListView activityListView;
	
	protected Class<?>[] activities = new Class[]{
		WishlistActivity.class,
		NotificationsActivity.class,
		ComposeMessageActivity.class,
		ComposeMessageWithRealRecipientActivity.class,
		DownloadActivity.class,
		ToastsActivity.class,
		ContactsActivity.class,
		BookmarksActivity.class,
		TimerActivity.class,
		NewsListActivity.class,
		StopwatchActivity.class,
		MultilingualActivity.class,
		MultideviceActivity.class,
		LayoutsActivity.class,
		ListViewActivity.class,
		ContactListViewActivity.class,
		ContactGridViewActivity.class,
		ScrapbookInFileActivity.class,
		ScrapbookInPreferencesActivity.class,
		PhoneListViewActivity.class,
		SensorsActivity.class,
		StartedMusicPlayerActivity.class,
		HandlerActivity.class,
		MessengerActivity.class,
		CalculatorAidlServiceActivity.class,
		ActionBarActivity.class,
		ContextMenuActivity.class,
		IncomingSmsLoggerActivity.class,
		StickyBroadcastActivity.class,
		LocationListenerActivity.class,
		GpsLocationListenerActivity.class,
		CountriesActivity.class,
		WebViewActivity.class,
		AdcActivity.class,
		NetworkActivity.class,
		CalculatorActivity.class,
		OutgoingCallEmulatingActivity.class,
		CountryListActivity.class,
		ViewPagerActivity.class,
		AdvancedDrawingActivity.class,
		GestureDetectorActivity.class,
		DrawingActivity.class,
		ScaleDetectorActivity.class,
		LightSensorActivity.class,
		GesturesListActivity.class, 
		KSOAP2Activity.class,
		AidlMusicPlayerActivity.class
	};
	
	protected Class<?> auto = null; //IncomingSmsLogger.class; //LightSensorActivity.class;// activities[activities.length-1];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_kitchen_sink);
		activityListView = (ListView) findViewById(R.id.activityListView);

		Arrays.sort(activities, new Comparator<Class<?>>() {
			@Override
			public int compare(Class<?> lhs, Class<?> rhs) {
				return lhs.getSimpleName().compareTo(rhs.getSimpleName());
			}
		});

		activityListView.setAdapter(new ArrayAdapter<Class<?>>(this, android.R.layout.simple_list_item_1, activities) {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				TextView view = (TextView) super.getView(position, convertView, parent);
				view.setText(getItem(position).getSimpleName().replace("Activity", ""));
				view.setSingleLine(true);
				return view;
			}
			
		});
		
		activityListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				Intent intent = new Intent(MainActivity.this, activities[position]);
				startActivity(intent);
			}
		});
		
		if (auto != null) {
			Intent intent = new Intent(MainActivity.this, auto);
			startActivity(intent);
		}
	}
	
}
