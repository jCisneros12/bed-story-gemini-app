package com.jcisneros12.mygooglegeminiapp.core.data.ia

import android.util.Log
import com.google.ai.client.generativeai.GenerativeModel
import com.google.gson.Gson
import com.jcisneros12.mygooglegeminiapp.core.models.KidStoryGeneratedModel
import com.jcisneros12.mygooglegeminiapp.utils.RequestState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


/**
 * @author Juan Cisneros on 03/03/2024
 */

class GenerativeModelDataSourceImpl @Inject constructor(
    private val generativeModel: GenerativeModel,
    private val gson: Gson
): IGenerativeModelDataSource {

    override fun generateKidStory(prompt: String): Flow<RequestState<KidStoryGeneratedModel>>  = flow {
        emit(RequestState.Loading)

       try {
           val geminiResponse =  generativeModel.generateContent(prompt).text ?: ""

           Log.i("IA RESPONSE", geminiResponse)

           val kidStoryGeneratedModel =
               gson.fromJson(geminiResponse, KidStoryGeneratedModel::class.java)
           emit(RequestState.Success(kidStoryGeneratedModel))
       } catch (e: Exception) {
           Log.e("IA ERROR", e.toString())
           emit(RequestState.Error("Something went wrong."))
       }
    }
}