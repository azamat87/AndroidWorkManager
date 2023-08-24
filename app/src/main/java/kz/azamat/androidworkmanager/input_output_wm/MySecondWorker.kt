package kz.azamat.androidworkmanager.input_output_wm

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class MySecondWorker(context: Context, parameters: WorkerParameters): Worker(context, parameters) {

    private val TAG = this.javaClass.simpleName

    override fun doWork(): Result {

//        val valueA = inputData.getString("keyA")
//        val valueB = inputData.getInt("keyB", 0)
//        Log.d(TAG, "doWork:valueA $valueA")
//        Log.d(TAG, "doWork:valueB $valueB")

        val output = Data.Builder()
            .putString("keyA", "value2")
            .putInt("keyB", 2)
            .putString("keyD", "valueD")
            .build()

        return Result.success(output)
    }
}