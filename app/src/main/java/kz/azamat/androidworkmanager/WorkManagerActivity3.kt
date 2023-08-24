package kz.azamat.androidworkmanager

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkContinuation
import androidx.work.WorkManager
import kz.azamat.androidworkmanager.workers.*
import java.util.Timer


class WorkManagerActivity3 : AppCompatActivity() {

    private val TAG = this.javaClass.simpleName

    @SuppressLint("EnqueueWork")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager3)

//        WorkManager
//            .getInstance(this)
//            .beginWith(worker1)
//            .then(worker2)
//            .then(worker3)
//            .enqueue()

//        WorkManager
//            .getInstance(this)
//            .beginWith(listOf(worker1, worker2))
//            .then(listOf(worker3, worker4))
//            .then(worker5)
//            .enqueue()

//        val chain12: WorkContinuation = WorkManager
//            .getInstance(this)
//            .beginWith(worker1)
//            .then(worker2)
//
//        val chain34: WorkContinuation = WorkManager
//            .getInstance(this)
//            .beginWith(worker3)
//            .then(worker4)
//
//        WorkContinuation.combine(listOf(chain12, chain34))
//            .then(worker5)
//            .enqueue()

//        WorkManager
//            .getInstance(this)
//            .enqueue(worker1)


        findViewById<AppCompatButton>(R.id.startWork).setOnClickListener {
            Log.e(TAG, "enqueue APPEND_OR_REPLACE")
            work()
        }
    }

    private fun work() {
        val worker1 = OneTimeWorkRequestBuilder<Worker1>()
            .build()
        val worker2 = OneTimeWorkRequestBuilder<Worker2>()
            .build()
        val worker3 = OneTimeWorkRequestBuilder<Worker3>()
            .build()
        val worker4 = OneTimeWorkRequestBuilder<Worker4>()
            .build()
        val worker5 = OneTimeWorkRequestBuilder<Worker5>()
            .build()

        WorkManager.getInstance(this)
            .beginUniqueWork("work123", ExistingWorkPolicy.APPEND_OR_REPLACE, worker1)
            .then(worker3)
            .then(worker5)
            .enqueue()
    }
}