package com.navjot.tasklist;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class CatogriseInboxMessage extends Service {
    public CatogriseInboxMessage() {
        super();
    }

    public void OnCreate() {

    }

    public void OnDestroy() {

    }

    @Override
    public void OnStartCommand(Intent intent, int flags, int startId) {
        handleCommand(intent);
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
