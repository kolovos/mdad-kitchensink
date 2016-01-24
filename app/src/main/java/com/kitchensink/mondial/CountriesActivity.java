package com.kitchensink.mondial;

import java.util.List;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kitchensink.R;
import com.kitchensink.mondial.thrift.CountriesThriftLoader;
import com.kitchensink.util.KitchenSinkActivity;

public class CountriesActivity extends KitchenSinkActivity {
	
	protected ListView listView = null;
	protected ArrayAdapter<Country> listAdapter = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_countries);
		
		listView = findListViewById(R.id.listView);
		listAdapter = new ArrayAdapter<Country>(this, android.R.layout.simple_list_item_1);
		listView.setAdapter(listAdapter);
		
		getLoaderManager().initLoader(0, null, new LoaderCallbacks<List<Country>>() {
	
			@Override
			public Loader<List<Country>> onCreateLoader(int id, Bundle args) {
				return new CountriesLoader(CountriesActivity.this);
			}
	
			@Override
			public void onLoadFinished(Loader<List<Country>> loader, List<Country> list) {
				listAdapter.clear(); listAdapter.addAll(list);
				listAdapter.notifyDataSetChanged();
			}
	
			@Override
			public void onLoaderReset(Loader<List<Country>> loader) {}
		});
	}

}
