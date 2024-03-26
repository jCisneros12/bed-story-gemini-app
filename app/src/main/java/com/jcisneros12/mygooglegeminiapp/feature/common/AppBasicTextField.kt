package com.jcisneros12.mygooglegeminiapp.feature.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jcisneros12.mygooglegeminiapp.ui.theme.AppOnBackground


/**
 * @author Juan Cisneros on 15/03/2024
 */
@Composable
fun AppBasicTextField(
    placeHolderText: String = "Placeholder text",
    onValueChange: (text: String) -> Unit
) {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppOnBackground, shape = CircleShape)
            .border(color = AppOnBackground, width = 2.dp, shape = CircleShape),
        shape = CircleShape,
        value = text,
        textStyle = TextStyle(color = Color.White),
        placeholder = { Text(text = placeHolderText) },
        onValueChange = {
            text = it
            onValueChange(it) },
    )
}

@Preview(showBackground = true)
@Composable
fun AppBasicTextFieldPreview() {
    AppBasicTextField(
        placeHolderText = "A little unicorn..."
    ) {
        // ...
    }
}