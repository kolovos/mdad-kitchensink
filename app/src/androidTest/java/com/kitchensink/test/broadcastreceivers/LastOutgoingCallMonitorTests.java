package com.kitchensink.test.broadcastreceivers;

import com.kitchensink.broadcastreceivers.LastOutgoingCallMonitor;

import android.content.Intent;
import android.test.AndroidTestCase;

public class LastOutgoingCallMonitorTests extends AndroidTestCase {
	
	public void testLastNumber() {
		String number = "07787000000";
		Intent intent = new Intent(Intent.ACTION_NEW_OUTGOING_CALL);
        intent.putExtra(Intent.EXTRA_PHONE_NUMBER, number);
        
        LastOutgoingCallMonitor monitor = new LastOutgoingCallMonitor();
        monitor.onReceive(getContext(), intent);
        assertEquals(number, monitor.getLastNumber());
	}
	
}
