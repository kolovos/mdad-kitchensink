package com.kitchensink.mondial.fragments;

import java.net.URL;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import com.kitchensink.mondial.Country;

public class CountryLoader extends AsyncTaskLoader<Country> {
	
	protected int countryId = -1;
	
	public CountryLoader(Context context, int countryId) {
		super(context);
		this.countryId = countryId;
	}

	@Override
	protected void onStartLoading() {
		forceLoad();
	}

	@Override
	public Country loadInBackground() {
		try {
			SAXBuilder builder = new SAXBuilder();
			// Build an XML document from the remote XML document
			Document document = builder.build(
					new URL("http://www-module.cs.york.ac.uk/soar/" + 
							"public/mondial/country/" + countryId));

			Element element = document.getRootElement();
			Country country = new Country();
			country.setName(element.getAttributeValue("name"));
			country.setId(Integer.parseInt(element.getAttributeValue("id")));
			country.setPopulation(Integer.parseInt(element.getAttributeValue("population")));
			country.setTotalArea(Double.parseDouble(element.getAttributeValue("total_area")));
			country.setTotalGdp(Double.parseDouble(element.getAttributeValue("gdp_total")));
			return country;
		} catch (Exception e) {
			Log.e(this.getClass().getCanonicalName(), e.getMessage(), e);
			return null;
		}
	}
}
