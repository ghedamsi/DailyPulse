package es.dv.pro.daily

import platform.Foundation.NSLog
import platform.UIKit.UIDevice
import platform.UIKit.UIScene
import platform.UIKit.UIScreen

actual class  Platform {
    actual val osName: String
        get() = UIDevice.currentDevice.systemName()
    actual val deviseModel: String
        get() = UIDevice.currentDevice.systemVersion
    actual val osVersion: String
        get() = UIDevice.currentDevice.model
    actual val density: Int
        get() = UIScreen.mainScreen.scale.toInt()

    actual fun logSystem() {
        NSLog( "($osName,$osVersion,$deviseModel,$density) " )

    }
}

