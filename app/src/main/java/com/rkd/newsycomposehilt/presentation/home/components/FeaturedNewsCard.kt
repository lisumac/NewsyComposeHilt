package com.rkd.newsycomposehilt.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.rkd.newsycomposehilt.domain.model.Article
import java.nio.file.WatchEvent

@Composable
fun FeaturedNewsCard(article: Article) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), shape = RoundedCornerShape(20.dp)
    ) {
        AsyncImage(
            model = article.imageUrl,

            contentDescription = article.title,

            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        )
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = article.title,
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = article.description,
                style = MaterialTheme.typography.headlineMedium,
                maxLines = 2
            )
        }

    }
}

@Preview
@Composable
fun PreviewFeaturedNewsCard() {
    FeaturedNewsCard(
        article = Article(
            id = "8",
            imageUrl = "",
            title = "Hey You",
            articleUrl = "",
            publishedAt = "",
            sourceName = "hey",
            description = ""
        )
    )
}