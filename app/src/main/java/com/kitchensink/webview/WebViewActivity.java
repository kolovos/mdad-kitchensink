package com.kitchensink.webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kitchensink.R;
import com.kitchensink.R.id;
import com.kitchensink.R.layout;
import com.kitchensink.R.menu;
import com.kitchensink.util.KitchenSinkActivity;

public class WebViewActivity extends Activity {

	protected WebView webView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view);
		webView = (WebView) findViewById(R.id.webView);
		webView.setWebViewClient(new WebViewClient());
		webView.getSettings().setJavaScriptEnabled(true);
		webView.addJavascriptInterface(new JavaScriptAPI(this), "Android");
		webView.loadUrl("file:///android_asset/embedded.html");
		//webView.loadUrl("http://www.bbc.co.uk");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.web_view, menu);
		return true;
	}

}
