package com.example.blackdandan.aidltest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        System.out.println("do====MyService.onCreate.process:"+ Process.myPid());
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       return mBinder;
    }
//    IMyService.Stub mBinder = new Stub(){
//        @Override
//        int plus(int a,int b){
//         return 0;
//        }
//        String toUpperCase(String str){
//            return str.toUpperCase();
//        }
//    };
    IMyAidlInterface.Stub mBinder = new IMyAidlInterface.Stub() {

        @Override
        public void sayHello() throws RemoteException {
            System.out.println("xm====Hello :"+Process.myPid());
        }
    };
}
