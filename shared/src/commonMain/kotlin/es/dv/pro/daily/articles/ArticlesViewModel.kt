package es.dv.pro.daily.articles

import es.dv.pro.daily.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel: BaseViewModel() {
    private val _articleStateFlow:MutableStateFlow<ArticlesStates> = MutableStateFlow(ArticlesStates(loading = true))
    val articleState:StateFlow<ArticlesStates> get() = _articleStateFlow
    init {
        getArticles()
    }
    private fun getArticles(){
        scope.launch {
            delay(1500)
            _articleStateFlow.emit(ArticlesStates(error = "Fuck it happend !!!"))

            delay(1500)

            val fetched=fetchArticles()
            _articleStateFlow.emit(ArticlesStates(articles = fetched))
        }
    }
    suspend fun fetchArticles():List<Article> = mockArticles
    private val mockArticles = listOf(
        Article(
        "Stock market today: Live updates - CNBC",
            "Futures were higher in premarket trading as Wall Street tried to regain its footing.",
            "2023-11-89",
            "https://images.unsplash.com/photo-1575936123452-b67c3203c357?q=80&w=870&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
        ),
         Article(
                "Best iPhone Deals (2023): Carrier Deals, Unlocked iPhones",
        "Apple's smartphones rarely go on sale, but if you're looking to upgrade (or you're gift shopping), here ",
        "2023-11-09",
        "https://images.unsplash.com/photo-1576158113928-4c240eaaf360?q=80&w=580&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
         )
        ,
        Article(
            "Samsung details 'Galaxy AI' and a feature that can translate phone calls in real time",
            "n a new blog post, Samsung previewed what it calls \"a new era of Galaxy AI coming to its smartphones",
            "2023-11-09",
            "https://images.unsplash.com/photo-1566438480900-0609be27a4be?q=80&w=394&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
        )

    )
}