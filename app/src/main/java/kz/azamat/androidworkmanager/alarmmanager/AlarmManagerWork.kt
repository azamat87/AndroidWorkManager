package kz.azamat.androidworkmanager.alarmmanager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import kz.azamat.androidworkmanager.AbsWorker
import kz.azamat.androidworkmanager.Receiver

// for Android 12 & 13

class AlarmManagerWork(context: Context): AbsWorker {

    private val alarmManager = context.getSystemService(AlarmManager::class.java)
    private val intent = Intent("ActionID", null, context, Receiver::class.java)
    private val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT)


    override fun planWork() {
        alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + 5000, pendingIntent)
    }

    override fun cancelWork() {
        alarmManager.cancel(pendingIntent)
    }

}