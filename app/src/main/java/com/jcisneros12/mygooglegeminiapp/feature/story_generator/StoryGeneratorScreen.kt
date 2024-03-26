package com.jcisneros12.mygooglegeminiapp.feature.story_generator

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults.inputChipColors
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jcisneros12.mygooglegeminiapp.R
import com.jcisneros12.mygooglegeminiapp.feature.common.AppBasicTextField
import com.jcisneros12.mygooglegeminiapp.feature.common.AppButton
import com.jcisneros12.mygooglegeminiapp.navigation.Screen
import com.jcisneros12.mygooglegeminiapp.ui.theme.AppPurple
import com.jcisneros12.mygooglegeminiapp.ui.theme.jostSansFamily
import com.jcisneros12.mygooglegeminiapp.utils.handleSliderRange


/**
 * @author Juan Cisneros on 03/03/2024
 */

@Composable
fun StoryGeneratorScreen(
    navController: NavHostController,
    viewModel: StoryGeneratorViewModel = hiltViewModel()
) {
    var chipSelected by remember { mutableIntStateOf(1) }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = Color.Black
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.purple_moon_25),
                contentScale = ContentScale.Fit,
                contentDescription = "background screen",
                modifier = Modifier.matchParentSize()
            )
            Column(
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                AppTopAppBar()

                Spacer(modifier = Modifier.height(28.dp))

                Text(
                    text = "What will your story be about",
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = jostSansFamily,
                        fontSize = 14.sp
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                AppBasicTextField(
                    placeHolderText = "A little unicorn..."
                ) { text ->
                    viewModel.onAboutTextChange(text)
                }

                Spacer(modifier = Modifier.height(28.dp))

                Text(
                    text = "Gender",
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = jostSansFamily,
                        fontSize = 14.sp
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    AppInputChip(
                        isSelected = chipSelected == 1,
                        text = "Boy"
                    ) {
                        chipSelected = 1
                        viewModel.onGenderChange("Boy")
                    }
                    AppInputChip(
                        isSelected = chipSelected == 2,
                        text = "Girl"
                    ) {
                        chipSelected = 2
                        viewModel.onGenderChange("Boy")
                    }
                    AppInputChip(
                        isSelected = chipSelected == 3,
                        text = "Other"
                    ) { chipSelected = 3 }
                }

                Spacer(modifier = Modifier.height(28.dp))

                Text(
                    text = "Age",
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = jostSansFamily,
                        fontSize = 14.sp
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                AppSlider {
                    viewModel.onAgeChange(it.toString())
                }
            }
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 20.dp)
            ) {
                AppButton(
                    text = "Generate story",
                    icon = R.drawable.ic_ia_magic_stars
                ) {
                    navController.navigate(Screen.StoryGeneratedScreen.route + "/${viewModel.getPrompt()}")
                }
            }
        }
    }
}

@Composable
fun AppSlider(
    onValueChange: (value: Int) -> Unit
) {
    var sliderPosition by remember { mutableFloatStateOf(75f) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Slider(
            modifier = Modifier.fillMaxWidth(0.85f),
            value = sliderPosition,
            onValueChange = {
                sliderPosition = it
                onValueChange(handleSliderRange(sliderPosition)) },
            colors = SliderDefaults.colors(
                thumbColor = AppPurple,
                activeTrackColor = AppPurple,
                inactiveTrackColor = Color.White,
            ),
            steps = 3 ,
            valueRange = 0f..100f
        )
        Text(
            text = handleSliderRange(sliderPosition).toString(),
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontFamily = jostSansFamily,
                fontSize = 14.sp
            )
        )
    }
}

@Composable
fun AppTopAppBar() {
    Surface(
        modifier = Modifier.padding(vertical = 24.dp),
        color = Color.Transparent,
    ) {
        Icon(
            painter = painterResource(R.drawable.arrow_back_ios_24px),
            tint = Color.White,
            contentDescription = null
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppInputChip(
    isSelected: Boolean = false,
    text: String = "Text",
    onSelected: () -> Unit
) {
    InputChip(
        modifier = Modifier
            .width(100.dp)
            .height(38.dp),
        selected = isSelected,
        shape = CircleShape,
        onClick = { onSelected.invoke() },
        colors = inputChipColors(
            selectedLabelColor = Color.White,
            selectedContainerColor = AppPurple,
            disabledLabelColor = Color.White
        ),
        label = { Text(
            modifier = Modifier.width(80.dp),
            text = text,
            style = TextStyle(
                fontFamily = jostSansFamily,
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
        ) },
    )
}

@Preview
@Composable
fun StoryGeneratorScreenPreview() {
    StoryGeneratorScreen(rememberNavController())
}