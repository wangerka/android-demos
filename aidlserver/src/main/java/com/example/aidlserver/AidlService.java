package com.example.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.example.aidl.IMyAidlInterface;

/**
 * Created by gejun on 2016/12/30.
 */

public class AidlService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public IMyAidlInterface.Stub binder = new IMyAidlInterface.Stub() {
        @Override
        public int add(int a, int b) throws RemoteException {
            return a + b;
        }
    };
}
