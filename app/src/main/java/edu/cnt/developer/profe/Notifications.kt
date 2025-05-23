package edu.cnt.developer.profe

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import edu.cnt.developer.profe.dogs.DogsActivity

object Notifications {
    const val ID_CANAL = "CANAL 1 CNTGPROFE"
    const val NOMBRE_CANAL = "CANAL CNTGPROFE"

    fun launchNotification (context: Context) {
        Log.d("MYAPP", "Notifications: launchNotification: start")
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //creo el canal
            var notificationChannel = createNotificationChannel(context)
            notificationManager.createNotificationChannel(notificationChannel!!)
        }

        var nb = NotificationCompat.Builder(context, ID_CANAL)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.imc_perfect))
            .setContentTitle("BUENOS DÍAS")
            .setSubText("aviso")
            .setContentText("Vamos a ver fotos de perros")
            .setAutoCancel(true)//cuando toque la noti, se deja de ver
            .setDefaults(Notification.DEFAULT_ALL)

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            //le asigno un sonido por si esta notificación es de un movil 7 y no tiene canal
            nb.setSound(Uri.parse("android.resource://" + context.packageName + "/" + R.raw.snd_noti))

        }

        var intentPerros = Intent(context, DogsActivity::class.java)
        var pendingIntent = PendingIntent.getActivity(context, 100, intentPerros, PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE)
        nb.setContentIntent(pendingIntent)

        var notication = nb.build()
        notificationManager.notify(500, notication)//lanzo la notificación
        Log.d("MYAPP", "Notifications: launchNotification: finish")
    }

    //@TargetApi(Build.VERSION_CODES.O)//DESAPARECE EL WARNING Y ADEMÁS, AL LLAMANTE, NO LE OBLIGA A GESTIONAR QUE ESTÁ EN UNA VERSIÓN ADECUADA
    @RequiresApi(Build.VERSION_CODES.O)//DESAPARECE EL WARNING Y ADEMÁS, AL LLAMANTE, LE OBLIGA A GESTIONAR QUE ESTÁ EN UNA VERSIÓN ADECUADA
    fun createNotificationChannel (context: Context): NotificationChannel? {
        Log.d("MYAPP", "Notifications: createNotificationChannel: start")
        var notificationChannel : NotificationChannel? = null

        notificationChannel = NotificationChannel(ID_CANAL, NOMBRE_CANAL, NotificationManager.IMPORTANCE_DEFAULT)
        notificationChannel.enableLights(true)
        notificationChannel.enableVibration(true)
        notificationChannel.vibrationPattern = longArrayOf(
            500,
            500,
            500,
            500,
            500,
            500,
            500,
            500
        )

        notificationChannel.lightColor = context.getColor(R.color.blue)

        val audioAttributes = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .setUsage(AudioAttributes.USAGE_NOTIFICATION)
            .build()

        notificationChannel.setSound(
            Uri.parse("android.resource://" + context.packageName + "/" + R.raw.snd_noti),
            audioAttributes
        )

        Log.d("MYAPP", "Notifications: createNotificationChannel: finish")
        return notificationChannel
    }
}