package kz.azamat.androidworkmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.concurrent.TimeUnit

class WorkManagerSecond (context: Context, parameters: WorkerParameters) : Worker(context, parameters) {

    private val TAG = this.javaClass.simpleName

    override fun doWork(): Result {
        Log.d(TAG, "doWork: start")

        try {
            (0 until  10).forEach {
                TimeUnit.SECONDS.sleep(10)
                Log.d(TAG, "${it}, isStopped: $isStopped")
                if (isStopped)
                    return Result.failure()
            }
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        Log.d(TAG, "doWork: end")
        return Result.success()
    }

    override fun onStopped() {
        super.onStopped()
        Log.d(TAG, "onStopped: ")
    }

}