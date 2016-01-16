package com.kitchensink.mondial.thrift;

import java.util.ArrayList;
import java.util.List;

import mondial.thrift.Mondial;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.kitchensink.mondial.Country;

public class CountriesThriftLoader extends AsyncTaskLoader<List<Country>> {
	
	public CountriesThriftLoader(Context context){ super(context); }
	
	@Override
	protected void onStartLoading() {
		forceLoad();
	}

	@Override
	public List<Country> loadInBackground() {
		try {
			TTransport transport = new THttpClient("http://10.0.2.2:8888/mondial/thrift/");
			TProtocol protocol = new TBinaryProtocol(transport);
			Mondial.Client client = new Mondial.Client(protocol);
			ArrayList<Country> countries = new ArrayList<Country>();
			for (mondial.thrift.Country thriftCountry : client.getCountries()) {
				countries.add(new Country(thriftCountry.getId(), thriftCountry.getName(),
					thriftCountry.getPopulation(), thriftCountry.getTotalGdp(), thriftCountry.getTotalArea()));
			}
			transport.close();
			return countries;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	

}
