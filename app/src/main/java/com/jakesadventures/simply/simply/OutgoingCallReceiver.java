package com.jakesadventures.simply.simply;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class OutgoingCallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String state = extras.getString(TelephonyManager.EXTRA_STATE);
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                Intent intent1=new Intent(context, CallActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent1);

            }
        }
    }
}
