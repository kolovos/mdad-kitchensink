package com.kitchensink.notifications;

import com.kitchensink.MainActivity;
import com.kitchensink.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ToastsActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toasts);
		
		((Button) findViewById(R.id.toastButton)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(ToastsActivity.this, "Toast text", Toast.LENGTH_LONG);
				toast.setGravity(Gravity.BOTTOM, 0, 0);
				toast.show();
			}
		});
	}
	
}
