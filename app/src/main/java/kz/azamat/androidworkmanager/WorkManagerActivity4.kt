package kz.azamat.androidworkmanager

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import kz.azamat.androidworkmanager.input_output_wm.MyFirstWorker
import kz.azamat.androidworkmanager.input_output_wm.MySecondWorker
import kz.azamat.androidworkmanager.input_output_wm.MyThirdWorker


class WorkManagerActivity4 : AppCompatActivity() {

    private val TAG: String = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager4)

        val myData: Data = Data.Builder()
            .putString("keyA", "value1")
            .putInt("keyB", 1)
            .build()

        val myWorkRequest1: OneTimeWorkRequest = OneTimeWorkRequestBuilder<MyFirstWorker>()
            .setInputData(myData)
            .build()

        val myWorkRequest2: OneTimeWorkRequest = OneTimeWorkRequestBuilder<MySecondWorker>()
            .build()

        val myWorkRequest3: OneTimeWorkRequest = OneTimeWorkRequestBuilder<MyThirdWorker>()
            .setInputMerger(ArrayCreatingInputMerger::class.java)
            .build()

//        WorkManager
//            .getInstance(this)
//            .beginWith(myWorkRequest1)
//            .then(myWorkRequest2)
//            .enqueue()

        WorkManager
            .getInstance(this)
            .beginWith(listOf(myWorkRequest1, myWorkRequest2))
            .then(myWorkRequest3)
            .enqueue()

        WorkManager
            .getInstance(this)
            .getWorkInfoByIdLiveData(myWorkRequest1.id)
            .observe(this) { info ->
                when (info?.state) {
                    WorkInfo.State.FAILED -> {

                    }
                    WorkInfo.State.SUCCEEDED -> {
                        val valueA = info.outputData.getString("keyA")
                        val valueB = info.outputData.getInt("keyB", 0)
                        val valueC = info.outputData.getString("keyC")
                        Log.e(TAG, "value: $valueA" )
                        Log.e(TAG, "value: $valueB" )
                        Log.e(TAG, "value: $valueC" )
                    }
                    else -> {

                    }
                }
            }

    }
}