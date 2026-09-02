package com.rkd.newsycomposehilt.presentation.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.rkd.newsycomposehilt.domain.model.Article

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(article: Article, onBackClick: () -> Unit) {
    val scrollState = rememberScrollState()
        Scaffold(
            topBar = {
                TopAppBar(

                    title = {
                        Text(article.title)
                    },

                    navigationIcon = {
                        IconButton(
                            onClick = onBackClick
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    },

                    actions = {
                        IconButton(
                            onClick = {
                                // Share later
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Share"
                            )
                        }
                    }
                )
            }
        ) {paddingValues ->

            Column(modifier = Modifier.fillMaxSize().padding(paddingValues).verticalScroll(scrollState)) {


                AsyncImage(

                    model = article.imageUrl,

                    contentDescription = article.title,

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),

                    contentScale = ContentScale.Crop
                )


            }

        }

}