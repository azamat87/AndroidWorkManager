package kz.azamat.androidworkmanager

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest

class WorkManagerActivity2 : AppCompatActivity() {

    private val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager2)

//        criteria

        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .build()

        val workRequest: WorkRequest = OneTimeWorkRequestBuilder<WorkManagerSecond>()
            .setConstraints(constraints)
            .build()

        WorkManager
            .getInstance(this)
            .enqueue(workRequest)

        WorkManager.getInstance(this)
            .getWorkInfoByIdLiveData(workRequest.id)
            .observe(this) { workInfo ->
                Log.d(TAG, "onChanged: " + workInfo.state)
            }

    }
}