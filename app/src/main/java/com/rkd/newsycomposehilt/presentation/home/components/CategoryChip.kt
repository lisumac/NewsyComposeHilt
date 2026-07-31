package com.rkd.newsycomposehilt.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CategoryChip(title: String, selected: Boolean, onClick: () -> Unit) {
    Surface(
        Modifier
            .padding(end = 8.dp)
            .clickable { onClick },
        shape = RoundedCornerShape(24.dp), tonalElevation = if (selected) 4.dp else 0.dp
    ) {
        Text(

            text = title,

            modifier = Modifier
                .padding(
                    horizontal = 18.dp,
                    vertical = 10.dp
                ),

            style = MaterialTheme.typography.bodyMedium
        )
    }

}

@Preview
@Composable
fun PreviewCategoryChip() {
    CategoryChip("no", true, onClick = { "hey" })
}