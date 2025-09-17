package es.dv.pro.daily

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {
    val scope:CoroutineScope

}