package com.kitchensink.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class IncomingSmsLogger extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		Bundle extras = intent.getExtras();
	    if (extras != null) {
	    	// Get the encoded SMSs from the intent's extras
	    	Object[] pdus = (Object[]) extras.get("pdus");

            for (int i = 0; i < pdus.length; i++) {
            	// Decode each SMS and toast its body
            	String messageBody = SmsMessage.createFromPdu((byte[])pdus[i]).getMessageBody();
                Toast.makeText(context, 
                		"Received SMS: " + messageBody, 
                		Toast.LENGTH_SHORT).show();
            }
	    }
	}

}
