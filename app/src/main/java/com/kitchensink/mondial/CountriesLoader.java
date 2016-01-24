package com.kitchensink.mondial;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

public class CountriesLoader extends AsyncTaskLoader<List<Country>> {
	
	public CountriesLoader(Context context){ super(context); }
	
	@Override
	protected void onStartLoading() {
		forceLoad();
	}
	
	@Override
	public List<Country> loadInBackground() {
		try {
			SAXBuilder builder = new SAXBuilder();			
			// Build an XML document from the remote XML document
			Document document = builder.build(
					new URL("http://www-module.cs.york.ac.uk/soar/" + 
							"public/mondial/countries"));
			
			List<Country> countries = new ArrayList<Country>();
			// Iterate through all <country> elements
			for (Element element : document.getRootElement().getChildren("country")) {
				Country country = new Country();
				country.setName(element.getAttributeValue("name"));
				country.setId(Integer.parseInt(element.getAttributeValue("id")));
				countries.add(country);
			}
			return countries;
		} catch (Exception e) {
			Log.e(this.getClass().getCanonicalName(), e.getMessage(), e);
			return null;
		}
	}
	
}
