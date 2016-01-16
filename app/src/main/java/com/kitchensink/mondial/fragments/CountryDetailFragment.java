package com.kitchensink.mondial.fragments;

import android.app.Fragment;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kitchensink.R;
import com.kitchensink.mondial.Country;

public class CountryDetailFragment extends Fragment {

	public static String COUNTRY_ID = "countryId";
	
	public CountryDetailFragment() {}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(COUNTRY_ID)) {
			
			getLoaderManager().initLoader(0, getArguments(), new LoaderCallbacks<Country>() {

				@Override
				public Loader<Country> onCreateLoader(int arg0, Bundle bundle) {
					System.out.println("DBG: Loading...");
					return new CountryLoader(getActivity(), bundle.getInt(COUNTRY_ID));
				}

				@Override
				public void onLoadFinished(Loader<Country> loader, Country country) {
					String text = country.getName() + " has a population of " + + country.getPopulation() +
							", a total GDP of " + country.getTotalGdp() + " and occupies an area of " +
							country.getTotalArea() + " km2.";
					((TextView) getView().findViewById(R.id.country_detail)).setText(text);
				}

				@Override
				public void onLoaderReset(Loader<Country> loader) {}
			});
			
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_country_detail, container, false);
	}
}
