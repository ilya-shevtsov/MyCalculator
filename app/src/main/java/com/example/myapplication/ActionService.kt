package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class ActionService : Service() {

    companion object {
        private const val TAG = "ActionService"

    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        Log.d(TAG,"onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG,"onCommand")
        return START_STICKY
    }



    override fun onDestroy() {
        Log.d(TAG,"onDestroy")
    }


}