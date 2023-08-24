package kz.azamat.androidworkmanager

import android.app.Application
import androidx.work.Configuration

class App: Application(), Configuration.Provider {
    override fun getWorkManagerConfiguration() =
        Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.DEBUG)
            .build()
}
