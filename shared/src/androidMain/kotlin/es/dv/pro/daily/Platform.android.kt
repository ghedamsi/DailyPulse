package es.dv.pro.daily

import android.content.res.Resources
import android.os.Build
import android.util.Log
import kotlin.math.round

actual class Platform(){
    actual val osName: String
        get() = "Android"
    actual val deviseModel: String
        get() = "${Build.VERSION.SDK_INT}"
    actual val osVersion: String
        get() = "${Build.MANUFACTURER} ${Build.MODEL}"
    actual val density: Int
        get() = round(Resources.getSystem().displayMetrics.density).toInt()

    actual fun logSystem() {
        Log.e("Daily Pulse", "($osName,$osVersion,$deviseModel,$density) " )
    }

}