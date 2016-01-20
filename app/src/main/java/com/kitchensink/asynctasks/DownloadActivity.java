package com.kitchensink.asynctasks;

import com.kitchensink.R;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class DownloadActivity extends Activity {
	
	protected DownloadTask downloadTask = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_download);
		final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		
		Button downloadButton = (Button) findViewById(R.id.downloadButton);
		downloadButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				downloadTask = new DownloadTask();
				downloadTask.addListener(new DownloadProgressListener() {
					
					@Override
					public void downloaded(int percent) {
						progressBar.setProgress(percent);
					}
				});
				downloadTask.execute("foo.pdf", "bar.zip", "foo.docx");

				// downloadTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
			}
		});
		
		((Button) findViewById(R.id.cancelDownloadButton)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				downloadTask.cancel(true);
			}
		});

	}
	
}
