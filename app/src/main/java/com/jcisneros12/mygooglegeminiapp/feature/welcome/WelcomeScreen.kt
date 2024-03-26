package com.jcisneros12.mygooglegeminiapp.feature.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jcisneros12.mygooglegeminiapp.R
import com.jcisneros12.mygooglegeminiapp.feature.common.AppButton
import com.jcisneros12.mygooglegeminiapp.feature.common.AppOutlineButton
import com.jcisneros12.mygooglegeminiapp.navigation.Screen
import com.jcisneros12.mygooglegeminiapp.ui.theme.jostSansFamily


/**
 * @author Juan Cisneros on 03/03/2024
 */

@Composable
fun WelcomeScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = Color.Black
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.welcome_main_image),
                contentDescription = null
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Let's read a bedtime story",
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        fontFamily = jostSansFamily
                    )
                )
                Spacer(modifier = Modifier.height(14.dp))

                Text(text = "It's time to create a story with \n" +
                        "Google Gemini",
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        fontFamily = jostSansFamily
                    ),
                    textAlign = TextAlign.Center
                )
            }

            Column {
                AppButton(
                    text = "Let's generate a story",
                    icon = R.drawable.ic_ia_magic_stars
                ) {
                    navController.navigate(route = Screen.StoryGeneratorScreen.route)
                }

                Spacer(modifier = Modifier.height(14.dp))

                AppOutlineButton(
                    text = "Read my saved stories",
                    icon = R.drawable.ic_favorite_heart
                ) {
                    // todo navigate
                }
            }
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(rememberNavController())
}