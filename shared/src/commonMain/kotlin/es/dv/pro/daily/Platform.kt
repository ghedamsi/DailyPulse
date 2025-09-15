package es.dv.pro.daily

expect class Platform {

    val osName: String
    val deviseModel:String
    val osVersion:String
    val density:Int
    fun logSystem()
}