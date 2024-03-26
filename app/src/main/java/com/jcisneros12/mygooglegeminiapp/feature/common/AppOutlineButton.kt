package com.jcisneros12.mygooglegeminiapp.feature.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jcisneros12.mygooglegeminiapp.R
import com.jcisneros12.mygooglegeminiapp.ui.theme.AppPurple
import com.jcisneros12.mygooglegeminiapp.ui.theme.jostSansFamily
import java.time.format.TextStyle


/**
 * @author Juan Cisneros on 14/03/2024
 */

@Composable
fun AppOutlineButton(
    text: String = "Text button",
    icon: Int? = null,
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 1.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
        ),
        onClick = { onClick.invoke() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(if (icon!=null) 20.dp else 0.dp))
            Text(
                modifier = Modifier.padding(horizontal = 20.dp),
                text = text,
                style = androidx.compose.ui.text.TextStyle(
                    fontFamily = jostSansFamily,
                    fontWeight = FontWeight.Bold
                ),
                color = AppPurple,
            )
            if (icon != null) {
                Icon(painter = painterResource(id = icon),
                    contentDescription = null,
                    tint = AppPurple)
            }
        }
    }
}

@Composable
@Preview(
    showBackground = true
)
fun AppOutlineButtonPreview(){
    AppOutlineButton(
        text = "Read my saved stories",
        icon = R.drawable.ic_favorite_heart
    ) {
        // on click
    }
}