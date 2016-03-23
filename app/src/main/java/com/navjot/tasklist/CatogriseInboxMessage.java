package com.navjot.tasklist;

import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;

public class CatogriseInboxMessage extends Service {

    private static String SMS_URI = "content://sms/inbox";
    private Cursor dataBaseCursor = null;
    public CatogriseInboxMessage() {
        super();
    }

    @Override
    public void onCreate() {
        Uri smsInboxUri = Uri.parse(CatogriseInboxMessage.SMS_URI);
        dataBaseCursor = getContentResolver().query(smsInboxUri, null, null, null, null);
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return 1;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
