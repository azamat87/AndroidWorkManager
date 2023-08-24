package kz.azamat.androidworkmanager.workers

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.concurrent.TimeUnit

class Worker4(context: Context, parameters: WorkerParameters) : Worker(context, parameters) {
    private val TAG = this.javaClass.simpleName

    override fun doWork(): Result {
        Log.d(TAG, "doWork: start")

        try {
            TimeUnit.SECONDS.sleep(5)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        Log.d(TAG, "doWork: end")
        return Result.success()
    }

    override fun onStopped() {
        super.onStopped()
        Log.d(TAG, "onStopped")
    }
}