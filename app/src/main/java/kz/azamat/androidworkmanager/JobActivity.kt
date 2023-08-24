package kz.azamat.androidworkmanager

import android.annotation.SuppressLint
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.app.job.JobService
import android.content.ComponentName
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.work.Constraints
import androidx.work.WorkManager
import androidx.work.WorkRequest
import androidx.work.Worker
import kz.azamat.androidworkmanager.alarmmanager.AlarmManagerWork
import kz.azamat.androidworkmanager.jobscheduler.JobSchedulerWork

class JobActivity : AppCompatActivity() {

//    private val work by lazy { AlarmManagerWork(this) }
    private val work by lazy { JobSchedulerWork(this) }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job)

        findViewById<Button>(R.id.start_button).setOnClickListener {
            work.planWork()
        }

        findViewById<Button>(R.id.cancel_button).setOnClickListener {
            work.cancelWork()
        }
    }
}