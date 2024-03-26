package com.jcisneros12.mygooglegeminiapp.core.usecase

import com.google.gson.Gson
import com.jcisneros12.mygooglegeminiapp.core.models.KidStoryGeneratedModel
import com.jcisneros12.mygooglegeminiapp.core.models.PromptStructureModel
import com.jcisneros12.mygooglegeminiapp.core.repository.IGenerativeModelRepository
import com.jcisneros12.mygooglegeminiapp.utils.RequestState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * @author Juan Cisneros on 03/03/2024
 */

class GenerateKidStoryUseCase @Inject constructor(
    private val generativeModelRepo: IGenerativeModelRepository,
    private val gson: Gson
): IGenerateKidStoryUseCase {

    override fun run(promptStructureJson: String): Flow<RequestState<KidStoryGeneratedModel>>  {
        return generativeModelRepo.generateKidStory(
            createPromptStructure(convertPromptJsonToObject(promptStructureJson))
        )
    }

    private fun convertPromptJsonToObject(prompt: String): PromptStructureModel {
        return gson.fromJson(prompt, PromptStructureModel::class.java)
    }

    private fun createPromptStructure(promptStructure: PromptStructureModel): String {
        return "Generate a child story in english about \"${promptStructure.about}\" " +
                "for an ${promptStructure.age} year old ${promptStructure.gender} " +
                "and give me a tittle, the response must be a json like (scape double quotes if necessary in the story generated): \n" +
                "{\n" +
                "\"tittle\": \"tittle generated\",\n" +
                "\"story\": \"story generated with double quotes scape\"\n" +
                "}"
    }
}

interface IGenerateKidStoryUseCase {
    fun run(promptStructureJson: String): Flow<RequestState<KidStoryGeneratedModel>>
}