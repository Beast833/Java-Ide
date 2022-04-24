package com.pranav.java.ide

import android.app.Application
import android.content.Context
import android.os.Process
import android.util.Log
import com.pranav.lib_android.util.FileUtil
import androidx.appcompat.app.AppCompatActivity

class ApplicationLoader : Application() {

	override fun onCreate() {
	super.onCreate()
		val mContext = getApplicationContext()
		FileUtil.initializeContext(mContext)
		val uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()

		Thread.setDefaultUncaughtExceptionHandler {
				thread, throwable -> 
					val errorMessage = Log.getStackTraceString(throwable)
					MaterialAlertDialogBuilder(mContext)
				        .setTitle("An error occurred")
				        .setMessage(errorMessage)
			        	.setPositiveButton("Quit", {_, _ -> finish()})
				        .create()
				        .show()

					Process.killProcess(Process.myPid())
					System.exit(0)

					uncaughtExceptionHandler?.uncaughtException(thread, throwable)
				}
	}
}
