package com.kitchensink.test.mondial;

import java.util.List;

import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.SmallTest;

import com.kitchensink.mondial.CountriesLoader;
import com.kitchensink.mondial.Country;

public class CountriesLoaderTests extends LoaderTestCase {
	
	@LargeTest
	public void testNumberOfCountries() {
		// Initialise the loader to test
		CountriesLoader loader = new CountriesLoader(getContext());
		// In our normal code, we'd need to invoke the loader in an asynchronous way
		// but getLoaderResultSynchronously enables us to invoke it synchronously
		List<Country> countries = getLoaderResultSynchronously(loader);
		// Check that the number of returned countries is 231
		assertEquals(231, countries.size());
	}
	
}
