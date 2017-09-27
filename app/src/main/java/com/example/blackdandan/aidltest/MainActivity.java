package com.example.blackdandan.aidltest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("xm====mainActivity.connection.service connected :"+ Process.myPid());
            if (service!=null){
                try {
                    IMyAidlInterface.Stub.asInterface(service).sayHello();
                } catch (RemoteException e) {
                    
                }
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,MyService.class);
        bindService(intent,connection,BIND_AUTO_CREATE);
    }
}
