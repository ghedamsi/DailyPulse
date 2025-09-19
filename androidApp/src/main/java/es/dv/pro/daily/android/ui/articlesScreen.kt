package es.dv.pro.daily.android.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.dv.pro.daily.articles.Article
import es.dv.pro.daily.articles.ArticlesViewModel
import coil.compose.AsyncImage

@Composable
fun articlesScreen(
    onAboutBackButton:() ->Unit,
    articlesViewModel: ArticlesViewModel
) {
    val articlesStates=articlesViewModel.articleState.collectAsState()
    Column {
        appBar(onAboutBackButton)
        if (articlesStates.value.loading)
            Loader()
        if(articlesStates.value.error!=null)
            ErrorMessage(articlesStates.value.error!!)
        if (articlesStates.value.articles.isNotEmpty())
            ArticlesListView(articlesStates.value.articles)

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun appBar(
    onAboutBackButton:() ->Unit,
    ){
    TopAppBar(
        title = {
            Text(text =
            "Articles",
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                style = TextStyle(Color.Black, fontWeight=FontWeight.Bold)
            )

        },
        actions = {
            IconButton(onClick = onAboutBackButton) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "About Device Button"
                )
            }
        }
    )
}
@Composable
private fun ArticlesListView(articles:List<Article>){
    LazyColumn( modifier = Modifier.fillMaxSize()) {
        items(articles){article->
            ArticleItemView(article)
        }

    }
}

@Composable
private fun ArticleItemView(article: Article){
    Column( modifier = Modifier.fillMaxSize().padding(16.dp))  {

        AsyncImage(
            model=article.imageUrl,
            contentDescription=null,
            modifier = Modifier.fillMaxSize(),
            contentScale= ContentScale.Crop


        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text =article.desc,
            fontSize =18.sp,
            style = TextStyle(Color.Black, fontWeight=FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text =article.desc,
            fontSize =16.sp,
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(4.dp))

    }
}

@Composable
private fun  Loader(){
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = MaterialTheme.colorScheme.surfaceVariant,
            trackColor = MaterialTheme.colorScheme.secondary

        )
    }
}
@Composable
private fun ErrorMessage(message:String){
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ){
        Text(
                text = message,
               style = TextStyle(fontSize =28.sp, textAlign = TextAlign.Center)
        )
    }
    
}
