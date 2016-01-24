package com.kitchensink.mondial.fragments;

import java.util.List;

import com.kitchensink.mondial.CountriesLoader;
import com.kitchensink.mondial.Country;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Loader;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.LoaderManager;


public class CountryListFragment extends ListFragment {
	
	private CountrySelectionListener listener = null;

	public CountryListFragment() {}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getLoaderManager().initLoader(0, null, new LoaderManager.LoaderCallbacks<List<Country>>() {

			@Override
			public Loader<List<Country>> onCreateLoader(int id, Bundle args) {
				return new CountriesLoader(getActivity());
			}

			@Override
			public void onLoadFinished(Loader<List<Country>> loader, List<Country> countries) {
				setListAdapter(new ArrayAdapter<Country>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, countries));
			}

			@Override
			public void onLoaderReset(Loader<List<Country>> arg0) {}
			
		});
		
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		if (!(activity instanceof CountrySelectionListener)) {
			throw new IllegalStateException(
				"Container activity must implement " + 
				"the CountrySelectionListener interface.");
		}

		listener = (CountrySelectionListener) activity;
	}

	@Override
	public void onDetach() {
		super.onDetach();
		listener = null;
	}

	@Override
	public void onListItemClick(ListView listView, View view, int position, long id) {
		super.onListItemClick(listView, view, position, id);
		if (listener != null) {
			listener.onCountrySelected(((Country) listView.getAdapter().getItem(position)));
		}
	}

}
