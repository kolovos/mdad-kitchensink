package com.kitchensink.util;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import com.kitchensink.R;

public class NotificationUtil {
	
	public static void display(Context context) {
		NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
		.setContentTitle("Notification title")
		.setContentText("Notification text")
		.setSmallIcon(R.drawable.ic_launcher);
		
		NotificationManager notificationManager =
			    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		notificationManager.notify(0, builder.build());
	}
	
}
