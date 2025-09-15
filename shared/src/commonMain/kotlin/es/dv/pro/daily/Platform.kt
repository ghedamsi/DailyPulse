package es.dv.pro.daily

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform