package kz.azamat.androidworkmanager.input_output_wm

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters


class MyThirdWorker(context: Context, parameters: WorkerParameters): Worker(context, parameters) {

    private val TAG = this.javaClass.simpleName

    override fun doWork(): Result {

//        val valueA = inputData.getString("keyA")
//        val valueB = inputData.getInt("keyB", 0)
//        Log.d(TAG, "doWork:valueA $valueA")
//        Log.d(TAG, "doWork:valueB $valueB")

        val valueA = inputData.getStringArray("keyA")
        val valueB = inputData.getIntArray("keyB")
        val valueC = inputData.getStringArray("keyC")
        val valueD = inputData.getStringArray("keyD")

        Log.d(TAG, "valueA ${valueA?.toList()}")
        Log.d(TAG, "valueB ${valueB?.toList()}")
        Log.d(TAG, "valueC ${valueC?.toList()}")
        Log.d(TAG, "valueD ${valueD?.toList()}")

        return Result.success()
    }
}