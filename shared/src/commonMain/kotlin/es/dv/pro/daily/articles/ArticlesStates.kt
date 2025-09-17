package es.dv.pro.daily.articles

data class ArticlesStates (
    val articles:List<Article> = listOf(),
    val loading:Boolean=false,
    val error:String?=null
)