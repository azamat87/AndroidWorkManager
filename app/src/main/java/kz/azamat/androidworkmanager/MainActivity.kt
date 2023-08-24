package kz.azamat.androidworkmanager

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.Observer
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val constraints = Constraints.Builder()
//            .setRequiresCharging(true)
//            .build()

        val workRequest: WorkRequest = OneTimeWorkRequestBuilder<MyWorker>()
            .addTag("myWorkTag")
            .build()

//        Выполнение задачи можно отложить на указанное время
//        val workDelayRequest: WorkRequest = OneTimeWorkRequestBuilder<MyWorker>()
//            .setInitialDelay(10, TimeUnit.SECONDS)
//            .build()

        val periodicWorkRequest: WorkRequest = PeriodicWorkRequestBuilder<MyWorker>(30, TimeUnit.MINUTES, 25, TimeUnit.MINUTES)
            .build()


        WorkManager.getInstance(this)
            .getWorkInfoByIdLiveData(workRequest.id)
            .observe(this) { workInfo ->
                Log.d(TAG, "onChanged: " + workInfo.state)
            }

        findViewById<AppCompatButton>(R.id.buttonCancel).setOnClickListener {
//            WorkManager.getInstance(this).cancelWorkById(workRequest.id)
//            WorkManager.getInstance(this).cancelAllWorkByTag("myWorkTag")
            WorkManager
                .getInstance(this)
                .enqueue(workRequest)
        }

    }
}