package com.jcisneros12.mygooglegeminiapp.feature.story_generator

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jcisneros12.mygooglegeminiapp.R
import com.jcisneros12.mygooglegeminiapp.feature.common.AppButton
import com.jcisneros12.mygooglegeminiapp.feature.common.LoadingLottieView
import com.jcisneros12.mygooglegeminiapp.navigation.Screen
import com.jcisneros12.mygooglegeminiapp.ui.theme.jostSansFamily
import com.jcisneros12.mygooglegeminiapp.utils.RequestState


/**
 * @author Juan Cisneros on 03/03/2024
 */

@Composable
fun StoryGeneratedScreen(
    navController: NavController,
    promptString: String,
    viewModel: StoryGeneratedViewModel = hiltViewModel()
) {
    val data by viewModel.data(promptString).collectAsState(initial = RequestState.Idle)

    if (promptString.isEmpty()) navController.popBackStack()

    Surface(
        color = Color.Black
    ) {
        Box {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.story_generated_bg_image),
                contentScale = ContentScale.FillBounds,
                contentDescription = null
            )
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(end = 30.dp, top = 30.dp),
                        tint = Color.White,
                        painter = painterResource(id = R.drawable.ic_favorite_heart),
                        contentDescription = null
                    )
                }
                data.DisplayResult(
                    onLoading = { LoadingLottieView() },
                    onSuccess = {
                        KidStoryGeneratedText(
                            textTittle = data.getSuccessData().tittle,
                            textStory = data.getSuccessData().story
                        )
                    },
                    onError = {
                        Text(text = it, color = Color.White)
                    }
                )
            }
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 20.dp)
            ) {
                AppButton(
                    "Time to sleep",
                    icon = R.drawable.moon_dark_mode_24px
                ) {
                    navController.navigate(route = Screen.WelcomeScreen.route)
                }
            }
        }
    }
}

@Composable
fun KidStoryGeneratedText(
    modifier: Modifier = Modifier,
    textTittle: String? = "",
    textStory: String? = "",
    textError: String = ""
) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .padding(all = 22.dp)
    ) {
        if (textError.isEmpty()) {
            Text(
                text = textTittle ?: "",
                modifier = modifier.padding(bottom = 28.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                color = Color.White,
                fontFamily = jostSansFamily
            )

            Text(
                text = textStory ?: "",
                modifier = modifier,
                color = Color.White,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                fontFamily = jostSansFamily
            )

            Spacer(modifier = Modifier.height(100.dp))
        } else {
            Text(text = textError)
        }
    }
}

@Preview
@Composable
fun StoryGeneratedScreenPreview() {
    StoryGeneratedScreen(
        rememberNavController(),
        ""
    )
}