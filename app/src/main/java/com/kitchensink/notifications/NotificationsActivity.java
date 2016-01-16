package com.kitchensink.notifications;

import com.kitchensink.R;
import com.kitchensink.R.drawable;
import com.kitchensink.R.id;
import com.kitchensink.R.layout;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.BigPictureStyle;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.TaskStackBuilder;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

public class NotificationsActivity extends Activity {
	
	protected CheckBox ongoingCheckBox = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_notifications);
		
		ongoingCheckBox = (CheckBox) findViewById(R.id.ongoingCheckBox);
		
		Button notificationButton = (Button) findViewById(R.id.notificationButton);
		notificationButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(NotificationsActivity.this, NotificationsActivity.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(NotificationsActivity.this, 0, intent, 0);
				
				NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationsActivity.this)
					.setContentTitle("Notification title")
					.setContentText("Notification text")
					.setSmallIcon(R.drawable.ic_launcher)
					.setOngoing(ongoingCheckBox.isChecked())
					.setContentIntent(pendingIntent);
				
				NotificationCompat.BigTextStyle style = new BigTextStyle();
				StringBuffer buffer = new StringBuffer();
				for (int i=1;i<=10;i++) {
					buffer.append("Line " + i + " of text.\n");
				}
				style.bigText(buffer.toString());
				builder.setStyle(style);
				
				NotificationManager notificationManager =
					    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				
				Notification notification = builder.build();
				// Hide the notification when it's clicked
				notification.flags |= Notification.FLAG_AUTO_CANCEL;
				
				notificationManager.notify(0, notification);
			}
		});
	}
	
}
