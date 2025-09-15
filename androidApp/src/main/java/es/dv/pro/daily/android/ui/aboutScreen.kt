package es.dv.pro.daily.android.ui

import android.icu.text.CaseMap.Title
import android.widget.Toolbar
import androidx.annotation.ContentView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import es.dv.pro.daily.Platform

@Composable
fun aboutScreen() {
    Column {
        Toolbar()
        ContentViews()

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(){
    TopAppBar(
        title = {
            Text(text =
                "Android Device")

        }
    )
}
@Composable
private fun ContentViews(){
    val items=makeItems()
    LazyColumn(
        modifier= Modifier.fillMaxSize()
    ) {
        items(items){row->
            RowView(
                title=row.first,subTitle=row.second
            )
        }
    }
}

private fun makeItems():List<Pair<String,String>>{
    val platfrom=Platform()
    return listOf(
        Pair("Operation System","${platfrom.osName} ${platfrom.osVersion}"),
        Pair("Devise","${platfrom.deviseModel}"),
        Pair("Density","${platfrom.density.toString()}")
    )
}
@Composable
private fun RowView(title: String,subTitle: String){
    Column (modifier = Modifier.fillMaxSize()){
        Column(Modifier.padding(8.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodySmall,
                color = Color.White
            )
            Text(
                text = subTitle,
                style = MaterialTheme.typography.bodySmall,
                color = Color.White
            )

        }
        Divider()
    }
}
