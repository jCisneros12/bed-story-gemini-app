package com.jcisneros12.mygooglegeminiapp.feature.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jcisneros12.mygooglegeminiapp.ui.theme.AppOnBackground


/**
 * @author Juan Cisneros on 15/03/2024
 */

@Composable
fun AppStoryCard(
    tittleText: String,
    contentText: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.padding(10.dp).clickable { onClick.invoke() },
        colors = CardDefaults.cardColors(
            containerColor = AppOnBackground,
            contentColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = tittleText,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
            )
            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = contentText,
                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AppStoryCardPreview() {
    AppStoryCard(
        tittleText = "A little unicorn",
        contentText = "In a shimmering valley nestled between rolling hills, lived a little unicorn named Luna. Unlike other unicorns, Luna's coat wasn't the ... In a shimmering valley nestled between rolling hills, lived a little unicorn named Luna. Unlike other unicorns, Luna's coat wasn't the ... In a shimmering valley nestled between rolling hills, lived a little unicorn named Luna. Unlike other unicorns, Luna's coat wasn't the"
    ) {
        // ...
    }
}