package com.jcisneros12.mygooglegeminiapp.feature.story_generator

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.jcisneros12.mygooglegeminiapp.core.models.PromptStructureModel
import com.jcisneros12.mygooglegeminiapp.core.models.toJson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 * @author Juan Cisneros on 24/03/2024
 */

@HiltViewModel
class StoryGeneratorViewModel @Inject constructor(
    private val gson: Gson
): ViewModel() {
    private var promptStructureModel: PromptStructureModel? = null

    private val aboutText: MutableState<String> = mutableStateOf("")
    private val gender: MutableState<String> = mutableStateOf("")
    private val age: MutableState<String> = mutableStateOf("")

    fun onAboutTextChange(string: String) {
        aboutText.value = string
    }

    fun onGenderChange(string: String) {
        gender.value = string
    }

    fun onAgeChange(string: String) {
        age.value = string
    }

    fun getPrompt(): String {
        promptStructureModel = PromptStructureModel(
            about = aboutText.value,
            gender = gender.value,
            age = age.value
        )
        return promptStructureModel!!.toJson(gson)
    }
}