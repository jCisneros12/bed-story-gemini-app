package com.jcisneros12.mygooglegeminiapp.feature.story_generator

import androidx.lifecycle.ViewModel
import com.jcisneros12.mygooglegeminiapp.core.usecase.GenerateKidStoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 * @author Juan Cisneros on 03/03/2024
 */

@HiltViewModel
class StoryGeneratedViewModel @Inject constructor(
    private val generateKidStoryUseCase: GenerateKidStoryUseCase,
): ViewModel() {
    fun data(promptJson: String) = generateKidStoryUseCase.run(promptJson)
}