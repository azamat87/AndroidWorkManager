package kz.azamat.androidworkmanager.jobscheduler

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.app.job.JobService
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import androidx.core.content.getSystemService
import kz.azamat.androidworkmanager.AbsWorker
import kz.azamat.androidworkmanager.Receiver

// for Android 12 & 13

class JobSchedulerWork(context: Context): AbsWorker {

    private val componentName = ComponentName(context, MyJobService::class.java)
    private val jobScheduler = context.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

    override fun planWork() {
        val jobInfo = JobInfo.Builder(1, componentName)
            .setPersisted(true)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_CELLULAR)
            .setPeriodic(5000000)
            .build()
        jobScheduler.schedule(jobInfo)
    }

    override fun cancelWork() {
        jobScheduler.cancel(1)
    }

}