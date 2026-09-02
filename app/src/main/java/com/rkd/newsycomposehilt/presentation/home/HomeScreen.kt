package com.rkd.newsycomposehilt.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rkd.newsycomposehilt.domain.model.Article
import com.rkd.newsycomposehilt.presentation.Search.SearchBar
import com.rkd.newsycomposehilt.presentation.home.components.CategoryChip
import com.rkd.newsycomposehilt.presentation.home.components.FeaturedNewsCard
import com.rkd.newsycomposehilt.presentation.home.components.LoadingView
import com.rkd.newsycomposehilt.presentation.home.components.NewsCard
import kotlinx.coroutines.flow.map


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen( state:HomeState,  onArticleClick: (Article) -> Unit) {

    var query by remember {
        mutableStateOf("")
    }

    var selectedCategory by remember {
        mutableStateOf("Technology")
    }


    val categories = listOf(
        "Technology",
        "Sports",
        "Business",
        "Health"
    )

    Scaffold(

        topBar = {

            CenterAlignedTopAppBar(

                title = {



                },

                actions = {

                    IconButton(
                        onClick = {}
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = null
                        )

                    }

                }

            )

        }

    ) { padding ->

        LazyColumn(

            modifier = Modifier
                .fillMaxSize()
                .padding(padding),

            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {

            item {

                Column {

                    Text(
                        "Good Morning 👋",
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )

                    Text(
                        "Discover today's breaking news",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )

                }

            }

            item {

                SearchBar(

                    query = query,

                    onQueryChange = {

                        query = it

                    }

                )

            }

            item {

                LazyRow(

                    contentPadding = PaddingValues(horizontal = 16.dp),

                    horizontalArrangement = Arrangement.spacedBy(8.dp)

                ) {

                    items(categories) {

                        CategoryChip(

                            title = it,

                            selected = selectedCategory == it,

                            onClick = {

                                selectedCategory = it

                            }

                        )

                    }

                }

            }

            item {

                Text(

                    text = "Featured News",

                    style = MaterialTheme.typography.titleLarge,

                    modifier = Modifier.padding(horizontal = 16.dp)

                )

            }

            item {

                FeaturedNewsCard(

                    article =state.articles.first()

                )

            }

            item {

                Text(

                    text = "Breaking News",

                    style = MaterialTheme.typography.titleLarge,

                    modifier = Modifier.padding(horizontal = 16.dp)

                )

            }

            items(state.articles) {articles->

                NewsCard(

                    article = articles,

                    modifier = Modifier.padding(horizontal = 16.dp),
                    onClick = {
                        onArticleClick(articles)
                    }


                )

            }

            item {

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

            }

        }

    }

}
@Preview
@Composable
fun previewHomeScreen(){
    //HomeScreen()
}
@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel(),
    onArticleClick: (Article) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    when {
        state.isLoading -> {
            LoadingView()
        }

        state.error.isNotEmpty() -> {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error
            )
        }

        else -> {
            HomeScreen(
                state = state,
                onArticleClick = onArticleClick
            )
        }
    }
}