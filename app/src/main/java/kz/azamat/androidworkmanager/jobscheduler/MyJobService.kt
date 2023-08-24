package kz.azamat.androidworkmanager.jobscheduler

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class MyJobService: JobService() {

    override fun onStartJob(params: JobParameters?): Boolean {
        Log.e("JOB", "onStartJob")

        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.e("JOB", "onStopJob")
        return true
    }
}