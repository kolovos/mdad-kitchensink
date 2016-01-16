package com.kitchensink.mondial.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.kitchensink.R;
import com.kitchensink.mondial.Country;

public class CountryListActivity extends FragmentActivity implements CountrySelectionListener {

	private boolean wideLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_country_list);

		if (findViewById(R.id.country_detail_container) != null) {
			wideLayout = true;
		}
	}

	@Override
	public void onCountrySelected(Country country) {
		if (wideLayout) {
			Bundle arguments = new Bundle();
			arguments.putInt(CountryDetailFragment.COUNTRY_ID, country.getId());
			CountryDetailFragment fragment = new CountryDetailFragment();
			fragment.setArguments(arguments);
			getFragmentManager().beginTransaction().replace(R.id.country_detail_container, fragment).commit();
		} else {
			Intent detailIntent = new Intent(this, CountryDetailActivity.class);
			detailIntent.putExtra(CountryDetailFragment.COUNTRY_ID, country.getId());
			startActivity(detailIntent);
		}
	}
}
