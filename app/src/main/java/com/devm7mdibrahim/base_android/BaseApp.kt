package com.devm7mdibrahim.base_android

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.os.Build
import com.devm7mdibrahim.data.remote.utils.NetworkConstants.Languages.ARABIC
import com.devm7mdibrahim.utils.extensions.ThemeHelper
import com.akexorcist.localizationactivity.ui.LocalizationApplication
import dagger.hilt.android.HiltAndroidApp
import java.util.*

@HiltAndroidApp
class BaseApp : LocalizationApplication() {

    private lateinit var notificationManager: NotificationManager

    companion object {
        const val CHANNEL_ID = "base_channel_id"
        const val CHANNEL_NAME = "base_channel"
    }

    override fun getDefaultLanguage(base: Context): Locale {
        return Locale(ARABIC)
    }

    override fun onCreate() {
        super.onCreate()
        ThemeHelper.applyTheme(ThemeHelper.ThemeMode.LIGHT)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        notificationManager =
            base.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        createAppChannel()
    }

    private fun createAppChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val notificationChannel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            )

            val defaultSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

            notificationChannel.setSound(
                defaultSound,
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )

            notificationManager.createNotificationChannel(notificationChannel)
        }
    }
}