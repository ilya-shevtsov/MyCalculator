package com.example.myapplication

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

class ActionService : Service() {

    private lateinit var nManager: NotificationManager
    private lateinit var nBuilder: NotificationCompat.Builder

    companion object {
        private const val TAG = "ActionService"

    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        Log.d(TAG, "onCreate")

        nManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nBuilder = getNotificationBuilder()
        nBuilder.setContentTitle("Action service notification")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onCommand")

        nManager.notify(
            123,
            getNotification("Why are you not calculating something? GET BACK!")
        )
        return START_STICKY
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        val intentActionService = Intent(this, ActionService::class.java)
        stopService(intentActionService)
    }

    private fun getNotification(contentText: String): Notification {
        return nBuilder.setContentText(contentText).build()
    }

    private fun getNotificationBuilder(): NotificationCompat.Builder {
        return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            NotificationCompat.Builder(this)
        } else {
            val channelId = "my_channel_id"
            if (nManager.getNotificationChannel(channelId) == null) {
                val channel =
                    NotificationChannel(
                        channelId,
                        "text for user",
                        NotificationManager.IMPORTANCE_LOW
                    )
                nManager.createNotificationChannel(channel)
            }
            NotificationCompat.Builder(this, channelId)
        }
    }
}